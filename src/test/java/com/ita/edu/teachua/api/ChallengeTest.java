package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.ChallengeClient;
import com.ita.edu.teachua.api.models.ErrorResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ChallengeTest extends ApiTestRunner {
    private ChallengeClient client;

    @BeforeClass
    public void setUpClass() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        client = new ChallengeClient(authorization.getToken());
    }

    @Description("Verify that user is able to create Challenge using valid values")
    @Issue("TUA-429")
    @Test(description = "TUA-429")
    public void verifyThatUserIsAbleToCreateChallengeUsingValidData() {
        Random random = new Random();
        int sortNumber = random.nextInt(200);
        Response response = client.post(sortNumber);

        assertEquals(response.getStatusCode(), 200, "Challenge is successfully created");
    }

    @Description("Verify that user is not able to delete Challenge using non-administrator rights")
    @Issue("TUA-436")
    @Test(description = "TUA-436")
    public void verifyThatUserIsNotAbleToDeleteChallengeUsingNonAdministratorRights() {
        Authorization authorization = new Authorization(provider.getUserWithNonAdministratorRightsEmail(),
                provider.getUserWithNonAdministratorRightsPassword());
        client = new ChallengeClient(authorization.getToken());
        Response response = client.delete(147);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 401);
        softAssert.assertEquals(errorResponse.getMessage(), "You have no necessary permissions (role)");

        softAssert.assertAll();
    }
}
