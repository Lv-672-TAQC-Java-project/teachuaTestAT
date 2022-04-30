package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import com.ita.edu.teachua.utils.jdbc.entity.LocationEntity;
import com.ita.edu.teachua.utils.jdbc.services.LocationService;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddLocationClubTest extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void loggingIn() {
        HomePage home = new HomePage(driver);
        home.login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .getHeader()
                .clickOnAddNewClubBtn();
    }

    final String CITY = "Київ";
    final String DISTRICT = "Деснянський";
    final String STATION = "Академістечко";

    @Description("Verify that a 'Керівник' can add a location of a club")
    @Issue("TUA-237")
    @Test(description = "TUA-237")
    public void verifyThatAdminCanAddLocationTest() {
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        descriptionClub
                .fillBasicInfo()
                .clickAddLocationButton();

        SoftAssert softAssert = new SoftAssert();

        String nameLocation = "Club1";
        AddLocationComponent addLocationComponent = new AddLocationComponent(driver);
        addLocationComponent
                .inputLocationNameField(nameLocation);

        softAssert.assertTrue(addLocationComponent
                .clickCityListButton()
                .isElementFromDropDownListDisplayed(CITY), CITY + " should be displayed in drop down list");

        addLocationComponent.clickElementFromDropDownList(CITY);

        addLocationComponent
                .inputAddressField("Мазепа 55")

                .inputCoordinatesField("49.829104498711104, 24.005058710351314")
                .inputPhoneField("0938784576");

        softAssert.assertTrue(addLocationComponent
                .isAddLocationButtonEnable(), "All fields should be filled");
        addLocationComponent
                .clickAddLocationButton();

        String descriptionText = "An English Club is a place for language learners to use English in a casual setting." +
                " In the classroom, you often focus on one skill and one item (for example: grammar - future tense)." +
                " Розмовний клуб пишається тим, що об'єднує дітей  з усього світу. Наша пошта - englishclub@gmail.com";

        softAssert.assertTrue(descriptionClub
                .fillContactsInfo()
                .enterDescriptionText(descriptionText)
                .isSuccessCheckCircleVisible(), "The description should have valid data");
        softAssert.assertTrue(descriptionClub
                .isCreateClubButtonEnabled(), "Finish button should be enabled");

        descriptionClub.clickCreateClubButton();

        LocationService locationService = new LocationService();
        List<LocationEntity> locations = locationService.getAllLocationsWhereName(nameLocation);
        locations.forEach(location -> Assert.assertTrue(location
                .getName()
                .equalsIgnoreCase(nameLocation)));

        softAssert.assertAll();
    }

}
