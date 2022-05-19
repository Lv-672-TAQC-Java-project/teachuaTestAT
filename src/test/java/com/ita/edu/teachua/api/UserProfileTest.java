package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.UserClient;
import com.ita.edu.teachua.api.models.credenntials.UserCredentialsPut;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.EditMyProfileComponent;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.UserService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class UserProfileTest extends TestRunnerWithValueProvider {

    private UserClient userClient;

    @BeforeClass
    public void setUpClass() {
        Authorization authorizationUser = new Authorization(valueProvider.getUserEmail(), valueProvider.getUserPassword());
        userClient = new UserClient(authorizationUser.getToken());
    }

    @Description("User can edit profile with valid data")
    @Issue("TUA-408")
    @Test(description = "TUA-408")
    public void verifyUserCanEditProfile() {

        UserCredentialsPut userCredentialsPutName = new UserCredentialsPut
                ("Anna",
                        "Kukh",
                        valueProvider.getUserEmail(),
                        "0999999922",
                        null,
                        "true",
                        "ROLE_MANAGER");

        Response response = userClient.putUser(203, userCredentialsPutName);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);

        UserCredentialsPut userCredentialsPutLastName = new UserCredentialsPut
                ("Anna",
                        "Kukarska",
                        valueProvider.getUserEmail(),
                        "0999999922",
                        null,
                        "true",
                        "ROLE_MANAGER");

        response = userClient.putUser(203, userCredentialsPutLastName);

        softAssert.assertEquals(response.getStatusCode(), 200);

        UserCredentialsPut userCredentialsPutPhone = new UserCredentialsPut
                ("Anna",
                        "Kukarska",
                        valueProvider.getUserEmail(),
                        "0999999911",
                        null,
                        "true",
                        "ROLE_MANAGER");

        response = userClient.putUser(203, userCredentialsPutPhone);

        softAssert.assertEquals(response.getStatusCode(), 200);

        HomePage openMyProfile = new HomePage(driver);
        openMyProfile
                .login(valueProvider.getUserEmail(), valueProvider.getUserPassword());

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        myProfilePage
                .clickDropDownMyProfileButton()
                .clickMyProfileButton()
                .clickEditMyProfileComponent();

        EditMyProfileComponent editMyProfileComponent = new EditMyProfileComponent(driver);

        softAssert.assertEquals(editMyProfileComponent.getLastNameProfile(), "Kukarska");

        softAssert.assertEquals(editMyProfileComponent.getFirstNameProfile(), "Anna");

        softAssert.assertEquals(editMyProfileComponent.getPhoneProfile(), "0999999911");

        List<UserEntity> usersWithExpectedEmail = new UserService().getAllUsersWhereEmailLike(valueProvider.getUserEmailLike());

        softAssert.assertEquals(usersWithExpectedEmail.get(0).getFirstName(), "Anna");

        softAssert.assertAll();
    }
}
