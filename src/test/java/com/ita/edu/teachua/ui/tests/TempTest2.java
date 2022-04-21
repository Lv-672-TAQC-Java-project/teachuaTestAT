package com.ita.edu.teachua.ui.tests;


import com.ita.edu.teachua.utils.jdbc.entity.CenterEntity;
import com.ita.edu.teachua.utils.jdbc.entity.CityEntity;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.CenterService;
import com.ita.edu.teachua.utils.jdbc.services.CityService;
import com.ita.edu.teachua.utils.jdbc.services.UserService;
import org.testng.annotations.Test;

import java.util.List;

//public class TempTest2 extends TestRunnerWithValueProvider {
public class TempTest2 {


    //    @Test
//    public void test3() {
//        HomePage home = new HomePage(driver);
//        SoftAssert softAssert = new SoftAssert();
//        home
//                .getHeader()
//                .clickUserProfile()
//                .clickLogin()
//                .setEmail(valueProvider.getAdminEmail())
//                .setPassword(valueProvider.getAdminPassword())
//                .clickLoginButton();
//
//    }
//
    @Test
    public void test4() {
        CityService cityService = new CityService();
        List<CityEntity> cities = cityService.getAllCities();
        for (CityEntity city : cities) {
            System.out.println(city);
        }

    }

    @Test
    public void test5() {
        CenterService clubsService = new CenterService();
        List<CenterEntity> clubs = clubsService.getAllCenters();
        for (CenterEntity club : clubs) {
            System.out.println(club);
        }

    }



}
