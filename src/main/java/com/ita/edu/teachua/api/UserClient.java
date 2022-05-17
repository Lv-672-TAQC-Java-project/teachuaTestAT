package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.User1Credentials;
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

    public Response put(int id, User1Credentials credentials){
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .body(credentials)
                .when()
                .put(String.format("%s/api/user/%s", baseUrl, id));
    }

}
