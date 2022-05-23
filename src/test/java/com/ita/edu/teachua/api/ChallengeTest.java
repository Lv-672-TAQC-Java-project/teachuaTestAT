package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.ChallengeClient;
import com.ita.edu.teachua.api.models.credenntials.ChallengeCredentials;
import com.ita.edu.teachua.api.models.response.ErrorResponse;
import com.ita.edu.teachua.api.models.response.challenge.ChallengeResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ChallengeTest extends ApiTestRunner {

    private ChallengeClient client;

    @DataProvider(name = "credentials")
    public Object[][] credentials() {

        return new Object[][]{
                {provider.getNonAdminEmail(), provider.getNonAdminPassword()},
                {provider.getAdminEmail(), provider.getAdminPassword()},
        };
    }

    @Description("Verify that user is able to create Challenge using valid values")
    @Issue("TUA-429")
    @Test(description = "TUA-429")
    public void verifyThatUserIsAbleToCreateChallengeUsingValidData() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        ChallengeClient client = new ChallengeClient(authorization.getToken());

        Random random = new Random();
        int sortNumber = random.nextInt(200);
        Response response = client.post(sortNumber);

        assertEquals(response.getStatusCode(), 200, "Challenge is successfully created");
    }

    @DataProvider
    public Object[][] inputDate() {
        ChallengeCredentials challengeCredentialsNull = new ChallengeCredentials
                (null, null, null, null, null, null);
        ChallengeCredentials challengeCredentialsSpaces = new ChallengeCredentials
                (" ", " ", " ", " ", " ", " ");
        ChallengeCredentials challengeCredentialsSymbols = new ChallengeCredentials
                ("", "", "", "", "", "");

        return new Object[][]{

                {challengeCredentialsNull, 400},
                {challengeCredentialsSpaces, 400},
                {challengeCredentialsSymbols, 400},
        };
    }

    @Description("Verify that user is not able to create Challenge using null, spaces or absence of symbols as values")
    @Issue("TUA-431")
    @Test(dataProvider = "inputDate")
    public void verifyCreateChallengeUsingNullSpaceSymbols(ChallengeCredentials inputDate, int expect) {

        Response response = client.postChallenge(inputDate);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), expect);
        softAssert.assertAll();
    }

    @Description("Verify that user is not able to delete Challenge using non-administrator rights")
    @Issue("TUA-436")
    @Test(description = "TUA-436")
    public void verifyThatUserIsNotAbleToDeleteChallengeUsingNonAdministratorRights() {
        Authorization authorization = new Authorization(provider.getUserWithNonAdministratorRightsEmail(),
                provider.getUserWithNonAdministratorRightsPassword());
        client = new ChallengeClient(authorization.getToken());
        Response response = client.delete(147);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 401);
        softAssert.assertEquals(errorResponse.getMessage(), "You have no necessary permissions (role)");
        softAssert.assertAll();
    }

    @Description("Verify that user is not able to edit information about Challenge using null, spaces or absence of symbols as values")
    @Issue("TUA-434")
    @Test(description = "TUA-434", dataProvider = "inputDate")
    public void verifyThatUserIsNotAbleToEditInformationUsingNullSpaceSymbols(ChallengeCredentials inputDate, int expect) {
        var response = client.putChallenge(143, inputDate);

        var softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), expect);
        softAssert.assertAll();
    }

    @Description("Verify that user with any rights can view info about specific Challenge")
    @Issue("TUA-437")
    @Test(dataProvider = "credentials")
    public void verifyThatUserWithAnyRightsCanViewInfoAboutSpecificChallenge(String email, String password) {

        Authorization authorization = new Authorization(email, password);
        client = new ChallengeClient(authorization.getToken());
        Response response = client.get(196);
        ChallengeResponse challengeResponse = response.as(ChallengeResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(challengeResponse.getId(), 196);

        softAssert.assertAll();
    }

    @Description("Verify that user without authorization can view info about specific Challenge")
    @Issue("TUA-437")
    @Test(description = "TUA-437")
    public void verifyThatUserWithoutAuthorizationCanViewInfoAboutSpecificChallenge() {

        ChallengeClient client = new ChallengeClient();
        Response responseWithoutAuthorization = client.getWithoutAuthorization(196);
        ChallengeResponse challengeResponse = responseWithoutAuthorization.as(ChallengeResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseWithoutAuthorization.getStatusCode(), 200);
        softAssert.assertEquals(challengeResponse.getId(), 196);
        softAssert.assertAll();
    }

    @Description("This test case verifies that user is not able to create Challenge using invalid values")
    @Issue("TUA-430")
    @Test(description = "TUA-430")
    public void verifyThatUserIsNotAbleToCreateChallengeUsingInvalidValues() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        client = new ChallengeClient(authorization.getToken());
        ChallengeCredentials challengeCredentials = new ChallengeCredentials("nam",
                "tit",
                "des",
                "",
                "/upload/test/test.png",
                "1");

        Response response = client.postChallenge(challengeCredentials);
        ErrorResponse challengeErrorResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(challengeErrorResponse.getStatus(), 400);
        softAssert.assertFalse(challengeErrorResponse.getMessage().isEmpty());

        challengeCredentials = new ChallengeCredentials("Lorem ipsum dolor sit amet, consect",
                "Lorem ipsum dolor sit amet, consect",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eu",
                "",
                "/upload/test/test.png",
                "1");

        response = client.postChallenge(challengeCredentials);
        challengeErrorResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(challengeErrorResponse.getStatus(), 400);
        softAssert.assertFalse(challengeErrorResponse.getMessage().isEmpty());

        challengeCredentials = new ChallengeCredentials("эЭъЪыЫёЁ",
                "эЭъЪыЫёЁ",
                "эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ",
                "",
                "/upload/test/test.png",
                "1");

        response = client.postChallenge(challengeCredentials);
        challengeErrorResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(challengeErrorResponse.getStatus(), 400);
        softAssert.assertFalse(challengeErrorResponse.getMessage().isEmpty());
        softAssert.assertAll();
    }

    @Description("This test case verifies that user is not able to edit information about Challenge using valid values")
    @Issue("TUA-432")
    @Test(description = "TUA-432")
    public void VerifyThatUserIsAbleToEditChallengeUsingValidValues() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        ChallengeClient client = new ChallengeClient(authorization.getToken());

        ChallengeCredentials challengeCredentials = new ChallengeCredentials("Example name",
                "Example title",
                "Lorem ipsum dolor sit amet, consectetuer adipiscin",
                "https://docs.google.com/forms/d/e/132/viewform?embedded=true",
                "/upload/test/test.png",
                "1",
                "true");

        Response response = client.putChallenge(171, challengeCredentials);
//        ErrorResponse challengeResponse = response.as(ErrorResponse.class);
//        System.out.println(challengeResponse.getMessage());

        Assert.assertEquals(response.getStatusCode(), 200, "Server should be responded with status 200");
    }
}
