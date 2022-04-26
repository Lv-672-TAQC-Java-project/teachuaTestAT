package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class ComplaintEntity {
    public static final String SELECT_ALL = "SELECT * FROM complaints ORDER BY id;";

    private Long id;
    private String date;
    private String text;
    private Long clubId;
    private Long userId;

    public ComplaintEntity(Long id, String date, String text, Long clubId, Long userId) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.clubId = clubId;
        this.userId = userId;
    }

    public ComplaintEntity() {
        this.id = 0l;
        this.date = null;
        this.text = null;
        this.clubId = 0l;
        this.userId = 0l;
    }

    public static ComplaintEntity getComplaint(List<String> row) {
        ComplaintEntity complaint = new ComplaintEntity();
        complaint.setId(Long.parseLong(row.get(0)));
        complaint.setDate(row.get(1));
        complaint.setText(row.get(2));
        complaint.setClubId(Long.parseLong(row.get(3)));
        complaint.setUserId(Long.parseLong(row.get(4)));
        return complaint;
    }

    public static List<ComplaintEntity> getComplaints(List<List<String>> rows) {
        List<ComplaintEntity> complaints = new ArrayList<>();
        for (List<String> row : rows) {
            complaints.add(getComplaint(row));
        }
        return complaints;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Long getClubId() {
        return clubId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "ComplaintEntity{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", clubId=" + clubId +
                ", userId=" + userId +
                '}';
    }
}
