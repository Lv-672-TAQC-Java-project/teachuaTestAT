package com.ita.edu.teachua.api.models.response.user;

import lombok.Data;

@Data
public class SuccessSingInResponse {
    int id;
    String email;
    String accessToken;
}
