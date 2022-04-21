package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.QuestionDao;
import com.ita.edu.teachua.utils.jdbc.entity.QuestionEntity;

import java.util.List;

public class QuestionService {

    private final QuestionDao questionDao;

    public QuestionService() {
        this.questionDao = new QuestionDao();
    }

    public List<QuestionEntity> getAllQuestions() {
        return questionDao.selectAll();
    }
}
