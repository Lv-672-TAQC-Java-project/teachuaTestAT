package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.header.HeaderPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.ClubDetailsPage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addclub.BasicInformationClubComponent;
import com.ita.edu.teachua.ui.pages.user.addclub.ContactsClubComponent;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import com.ita.edu.teachua.utils.jdbc.entity.ClubsEntity;
import com.ita.edu.teachua.utils.jdbc.services.ClubsService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

        String detailsPageClubName = clubDetailsPage.getClubName();
        String detailsPageDescription = clubDetailsPage.getDescription();
        int detailsPageAgeFrom = clubDetailsPage.getAgeFrom();
        int detailsPageAgeTo = clubDetailsPage.getAgeTo();
        String detailsPageClubCenter = clubDetailsPage.getClubCenterName();
        String detailsPageContacts = clubDetailsPage.getContactsInfo();
        String detailsPageAddress = clubDetailsPage.getAddress();

        assertEquals(clubName, detailsPageClubName);
        assertEquals(descriptionText, detailsPageDescription);
        assertEquals(ageFrom, detailsPageAgeFrom);
        assertEquals(ageTo, detailsPageAgeTo);
        assertTrue(detailsPageContacts.contains(phoneNumber));

//        Don't forget to change ValueProvider() path
        ClubsService clubsService = new ClubsService();
        List<ClubsEntity> clubInfo = clubsService.getClubWhereName(clubName);
        String test = clubInfo.toString();

        assertTrue(test.contains(detailsPageClubName));
        assertTrue(test.contains(detailsPageDescription));
        assertTrue(test.contains(String.valueOf(detailsPageAgeFrom)));
        assertTrue(test.contains(String.valueOf(detailsPageAgeTo)));
        assertTrue(test.contains(detailsPageContacts.substring(4)));
    }
}
