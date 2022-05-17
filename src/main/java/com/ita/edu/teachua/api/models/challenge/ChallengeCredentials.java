package com.ita.edu.teachua.api.models.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChallengeCredentials {
    String name;
    String description;
    String picture;
    String startDate;
}
