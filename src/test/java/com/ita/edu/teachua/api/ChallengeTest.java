package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChallengeTest extends ApiTestRunner{
    private ChallengeClient client;
    @BeforeClass
    public void setUpClass(){
        Authorization authorization = new Authorization(provider.getUserWithNonAdministratorRightsEmail(),
                provider.getUserWithNonAdministratorRightsPassword());
        client = new ChallengeClient(authorization.getToken());
    }
    @Description("Verify that user is not able to delete Challenge using non-administrator rights")
    @Issue("TUA-436")
    @Test(description = "TUA-436")
    public void verifyThatUserIsNotAbleToDeleteChallengeUsingNonAdministratorRights() {
        Response response = client.delete(147);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 401);
        softAssert.assertEquals(errorResponse.getMessage(), "You have no necessary permissions (role)");

        softAssert.assertAll();
    }
}
