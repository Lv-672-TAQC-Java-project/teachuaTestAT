package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import com.ita.edu.teachua.ui.pages.user.addcenter.AddCenterPage;
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

    @FindBy(how = How.XPATH, using = "//button[@class='ant-btn ant-btn-text button']/span[1]")
    private WebElement editButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div/ul/li[2]/span/div")
    private WebElement buttonAddCenter;

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

    public AddCenterPage clickAddCenter() {
        buttonAddCenter.click();

        return new AddCenterPage(driver);
    }

    public EditMyProfileComponent clickEditMyProfileComponent() {
        editButton.click();
        return new EditMyProfileComponent(driver);
    }
}