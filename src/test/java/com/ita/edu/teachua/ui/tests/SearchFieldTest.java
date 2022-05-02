package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.clubs.ClubCardComponent;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.utils.jdbc.entity.ClubsEntity;
import com.ita.edu.teachua.utils.jdbc.services.ClubsService;
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

        List<ClubCardComponent> clubCards = home
                .getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(oneSymbol)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 1 symbol entered Search Field does not start search process");
    }

    @Description("Verify search field behavior for fifty symbols entered")
    @Issue("TUA-428")
    @Test(description = "TUA-428")
    public void verifySearchFieldBehaviorForFiftySymbolsEntered() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String fiftySymbols = RandomStringUtils.randomAlphabetic(50);

        List<ClubCardComponent> clubCards = home
                .getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(fiftySymbols)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 50 symbols entered Search Field does not start search process");
    }

    @Description("Verify search field behavior for invalid number of symbol entered")
    @Issue("TUA-428")
    @Test(description = "TUA-428")
    public void verifySearchFieldBehaviorForInvalidNumberOfSymbolsEntered() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String fiftyOneSymbols = RandomStringUtils.randomAlphabetic(51);

        List<ClubCardComponent> clubCards = home
                .getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .enterSearch(fiftyOneSymbols)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 51 symbols entered Search Field does not start search process");


        int symbolsInSearchField = home.getHeader().getSearchValue().length();
        softAssert.assertEquals(symbolsInSearchField,
                Integer.parseInt(valueProvider.getMaxSizeOfSearchField()),
                "With 51 symbols entered Search Field does not limit number of symbols. " +
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

        List<ClubCardComponent> clubCards = home
                .getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .parseSearch(oneSymbol)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 1 symbol parsed Search Field does not start search process");
    }

    @Description("Verify search field behavior for fifty symbols parsed")
    @Issue("TUA-428")
    @Test(description = "TUA-428")
    public void verifySearchFieldBehaviorForFiftySymbolsParsed() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String fiftySymbols = RandomStringUtils.randomAlphabetic(50);

        List<ClubCardComponent> clubCards = home
                .getHeader()
                .clickAdvancedSearchBtn()
                .getHeader()
                .parseSearch(fiftySymbols)
                .getClubCards();

        softAssert.assertNotEquals(clubCards.size(), Integer.parseInt(valueProvider.getSizeOfSearchResult()),
                "With 50 symbols parsed Search Field does not start search process");
    }

    @Description("Verify that user can perform basic search by name of a club")
    @Issue("TUA-226")
    @Test(description = "TUA-226")
    public void verifyThatUserCanPerformBasicSearchByNameOfAClub() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();

        ClubsService clubsService = new ClubsService();
        List<ClubsEntity> clubs = clubsService.getClubsName();

        String clubName = clubs.get(0).getName();
        List<ClubCardComponent> clubCards = home
                .getHeader()
                .enterSearch(clubName)
                .getClubCards();

        softAssert.assertEquals(clubName, clubCards.get(0).getName(),
                "The result of the search does not contain a club with the name of a club");
    }
}
