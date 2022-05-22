package com.ita.edu.teachua.api.client;

import com.ita.edu.teachua.api.models.credenntials.TaskCredentials;
import io.restassured.response.Response;

public class TaskClient extends BaseClient {

    private final String authorizationToken;

    public TaskClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response post(int id, TaskCredentials credentials) {

        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .body(credentials)
                .when()
                .post(String.format("%s/api/challenge/%s/task", baseUrl, id));
    }
    public Response put(int id, TaskCredentials credentials) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .body(credentials)
                .put(String.format("%s/api/challenge/task/%s", baseUrl, id));
    }
}
