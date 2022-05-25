package com.ita.edu.teachua.api.models.credenntials;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCredentialsPut {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String urlLogo;
    private String status;
    private String roleName;
}
