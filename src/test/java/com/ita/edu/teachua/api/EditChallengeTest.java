package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorResponse;
import com.ita.edu.teachua.api.models.UserResponse;
import com.ita.edu.teachua.api.models.challenge.ChallengeCredentials;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditChallengeTest extends ApiTestRunner{
    private UserClient client;

    @BeforeClass
    public void setUpClass(){
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        client = new UserClient(authorization.getToken());
    }


    @Test
    public void getUserByIdTest() {
        ChallengeCredentials credentials = new ChallengeCredentials(providerCredentials.getNameChallenge(),
                providerCredentials.getDescriptionChallenge(),
                providerCredentials.getPictureChallenge(), providerCredentials.getStartDateChallenge());
        Response response = client.put(22, credentials);
        ErrorResponse userResponse = response.as(ErrorResponse.class);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "headerText must not be blank and challengeId must not be null and startDate must be a future date");
        softAssert.assertAll();
    }
}
