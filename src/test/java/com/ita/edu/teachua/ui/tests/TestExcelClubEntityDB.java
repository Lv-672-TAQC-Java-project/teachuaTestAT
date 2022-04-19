package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.utils.jdbc.entity.ExcelClubEntityEntity;
import com.ita.edu.teachua.utils.jdbc.services.ExcelClubEntityService;
import org.testng.annotations.Test;

import java.util.List;

public class TestExcelClubEntityDB {
    @Test
    public void testSelectLast() {
        ExcelClubEntityService excelClubEntityService = new ExcelClubEntityService();
        List<ExcelClubEntityEntity> excelClubEntities = excelClubEntityService.getAllExcelClubEntities();
        for (ExcelClubEntityEntity excelClubEntity : excelClubEntities) {
            System.out.println(excelClubEntity);
        }

    }
}
