package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.utils.jdbc.entity.ClubCategoryEntity;
import com.ita.edu.teachua.utils.jdbc.services.ClubCategoryService;
import org.testng.annotations.Test;

import java.util.List;

public class TestClubCategoryDB {
    @Test
    public void testSelectFirst() {
        ClubCategoryService clubCategoryService = new ClubCategoryService();
        List<ClubCategoryEntity> clubCategories = clubCategoryService.getAllClubCategories();
        for (ClubCategoryEntity clubCategory : clubCategories) {
            System.out.println(clubCategory);
        }

    }
}
