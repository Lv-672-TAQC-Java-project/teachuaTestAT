package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class ComplaintEntity {
    public static final String SELECT_ALL = "SELECT * FROM complaints ORDER BY id;";

    private Long id;
    private String date;
    private String text;
    private Long club_id;
    private Long user_id;

    public ComplaintEntity(Long id, String date, String text, Long club_id, Long user_id) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.club_id = club_id;
        this.user_id = user_id;
    }

    public ComplaintEntity() {
        this.id = 0l;
        this.date = null;
        this.text = null;
        this.club_id = 0l;
        this.user_id = 0l;
    }

    public static ComplaintEntity getComplaint(List<String> row) {
        ComplaintEntity complaint = new ComplaintEntity();
        complaint.setId(Long.parseLong(row.get(0)));
        complaint.setDate(row.get(1));
        complaint.setText(row.get(2));
        complaint.setClub_id(Long.parseLong(row.get(3)));
        complaint.setUser_id(Long.parseLong(row.get(4)));
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

    public void setClub_id(Long club_id) {
        this.club_id = club_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Long getClub_id() {
        return club_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "ComplaintEntity{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", club_id=" + club_id +
                ", user_id=" + user_id +
                '}';
    }
}
