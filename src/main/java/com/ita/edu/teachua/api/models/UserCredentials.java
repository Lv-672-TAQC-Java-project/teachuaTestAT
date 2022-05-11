package com.ita.edu.teachua.api.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCredentials {
    private String email;
    private String password;
}