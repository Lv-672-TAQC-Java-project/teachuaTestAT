package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.UserClient;
import com.ita.edu.teachua.api.models.credenntials.UserCredentials;
import com.ita.edu.teachua.api.models.response.ErrorResponse;
import com.ita.edu.teachua.api.models.response.user.UserResponse;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.UserService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

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
        UserCredentials userCredentials = new UserCredentials(provider.getFirstName(),
                provider.getLastName(),
                provider.getEmail(),
                provider.getPhone(),
                provider.getRoleName(),
                provider.getUrlLogo(),
                provider.getStatus());
        SoftAssert softAssert = new SoftAssert();

        userCredentials.setFirstName(null);
        Response response = client.put(203, userCredentials);
        ErrorResponse userResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "\"firstName\" can`t be null");
        userCredentials.setFirstName(provider.getFirstName());

        userCredentials.setLastName(null);
        response = client.put(203, userCredentials);
        userResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "\"lastName\" can`t be null");
        userCredentials.setLastName(provider.getLastName());

        userCredentials.setPhone(null);
        response = client.put(203, userCredentials);
        userResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(userResponse.getStatus(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "phone must not be blank");

        softAssert.assertAll();
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

    @Description("Verify that user can not save changes where enter invalid data in field 'Phone'")
    @Issue("TUA-421")
    @Test(description = "TUA-421")
    public void verifyThatUserCanNotSaveChangesWhereEnterInvalidDataInFieldPhone() {
        UserCredentials userCredentials = new UserCredentials("Nastia", "Kukh", "soyec48727@busantei.com",
                "123456789121212", "ROLE_MANAGER", null, "true");
        Response response = client.put(203, userCredentials);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");

        userCredentials = new UserCredentials("Nastia", "Kukh", "soyec48727@busantei.com",
                "assdsdsd", "ROLE_MANAGER", null, "true");
        response = client.put(203, userCredentials);
        errorResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");

        userCredentials = new UserCredentials("Nastia", "Kukh", "soyec48727@busantei.com",
                "@$#%#%^", "ROLE_MANAGER", null, "true");
        response = client.put(203, userCredentials);
        errorResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "phone Phone number must contain 10 numbers and can`t contain other symbols");

        List<UserEntity> usersWithExpectedId = new UserService().getAllUsersWhereId(203);
        softAssert.assertEquals(usersWithExpectedId.get(0).getFirstName(), "Anna", "First name should be Anna");
        softAssert.assertEquals(usersWithExpectedId.get(0).getLastName(), "Kukarska", "Last name should be Kukarska");
        softAssert.assertEquals(usersWithExpectedId.get(0).getEmail(), "soyec48727@busantei.com", "Email should be soyec48727@busantei.com");
        softAssert.assertEquals(usersWithExpectedId.get(0).getPhone(),"0999999911", "Phone should be 0999999911");
        softAssert.assertEquals(usersWithExpectedId.get(0).getUrlLogo(),null , "Url logo should be null");
        softAssert.assertEquals(usersWithExpectedId.get(0).getRoleId(),3, "Role id should be 3");
        softAssert.assertFalse(usersWithExpectedId.get(0).getStatus(), "Status should be false");

        softAssert.assertAll();
    }
}
