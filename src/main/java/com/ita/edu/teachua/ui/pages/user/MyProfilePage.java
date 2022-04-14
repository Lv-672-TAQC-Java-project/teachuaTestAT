package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import com.ita.edu.teachua.ui.pages.user.addcenter.AddCenterPage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import io.qameta.allure.Step;
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

    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div/ul/li[2]/span/div")
    private WebElement addCenterButton;

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on add center button in drop down list")
    public BasicInformationCenterComponent clickAddCenterInDropDownButton() {
        addCenterButton.click();
        sleep(2000);
        return new BasicInformationCenterComponent(driver);
    }

    public boolean addCenterButtonIsEnabled() {
        return addCenterButton.isEnabled();
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

    @Step("click button 'Додати центр' in My Profile")
    public AddCenterPage clickAddCenter() {
        buttonAddCenter.click();

        return new AddCenterPage(driver);
    }

    @Step("click button edit profile")
    public EditMyProfileComponent clickEditMyProfileComponent() {
        editButton.click();
        return new EditMyProfileComponent(driver);
    }
}