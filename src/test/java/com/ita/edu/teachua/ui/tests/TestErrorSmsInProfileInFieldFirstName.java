package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.EditMyProfileComponent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class TestErrorSmsInProfileInFieldFirstName extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void beforeMethot() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home
                .getHeader()
                .clickUserProfile()
                .clickLogin()
                .setEmail(valueProvider.getAdminEmail())
                .setPassword(valueProvider.getAdminPassword())
                .clickLoginButton2()
                .clickDropDownProfileButton()
                .clickMyProfileButton()
                .clickEditMyProfileComponent();
        sleep(3000);

    }

    @Test
    public void verifyThatErrorMessagesIsDisplayedInFirstNameField() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        HashMap<String, String> map = new HashMap<>();
        map.put("AfBbCcDdEeFfGgHhIiJjKkLlMmNn", "Ім'я не може містити більше, ніж 25 символів");
        map.put("AfBbCcDdEeFfGgHhIiJjKkLlMm", "Ім'я не може містити більше, ніж 25 символів");
        map.put("!@#$%^&,", "Ім’я не може містити спеціальні символи");
        map.put("1234", "Ім’я не може містити цифри");
        map.put("-Name", "Ім’я повинно починатися та закінчуватися літерою");
        map.put(" Name", "Ім’я повинно починатися та закінчуватися літерою");
        map.put("'Name", "Ім’я повинно починатися та закінчуватися літерою");
        map.put("Name-", "Ім’я повинно починатися та закінчуватися літерою");
        map.put("Name ", "Ім’я повинно починатися та закінчуватися літерою");
        map.put("Name'", "Ім’я повинно починатися та закінчуватися літерою");
        map.put("", "Введіть ім'я");

        EditMyProfileComponent editMyProfileComponent = new EditMyProfileComponent(driver);

        for (String key : map.keySet()) {
            softAssert.assertEquals(editMyProfileComponent
                            .setFirstName(key)
                            .getErrorTextAfterInput(), map.get(key),
                    String.format("In field should be text %s", map.get(key)));
            softAssert.assertTrue(editMyProfileComponent.isButtonSaveChangedDisabled(),
                    "button 'Save Changes' should be disabled");

  //           assertTrue(editMyProfileComponent.isButtonSaveChangedDisabled(), "button 'Save Changes' should be disabled");

        }

        editMyProfileComponent.setFirstName("admin");
        sleep(1000);
    }
}
