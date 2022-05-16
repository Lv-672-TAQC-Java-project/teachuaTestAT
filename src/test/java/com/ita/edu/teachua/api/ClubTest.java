package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.Club;
import com.ita.edu.teachua.api.client.ClubClient;
import com.ita.edu.teachua.api.models.credenntials.ClubCredentials;
import com.ita.edu.teachua.api.models.response.club.ClubResponse;
import com.ita.edu.teachua.api.models.response.club.Location;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClubTest extends ApiTestRunner {

    private ClubClient client;
    private Club club;

    @BeforeClass
    public void setUpClass() {

        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getPassword());
        client = new ClubClient(authorization.getToken());
        club = new Club(authorization.getToken());
    }

    @Description("Verify that User as 'Керiвник гуртка' can create new club is in a center if 'Назва' field consists of a word length of 5 characters")
    @Issue("TUA-504")
    @Test(description = "TUA-504")
    public void verifyThatUserCanCreateNewClub() {
        String name = "qrtqt";
        Response response = client.post(name);
        ClubResponse clubResponse = response.as(ClubResponse.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(clubResponse.getName(), name);

        softAssert.assertAll();

    }

    @Description("Verify that the duplicate club cannot be created")
    @Issue("TUA-469")
    @Test(description = "TUA-469")
    public void verifyDuplicateClubCannotCreated() {

        List<Location> locations = new ArrayList<>();

        ClubCredentials clubCredentials = new ClubCredentials(
                Collections.singletonList("Спортивні секції"),
                "Спроба1",
                2,
                18,
                true,
                "{}",
                "{\"blocks\":[{\"key\":\"brl63\",\"text\":\"йййййййййййййййййййййййййййййййййййййййййййййййййййййййййй\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
                locations,
                272);

        Response response = club.postClub(clubCredentials);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 403);
        softAssert.assertTrue(response
                .getBody()
                .asString()
                .contains("Club already exist with name: Спроба1"));

        softAssert.assertAll();
    }
}
