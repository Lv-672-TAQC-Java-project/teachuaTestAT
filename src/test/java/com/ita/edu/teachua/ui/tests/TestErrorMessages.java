package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class TestErrorMessages extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void beforeMethot ()  {

        HomePage home = new HomePage(driver);
        home
                .getHeader()
                .clickUserProfile()
                .clickLogin()
                .setEmail(valueProvider.getAdminEmail())
                .setPassword(valueProvider.getAdminPassword())
                .clickLoginButton2()
                .clickDropDownProfileButton()
                .clickMyProfileButton1()
                .clickButtonAddCenter();

    }

    @Test
    public void verifyThatErrorMessagesIsDisplayed() {

        SoftAssert softAssert = new SoftAssert();

        BasicInformationCenterComponent basicInformationCenterComponent = new BasicInformationCenterComponent(driver);
        softAssert.assertSame(basicInformationCenterComponent
                .getFieldNameCenter(),"","field 'Назва центру' have to be empty");
        basicInformationCenterComponent.clickNextButton();
        assertEquals(basicInformationCenterComponent.getTextAfterClick(), "Некоректна назва центру");

    }
}
