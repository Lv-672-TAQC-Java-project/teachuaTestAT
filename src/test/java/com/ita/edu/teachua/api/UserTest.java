package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.UserClient;
import com.ita.edu.teachua.api.models.credenntials.UserCredentialsPut;
import com.ita.edu.teachua.api.models.response.user.UserResponse;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.UserService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class UserTest extends ApiTestRunner {
    private UserClient client;
    private UserClient userClient;

    @BeforeClass
    public void setUpClass() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getPassword());
        Authorization authorizationUser = new Authorization(provider.getUserEmail(), provider.getUserPassword());
        client = new UserClient(authorization.getToken());
        userClient = new UserClient(authorizationUser.getToken());
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

    @DataProvider
    public Object[][] inputDate() {
        UserCredentialsPut uerCredentialsPutName = new UserCredentialsPut
                ("Anna", "Kukh", "soyec48727@busantei.com", "0999999922", null, "true", "ROLE_MANAGER");
        UserCredentialsPut userCredentialsPutLastName = new UserCredentialsPut
                ("Anna", "Kukarska", "soyec48727@busantei.com", "0999999922", null, "true", "ROLE_MANAGER");
        UserCredentialsPut userCredentialsPutPhone = new UserCredentialsPut
                ("Anna", "Kukarska", "soyec48727@busantei.com", "0999999911", null, "true", "ROLE_MANAGER");

        return new Object[][]{

                {uerCredentialsPutName, 200},
                {userCredentialsPutLastName, 200},
                {userCredentialsPutPhone, 200},
        };
    }

    @Description("User can edit profile with valid data")
    @Issue("TUA-408")
    @Test(dataProvider = "inputDate")
    public void verifyUserCanEditProfile(UserCredentialsPut user, int expect) {

        Response response = userClient.putUser(203, user);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200);
///////////////////////////////////////////////////////////////////////////////
//        HomePage homePage = new HomePage(driver);
//        homePage
//                .login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());


        List<UserEntity> usersWithExpectedEmail = new UserService().getAllUsersWhereEmailLike(provider.getUserEmailLike());

        softAssert.assertEquals(provider.getUserEmail(), usersWithExpectedEmail.get(0).getEmail());
        System.out.println(usersWithExpectedEmail.get(0).getEmail());

        softAssert.assertAll();
    }
}
