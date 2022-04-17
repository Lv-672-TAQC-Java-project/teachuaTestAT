package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ContactTypeDao;
import com.ita.edu.teachua.utils.jdbc.entity.ContactTypeEntity;

import java.util.List;

public class ContactTypeService {
    private final ContactTypeDao contactTypeDao;

    public ContactTypeService() {
        this.contactTypeDao = new ContactTypeDao();
    }

    public List<ContactTypeEntity> getAllContactTypes() {
        return contactTypeDao.selectAll();
    }
}
