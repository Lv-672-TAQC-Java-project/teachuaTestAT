package com.ita.edu.teachua.utils;

import com.jayway.jsonpath.JsonPath;

import java.util.Map;

public class JsonUtils {

    public static String setFieldsToJsonBodyByJsonPath(String jsonBody, Map<String, Object> parameters) {
        var context = JsonPath.parse(jsonBody);
        parameters.forEach(context::set);
        return context.jsonString();
    }
}
