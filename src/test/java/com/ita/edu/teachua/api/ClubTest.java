package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorResponse;
import com.ita.edu.teachua.api.client.ClubClient;
import com.ita.edu.teachua.api.models.response.club.ClubResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClubTest extends ApiTestRunner {

    private ClubClient client;

    @BeforeClass
    public void setUpClass() {
        Authorization authorization = new Authorization(provider.getClubHeadEmail(), provider.getClubHeadPassword());
        client = new ClubClient(authorization.getToken());
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

    @Description("Verify that User as 'Керiвник гуртка' cannot create new club is in a center if 'Назва' field contain more than 100 characters")
    @Issue("TUA-503")
    @Test(description = "TUA-503")
    public void verifyThatUserCannotCreateNewClubIsInACenterIfNameFieldContainMoreThan100Characters() {
        var response = client.post();
        var errorResponse = response.as(ErrorResponse.class);
        var softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "name Довжина назви має бути від 5 до 100 символів");
        softAssert.assertAll();
    }
}
