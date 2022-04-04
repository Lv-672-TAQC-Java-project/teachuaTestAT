package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.EditMyProfileComponent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.Thread.sleep;

public class TestErrorSmsInProfileInFieldFirstName extends TestRunnerWithValueProvider {

    @DataProvider
    public Object[][] inputName() {

        Object[][] parameters = new Object[][]{

                {"1234", "Ім’я не може містити цифри"},
                {"AfBbCcDdEeFfGgHhIiJjKkLlMmNn", "Ім'я не може містити більше, ніж 25 символів"},
                {"AfBbCcDdEeFfGgHhIiJjKkLlMm", "Ім'я не може містити більше, ніж 25 символів"},
                {"!@#$%^&,", "Ім'я не може містити спеціальні символи"},
                {"-Name", "Ім’я повинно починатися та закінчуватися літерою"},
                {" Name", "Ім’я повинно починатися та закінчуватися літерою"},
                {"'Name", "Ім’я повинно починатися та закінчуватися літерою"},
                {"Name-", "Ім’я повинно починатися та закінчуватися літерою"},
                {"Name ", "Ім’я повинно починатися та закінчуватися літерою"},
                {"Name'", "Ім’я повинно починатися та закінчуватися літерою"},
                {"", "Введіть ім'я"},

        };
        return parameters;
    }

    @BeforeMethod
    public void beforeMethot() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home
                .getHeader()
                .clickUserProfile()
                .clickLogin()
                .setEmail(valueProvider.getAdminEmail())
                .setPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .clickDropDownProfileButton()
                .clickMyProfileButton()
                .clickEditMyProfileComponent();
        sleep(3000);
    }

    @Test(dataProvider = "inputName")
    public void verifyThatErrorMessagesIsDisplayedInFirstNameField(String input, String expected) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        EditMyProfileComponent editMyProfileComponent = new EditMyProfileComponent(driver);

        softAssert.assertEquals(editMyProfileComponent
                        .setFirstName(input)
                        .getErrorTextAfterInput(), expected,
                         String.format("In field should be text %s", expected));
        softAssert.assertTrue(editMyProfileComponent.isButtonSaveChangedDisabled(),
                "button 'Save Changes' should be disabled");
        softAssert.assertAll();

        editMyProfileComponent.setFirstName("admin");
        sleep(1000);
    }
}
