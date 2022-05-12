package com.ita.edu.teachua.api.models;

import lombok.Data;

@Data
public class ErrorResponse {
    private String status;
    private String message;
}
