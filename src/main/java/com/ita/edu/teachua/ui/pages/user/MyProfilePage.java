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

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Додати')]")
    private WebElement addButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div/ul/li[1]")
    private WebElement addWorkshop;

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public MyProfilePage clickDropDownProfileButton() {
        dropDownProfileButton.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage clickMyProfileButton() {
        myProfileButton.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage clickAddButton() {
        addButton.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage clickAddWorkshop() {
        addWorkshop.click();

        return new MyProfilePage(driver);
    }
}
