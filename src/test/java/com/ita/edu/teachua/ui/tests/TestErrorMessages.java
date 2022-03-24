package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.header.HeaderPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.AddCenterPage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider.valueProvider;
import static org.testng.Assert.assertEquals;

public class TestErrorMessages extends TestRunner {

    @Test
    public void testOpen() throws IOException {

        SoftAssert softAssert = new SoftAssert();

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        HeaderPage headP = new HeaderPage(driver);
        headP.clickUserProfile();
        headP.clickLogo();
        headP.login(properties.getProperty("adminEmail"), properties.getProperty("adminPassword"));
/*
        HomePage home = new HomePage(driver);
        home
                .getHeader()
                .clickUserProfile()
                .clickLogin()
                .setEmail(valueProvider.getAdminEmail())
                .setPassword(valueProvider.getAdminPassword())
                .clickLoginButton();
*/
        MyProfilePage mypr = new MyProfilePage(driver);
        mypr.clickDropDownProfileButton();
        mypr.clickMyProfileButton();

        AddCenterPage addCenterPage = new AddCenterPage(driver);
        addCenterPage.clickAddButton();
        addCenterPage.clickButtonAddCenter();

        BasicInformationCenterComponent checkCenterPage = new BasicInformationCenterComponent(driver);
        softAssert.assertSame(checkCenterPage.getFieldNameCenter(), "");
        checkCenterPage.clickNextButton();
        System.out.println("TEXT   =>   " + checkCenterPage.getTextAfterClick());
        assertEquals(checkCenterPage.getTextAfterClick(), "Некоректна назва центру");
    }
}
