package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.ClubCredentials;
import io.restassured.response.Response;

public class Club extends BaseClient {

    private final String authorizationToken;

    public Club(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response postClub(ClubCredentials credentials) {
//In progress
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .body(credentials)
                .when()
                .post(String.format("%s/api/club", baseUrl));
    }
}
