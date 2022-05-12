package com.ita.edu.teachua.api;

import com.ita.edu.teachua.api.models.TaskCredentials;
import io.restassured.response.Response;

public class TaskClient extends BaseClient {
    private final String authorizationToken;

    public TaskClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response put(int id, TaskCredentials credentials) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .body(credentials)
                .put(String.format("%s/api/challenge/task/%s", baseUrl, id));
    }
}
