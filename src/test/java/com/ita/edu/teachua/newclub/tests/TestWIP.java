package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.header.HeaderPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.ClubDetailsPage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addclub.BasicInformationClubComponent;
import com.ita.edu.teachua.ui.pages.user.addclub.ContactsClubComponent;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import com.ita.edu.teachua.utils.jdbc.services.CenterService;
import com.ita.edu.teachua.utils.jdbc.services.ClubsService;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestWIP extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void loggingAsClubLeader() {
        HomePage home = new HomePage(driver);
        home
                .login(valueProvider.getClubLeaderEmail(), valueProvider.getClubLeaderPassword())
                .getHeader()
                .clickOnAddNewClubBtn();
    }

    @Test
    public void wipTest() {
        String clubName = "Малявки";
        int ageFrom = 4;
        int ageTo = 6;
        String phoneNumber = "0934444444";
        String descriptionText = "Відділення образотворчого та декоративного мистецтва відкрите" +
                " з моменту заснування Студії." +
                "У 2005р. відбулась перша виставка робіт учасників Студії у " +
                "Львівському обласному палаці мистецтв.";

        HeaderPage header = new HeaderPage(driver);

        BasicInformationClubComponent basicInfoComponent = new BasicInformationClubComponent(driver);
        basicInfoComponent
                .enterClubName(clubName)
                .selectCheckboxes()
                .enterAge(ageFrom, ageTo)
                .selectCenter();

        ContactsClubComponent contactsComponent = basicInfoComponent.goToContactsClubComponent();
        contactsComponent
                .fillContactPhone(phoneNumber);

        DescriptionClubComponent descriptionComponent = contactsComponent.goToDescriptionClubComponent();
        descriptionComponent
                .enterDescriptionText(descriptionText)
                .createClub();

        MyProfilePage myProfilePage = header
                .clickAdminProfile()
                .clickMyProfileButton();

        ClubDetailsPage clubDetailsPage = myProfilePage.goToClubDetailsPage(2);

        int detailsPageAgeFrom = clubDetailsPage.getAgeFrom();
        int detailsPageAgeTo = clubDetailsPage.getAgeTo();
        String detailsPageClubName = clubDetailsPage.getClubName();
        String detailsPageDescription = clubDetailsPage.getDescription();
        String detailsPageContacts = clubDetailsPage.getContactsInfo();

        String detailsPageAddress = clubDetailsPage.getAddress();
        Boolean isOnline = detailsPageAddress.contains("Онлайн");

        String detailsPageClubCenter = clubDetailsPage.getClubCenterName();
        CenterService centerService = new CenterService();
        int centerId = centerService.getIdWhereName(detailsPageClubCenter);

        assertEquals(clubName, detailsPageClubName);
        assertEquals(descriptionText, detailsPageDescription);
        assertEquals(ageFrom, detailsPageAgeFrom);
        assertEquals(ageTo, detailsPageAgeTo);
        assertTrue(detailsPageContacts.contains(phoneNumber));
        assertTrue(isOnline);

//        Don't forget to change ValueProvider() path
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
        assertEquals(DBContacts, detailsPageContacts.substring(4));
    }
}
