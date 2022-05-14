package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorResponse;
import com.ita.edu.teachua.api.models.TaskCredentials;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskTempTest extends ApiTestRunner {
    private TaskClient client;

    @BeforeClass
    public void setUpClass() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        client = new TaskClient(authorization.getToken());
    }

    @Description("Verify that user can not edit Task using null as values")
    @Issue("TUA-446")
    @Test(description = "TUA-446")
    public void verifyThatUserCanCreateNewClubUsingNullAsValues() {
        TaskCredentials credentials = new TaskCredentials(null, provider.getHeaderTextChallenge(),
                null, provider.getPictureChallenge(), provider.getStartDateChallenge(),
                Long.parseLong(provider.getChallengeId()));
        Response response = client.put(22, credentials);
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
        Response response = client.put(22, credentials);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        var softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "name must not be blank and name can't contain russian " +
                "letters and description can't contain russian letters and name must contain a minimum of " +
                "5 and a maximum of 255 letters");
        softAssert.assertAll();
    }

    @Description("Verify that user can not edit Task using spaces as values")
    @Issue("TUA-446")
    @Test(description = "TUA-446", enabled = false)
    public void verifyThatUserCanCreateNewClubUsingSpaces() {
        TaskCredentials credentials = new TaskCredentials(" ", provider.getHeaderTextChallenge(),
                " ", provider.getPictureChallenge(), provider.getStartDateChallenge(),
                Long.parseLong(provider.getChallengeId()));
        Response response = client.put(22, credentials);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);
//        {
//              "name": " namenamena ",
//              "headerText": "stringstringstringstringstringstringstri",
//              "description": " descriptiondescriptiondescriptiondescriptiondescription ",
//              "picture": "/upload/test/test.png",
//              "startDate": "2022-06-14",
//              "challengeId": 169
//         }
//          Code	200
//         {
//              "id": 303,
//              "name": "namenamena",
//              "headerText": "stringstringstringstringstringstringstri",
//              "description": "descriptiondescriptiondescriptiondescriptiondescription",
//              "picture": "/upload/test/test.png",
//              "startDate": [
//                  2022,
//                  6,
//                  14
//              ],
//          "challengeId": 169
//      }
        var softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "name must not be blank and name can't contain russian " +
                "letters and description can't contain russian letters and name must contain a minimum of " +
                "5 and a maximum of 255 letters");
        softAssert.assertAll();
    }
}
