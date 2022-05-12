package com.ita.edu.teachua.api;

import io.restassured.response.Response;

public class ChallengeClient extends BaseClient{
    private final String authorizationToken;

    public ChallengeClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response delete(int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .delete(String.format("%s/api/challenge/%s", baseUrl, id));

    }
}
