package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.clubs.AdvancedSearchComponent;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdvancedSearchTest extends TestRunner{

    @Test(description = "TUA-510")
    public void verifyThatParametersDeactivatedAfterSelectingCenterBtn(){
        SoftAssert softAssert = new SoftAssert();
        HomePage home = new HomePage(driver);
        AdvancedSearchComponent advancedSearchComponent = home.getHeader()
                .clickAdvancedSearchBtn()
                .clickOnСenterButton();

        softAssert.assertTrue(advancedSearchComponent
                .isDisplayedCategory("Місто"));
        softAssert.assertTrue(advancedSearchComponent
                .isDisplayedCategory("Район міста"));
        softAssert.assertTrue(advancedSearchComponent
                .isDisplayedCategory("Найближча станція метро"));

        softAssert.assertFalse(advancedSearchComponent
                .isDisplayedCategory("Категорії"));
        softAssert.assertFalse(advancedSearchComponent
                .isDisplayedCategory("Ремоут"));
        softAssert.assertFalse(advancedSearchComponent
                .isDisplayedCategory("Вік дитини"));

        softAssert.assertAll();
    }
}