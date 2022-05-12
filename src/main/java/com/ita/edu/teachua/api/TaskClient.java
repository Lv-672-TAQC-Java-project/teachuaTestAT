package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.TaskCredentials;
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
}
