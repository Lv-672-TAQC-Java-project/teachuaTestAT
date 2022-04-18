package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.TasksDao;
import com.ita.edu.teachua.utils.jdbc.entity.TasksEntity;

import java.util.List;

public class TasksService {

    private final TasksDao tasksDao;

    public TasksService() {
        this.tasksDao = new TasksDao();
    }

    public List<TasksEntity> getAllTasks() {
        return tasksDao.selectAll();
    }
}
