package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.base.BaseComponent;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserMenuDropDownComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = ".//ul/li[3]")
    private WebElement myProfileBtn;


    public UserMenuDropDownComponent(WebDriver driver, WebElement root) {
        super(driver, root);
    }

    public MyProfilePage clickMyProfileButton() {
        myProfileBtn.click();
        return new MyProfilePage(driver);
    }

}
