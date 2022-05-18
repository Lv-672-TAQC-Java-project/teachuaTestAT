package com.ita.edu.teachua.utils.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class ClubsEntity {
    public static final String SELECT_ALL = "SELECT * FROM clubs ORDER BY id;";
    public static final String SELECT_ALL_WHERE_NAME = "SELECT * FROM clubs WHERE name = '%s';";
    public static final String SELECT_NAME = "SELECT name FROM public.clubs ORDER BY id;";
    public static final String SELECT_ALL_BY_RATING_ASC = "SELECT * FROM clubs ORDER BY rating ASC;";
    public static final String SELECT_ALL_BY_RATING_DESC = "SELECT * FROM clubs ORDER BY rating DESC;";

    private Long id;
    private Integer ageFrom;
    private Integer ageTo;
    private Long centerExternalId;
    private Long clubExternalId;
    private String contacts;
    private String description;
    private Boolean isApproved;
    private Boolean isOnline;
    private String name;
    private Double rating;
    private String urlBackground;
    private String urlLogo;
    private String urlWeb;
    private String workTime;
    private Long centerId;
    private Long userId;
    private Long feedbackCount;

    public ClubsEntity() {
        this.id = 0L;
        this.ageFrom = 0;
        this.ageTo = 0;
        this.centerExternalId = 0L;
        this.clubExternalId = 0L;
        this.contacts = null;
        this.description = null;
        this.isApproved = null;
        this.isOnline = null;
        this.name = null;
        this.rating = 0.0;
        this.urlBackground = null;
        this.urlLogo = null;
        this.urlWeb = null;
        this.workTime = null;
        this.centerId = 0L;
        this.userId = 0L;
        this.feedbackCount = 0L;
    }

    public static ClubsEntity getClub(List<String> row) {
        ClubsEntity clubs = new ClubsEntity();
        clubs.setId(Long.parseLong(row.get(0)));
        clubs.setAgeFrom(Integer.valueOf(row.get(1)));
        clubs.setAgeTo(Integer.valueOf(row.get(2)));
        if (row.get(3) != null) {
            clubs.setCenterExternalId(Long.valueOf(row.get(3)));
        }
        if (row.get(4) != null) {
            clubs.setClubExternalId(Long.valueOf(row.get(4)));
        }
        clubs.setContacts(row.get(5));
        clubs.setDescription(row.get(6));
        if (row.get(7) != null) {
            clubs.setIsApproved(Boolean.valueOf(row.get(7)));
        }
        if (row.get(8) != null) {
            clubs.setIsOnline(row.get(8) == "t");
        }
        clubs.setName(row.get(9));
        clubs.setRating(Double.valueOf(row.get(10)));
        clubs.setUrlBackground(row.get(11));
        clubs.setUrlLogo(row.get(12));
        clubs.setUrlWeb(row.get(13));
        clubs.setWorkTime(row.get(14));
        if (row.get(15) != null) {
            clubs.setCenterId(Long.valueOf(row.get(15)));
        }
        if (row.get(16) != null) {
            clubs.setUserId(Long.valueOf(row.get(16)));
        }
        if (row.get(17) != null) {
            clubs.setFeedbackCount(Long.valueOf(row.get(17)));
        }

        return clubs;
    }

    public static List<ClubsEntity> getClubs(List<List<String>> rows) {
        List<ClubsEntity> clubs = new ArrayList<>();
        for (List<String> row : rows) {
            clubs.add(getClub(row));
        }
        return clubs;
    }

    public static ClubsEntity getClubName(List<String> row) {
        ClubsEntity clubs = new ClubsEntity();
        clubs.setName(row.get(0));

        return clubs;
    }

    public static List<ClubsEntity> getClubsName(List<List<String>> rows) {
        List<ClubsEntity> clubs = new ArrayList<>();
        for (List<String> row : rows) {
            clubs.add(getClubName(row));
        }
        return clubs;
    }
}
