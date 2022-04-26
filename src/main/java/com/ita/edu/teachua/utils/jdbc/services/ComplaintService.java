package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ComplaintDao;
import com.ita.edu.teachua.utils.jdbc.entity.ComplaintEntity;

import java.text.ParseException;
import java.util.List;

public class ComplaintService {
    private final ComplaintDao complaintDao;

    public ComplaintService() {
        this.complaintDao = new ComplaintDao();
    }

    public List<ComplaintEntity> getAllComplaints() throws ParseException {
        return complaintDao.selectAll();
    }
}
