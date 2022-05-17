package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ErrorResponse;
import com.ita.edu.teachua.api.models.User1Credentials;
import com.ita.edu.teachua.api.models.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserTest extends ApiTestRunner {
    private UserClient client;

    @BeforeClass
    public void setUpClass() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        client = new UserClient(authorization.getToken());
    }

    @Description("This test case verifies that user can not save changes where mandatory fields are empty")
    @Issue("TUA-411")
    @Test(description = "TUA-411")
    public void VerifyThatUserCanNotSaveChangesWhereMandatoryFieldsAreEmpty() {
        User1Credentials userCredentials = new User1Credentials(provider.getFirstName(),
                provider.getLastName(),
                provider.getPhone(),
                provider.getEmail(),
                provider.getUrlLogo(),
                provider.getStatus(),
                provider.getRoleName());
        SoftAssert softAssert = new SoftAssert();

        userCredentials.deleteFirstName();
        Response response = client.put(203, userCredentials);
        ErrorResponse userResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "\"firstName\" can`t be null");

        userCredentials.deleteLastName();
        response = client.put(203, userCredentials);
        userResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "\"lastName\" can`t be null");

        userCredentials.deletePhone();
        response = client.put(203, userCredentials);
        userResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "\"phone\" can`t be null");
    }

    @Test
    public void getUserByIdTest() {
        Response response = client.get(1);
        UserResponse userResponse = response.as(UserResponse.class);


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(userResponse.getId(), 1);
        softAssert.assertEquals(userResponse.getFirstName(), "admin");
        softAssert.assertEquals(userResponse.getLastName(), "Admin");
        softAssert.assertEquals(userResponse.getPhone(), "0963254877");
        softAssert.assertEquals(userResponse.getEmail(), "admin@gmail.com");
        softAssert.assertEquals(userResponse.getRoleName(), "ROLE_ADMIN");
        softAssert.assertEquals(userResponse.getUrlLogo(), "/static/images/user/avatar/user1.png");
        softAssert.assertEquals(userResponse.getStatus(), "true");
        softAssert.assertAll();

    }
}
