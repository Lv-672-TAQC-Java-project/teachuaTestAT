package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorResponse;
import com.ita.edu.teachua.api.models.TaskCredentials;
import com.ita.edu.teachua.api.models.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskTempTest extends ApiTestRunner{
    private TaskClient client;

    @BeforeClass
    public void setUpClass(){
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        client = new TaskClient(authorization.getToken());
    }

    @Description("Verify that user can not edit Task using null, spaces as values")
    @Issue("TUA-446")
    @Test(description = "TUA-446")
    public void verifyThatUserCanCreateNewClub() {
        TaskCredentials credentials = new TaskCredentials(null, provider.getHeaderTextChallenge(),
                null, provider.getPictureChallenge(), provider.getStartDateChallenge(),
                Long.parseLong(provider.getChallengeId()));
        Response response = client.put(22, credentials);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);
//        {
//  "name": " ",
//  "headerText": "stringstringstringstringstringstringstri",
//  "description": " ",
//  "picture": "/upload/test/test.png",
//  "startDate": "2022-11-13",
//  "challengeId": 0
//}
//
//        name не може бути пустим and name must contain a minimum of 5 and a maximum of 255
//        letters and description can't contain russian letters and name can't contain russian letters

//        {
//            "name": " namenamena ",
//                "description": " descriptiondescriptiondescriptiondescriptiondescription ",
//                "picture": "/upload/test/test.png",
//                "startDate": "2021-11-03"
//        }
//        startDate має бути в майбутньому and headerText не може бути пустим and challengeId не може бути відсутнім,
//        має бути задано
        var softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "name must not be blank");
        softAssert.assertAll();

    }
}
