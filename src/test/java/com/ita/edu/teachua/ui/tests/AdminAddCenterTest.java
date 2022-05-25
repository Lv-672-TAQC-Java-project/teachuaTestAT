package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.*;
import com.ita.edu.teachua.ui.pages.user.models.City;
import com.ita.edu.teachua.utils.TestRunnerWithValueProvider;
import com.ita.edu.teachua.utils.jdbc.services.CenterService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminAddCenterTest extends TestRunnerWithValueProvider {
    @BeforeMethod
    public void beforeAddCenter() {
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().login("fox.diana195@gmail.com", "Fox_1998");
    }

    @Description("[Center] Verify that user can create a center with valid data")
    @Issue("TUA-214")
    @Test(description = "TUA-214")
    public void VerifyThatUserCanCreateCenterWithValidData() {
        SoftAssert softAssert = new SoftAssert();

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        myProfilePage
                .getHeader()
                .clickAdminProfile()
                .clickMyProfileButton();

        softAssert.assertTrue(myProfilePage
                        .clickAddButton()
                        .isDropDownListDisplayed(),
                "Drop down list should be displayed");

        softAssert.assertTrue(myProfilePage
                        .clickAddCenterInDropDownButton()
                        .isAddCenterPopUpDisplayed(),
                "add center pop up should be displayed");

        BasicInformationCenterComponent basicInformationCenterComponent = new BasicInformationCenterComponent(driver);
        String centerName = "Ccccc1";

        CenterService centerService = new CenterService();
        int centerNumberBeforeAdded = centerService.getAllCentersWhereName(centerName).size();

        softAssert.assertTrue(basicInformationCenterComponent
                        .inputNameCenterField(centerName)
                        .getCenterName()
                        .contains(centerName),
                "center name should be displayed");

        softAssert.assertTrue(basicInformationCenterComponent
                        .clickAddLocationButton()
                        .isAddLocationPopUpDisplayed(),
                "add addedLocation pop up should be displayed");

        AddLocationComponent addLocationComponent = new AddLocationComponent(driver);
        String locationName = "Test1";
        softAssert.assertTrue(addLocationComponent
                        .inputLocationNameField(locationName)
                        .isSuccessNameCircleDisplayed(),
                "The addedLocation name should be entered correctly");

        City locationCity = City.KYIV;
        softAssert.assertTrue(addLocationComponent
                        .clickCityNameListButton()
                        .isDropDownListContainCity(locationCity),
                "The dropdown list should contain " + locationCity);

        softAssert.assertTrue(addLocationComponent
                        .clickCityFromDropDownList(locationCity)
                        .isSuccessCityCircleDisplayed(),
                "The city should be chosen");

        softAssert.assertTrue(addLocationComponent
                        .inputAddressField("Мазепа 55")
                        .isSuccessAddressCircleDisplayed(),
                "The address should be entered correctly");

        softAssert.assertTrue(addLocationComponent
                        .inputCoordinatesField("49.829104498711104, 24.005058710351314")
                        .isSuccessCoordinatesCircleDisplayed(),
                "The coordinates should be entered correctly");

        softAssert.assertTrue(addLocationComponent
                        .inputPhoneField("0938784576")
                        .isSuccessPhoneNumberCircleDisplayed(),
                "The phone number should be entered correctly");

        addLocationComponent.clickAddCenterLocationButton();

        LocationCheckBoxComponent addedLocation = basicInformationCenterComponent.getAddedLocation();
        Assert.assertTrue(addedLocation
                .getName()
                .contains(locationName));
        softAssert.assertTrue(addedLocation
                        .clickCheckBox()
                        .isAddedLocationSelected(),
                "The added location should be selected");

        softAssert.assertTrue(basicInformationCenterComponent
                        .clickNextStepButton()
                        .isContactTabActivated(),
                "Tab 'Контакти' in 'Додати центр' pop up is shown");

        ContactsCenterComponent contactsCenterComponent = new ContactsCenterComponent(driver);
        softAssert.assertTrue(contactsCenterComponent
                        .inputPhoneField("0950000000")
                        .isSuccessPhoneNumberCircleDisplayed(),
                "The phone number is entered correctly");

        softAssert.assertTrue(contactsCenterComponent
                        .clickNextButton()
                        .isDescriptionTabActivated(),
                "Tab 'Опис' in 'Додати центр' pop up is shown");

        DescriptionCenterComponent descriptionCenterComponent = new DescriptionCenterComponent(driver);
        softAssert.assertTrue(descriptionCenterComponent
                        .inputDescriptionField("test test test test test test test test test")
                        .isSuccessDescriptionCircleDisplayed(),
                "the Description is entered correctly");

        softAssert.assertTrue(descriptionCenterComponent
                        .clickNextButton()
                        .isClubsTabActivated(),
                "Tab 'Гуртки' in 'Додати центр' pop up is displayed");

        ClubsComponent clubsComponent = new ClubsComponent(driver);
        softAssert.assertTrue(clubsComponent
                        .clickCheckBoxClub()
                        .clickFinishButton()
                        .isContentTitleDisplayed(),
                "Pop up should be closed");

        int centerNumberAfterAdded = centerService.getAllCentersWhereName(centerName).size();
        softAssert.assertEquals(centerNumberAfterAdded, centerNumberBeforeAdded + 1);

        softAssert.assertAll();
    }
}
