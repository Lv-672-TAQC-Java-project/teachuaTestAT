package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.clubs.ClubsPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchFieldTest extends TestRunner {
    @Test
    public void verifySearchFieldBehaviorForInvalidValidNumberOfSymbolsEntered() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String oneSymbol = RandomStringUtils.randomAlphabetic(1);
        List<WebElement> clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(oneSymbol)
                .getClubCards();
        softAssert.assertNotEquals(6, clubCards.size(),"1 symbol" + clubCards.size());

        String oneHundredAndFiftySymbols = RandomStringUtils.randomAlphabetic(150);
        clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(oneHundredAndFiftySymbols)
                .getClubCards();
        softAssert.assertNotEquals(6, clubCards.size(),"150 symbols" + clubCards.size());

        String oneHundredAndFiftyOneSymbols = RandomStringUtils.randomAlphabetic(151);
        clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(oneHundredAndFiftyOneSymbols)
                .getClubCards();
        softAssert.assertNotEquals(6, clubCards.size(),"151 symbols" + clubCards.size());

        clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .parseSearch(oneSymbol)
                .getClubCards();
        softAssert.assertNotEquals(6, clubCards.size(),"1 symbol" + clubCards.size());

        clubCards = home.getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .parseSearch(oneHundredAndFiftySymbols)
                .getClubCards();
        softAssert.assertNotEquals(6, clubCards.size(),"150 symbols" + clubCards.size());
    }
}