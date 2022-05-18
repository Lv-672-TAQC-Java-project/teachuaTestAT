package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.TaskClient;
import com.ita.edu.teachua.api.models.ErrorResponse;
import com.ita.edu.teachua.api.models.credenntials.TaskCredentials;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskTest extends ApiTestRunner {
    private TaskClient task;

    @BeforeClass
    public void setUpClass() {

        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getPassword());
        task = new TaskClient(authorization.getToken());
    }

    @Description("Verify that user can create TaskClient with valid values.")
    @Issue("TUA-441")
    @Test(description = "TUA-441")
    public void verifyCreatedTaskWithValidValues() {

        TaskCredentials taskCredentials = new TaskCredentials(" namenamename1213#$% ",
                "stringstringstringstringstringstringstringstring",
                " descriptiondescriptiondescriptiondescriptiondescription12345$%%^$# ",
                "/upload/test/test.png",
                "2022-05-25");

        Response response = task.post(169, taskCredentials);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertAll();
    }
    @Description("Verify that user can not edit Task using null as values")
    @Issue("TUA-446")
    @Test(description = "TUA-446")
    public void verifyThatUserCanCreateNewClubUsingNullAsValues() {
        com.ita.edu.teachua.api.models.TaskCredentials credentials = new com.ita.edu.teachua.api.models.TaskCredentials(null, provider.getHeaderTextChallenge(),
                null, provider.getPictureChallenge(), provider.getStartDateChallenge(),
                Long.parseLong(provider.getChallengeId()));
        Response response = task.put(22, credentials);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        var softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "name must not be blank");
        softAssert.assertAll();
    }

    @Description("Verify that user can not edit Task using spaces as values")
    @Issue("TUA-446")
    @Test(description = "TUA-446")
    public void verifyThatUserCanCreateNewClubUsingSpacesAsValues() {
        com.ita.edu.teachua.api.models.TaskCredentials credentials = new com.ita.edu.teachua.api.models.TaskCredentials(" ", provider.getHeaderTextChallenge(),
                " ", provider.getPictureChallenge(), provider.getStartDateChallenge(),
                Long.parseLong(provider.getChallengeId()));
        Response response = task.put(22, credentials);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        var softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 400);
        var message = errorResponse.getMessage();
        softAssert.assertTrue(message.contains("name must not be blank"), "message should contain: name must not be blank");
        softAssert.assertTrue(message.contains("name can't contain russian letters"), "message should contain: name can't contain russian letters");
        softAssert.assertTrue(message.contains("description can't contain russian letters"), "message should contain: description can't contain russian letters");
        softAssert.assertTrue(message.contains("name must contain a minimum of 5 and a maximum of 255 letters"), "message should contain: name must contain a minimum of 5 and a maximum of 255 letters");
        softAssert.assertAll();
    }
}
