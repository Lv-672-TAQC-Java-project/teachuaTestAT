package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.EditMyProfileComponent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.Thread.sleep;

public class TestErrorSmsInProfileInFieldLastName extends TestRunnerWithValueProvider {

    @DataProvider
    public Object[][] inputLastName() {

        Object[][] parameters = new Object[][]{

                {"1234", "Прізвище не може містити цифри"},
                {"AfBbCcDdEeFfGgHhIiJjKkLlMmNn", "Прізвище не може містити більше, ніж 25 символів"},
                {"AfBbCcDdEeFfGgHhIiJjKkLlMm", "Прізвище не може містити більше, ніж 25 символів"},
                {"!@#$%^&,", "Прізвище не може містити спеціальні символи"},
                {"-Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {" Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {"'Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname-", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname ", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname'", "Прізвище повинно починатися та закінчуватися літерою"},
                {"", "Введіть прізвище"},

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

    @Test(dataProvider = "inputLastName")
    public void verifyThatErrorMessagesIsDisplayedInLastNameField(String input, String expected) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        EditMyProfileComponent editMyProfileComponent = new EditMyProfileComponent(driver);
        softAssert.assertEquals(editMyProfileComponent
                        .setLastName(input)
                        .getErrorTextAfterInput(), expected,
                String.format("In field should be text %s", expected));
        softAssert.assertTrue(editMyProfileComponent.isButtonSaveChangedDisabled(),
                "button 'Save Changes' should be disabled");

        softAssert.assertAll();
        editMyProfileComponent.setLastName("Admin");
        sleep(1000);
    }
}