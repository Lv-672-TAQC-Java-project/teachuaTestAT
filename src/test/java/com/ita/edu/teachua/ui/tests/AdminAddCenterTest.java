package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import com.ita.edu.teachua.ui.pages.user.addcenter.ContactsCenterComponent;
import com.ita.edu.teachua.ui.pages.user.addcenter.DescriptionCenterComponent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminAddCenterTest extends TestRunnerWithValueProvider {
    @BeforeMethod
    public void beforeAddCenter() {
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
    }

    @Test
    public void testAddCenter() {
        SoftAssert softAssert = new SoftAssert();

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        myProfilePage
                .getHeader()
                .clickAdminProfile()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddCenterInDropDownButton();

        softAssert.assertTrue(myProfilePage.addButtonIsEnabled());
        softAssert.assertTrue(myProfilePage.addCenterButtonIsEnabled());

        BasicInformationCenterComponent basicInformationCenterComponent = new BasicInformationCenterComponent(driver)
                .inputNameCenterField("Center#1");

        AddLocationComponent addLocationComponent = new BasicInformationCenterComponent(driver)
                .clickAddLocationButton()
                .inputLocationNameField("test1")
                .clickCityListButton()
                .clickSelectedElements(1)
                .clickDistrictListButton()
                .clickSelectedElements(1)
                .inputAddressField("Мазепи 55")
                .inputCoordinatesField("49.829104498711104, 24.005058710351314")
                .inputPhoneField("0938784576");

        softAssert.assertTrue(addLocationComponent.isCheckCircleOfLocationNameFieldDisplayed());
        softAssert.assertTrue(addLocationComponent.isCheckCircleOfLocationAddressFieldDisplayed());
        softAssert.assertTrue(addLocationComponent.isCheckCircleOfLocationCoordinatesFieldDisplayed());
        softAssert.assertTrue(addLocationComponent.isCheckCircleOfLocationPhoneFieldDisplayed());
        softAssert.assertTrue(addLocationComponent.isAddLocationButtonEnabled());
        softAssert.assertTrue(addLocationComponent.isCityListButtonEnabled());
        softAssert.assertTrue(addLocationComponent.isCheckCircleOfCityListButtonDisplayed());


        BasicInformationCenterComponent basicInformationCenterComponent1 = new AddLocationComponent(driver)
                .clickAddLocationButton()
                .clickSelectedLocations(new String[]{"Школярик001"});

        softAssert.assertTrue(basicInformationCenterComponent.addLocationButtonIsEnabled());
        softAssert.assertTrue(basicInformationCenterComponent1.isCheckBoxLocationSelected(new String[]{"Школярик001"}));
        softAssert.assertTrue(basicInformationCenterComponent1.addLocationButtonIsEnabled());

        ContactsCenterComponent contactsCenterComponent = new BasicInformationCenterComponent(driver)
                .clickNextStepButton()
                .inputPhoneField("0950000000");

        softAssert.assertTrue(contactsCenterComponent.isCheckCircleOfPhoneNumberFieldDisplayed());
        softAssert.assertTrue(contactsCenterComponent.IsNextButtonEnabled());

        DescriptionCenterComponent descriptionCenterComponent = new ContactsCenterComponent(driver)
                .clickNextButton()
                .inputDescriptionField("test test test test test test test test test");

        softAssert.assertTrue(descriptionCenterComponent.isCheckCircleOfDescriptionFieldDisplayed());
        softAssert.assertTrue(descriptionCenterComponent.IsNextButtonEnabled());

        MyProfilePage profilePage = new DescriptionCenterComponent(driver)
                .clickNextButton()
                .clickSelectedClubs(new String[]{"test123456789"})
                .clickFinishButton()
                .clickMyClubsButton()
                .clickMyCenterButton();


        //softAssert.assertTrue(new ClubsComponent(driver).isCheckBoxClubsSelected(new String[]{"test123456789"}));

        softAssert.assertAll();
    }
}
