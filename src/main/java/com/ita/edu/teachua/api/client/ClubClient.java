package com.ita.edu.teachua.api.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

import static com.ita.edu.teachua.utils.FileReader.getFileAsString;
import static com.ita.edu.teachua.utils.JsonUtils.setFieldsToJsonBodyByJsonPath;

public class ClubClient extends BaseClient {
    public static final String CLUB_JSON = "src/test/resources/json/Club.json";
    public static final String CLUB_INVALID_JSON = "src/test/resources/json/ClubInvalid.json";
    public static final String CLUB_INPUT_BODY = getFileAsString(CLUB_JSON);
    public static final String CLUB_INVALID_INPUT_BODY = getFileAsString(CLUB_INVALID_JSON);
    private final String authorizationToken;

    public ClubClient(String authorizationToken) {
        super();
        this.authorizationToken = authorizationToken;
    }

    public Response post(String name) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .body(setFieldsToJsonBodyByJsonPath(CLUB_INPUT_BODY, Map.of(
                        "$..name", name
                )))
                .post(String.format("%s/api/club", baseUrl));
    }

    public Response post() {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .body(CLUB_INVALID_INPUT_BODY)
                .post(String.format("%s/api/club", baseUrl));
    }

    @Step("Deleted response by id")
    public Response delete(int id) {
        return prepareRequest()
                .header("Authorization", String.format("Bearer %s", authorizationToken))
                .when()
                .delete(String.format("%s/api/club/%s", baseUrl, id));
    }
}
