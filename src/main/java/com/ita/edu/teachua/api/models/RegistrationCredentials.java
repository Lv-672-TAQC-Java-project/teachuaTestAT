package com.ita.edu.teachua.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationCredentials {
    int id;
    String firstName;
    String lastName;
    String phone;
    String email;
    String password;
    String roleName;
    String verificationCode;
    String urlLogo;
    String status;

    public RegistrationCredentials(String firstName, String lastName,String email, String password, String phone, String roleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.roleName = roleName;
    }
}