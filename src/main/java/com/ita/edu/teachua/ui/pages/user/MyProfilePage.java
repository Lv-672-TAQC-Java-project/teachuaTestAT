package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import com.ita.edu.teachua.ui.pages.user.addcenter.AddCenterPage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
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

    @FindBy(how = How.XPATH, using = "//div[@class = 'content-title']")
    private WebElement contentTitle;

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isContentTitleDisplayed(){
        return contentTitle.isDisplayed();
    }

    @Step("Click on add center button and open add center pop up")
    public BasicInformationCenterComponent clickAddCenterInDropDownButton() {
        addCenterButton.click();
        //need
        sleep(2000);
        return new BasicInformationCenterComponent(driver);
    }

    public MyProfilePage clickDropDownProfileButton() {
        dropDownProfileButton.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage clickMyProfileButton() {
        myProfileButton.click();

        return new MyProfilePage(driver);
    }

    @Step("Open drop down list")
    public MyProfilePage clickAddButton() {
        addButton.click();
        //need
        sleep(1000);
        return this;
    }

    @Step("Check that drop down list is displayed")
    public boolean isDropDownListDisplayed() {
        return addButton
                .findElement(By.xpath(".//ancestor::body//ul[@classname ='menu']"))
                .isDisplayed();
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

    public MyProfilePage clickDropDownMyProfileButton() {
        sleep(3000);
        dropDownProfileButton.click();

        return this;
    }
}