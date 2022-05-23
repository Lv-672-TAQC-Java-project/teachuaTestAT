package com.ita.edu.teachua.api.models.credenntials;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserCredentials {
    String firstName;
    String lastName;
    String email;
    String phone;
    String roleName;
    String urlLogo;
    Boolean status;
}
