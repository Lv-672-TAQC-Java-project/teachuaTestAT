package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import com.ita.edu.teachua.ui.pages.user.addcenter.ContactsCenterComponent;
import com.ita.edu.teachua.ui.pages.user.addcenter.DescriptionCenterComponent;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminAddCenterTest extends TestRunnerWithValueProvider {
    @BeforeMethod
    public void beforeAddCenter() {
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
    }

    final String CITY = "Київ";
    final String DISTRICT = "Деснянський";
    final String STATION = "Академістечко";

    @Description("Verify optional fields work correctly")
    @Issue("TUA-214")
    @Test(description = "TUA-214")
    public void verifyThatOptionalFieldsAreDisplayed() {

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        myProfilePage
                .getHeader()
                .clickAdminProfile()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddCenterInDropDownButton()
                .clickAddLocationButton();

        SoftAssert softAssert = new SoftAssert();

        AddLocationComponent addLocationComponent = new AddLocationComponent(driver);
        softAssert.assertTrue(addLocationComponent
                .clickCityListButton()
                .isElementFromDropDownListDisplayed(CITY), CITY + " should be displayed in drop down list");
        addLocationComponent.clickElementFromDropDownList(CITY);

        softAssert.assertTrue(addLocationComponent
                .clickDistrictListButton()
                .isElementFromDropDownListDisplayed(DISTRICT), DISTRICT + " should be displayed in drop down list");
        addLocationComponent.clickElementFromDropDownList(DISTRICT);

        softAssert.assertTrue(addLocationComponent
                .clickStationListButton()
                .isElementFromDropDownListDisplayed(STATION),STATION + " should be displayed in drop down list" );
        addLocationComponent.clickElementFromDropDownList(STATION);

        softAssert.assertAll();
    }

    @Description("[Center] Verify that user can create a center with valid data")
    @Issue("TUA-214")
    @Test(description = "TUA-214")
    public void VerifyThatUserCanCreateCenterWithValidData()  {
        SoftAssert softAssert = new SoftAssert();

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        AddLocationComponent addLocationComponent = new AddLocationComponent(driver);
        myProfilePage
                .getHeader()
                .clickAdminProfile()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddCenterInDropDownButton();

        softAssert.assertTrue(myProfilePage.addCenterButtonIsEnabled());

        BasicInformationCenterComponent basicInformationCenterComponent = new BasicInformationCenterComponent(driver);

        basicInformationCenterComponent
                .inputNameCenterField("Center#1");

        basicInformationCenterComponent.clickAddLocationButton();

        addLocationComponent
                .inputLocationNameField("test1")
                .clickCityListButton()
                .clickElementFromDropDownList(CITY)
                .inputAddressField("Мазепи 55")
                .inputCoordinatesField("49.829104498711104, 24.005058710351314")
                .inputPhoneField("0938784576");

        softAssert.assertTrue(addLocationComponent.isCheckCircleOfLocationNameFieldDisplayed(),
                "the location name is entered correctly");
        softAssert.assertTrue(addLocationComponent.isElementFromDropDownListDisplayed(CITY),
                CITY + " should be displayed in drop down list");
        softAssert.assertTrue(addLocationComponent.isCheckCircleOfLocationAddressFieldDisplayed(),
                "the address of location is entered correctly");
        softAssert.assertTrue(addLocationComponent.isCheckCircleOfLocationCoordinatesFieldDisplayed(),
                "the coordinates of location is entered correctly");
        softAssert.assertTrue(addLocationComponent.isCheckCircleOfLocationPhoneFieldDisplayed(),
                "the phone number of location is entered correctly");

        softAssert.assertTrue(addLocationComponent.isAddLocationButtonEnable());
        addLocationComponent.clickAddLocationButton();

        basicInformationCenterComponent
                .clickSelectedLocations(new String[]{"Школярик001"})
                .clickNextButton();

        ContactsCenterComponent contactsCenterComponent = new ContactsCenterComponent(driver);

        contactsCenterComponent
                .inputPhoneField("0950000000").isCheckCircleOfPhoneNumberFieldDisplayed();

        softAssert.assertTrue(contactsCenterComponent.isCheckCircleOfPhoneNumberFieldDisplayed(),
                "the phone number is entered correctly");
        contactsCenterComponent
                .clickNextButton();

        DescriptionCenterComponent descriptionCenterComponent = new DescriptionCenterComponent(driver);

        descriptionCenterComponent
                .inputDescriptionField("test test test test test test test test test");

        softAssert.assertTrue(descriptionCenterComponent.isCheckCircleOfDescriptionFieldDisplayed(),
                "the Description is entered correctly");
        descriptionCenterComponent
                .clickNextButton()
                .clickSelectedClubs(new String[]{"test123456789"})
                .clickFinishButton();

        softAssert.assertAll();
    }
}
