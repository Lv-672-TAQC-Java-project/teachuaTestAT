package com.ita.edu.teachua.api.models.response;

import lombok.Data;

@Data
public class ErrorResponse {
    int status;
    String message;
}
