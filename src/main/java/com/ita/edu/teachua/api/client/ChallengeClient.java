package com.ita.edu.teachua.api.client;

import com.ita.edu.teachua.api.models.credenntials.ChallengeCredentials;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

import static com.ita.edu.teachua.utils.FileReader.getFileAsString;
import static com.ita.edu.teachua.utils.JsonUtils.setFieldsToJsonBodyByJsonPath;

public class ChallengeClient extends BaseClient {
    private String authorizationToken;
    public static final String CHALLENGE_JSON = "src/test/resources/json/Challenge.json";
    public static final String CHALLENGE_INPUT_BODY = getFileAsString(CHALLENGE_JSON);

    public ChallengeClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public ChallengeClient() {

    }

    @Step("Send a request to create a new challenge")
    public Response post(int sortNumber) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .body(setFieldsToJsonBodyByJsonPath(CHALLENGE_INPUT_BODY, Map.of(
                        "$..sortNumber", sortNumber
                )))
                .post(String.format("%s/api/challenge", baseUrl));
    }

    public Response postChallenge(ChallengeCredentials credentials) {

        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .body(credentials)
                .when()
                .post(String.format("%s/api/challenge", baseUrl));
    }

    public Response delete(int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .delete(String.format("%s/api/challenge/%s", baseUrl, id));
    }

    public Response putChallenge(int id, ChallengeCredentials credentials) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .body(credentials)
                .when()
                .put(String.format("%s/api/challenge/%s", baseUrl, id));
    }
    public Response get(int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .get(String.format("%s/api/challenge/%s", baseUrl, id));

    }

    public Response getWithoutAuthorization(int id) {
        return prepareRequest()
                .when()
                .get(String.format("%s/api/challenge/%s", baseUrl, id));
    }
}
