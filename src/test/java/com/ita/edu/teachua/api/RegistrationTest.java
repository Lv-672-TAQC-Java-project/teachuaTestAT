package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorResponse;
import com.ita.edu.teachua.api.models.RegistrationCredentials;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationTest {

    @Test
    public void VerifyThatUserWithInvalidDataCanNotBeCreated(){
        RegistrationCredentials credentials = new RegistrationCredentials("firstname",
                "lastname",
                "email",
                "Password_12",
                "0938787789",
                "ROLE_MANAGER");
        RegistrationClient registrationClient = new RegistrationClient();
        Response response = registrationClient.post(credentials);
        ErrorResponse registrationResponse = response.as(ErrorResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registrationResponse.getStatus(), 400);
        softAssert.assertEquals(registrationResponse.getMessage(), "email is not valid");
        softAssert.assertAll();
    }
}
