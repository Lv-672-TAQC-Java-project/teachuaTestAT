package com.ita.edu.teachua.utils.jdbc.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TasksEntity {

    public static final String SELECT_ALL = "SELECT * FROM tasks ORDER BY id;";

    private Long id;
    private String description;
    private String name;
    private String picture;
    private Timestamp startDate;
    private Long challengeId;
    private String headerText;

    public TasksEntity(Long id, String description, String name, String picture, Timestamp startDate, Long challengeId, String headerText) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.picture = picture;
        this.startDate = startDate;
        this.challengeId = challengeId;
        this.headerText = headerText;
    }

    public TasksEntity() {
        this.id = 0L;
        this.description = null;
        this.name = null;
        this.picture = null;
        this.startDate = null;
        this.challengeId = 0L;
        this.headerText = null;

    }

    public static TasksEntity getTask(List<String> row) {
        TasksEntity task = new TasksEntity();
        task.setId(Long.parseLong(row.get(0)));
        if (row.get(1) != null) {
            task.setDescription(row.get(1));
        }
        task.setName(row.get(2));
        task.setPicture(row.get(3));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (row.get(4) != null) {
                Date date = dateFormat.parse(row.get(4));
                task.setStartDate(new Timestamp(date.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (row.get(5) != null) {
            task.setChallengeId(Long.parseLong(row.get(5)));
        }
        task.setHeaderText(row.get(6));

        return task;
    }

    public static List<TasksEntity> getTasks(List<List<String>> rows) {
        List<TasksEntity> tasks = new ArrayList<>();
        for (List<String> row : rows) {
            tasks.add(getTask(row));
        }
        return tasks;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "TasksEntity{" +
                "challengeId=" + challengeId +
                ", description='" + description + '\'' +
                ", headerText='" + headerText + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
