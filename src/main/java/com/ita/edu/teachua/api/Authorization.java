package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.SuccessSingInResponse;
import com.ita.edu.teachua.api.models.UserCredentials;
import io.restassured.response.Response;

public class Authorization {
    private final SuccessSingInResponse singInResponse;

    public Authorization(String email, String password) {
        UserCredentials credentials = new UserCredentials(email, password);
        SingInClient client = new SingInClient();
        Response response = client.successSingInRequest(credentials);
        singInResponse = response.as(SuccessSingInResponse.class);
    }

    public String getToken() {
        return singInResponse.getAccessToken();
    }
}