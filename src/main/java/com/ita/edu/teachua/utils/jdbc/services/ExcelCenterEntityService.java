package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ExcelCenterEntityDao;
import com.ita.edu.teachua.utils.jdbc.entity.ExcelCenterEntity;

import java.util.List;

public class ExcelCenterEntityService {

    private final ExcelCenterEntityDao excelCenterEntityDao;

    public ExcelCenterEntityService() {
        this.excelCenterEntityDao = new ExcelCenterEntityDao();
    }

    public List<ExcelCenterEntity> getAllExcelCenterEntities() {
        return excelCenterEntityDao.selectAll();
    }
}
