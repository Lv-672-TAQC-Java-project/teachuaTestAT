package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyProfilePage extends CommonPage {
    @FindBy(how = How.XPATH, using = "//header/div[3]/div[2]")
    private WebElement dropDownProfileButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Мій Профіль')]")
    private WebElement myProfileButton;

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickDropDownProfileButton() {
        dropDownProfileButton.click();
    }

    public void clickMyProfileButton() {
        myProfileButton.click();
    }
}
