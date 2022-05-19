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
}
