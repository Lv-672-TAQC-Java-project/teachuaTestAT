package com.ita.edu.teachua.api.models;

import lombok.Data;

@Data
public class ErrorRegistrationResponse {
    int status;
    String message;
}