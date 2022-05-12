package com.ita.edu.teachua.api.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCredentials {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String urlLogo;
    private String status;
    private String roleName;

    public void deleteFirstName(){
        this.firstName = null;
    }

    public void deleteLastName(){
        this.lastName = null;
    }

    public void deletePhone(){
        this.phone = null;
    }
}
