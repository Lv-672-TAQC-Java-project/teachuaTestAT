package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.clubs.NewClubCredentials;
import io.restassured.response.Response;

public class HeadOfTheClubClient extends BaseClient {
    private final String authorizationToken;

    public HeadOfTheClubClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response post (NewClubCredentials credentials) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .body(credentials)
                .when()
                .post(String.format("%s/api/club", baseUrl));
    }

}
