package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.base.BaseComponent;
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

    public void clickRegistration() {
        registrationBtn.click();
    }

    public LoginPopUpComponent clickLogin() {
        loginBtn.click();
        return new LoginPopUpComponent(driver);
    }


}
