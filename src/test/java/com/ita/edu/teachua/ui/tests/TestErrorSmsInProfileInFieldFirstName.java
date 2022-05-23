package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.EditMyProfileComponent;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.utils.TestRunnerWithValueProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestErrorSmsInProfileInFieldFirstName extends TestRunnerWithValueProvider {

    @DataProvider
    public Object[][] inputName() {

        return new Object[][]{

                {"AfBbCcDdEeFfGgHhIiJjKkLlMmNn", "Ім'я не може містити більше, ніж 25 символів"},
                {"AfBbCcDdEeFfGgHhIiJjKkLlMm", "Ім'я не може містити більше, ніж 25 символів"},
                {"1234", "Ім'я не може містити цифри"},
                {"!@#$%^&,", "Ім'я не може містити спеціальні символи"},
                {"-Name", "Ім'я повинно починатися і закінчуватися літерою"},
                {" Name", "Ім'я повинно починатися і закінчуватися літерою"},
                {"'Name", "Ім'я повинно починатися і закінчуватися літерою"},
                {"Name-", "Ім'я повинно починатися і закінчуватися літерою"},
                {"Name ", "Ім'я повинно починатися і закінчуватися літерою"},
                {"Name'", "Ім'я повинно починатися і закінчуватися літерою"},
                {"", "Будь ласка введіть Ваше ім'я"},
        };
    }

    @BeforeMethod
    public void beforeMethod() {
        HomePage homePage = new HomePage(driver);
        homePage
                .login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        myProfilePage
                .clickDropDownMyProfileButton()
                .clickMyProfileButton()
                .clickEditMyProfileComponent();
    }

    @Description("Verify that error messages are shown and 'Зберегти зміни' button becomes disabled while entering invalid data into the 'Ім'я' field")
    @Issue("TUA-328")
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
    }
}
