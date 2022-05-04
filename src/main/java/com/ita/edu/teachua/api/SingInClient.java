package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.UserCredentials;
import io.restassured.response.Response;

import java.io.IOException;

public class SingInClient extends BaseClient{
    public SingInClient() {
        super();
    }
    public Response successSingInRequest(UserCredentials credentials) {
        return prepareRequest()
                .body(credentials)
                .when()
                .post(baseUrl + "/api/signin");
    }
}
