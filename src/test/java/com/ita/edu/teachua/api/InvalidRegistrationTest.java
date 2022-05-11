package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorRegistrationResponse;
import com.ita.edu.teachua.api.models.RegistrationCredentials;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InvalidRegistrationTest {

    @Test
    public void VerifyThatUserWithInvalidDataCanNotBeCreated(){
        RegistrationCredentials credentials = new RegistrationCredentials("firstname",
                "firstname",
                "email",
                "123456",
                "phone",
                "ROLE_MANAGER");
        RegistrationClient registrationClient = new RegistrationClient();
        Response response = registrationClient.post(credentials);
        ErrorRegistrationResponse registrationResponse = response.as(ErrorRegistrationResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registrationResponse.getStatus(), 401);
        softAssert.assertEquals(registrationResponse.getMessage(), "Incorrect password!");
        softAssert.assertAll();
    }
}
