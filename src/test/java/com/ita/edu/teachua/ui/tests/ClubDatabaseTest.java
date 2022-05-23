package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.header.HeaderPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addclub.BasicInformationClubComponent;
import com.ita.edu.teachua.utils.TestRunnerWithValueProvider;
import com.ita.edu.teachua.utils.jdbc.services.CenterService;
import com.ita.edu.teachua.utils.jdbc.services.ClubsService;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ClubDatabaseTest extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void loggingAsClubLeader() {
        HomePage home = new HomePage(driver);
        home
                .login(valueProvider.getClubLeaderEmail(), valueProvider.getClubLeaderPassword())
                .getHeader()
                .clickOnAddNewClubBtn();
    }

    @Description("Verify that user as 'Керiвник гуртка' after creating club " +
            "can find all information about it on the website and database.")
    @Issue("TUA-506")
    @Test(description = "TUA-506")
    public void verifyThatCreatedClubIsPresentOnTheDatabase() {
        String clubName = "Малявки";
        int ageFrom = 4;
        int ageTo = 6;
        String phoneNumber = "0934444444";
        String descriptionText = "Відділення образотворчого та декоративного мистецтва відкрите" +
                " з моменту заснування Студії." +
                "У 2005р. відбулась перша виставка робіт учасників Студії у " +
                "Львівському обласному палаці мистецтв.";

        HeaderPage header = new HeaderPage(driver);

        var basicInfoComponent = new BasicInformationClubComponent(driver);
        basicInfoComponent
                .enterClubName(clubName)
                .selectCheckboxes()
                .enterAge(ageFrom, ageTo)
                .selectCenter();

        var contactsComponent = basicInfoComponent.goToContactsClubComponent();
        contactsComponent
                .fillContactPhone(phoneNumber);

        var descriptionComponent = contactsComponent.goToDescriptionClubComponent();
        descriptionComponent
                .enterDescriptionText(descriptionText)
                .createClub();

        var myProfilePage = header
                .clickAdminProfile()
                .clickMyProfileButton();

        var clubDetailsPage = myProfilePage.goToClubDetailsPage(clubName);

        int detailsPageAgeFrom = clubDetailsPage.getAgeFrom();
        int detailsPageAgeTo = clubDetailsPage.getAgeTo();
        String detailsPageClubName = clubDetailsPage.getClubName();
        String detailsPageDescription = clubDetailsPage.getDescription();
        String detailsPageContacts = clubDetailsPage.getContactsInfo();

        String detailsPageAddress = clubDetailsPage.getAddress();
        Boolean isOnline = detailsPageAddress.contains("Онлайн");

        String detailsPageClubCenter = clubDetailsPage.getClubCenterName();
        var centerService = new CenterService();
        int centerId = centerService.getCenterIdWhereName(detailsPageClubCenter);

        assertEquals(clubName, detailsPageClubName);
        assertEquals(descriptionText, detailsPageDescription);
        assertEquals(ageFrom, detailsPageAgeFrom);
        assertEquals(ageTo, detailsPageAgeTo);
        assertEquals(detailsPageContacts, String.format("+38" + phoneNumber));
        assertTrue(isOnline);

        ClubsService clubsService = new ClubsService();
        JSONObject clubInfo = clubsService.getClubWhereName(clubName);

        String DBClubName = clubInfo.getString("name");
        String DBClubDescription = clubInfo.getString("description");
        String DBContacts = clubInfo.getString("contacts");
        Boolean DBIsClubOnline = clubInfo.getBoolean("isOnline");
        int DBAgeFrom = clubInfo.getInt("ageFrom");
        int DBAgeTo = clubInfo.getInt("ageTo");
        int DBCenterId = clubInfo.getInt("centerId");

        assertEquals(DBClubName, detailsPageClubName);
        assertEquals(DBAgeFrom, detailsPageAgeFrom);
        assertEquals(DBAgeTo, detailsPageAgeTo);
        assertEquals(DBCenterId, centerId);
        assertEquals(DBIsClubOnline, isOnline);
        assertEquals(DBClubDescription, detailsPageDescription);
        assertEquals(DBContacts, detailsPageContacts);
    }
}
