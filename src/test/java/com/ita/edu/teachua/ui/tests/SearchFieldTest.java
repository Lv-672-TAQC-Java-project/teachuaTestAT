package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchFieldTest extends TestRunnerWithValueProvider {

    @Description("Verify search field behavior for one symbol entered")
    @Issue("TUA-428")
    @Test(description = "TUA-428")
    public void verifySearchFieldBehaviorForOneSymbolEntered() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String oneSymbol = RandomStringUtils.randomAlphabetic(1);

        List<WebElement> clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(oneSymbol)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 1 symbol entered Search Field does not start search process");
    }

    @Description("Verify search field behavior for one hundred and fifty symbols entered")
    @Issue("TUA-428")
    @Test(description = "TUA-428")
    public void verifySearchFieldBehaviorForOneHundredAndFiftySymbolsEntered() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String oneHundredAndFiftySymbols = RandomStringUtils.randomAlphabetic(150);

        List<WebElement> clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(oneHundredAndFiftySymbols)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 150 symbols entered Search Field does not start search process");
    }

    @Description("Verify search field behavior for invalid number of symbol entered")
    @Issue("TUA-428")
    @Test(description = "TUA-428")
    public void verifySearchFieldBehaviorForInvalidNumberOfSymbolsEntered() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String oneHundredAndFiftyOneSymbols = RandomStringUtils.randomAlphabetic(151);

        List<WebElement> clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(oneHundredAndFiftyOneSymbols)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 151 symbols entered Search Field does not start search process");


        int symbolsInSearchField = home.getHeader().getSearchValue().length();
        softAssert.assertEquals(symbolsInSearchField,
                Integer.parseInt(valueProvider.getMaxSizeOfSearchField()),
                "With 151 symbols entered Search Field does not limit number of symbols. " +
                        symbolsInSearchField + " symbols in Search Field");

        softAssert.assertAll();
    }

    @Description("Verify search field behavior for one symbol parsed")
    @Issue("TUA-428")
    @Test(description = "TUA-428")
    public void verifySearchFieldBehaviorForOneSymbolParsed() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String oneSymbol = RandomStringUtils.randomAlphabetic(1);

        List<WebElement> clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .parseSearch(oneSymbol)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 1 symbol parsed Search Field does not start search process");
    }

    @Description("Verify search field behavior for one hundred and fifty symbols parsed")
    @Issue("TUA-428")
    @Test(description = "TUA-428")
    public void verifySearchFieldBehaviorForOneHundredAndFiftySymbolsParsed() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String oneHundredAndFiftySymbols = RandomStringUtils.randomAlphabetic(150);

        List<WebElement> clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .parseSearch(oneHundredAndFiftySymbols)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 150 symbols parsed Search Field does not start search process");
    }
}
