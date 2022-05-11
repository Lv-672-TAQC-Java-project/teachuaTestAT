package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.*;
import com.ita.edu.teachua.api.models.clubs.NewClubCredentials;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateNewClub extends ApiTestRunner {

    private HeadOfTheClubClient client;

    @BeforeClass
    public void setUpClass() {
        Authorization authorization = new Authorization(provider.getAdminEmail(), provider.getAdminPassword());
        client = new HeadOfTheClubClient(authorization.getToken());
    }

    @Test
    public void getUserByIdTest() {
        NewClubCredentials credentials = new NewClubCredentials(providerCredentials.getCategoriesName(), providerCredentials.getName(),
                Integer.parseInt(providerCredentials.getAgeFrom()), Integer.parseInt(providerCredentials.getAgeTo()),
                providerCredentials.getUrlLogo(), providerCredentials.getUrlBackground(), Boolean.parseBoolean(providerCredentials.getIsOnline()),
                providerCredentials.getDescription(), providerCredentials.getUserId(), providerCredentials.getLocations(),
                providerCredentials.getContacts(), Integer.parseInt(providerCredentials.getCenterId()));
        Response response = client.post(credentials);
        ErrorResponse userResponse = response.as(ErrorResponse.class);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertEquals(userResponse.getMessage(), "name Довжина назви має бути від 5 до 100 символів");
        softAssert.assertAll();
    }
}
