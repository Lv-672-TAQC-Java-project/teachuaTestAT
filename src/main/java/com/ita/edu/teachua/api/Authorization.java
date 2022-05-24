package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.client.SingInClient;
import com.ita.edu.teachua.api.models.credenntials.SignCredentials;
import com.ita.edu.teachua.api.models.response.user.SignInResponse;
import io.restassured.response.Response;

public class Authorization {
    private final SignInResponse singInResponse;

    public Authorization(String email, String password) {
        SignCredentials credentials = new SignCredentials(email, password);
        SingInClient client = new SingInClient();
        Response response = client.successSingInRequest(credentials);
        singInResponse = response.as(SignInResponse.class);
    }

    public String getToken() {
        return singInResponse.getAccessToken();
    }
}
