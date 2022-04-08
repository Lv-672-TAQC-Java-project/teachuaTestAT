package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.base.BaseComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GuestMenuDropDownComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = ".//ul/li[1]")
    private WebElement registrationBtn;
    @FindBy(how = How.XPATH, using = ".//ul/li[2]")
    private WebElement loginBtn;


    public GuestMenuDropDownComponent(WebDriver driver, WebElement root) {
        super(driver, root);
    }

    @Step("click Sing Up Btn in profile menu")
    public SingUpPopUpComponent clickRegistration() {
        registrationBtn.click();
        return new SingUpPopUpComponent(driver);
    }

    @Step("click Login Btn in profile menu")
    public LoginPopUpComponent clickLogin() {
        loginBtn.click();
        return new LoginPopUpComponent(driver);
    }


}
