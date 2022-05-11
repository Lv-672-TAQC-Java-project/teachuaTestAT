package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.UserResponse;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserTest extends ApiTestRunner{
    private UserClient client;
    @BeforeClass
    public void setUpClass(){
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getPassword());
        client = new UserClient(authorization.getToken());
    }

    @Test
    public void VerifyThatUserCanNotSaveChangesWhereMandatoryFieldsAreEmpty(){
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
