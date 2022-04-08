package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.header.SingUpPopUpComponent;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SingUpTest extends TestRunnerWithValueProvider {

    @Description("Verify that last entered data on the ‘Реєстрація’ page are remembered")
    @Issue("TUA-454")
    @Test(description = "TUA-454")
    public void VerifyThatLastEnteredDataOnTheSingUpPageAreRemembered() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        SingUpPopUpComponent singUpPopUpComponent = home
                .getHeader()
                .clickUserProfile()
                .clickRegistration()
                .setLastName("Вайтович")
                .setFirstName("Світлана")
                .setPhone(valueProvider.getPhone())
                .setEmail(valueProvider.getEmail())
                .setPassword(valueProvider.getPassword())
                .setConfirmPassword(valueProvider.getConfirmPassword())
                .clickCloseButton()
                .getHeader()
                .clickUserProfile()
                .clickRegistration();

        String lastNameFieldValue = singUpPopUpComponent.getLastNameFieldValue();
        softAssert.assertEquals(lastNameFieldValue, "Вайтович",
                "The last name field should be filled in with " + "Вайтович" + " not with " +
                        lastNameFieldValue);

        String firstNameFieldValue = singUpPopUpComponent.getFirstNameFieldValue();
        softAssert.assertEquals(firstNameFieldValue, "Світлана",
                "The first name field should be filled in with " + "Світлана" + " not with " +
                        firstNameFieldValue);

        String phoneFieldValue = singUpPopUpComponent.getPhoneFieldValue();
        softAssert.assertEquals(phoneFieldValue, valueProvider.getPhone(),
                "The phone field should be filled in with " + valueProvider.getPhone() + " not with " +
                        phoneFieldValue);

        String emailFieldValue = singUpPopUpComponent.getEmailFieldValue();
        softAssert.assertEquals(emailFieldValue, valueProvider.getEmail(),
                "The email field should be filled in with " + valueProvider.getEmail() + " not with " +
                        emailFieldValue);

        String passwordFieldValue = singUpPopUpComponent.getPasswordFieldValue();
        softAssert.assertEquals(passwordFieldValue, valueProvider.getPassword(),
                "The password field should be filled in with " + valueProvider.getPassword() + " not with " +
                        passwordFieldValue);

        String confirmPasswordFieldValue = singUpPopUpComponent.getConfirmPasswordFieldValue();
        softAssert.assertEquals(confirmPasswordFieldValue, valueProvider.getConfirmPassword(),
                "The confirm password field should be filled in with " + valueProvider.getConfirmPassword() +
                        " not with " + confirmPasswordFieldValue);
        softAssert.assertAll();
    }
}