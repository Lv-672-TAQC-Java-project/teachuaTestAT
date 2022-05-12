package com.ita.edu.teachua.api.models;

import lombok.Data;

@Data
public class SuccessSingInResponse {
    int id;
    String email;
    String accessToken;
}
