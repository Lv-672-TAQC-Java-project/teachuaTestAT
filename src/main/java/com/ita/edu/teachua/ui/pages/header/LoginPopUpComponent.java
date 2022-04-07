package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPopUpComponent extends BasePage {
    @FindBy(how = How.ID, using = "basic_email")
    private WebElement emailField;
    @FindBy(how = How.ID, using = "basic_password")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//*[@id='basic']/div[2]/div[3]/div/div/div/div/button")
    private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "./button[contains(@aria-label,'Close')]")
    private WebElement closeButton;

    LoginPopUpComponent(WebDriver driver) {
        super(driver);

    }

    public HomePage clickLoginButton(){
        loginButton.click();
        sleep(2000);
        return new HomePage(driver);
    }

    public void clickCloseButton(){
        loginButton.click();
    }

    public LoginPopUpComponent setEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPopUpComponent setPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }



}
