package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.ClubClient;
import com.ita.edu.teachua.api.models.response.club.ClubResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClubTest extends ApiTestRunner {

    private ClubClient client;

    @BeforeClass
    public void setUpClass() {

        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getPassword());
        client = new ClubClient(authorization.getToken());
    }

    @Description("Verify that User as 'Керiвник гуртка' can create new club is in a center if 'Назва' field consists of a word length of 5 characters")
    @Issue("TUA-504")
    @Test(description = "TUA-504")
    public void verifyThatUserCanCreateNewClub() {
        String name = RandomStringUtils.randomAlphabetic(5);
        Response response = client.post(name);
        ClubResponse clubResponse = response.as(ClubResponse.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(clubResponse.getName(), name);

        softAssert.assertAll();
    }

    @Description("Verify that User as 'Керiвник гуртка' can create new club, which will registered on him")
    @Issue("TUA-463")
    @Test(description = "TUA-463")
    public void verifyThatUserAsClubHeaderCanCreateNewClub() {
        String name = RandomStringUtils.randomAlphabetic(8);
        Response response = client.post(name);
        ClubResponse clubResponse = response.as(ClubResponse.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(clubResponse.getName(), name);
        softAssert.assertEquals(clubResponse.getUser().getId(), 264);
    }
}
