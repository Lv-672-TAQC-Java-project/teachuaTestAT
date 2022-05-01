package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestErrorMessages extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void beforeMethod() {

        HomePage homePage = new HomePage(driver);
        homePage
                .login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        myProfilePage
                .clickDropDownMyProfileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddCenter();

    }

    @Description("Verify that error messages is displayed after user leaves fields empty and clicks 'Наступний крок' button on 'Основна інформація' tab")
    @Issue("TUA-252")
    @Test(description = "TUA-252")
    public void verifyThatErrorMessagesIsDisplayed() {

        SoftAssert softAssert = new SoftAssert();

        BasicInformationCenterComponent basicInformationCenterComponent = new BasicInformationCenterComponent(driver);
        softAssert.assertSame(basicInformationCenterComponent
                .getFieldNameCenter(), "", "field 'Назва центру' have to be empty");
        basicInformationCenterComponent.clickNextButton();
        softAssert.assertEquals(basicInformationCenterComponent.getTextAfterClick(),
                "Некоректна назва центру");
        softAssert.assertAll();
    }
}

