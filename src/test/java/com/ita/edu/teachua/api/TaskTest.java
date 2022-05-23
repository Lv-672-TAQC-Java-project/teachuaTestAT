package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.TaskClient;
import com.ita.edu.teachua.api.models.credenntials.TaskCredentials;
import com.ita.edu.teachua.api.models.response.ErrorResponse;
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

        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
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

    @Description("Verify that user can edit Task with valid values.")
    @Issue("TUA-444")
    @Test(description = "TUA-444")
    public void verifyThatUserCanEditTaskWithValidValues() {

        TaskCredentials taskCredentials = new TaskCredentials(" namenamename1213#$% ",
                "stringstringstringstringstringstringstringstring",
                " descriptiondescriptiondescriptiondescriptiondescription12345$%%^$# ",
                "/upload/test/test.png",
                "2022-05-25",
                224L);

        var response = task.put(310, taskCredentials);

        var softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertAll();
    }
  
    @Description("Verify that user can not edit Task using null as values")
    @Issue("TUA-446")
    @Test(description = "TUA-446")
    public void verifyThatUserCanCreateNewClubUsingNullAsValues() {
       TaskCredentials credentials = new TaskCredentials(null, provider.getHeaderTextChallenge(),
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
        TaskCredentials credentials = new TaskCredentials(" ", provider.getHeaderTextChallenge(),
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
  
    @Description("This test case verifies that the user can not create Task, use invalid data")
    @Issue("TUA-442")
    @Test(description = "TUA-442")
    public void VerifyThatUserCanNotCreateTaskWithInvalidData(){
        TaskCredentials credentials = new TaskCredentials("name",
                "headerTextheaderTextheaderTextheaderText",
                "descriptiondescriptiondescriptiondescriptiondescription",
                "/upload/test/test.png",
                "2022-05-30");

        Response response = task.post(168, credentials);
        ErrorResponse taskResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(taskResponse.getStatus(), 400);
        softAssert.assertTrue(!taskResponse.getMessage().isEmpty());
        softAssert.assertAll();
    }

    @Description("Verify that user can not create Task using null, spaces as values")
    @Issue("TUA-443")
    @Test(description = "TUA-443")
    public void verifyThatUserCannotCreateTaskUsingNullSpaces() {
        TaskCredentials taskCredentials = new TaskCredentials("           ",
                "stringstringstringstringtextstringstringstringstringstringstring",
                "                                                                " ,
                "/upload/test/test.png",
                "2022-05-30");

        Response response = task.post(322, taskCredentials);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);
        String errorMessage = errorResponse.getMessage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorResponse.getStatus(), 400);
        softAssert.assertTrue(errorMessage.contains("name must contain a minimum of 5 and a maximum of 50 letters"));
        softAssert.assertTrue(errorMessage.contains("name must not be blank"));
        softAssert.assertTrue(errorMessage.contains("description must contain a minimum of 40 and a maximum of 3000 letters"));

        softAssert.assertAll();
    }
}
