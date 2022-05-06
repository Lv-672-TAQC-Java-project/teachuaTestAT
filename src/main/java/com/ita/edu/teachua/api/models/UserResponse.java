package com.ita.edu.teachua.api.models;

import lombok.Data;

@Data
public class UserResponse {
    int id;
    String firstName;
    String lastName;
    String phone;
    String email;
    String password;
    String roleName;
    String urlLogo;
    String status;
}

