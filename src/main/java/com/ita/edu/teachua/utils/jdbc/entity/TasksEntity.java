package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class TasksEntity {

    public static final String SELECT_ALL = "SELECT * FROM users ORDER BY id;";

    private Long challengeId;
    private String description;
    private String headerText;
    private Long id;
    private String name;
    private String picture;
    private String startDate;

    public TasksEntity(Long challengeId, String description, String headerText, Long id, String name, String picture, String startDate) {
        this.challengeId = challengeId;
        this.description = description;
        this.headerText = headerText;
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.startDate = startDate;
    }

    public TasksEntity() {
        this.challengeId = 0L;
        this.description = null;
        this.headerText = null;
        this.id = 0L;
        this.name = null;
        this.picture = null;
        this.startDate = null;
    }

    public static TasksEntity getTask(List<String> row) {
        TasksEntity task = new TasksEntity();
        task.setChallengeId(Long.parseLong(row.get(0)));
        task.setDescription(row.get(1));
        task.setHeaderText(row.get(2));
        task.setId(Long.parseLong(row.get(3)));
        task.setName(row.get(4));
        task.setPicture(row.get(5));
        task.setStartDate(row.get(6));

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
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

