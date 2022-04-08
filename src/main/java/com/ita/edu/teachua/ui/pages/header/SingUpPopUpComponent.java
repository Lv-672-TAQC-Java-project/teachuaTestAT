package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SingUpPopUpComponent extends CommonPage {

    @FindBy(how = How.ID, using = "lastName")
    private WebElement lastNameField;
    @FindBy(how = How.ID, using = "firstName")
    private WebElement firstNameField;
    @FindBy(how = How.ID, using = "phone")
    private WebElement phoneField;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailField;
    @FindBy(how = How.ID, using = "password")
    private WebElement passwordField;
    @FindBy(how = How.ID, using = "confirm")
    private WebElement confirmPasswordField;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'registration-button')]")
    private WebElement singUpButton;
    @FindBy(how = How.XPATH, using = "//button[contains(@aria-label,'Close')]")
    private WebElement closeButton;

    public SingUpPopUpComponent(WebDriver driver) {
        super(driver);
    }

    @Step("set last name field value: {lastName}")
    public SingUpPopUpComponent setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("set first name field value: {firstName}")
    public SingUpPopUpComponent setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("set phone field value: {email}")
    public SingUpPopUpComponent setPhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    @Step("set email field value: {email}")
    public SingUpPopUpComponent setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("set password field value: {password}")
    public SingUpPopUpComponent setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("set confirm password field value: {confirmPassword}")
    public SingUpPopUpComponent setConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
        return this;
    }

    @Step("click Sing Up")
    public SingUpPopUpComponent clickSingUpButton() {
        singUpButton.click();
        sleep(2000);
        return this;
    }

    @Step("click close button")
    public HomePage clickCloseButton() {
        closeButton.click();
        return new HomePage(driver);
    }

    public String getLastNameFieldValue(){

        return lastNameField.getAttribute("value");
    }

    public String getFirstNameFieldValue(){

        return firstNameField.getAttribute("value");
    }

    public String getPhoneFieldValue(){

        return phoneField.getAttribute("value");
    }

    public String getEmailFieldValue(){

        return emailField.getAttribute("value");
    }

    public String getPasswordFieldValue(){

        return passwordField.getAttribute("value");
    }

    public String getConfirmPasswordFieldValue(){

        return confirmPasswordField.getAttribute("value");
    }
}
