package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorResponse;
import com.ita.edu.teachua.api.models.TaskCredentials;
import com.ita.edu.teachua.api.models.UserResponse;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskTest extends ApiTestRunner{
    private TaskClient client;
    @BeforeClass
    public void setUpClass(){
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        client = new TaskClient(authorization.getToken());
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
        SoftAssert softAssert = new SoftAssert();
        Response response = client.post(168, credentials);
        ErrorResponse taskResponse = response.as(ErrorResponse.class);
        softAssert.assertEquals(taskResponse.getStatus(), 400);
        softAssert.assertTrue(!taskResponse.getMessage().isEmpty());
        softAssert.assertAll();
    }

}
