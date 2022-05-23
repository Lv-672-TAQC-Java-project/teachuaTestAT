package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.SingInClient;
import com.ita.edu.teachua.api.client.UserClient;
import com.ita.edu.teachua.api.models.credenntials.UserCredentials;
import com.ita.edu.teachua.api.models.response.user.SuccessSignInResponse;
import com.ita.edu.teachua.api.models.response.user.UserResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends ApiTestRunner {

    @Test
    public void singInTest() {
        UserCredentials credentials = new UserCredentials(provider.getAdminEmail(), provider.getAdminPassword());
        SingInClient client = new SingInClient();
        Response response = client.successSingInRequest(credentials);
        SuccessSignInResponse singInResponse = response.as(SuccessSignInResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(singInResponse.getEmail(), provider.getAdminEmail());
        softAssert.assertEquals(singInResponse.getId(), 1);
        softAssert.assertAll();

    }

    @Test
    public void getUserByIdTest() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getPassword());
        UserClient userClient = new UserClient(authorization.getToken());
        Response response = userClient.get(1);
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
