package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.clubs.AdvancedSearchComponent;
import com.ita.edu.teachua.ui.pages.clubs.ClubCard;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.utils.TestRunnerWithValueProvider;
import com.ita.edu.teachua.utils.Waiter;
import com.ita.edu.teachua.utils.jdbc.entity.CenterEntity;
import com.ita.edu.teachua.utils.jdbc.services.CenterService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.LinkedHashMap;
import java.util.List;

import static com.ita.edu.teachua.ui.pages.clubs.ClubSortingArrowDirection.DOWN;
import static com.ita.edu.teachua.ui.pages.clubs.ClubSortingArrowDirection.UP;

public class ClubsRatingTest extends TestRunnerWithValueProvider {
    @Description("Verify that the clubs can be sorted by rating")
    @Issue("TUA-440")
    @Test
    public void verifyThatClubsSortedByRating() {
        AdvancedSearchComponent sortedClubsByRating = new HomePage(driver)
                .getHeader()
                .clickAdvancedSearchBtn()
                .sortByRating();

        CenterService centerService = new CenterService();

        List<CenterEntity> centersFromDbAsc = centerService.getCentersByRating();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(getUiClubCardsRatingByNameMap(sortedClubsByRating.clickSortArrowButton(DOWN))
                        .equals(getDbClubCardsRatingByNameMap(centersFromDbAsc)),
                "sorted Clubs by rating ascending should have the same order as in DB");

        List<CenterEntity> centersFromDbDesc = centerService.getCentersByDescendingRating();

        softAssert.assertTrue(getUiClubCardsRatingByNameMap(sortedClubsByRating.clickSortArrowButton(UP))
                        .equals(getDbClubCardsRatingByNameMap(centersFromDbDesc)),
                "sorted Clubs by rating descending should have the same order as in DB");

        softAssert.assertAll();
    }

    private LinkedHashMap<String, Integer> getUiClubCardsRatingByNameMap(AdvancedSearchComponent sortedClubsByRating) {
        LinkedHashMap<String, Integer> uiClubCardsRatingByName = new LinkedHashMap<>();

        while (sortedClubsByRating.isNextPageButtonEnabled()) {
            for (ClubCard clubCard : sortedClubsByRating.getClubCards()) {
                uiClubCardsRatingByName.put(clubCard.getName(), clubCard.getRating());
            }

            sortedClubsByRating.isNextPageButtonEnabled();
        }

        return uiClubCardsRatingByName;
    }

    private LinkedHashMap<String, Double> getDbClubCardsRatingByNameMap(List<CenterEntity> centersFromDb) {
        LinkedHashMap<String, Double> dbClubCardsRatingByName = new LinkedHashMap<>();

        for (CenterEntity center : centersFromDb) {
            dbClubCardsRatingByName.put(center.getName(), center.getRating());
        }

        return dbClubCardsRatingByName;
    }
}
