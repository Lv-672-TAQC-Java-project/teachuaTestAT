package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.pages.user.models.City;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import com.ita.edu.teachua.utils.jdbc.services.LocationService;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddLocationClubTest extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void loggingIn() {
        HomePage home = new HomePage(driver);
        home.login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .getHeader()
                .clickOnAddNewClubBtn();
    }

    @Description("Verify that a 'Керівник' can add a location of a club")
    @Issue("TUA-237")
    @Test(description = "TUA-237")
    public void verifyThatAdminCanAddLocationTest() {
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        descriptionClub
                .fillBasicInfo()
                .clickAddLocationButton();
        String locationName = "Club11";

        LocationService locationService = new LocationService();
        int locationSizeBefore = locationService.getAllLocationsWhereName(locationName).size();

        AddLocationComponent addLocationComponent = new AddLocationComponent(driver);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(addLocationComponent
                        .inputLocationNameField(locationName)
                        .isSuccessNameCircleDisplayed(),
                "The location name should be entered correctly");

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

        softAssert.assertTrue(addLocationComponent
                        .clickAddClubLocationButton()
                        .getAddedLocation()
                        .getName()
                        .contains(locationName),
                "The location should be added to a list with locations");

        descriptionClub
                .fillContactsInfo()
                .fillDescriptionInfo();

        int locationSizeAfter = locationService.getAllLocationsWhereName(locationName).size();
        Assert.assertEquals(locationSizeAfter,
                locationSizeBefore + (locationSizeAfter - locationSizeBefore));
        softAssert.assertAll();
    }
}
