package com.ita.edu.teachua.api.client;

import com.ita.edu.teachua.api.models.credenntials.UserCredentials;
import io.restassured.response.Response;

public class SingInClient extends BaseClient {
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
