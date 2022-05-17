package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.RegistrationClient;
import com.ita.edu.teachua.api.models.response.ErrorResponse;
import com.ita.edu.teachua.api.models.credenntials.RegistrationCredentials;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.UserService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class RegistrationTest extends ApiTestRunner{

    @Description("This test case verifies that a user can't be created with invalid data in 'Email' field.")
    @Issue("TUA-499")
    @Test(description = "TUA-499")
    public void VerifyThatUserWithInvalidDataCanNotBeCreated() {
        RegistrationCredentials credentials = new RegistrationCredentials(provider.getFirstName(),
                provider.getLastName(),
                provider.getWrongEmail(),
                provider.getPassword(),
                provider.getPhone(),
                provider.getRoleName());
        Response response = new RegistrationClient().post(credentials);
        ErrorResponse registrationResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registrationResponse.getStatus(), 400);
        softAssert.assertEquals(registrationResponse.getMessage(), "email is not valid");

        List<UserEntity> usersWithExpectedEmail = new UserService().getAllUsersWhereEmail(provider.getWrongEmail());
        softAssert.assertTrue(usersWithExpectedEmail.isEmpty(), "This user should not be created");

        softAssert.assertAll();
    }
}
