package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.BaseClient;
import com.ita.edu.teachua.api.models.RegistrationCredentials;
import io.restassured.response.Response;

public class RegistrationClient extends BaseClient {
    public RegistrationClient() {
        super();
    }

    public Response post(RegistrationCredentials registrationCredentials) {
        return prepareRequest()
                .body(registrationCredentials)
                .when()
                .post(baseUrl + "/api/signup");
    }
}
