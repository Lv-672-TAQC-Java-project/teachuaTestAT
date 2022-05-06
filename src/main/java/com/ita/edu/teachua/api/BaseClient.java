package com.ita.edu.teachua.api;


import com.ita.edu.teachua.utils.ValueProvider;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class BaseClient {
    protected String baseUrl;
    protected ContentType contentType;
    protected ValueProvider valueProvider;


    public BaseClient() {
        if (valueProvider == null) {
            try {
                valueProvider = new ValueProvider();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        baseUrl = valueProvider.getAPIBaseUrl();
        contentType = ContentType.JSON;
    }

    protected RequestSpecification prepareRequest() {
        return given()
                .baseUri(baseUrl)
                .contentType(contentType)
                .accept(contentType);
    }
}
