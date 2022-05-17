package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasicInformationCenterComponent extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@id ='basic_name']")
    private WebElement fieldNameCenter;
    @FindBy(how = How.XPATH, using = "//button[@class='ant-btn ant-btn-default next-btn']")
    private WebElement clickToNextButton;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Некоректна назва центру')]")
    private WebElement textAfterClick;
    @FindBy(how = How.ID, using = "basic_locations")
    private WebElement locationList;
    @FindBy(how = How.XPATH, using = "//*[@class = 'add-club-location']//button")
    private WebElement addLocationButton;
    @FindBy(how = How.XPATH, using = "//main[@class = 'ant-layout-content add-center-container']")
    private WebElement addCenterPopUp;

    public BasicInformationCenterComponent(WebDriver driver) {
        super(driver);
    }

    @Step("check that add center pop up is displayed")
    public boolean isAddCenterPopUpDisplayed() {
        return addCenterPopUp.isDisplayed();
    }

    @Step("get added location")
    public LocationCheckBoxComponent getAddedLocation() {
        return new LocationCheckBoxComponent(driver, locationList.findElement(By.xpath("./div[last()]")));
    }

    @Step("check that added location are selected")
    public boolean isAddedLocationSelected() {
        return locationList.findElement(By.xpath(".//div[last()]/label//input")).isSelected();
    }

    @Step("get input field in 'Назва центру'")
    public String getFieldNameCenter() {
        return fieldNameCenter.getText();
    }

    @Step("click Next button")
    public BasicInformationCenterComponent clickNextButton() {
        clickToNextButton.click();

        return this;
    }

    @Step("click on next step button")
    public ContactsCenterComponent clickNextStepButton() {
        clickToNextButton.click();

        return new ContactsCenterComponent(driver);
    }

    @Step("get text after click")
    public String getTextAfterClick() {
        return textAfterClick.getText();
    }

    @Step("input {name} in 'Назва центру'")
    public BasicInformationCenterComponent inputNameCenterField(String name) {
        fieldNameCenter.sendKeys(name);

        return this;
    }

    @Step("get name text")
    public String getCenterName() {
        return fieldNameCenter.getAttribute("value");
    }

    @Step("click on added location button")
    public AddLocationComponent clickAddLocationButton() {
        addLocationButton.click();

        return new AddLocationComponent(driver);
    }
}
