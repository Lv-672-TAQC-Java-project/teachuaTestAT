package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.LoginCredentials;
import io.restassured.response.Response;

public class SingInClient extends BaseClient{
    public SingInClient() {
        super();
    }
    public Response successSingInRequest(LoginCredentials credentials) {
        return prepareRequest()
                .body(credentials)
                .when()
                .post(baseUrl + "/api/signin");
    }
}
