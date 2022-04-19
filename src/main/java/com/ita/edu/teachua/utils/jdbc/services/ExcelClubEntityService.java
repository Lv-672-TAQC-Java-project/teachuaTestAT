package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ExcelClubEntityDao;
import com.ita.edu.teachua.utils.jdbc.entity.ExcelClubEntityEntity;

import java.util.List;

public class ExcelClubEntityService {
    private final ExcelClubEntityDao excelClubEntityDao;

    public ExcelClubEntityService() {
        this.excelClubEntityDao = new ExcelClubEntityDao();
    }

    public List<ExcelClubEntityEntity> getAllExcelClubEntities() {
        return excelClubEntityDao.selectAll();
    }
}
