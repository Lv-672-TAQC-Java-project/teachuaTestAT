package com.ita.edu.teachua.utils.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum FeedbackFeelds {
    ID(0),
    DATE(1),
    RATE(2),
    TEXT(3),
    USER_NAME(4),
    CLUB_ID(5),
    USER_ID(6);

    private final int number;

    FeedbackFeelds(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

@AllArgsConstructor
@Setter
@Getter
public class FeedbackEntity {
    public static final String SELECT_ALL = "SELECT * FROM feedbacks ORDER BY id;";
    private Long clubId;
    private Timestamp date;
    private int id;
    private double rate;
    private String text;
    private Long userId;
    private String userName;

    public FeedbackEntity() {
        this.clubId = 0L;
        this.date = null;
        this.id = 0;
        this.rate = 0;
        this.text = null;
        this.userId = 0L;
        this.userName = null;
    }

    public static FeedbackEntity getFeedback(List<String> row) {
        FeedbackEntity feedbackEntity = new FeedbackEntity();

        feedbackEntity.setClubId(Long.parseLong(row.get(FeedbackFeelds.CLUB_ID.getNumber())));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        try {
            if (row.get(FeedbackFeelds.DATE.getNumber()) != null) {
                Date date = dateFormat.parse(row.get(FeedbackFeelds.DATE.getNumber()));
                feedbackEntity.setDate(new Timestamp(date.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        feedbackEntity.setId(Integer.parseInt(row.get(FeedbackFeelds.ID.getNumber())));
        feedbackEntity.setRate(Double.parseDouble(row.get(FeedbackFeelds.RATE.getNumber())));
        feedbackEntity.setText(row.get(FeedbackFeelds.TEXT.getNumber()));

        if (row.get(FeedbackFeelds.USER_ID.getNumber()) != null) {
            feedbackEntity.setUserId(Long.parseLong(row.get(FeedbackFeelds.USER_ID.getNumber())));
        }

        feedbackEntity.setUserName(row.get(FeedbackFeelds.USER_NAME.getNumber()));

        return feedbackEntity;
    }

    public static List<FeedbackEntity> getFeedbacks(List<List<String>> rows) {
        List<FeedbackEntity> feedbacks = new ArrayList<>();

        for (List<String> row : rows) {
            feedbacks.add(getFeedback(row));
        }

        return feedbacks;
    }

    @Override
    public String toString() {
        return "FeedbackEntity{" +
                "clubId=" + clubId +
                ", date=" + date +
                ", id=" + id +
                ", rate=" + rate +
                ", text='" + text + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
