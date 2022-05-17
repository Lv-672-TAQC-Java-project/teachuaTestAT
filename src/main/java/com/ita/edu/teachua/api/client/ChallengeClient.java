package com.ita.edu.teachua.api.client;

import io.restassured.response.Response;

import java.util.Map;

import static com.ita.edu.teachua.utils.FileReader.getFileAsString;
import static com.ita.edu.teachua.utils.JsonUtils.setFieldsToJsonBodyByJsonPath;

public class ChallengeClient extends BaseClient {
    private final String authorizationToken;
    public static final String CHALLENGE_JSON = "src/test/resources/json/Challenge.json";
    public static final String CHALLENGE_INPUT_BODY = getFileAsString(CHALLENGE_JSON);

    public ChallengeClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response post(int sortNumber) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .body(setFieldsToJsonBodyByJsonPath(CHALLENGE_INPUT_BODY, Map.of(
                        "$..sortNumber", sortNumber
                )))
                .post(String.format("%s/api/challenge", baseUrl));
    }
}
