package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.clubs.AdvancedSearchComponent;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.utils.jdbc.entity.CenterEntity;
import com.ita.edu.teachua.utils.jdbc.services.CenterService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.testng.Assert.*;

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
                .isCategoryDisplayed("Місто"), "Category with label 'Місто' is not displayed");
        softAssert.assertTrue(advancedSearchComponent
                .isCategoryDisplayed("Район міста"), "Category with label 'Район міста' is not displayed");
        softAssert.assertTrue(advancedSearchComponent
                .isCategoryDisplayed("Найближча станція метро"), "Category with label 'Найближча станція метро' is not displayed");

        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Ремоут", "Доступний онлайн"), "Available online checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Спортивні секції"), "Sport sections checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Танці, хореографія"), "Dance checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Студії раннього розвитку"), "Early development studies checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Програмування, робототехніка, STEM"), "Programming checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Вокальна студія, музика, музичні інструменти"), "Vocal studio, music checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Акторська майстерність, театр"), "Acting skills, theater checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Вчіться, діти"), "Learn, children checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Основи"), "Basics checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Основи Java444"), "Java Basics checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Особистісний розвиток"), "Personal development checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Журналістика, дитяче телебачення, монтаж відео, влогів"), "Journalism checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Центр розвитку"), "Development center checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCheckBoxDisplayed("Категорії", "Інше"), "Other checkbox is displayed");
        softAssert.assertFalse(advancedSearchComponent
                .isCategoryDisplayed("Вік дитини"), "Category with label 'Вік дитини' is displayed");

        softAssert.assertAll();
    }

    @Description("This test case checks if “Advanced search” button opens “Advanced search” section")
    @Issue("TUA-224")
    @Test
    public void verifyAdvancedSearchButtonOpensAdvancedSearchSection() {
        HomePage homePage = new HomePage(driver);
        homePage
                .getHeader()
                .clickAdvancedSearchBtn();

        AdvancedSearchComponent advancedSearchComponent = new AdvancedSearchComponent(driver);
        boolean isAdvancedSearchModalDisplayed = advancedSearchComponent.isAdvancedSearchModalDisplayed();
        assertTrue(isAdvancedSearchModalDisplayed, "Advanced search modal should be displayed");

        homePage
                .getHeader()
                .clickAdvancedSearchBtn();

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
        AdvancedSearchComponent advancedSearchComponent = home
                .getHeader()
                .clickAdvancedSearchBtn()
                .clickOnСenterButton()
                .clickOnListIcon();

        assertTrue(advancedSearchComponent.isCentersDisplayedAsAList(expectedWidth, expectedHeight), "Centers is not displayed as a list");
    }

    @Description("This test case verifies that the user can sort the search results alphabetically after clicking on the 'Центр' radio button")
    @Issue("TUA-440")
    @Test(description = "TUA-440")
    public void verifyThatUserCanSortCentersSearchResultsAlphabetically() {
        AdvancedSearchComponent advancedSearchComponent = new HomePage(driver)
                .getHeader()
                .clickAdvancedSearchBtn();

        boolean isAdvancedSearchModalDisplayed = advancedSearchComponent.isAdvancedSearchModalDisplayed();
        assertTrue(isAdvancedSearchModalDisplayed, "Advanced search modal should be displayed");

        advancedSearchComponent
                .clickOnСenterButton()
                .clickRemoveFilterButton()
                .clickSortAlphabeticallyButton();

        List<String> uiCentersNames = advancedSearchComponent.getCenterLabels();

        String message = "Centers should be displayed alphabetically %s on UI";
        List<String> dbCentersName = getFirstSixCentersNameSortedAscOrDesc(true);
        assertEquals(uiCentersNames, dbCentersName, String.format(message, "ASC"));

        advancedSearchComponent.clickArrowUpButton();
        uiCentersNames = advancedSearchComponent.getCenterLabels();

        dbCentersName = getFirstSixCentersNameSortedAscOrDesc(false);
        assertEquals(uiCentersNames, dbCentersName, String.format(message, "DESC"));
    }

    private List<String> getFirstSixCentersNameSortedAscOrDesc(boolean isAsc) {
        List<CenterEntity> centersFromDataBase = new CenterService().getCentresSortedByNameAscOrDesc(isAsc);

        List<String> dataBaseList = new ArrayList<>();
        for (CenterEntity center : centersFromDataBase) {
            dataBaseList.add(center
                    .getName()
                    .trim()
                    .replaceAll("  ", " ")
            );
        }

        return dataBaseList
                .stream()
                .limit(6)
                .collect(toList());
    }
}
