package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.CategoryDao;
import com.ita.edu.teachua.utils.jdbc.dao.FeedbackDao;
import com.ita.edu.teachua.utils.jdbc.entity.CategoryEntity;
import com.ita.edu.teachua.utils.jdbc.entity.FeedbackEntity;

import java.util.List;

public class FeedbackService {
    public final FeedbackDao feedbackDao;

    public FeedbackService() {
        this.feedbackDao = new FeedbackDao();
    }

    public List<FeedbackEntity> getAllFeedbacks() {
        return feedbackDao.selectAll();
    }
}
