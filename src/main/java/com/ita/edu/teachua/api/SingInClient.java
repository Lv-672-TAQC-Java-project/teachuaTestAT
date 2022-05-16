package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.SighInCredentials;
import io.restassured.response.Response;

public class SingInClient extends BaseClient{
    public SingInClient() {
        super();
    }
    public Response successSingInRequest(SighInCredentials credentials) {
        return prepareRequest()
                .body(credentials)
                .when()
                .post(baseUrl + "/api/signin");
    }
}
