package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.ChallengeClient;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
}
