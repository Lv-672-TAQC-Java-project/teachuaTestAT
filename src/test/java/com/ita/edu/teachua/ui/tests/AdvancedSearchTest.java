package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.clubs.AdvancedSearchComponent;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AdvancedSearchTest extends TestRunner {

    @Description("Verify that 'Доступний онлайн', 'Категорії', 'Вік дитини' parameters are deactivated after selecting 'Центр' radio button")
    @Issue("TUA-510")
    @Test(description = "TUA-510")
    public void verifyThatParametersDeactivatedAfterSelectingCenterBtn() {
        SoftAssert softAssert = new SoftAssert();
        HomePage home = new HomePage(driver);
        AdvancedSearchComponent advancedSearchComponent = home.getHeader()
                .clickAdvancedSearchBtn()
                .clickOnСenterButton();

        softAssert.assertTrue(advancedSearchComponent
                .isDisplayedCategory("Місто"),"Category with title 'Місто' should be displayed");
        softAssert.assertTrue(advancedSearchComponent
                .isDisplayedCategory("Район міста"),"Category with title 'Район міста' should be displayed");
        softAssert.assertTrue(advancedSearchComponent
                .isDisplayedCategory("Найближча станція метро"),"Category with title 'Найближча станція метро' should be displayed");

        softAssert.assertFalse(advancedSearchComponent
                .isDisplayedCategory("Категорії"),"Category with title 'Категорії' should not be displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isDisplayedCategory("Ремоут"),"Category with title 'Ремоут' should not be displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isDisplayedCategory("Вік дитини"),"Category with title 'Вік дитини' should not be displayed");

        softAssert.assertAll();
    }

    @Test
    public void verifyAdvancedSearchButtonOpensAdvancedSearchSection() {
        HomePage homePage = new HomePage(driver);
        homePage
                .getHeader()
                .clickAdvancedSearchButton();

        AdvancedSearchComponent advancedSearchComponent = new AdvancedSearchComponent(driver);
        boolean isAdvancedSearchModalDisplayed = advancedSearchComponent.isAdvancedSearchModalDisplayed();
        assertTrue(isAdvancedSearchModalDisplayed, "Advanced search modal should be displayed");

        homePage
                .getHeader()
                .clickAdvancedSearchButton();

        isAdvancedSearchModalDisplayed = advancedSearchComponent.isAdvancedSearchModalDisplayed();
        assertFalse(isAdvancedSearchModalDisplayed, "Advanced search modal should not be displayed");
    }

    @Description("Verify that the centers in the results of advanced search can be displayed as a list")
    @Issue("TUA-513")
    @Test(description = "TUA-513")
    public void verifyThatCentersDisplayedAsAList() {
        int expectedHeight = 184;
        int expectedWidth = 944;
        HomePage home = new HomePage(driver);
        AdvancedSearchComponent advancedSearchComponent = home.getHeader()
                .clickAdvancedSearchBtn()
                .clickOnСenterButton()
                .clickOnListIcon();

        assertTrue(advancedSearchComponent.isCentersDisplayedAsAList(expectedWidth, expectedHeight),"Centers should be displayed as a list");
    }
}
