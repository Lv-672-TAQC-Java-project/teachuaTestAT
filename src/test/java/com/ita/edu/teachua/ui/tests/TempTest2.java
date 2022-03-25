package com.ita.edu.teachua.ui.tests;


import com.ita.edu.teachua.ui.pages.about.AboutPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class TempTest2 extends TestRunnerWithValueProvider {


    @Test
    public void test3() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        home
                .getHeader()
                .clickUserProfile()
                .clickLogin()
                .setEmail(valueProvider.getAdminEmail())
                .setPassword(valueProvider.getAdminPassword())
                .clickLoginButton();

    }
}
