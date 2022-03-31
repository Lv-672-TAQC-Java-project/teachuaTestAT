package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.clubs.AdvancedSearchComponent;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdvancedSearchModalTest extends TestRunner {

    @Test
    public void verifyAdvancedSearchModalUi() {
        new HomePage(driver)
                .getHeader()
                .clickAdvancedSearchButton();

        AdvancedSearchComponent advancedSearchComponent = new AdvancedSearchComponent(driver);

        boolean isClubRadioButtonSelected = advancedSearchComponent.isClubRadioButtonSelected();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isClubRadioButtonSelected, "Club radio button should be selected");

        boolean isCityDropdownEnabled = advancedSearchComponent.isCityDropdownActivated();
        softAssert.assertTrue(isCityDropdownEnabled, "City dropdown should be activated");

        boolean isDistrictDropdownEnabled = advancedSearchComponent.isDistrictDropdownActivated();
        softAssert.assertTrue(isDistrictDropdownEnabled, "District dropdown should be activated");

        boolean isSubwayStationDropdownEnabled = advancedSearchComponent.isSubwayStationDropdownActivated();
        softAssert.assertTrue(isSubwayStationDropdownEnabled, "Subway station dropdown should be activated");

        boolean isAvailableOnlineCheckboxEnabled = advancedSearchComponent.isAvailableOnlineCheckboxActivated();
        softAssert.assertTrue(isAvailableOnlineCheckboxEnabled, "Available online checkbox should be activated");

        boolean isCategoriesCheckboxesEnabled = advancedSearchComponent.isCategoriesCheckboxesActivated();
        softAssert.assertTrue(isCategoriesCheckboxesEnabled, "Categories checkboxes should be activated");

        boolean isAgeFieldEnabled = advancedSearchComponent.isAgeFieldActivated();
        softAssert.assertTrue(isAgeFieldEnabled, "Age field should be activated");

        softAssert.assertAll();
    }
}