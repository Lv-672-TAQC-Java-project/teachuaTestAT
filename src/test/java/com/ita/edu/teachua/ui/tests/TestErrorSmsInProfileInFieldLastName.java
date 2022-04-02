package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.EditMyProfileComponent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class TestErrorSmsInProfileInFieldLastName extends TestRunnerWithValueProvider {

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
    public void verifyThatErrorMessagesIsDisplayedInLastNameField() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        HashMap<String, String> map = new HashMap<>();
        map.put("AfBbCcDdEeFfGgHhIiJjKkLlMmNn", "Прізвище не може містити більше, ніж 25 символів");
        map.put("AfBbCcDdEeFfGgHhIiJjKkLlMm", "Прізвище не може містити більше, ніж 25 символів");
        map.put("!@#$%^&,", "Прізвище не може містити спеціальні символи");
        map.put("1234", "Прізвище не може містити цифри");
        map.put("-Lastname", "Прізвище повинно починатися та закінчуватися літерою");
        map.put(" Lastname", "Прізвище повинно починатися та закінчуватися літерою");
        map.put("'Lastname", "Прізвище повинно починатися та закінчуватися літерою");
        map.put("Lastname-", "Прізвище повинно починатися та закінчуватися літерою");
        map.put("Lastname ", "Прізвище повинно починатися та закінчуватися літерою");
        map.put("Lastname'", "Прізвище повинно починатися та закінчуватися літерою");
        map.put("", "Введіть прізвище");

        EditMyProfileComponent editMyProfileComponent = new EditMyProfileComponent(driver);

        for (String key : map.keySet()) {
            softAssert.assertEquals(editMyProfileComponent
                            .setLastName(key)
                            .getErrorTextAfterInput(), map.get(key),
                    String.format("In field should be text %s", map.get(key)));
            softAssert.assertTrue(editMyProfileComponent.isButtonSaveChangedDisabled(),
                    "button 'Save Changes' should be disabled");

  //           assertTrue(editMyProfileComponent.isButtonSaveChangedDisabled(), "button 'Save Changes' should be disabled");

        }

        editMyProfileComponent.setLastName("Admin");
        sleep(1000);
    }
}
