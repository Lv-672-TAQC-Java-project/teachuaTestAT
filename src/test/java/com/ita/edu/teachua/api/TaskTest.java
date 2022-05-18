package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.TaskClient;
import com.ita.edu.teachua.api.models.credenntials.TaskCredentials;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskTest extends ApiTestRunner {
    // to be extended
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
}
