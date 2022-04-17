package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ArchiveDao;
import com.ita.edu.teachua.utils.jdbc.entity.ArchiveEntity;

import java.util.List;

public class ArchiveService {

    private final ArchiveDao archiveDao;

    public ArchiveService() {
        this.archiveDao = new ArchiveDao();
    }

    public List<ArchiveEntity> getAllArchives() {
        return archiveDao.selectAll();
    }
}
