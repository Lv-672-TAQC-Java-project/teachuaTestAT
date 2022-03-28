package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminAddLocationTest extends TestRunnerWithValueProvider {

    @Test(description = "TUA-160")
    public void verifyThatAdminCanNotAddLocationAfterLeavingAllFieldsEmpty() {
        HomePage homePage = new HomePage(driver);
        homePage
                .getHeader()
                .clickUserProfile()
                .clickLogin()
                .setEmail(valueProvider.getAdminEmail())
                .setPassword(valueProvider.getAdminPassword())
                .clickLoginButton();
        homePage
                .sleep(3000);

        boolean isEnable = homePage
                .getHeader()
                .clickAdminProfile()
                .clickAddCenter()
                .clickAddLocationBtn()
                .isAddButtonEnable();

        Assert.assertFalse(isEnable);
    }
}
