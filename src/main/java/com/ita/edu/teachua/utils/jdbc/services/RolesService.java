package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.RolesDao;
import com.ita.edu.teachua.utils.jdbc.entity.RolesEntity;

import java.util.List;

public class RolesService {

    private final RolesDao rolesDao;

    public RolesService() {
        this.rolesDao = new RolesDao();
    }

    public List<RolesEntity> getAllRoles() {
        return rolesDao.selectAll();
    }
}
