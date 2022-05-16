package com.ita.edu.teachua.api.models;

import lombok.Data;

@Data
public class ErrorResponse {
    int status;
    String message;
}