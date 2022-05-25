package com.ita.edu.teachua.utils.jdbc.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintEntity {
    public static final String SELECT_ALL = "SELECT * FROM complaints ORDER BY id;";

    private Long id;
    private Date date;
    private String text;
    private Long clubId;
    private Long userId;

    public ComplaintEntity(Long id, Date date, String text, Long clubId, Long userId) {
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

    public static ComplaintEntity getComplaint(List<String> row) throws ParseException {
        ComplaintEntity complaint = new ComplaintEntity();
        complaint.setId(Long.parseLong(row.get(0)));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        SimpleDateFormat exceptionDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (row.get(1) != null) {
                Date date = dateFormat.parse(row.get(1));
                complaint.setDate(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            Date date = exceptionDateFormat.parse(row.get(1));
            complaint.setDate(date);
        }
        complaint.setText(row.get(2));
        complaint.setClubId(Long.parseLong(row.get(3)));
        complaint.setUserId(Long.parseLong(row.get(4)));
        return complaint;
    }

    public static List<ComplaintEntity> getComplaints(List<List<String>> rows) throws ParseException {
        List<ComplaintEntity> complaints = new ArrayList<>();
        for (List<String> row : rows) {
            complaints.add(getComplaint(row));
        }
        return complaints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
