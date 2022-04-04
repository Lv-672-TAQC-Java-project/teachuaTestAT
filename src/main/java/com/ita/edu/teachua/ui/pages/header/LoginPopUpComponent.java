package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.AddCenterPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPopUpComponent extends BasePage {
    //protected final MyProfilePage myProfilePage1 = new MyProfilePage(driver);

    @FindBy(how = How.ID, using = "basic_email")
    private WebElement emailField;
    @FindBy(how = How.ID, using = "basic_password")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//*[@id='basic']/div[2]/div[3]/div/div/div/div/button")
    private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "./button[contains(@aria-label,'Close')]")
    private WebElement closeButton;

    @FindBy(how = How.XPATH, using = "//header/div[3]/div[2]")
    private WebElement dropDownProfileButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Мій Профіль')]")
    private WebElement myProfileButton;


    LoginPopUpComponent(WebDriver driver) {
        super(driver);

    }
    @Step("click Login")
    public LoginPopUpComponent clickLoginButton() {
        loginButton.click();
        sleep(2000);
        return this;
    }

    public void clickCloseButton() {
        loginButton.click();
    }

    @Step("set email field value: {email}")
    public LoginPopUpComponent setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    @Step("set password field value: {password}")
    public LoginPopUpComponent setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }



//
//    public LoginPopUpComponent clickLoginButton() {
//        loginButton.click();
//        sleep(2000);
//
//        return this;
//    }


    public LoginPopUpComponent clickDropDownProfileButton() {
        sleep(3000);
        dropDownProfileButton.click();

        return this;
    }


//    public AddCenterPage clickMyProfileButton() {
//        myProfileButton.click();
////        return myProfilePage1.clickAddButton2();
//          return new MyProfilePage(driver).clickAddButton2();
//    }

    public MyProfilePage clickMyProfileButton() {
        myProfileButton.click();
        return new MyProfilePage(driver).clickAddButton();
    }


}