package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.*;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateTaskTest extends ApiTestRunner {

    private Task task;

    @BeforeClass
    public void setUpClass() {

        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getPassword());
        task = new Task(authorization.getToken());
    }

    @Description("Verify that user can create Task with valid values.")
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
}
