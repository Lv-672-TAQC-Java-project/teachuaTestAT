package com.ita.edu.teachua.api;

import io.restassured.response.Response;

public class UserClient extends BaseClient{
    private final String authorizationToken;

    public UserClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response get(int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .get(String.format("%s/api/user/%s", baseUrl, id));

    }

    public Response put(int id){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .get(String.format("%s/api/user/%s", baseUrl, id));
    }

}
