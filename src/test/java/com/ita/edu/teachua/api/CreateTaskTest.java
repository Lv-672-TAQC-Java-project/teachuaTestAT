package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateTaskTest extends ApiTestRunner {

    private Task task;
    @BeforeClass
    public void setUpClass(){
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        task = new Task(authorization.getToken());
    }


    @Test
    public void singInTest() {
TaskCredentials taskCredentials = new TaskCredentials(" namenamename1213#$% ","stringstringstringstringstringstringstringstring",
        " descriptiondescriptiondescriptiondescriptiondescription12345$%%^$# ","/upload/test/test.png", "2022-05-25");
        Response response = task.post(1, taskCredentials);
        System.out.println(response.getStatusCode());
        TaskResponse taskResponse = response.as(TaskResponse.class);
        System.out.println(taskResponse.getName());

    }
}
