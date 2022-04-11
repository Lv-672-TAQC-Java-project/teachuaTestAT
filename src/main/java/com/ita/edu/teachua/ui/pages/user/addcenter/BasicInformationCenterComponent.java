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
    @FindBy(how = How.XPATH, using = "//span[@class='ant-input-affix-wrapper']/input")
    private WebElement fieldNameCenter;
    @FindBy(how = How.XPATH, using = "//button[@class='ant-btn ant-btn-default next-btn']/span")
    private WebElement clickToNextButton;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Некоректна назва центру')]")
    private WebElement textAfterClick;
    @FindBy(how = How.ID, using = "basic_locations")
    private WebElement checkBoxLocation;
    @FindBy(how = How.XPATH, using = "//*[@id = 'basic']//button[contains(@class, 'add-location')]")
    private WebElement addLocationButton;

    public BasicInformationCenterComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Click on {nameLocations} elements in checkbox")
    public BasicInformationCenterComponent clickSelectedLocations(String[] nameLocations) {

        for(String location: nameLocations) {
            String nameLocationPath = String.format(".//label//span[text() = '%s']", location);
            checkBoxLocation.findElement(By.xpath(nameLocationPath)).click();
            sleep(1000);
        }

        return new BasicInformationCenterComponent(driver);
    }

    @Step("Check if {nameLocations} are selected")
    public boolean isCheckBoxLocationSelected(String[] nameLocations) {
        boolean checkList = false;
        for (String location : nameLocations) {
            String nameLocationPath = String.format(".//label//input", location);
            checkList = checkBoxLocation.findElement(By.xpath(nameLocationPath)).isSelected();
            sleep(1000);
        }
        return checkList;
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
        sleep(2000);
        return new ContactsCenterComponent(driver);
    }

    @Step("get text after click")
    public String getTextAfterClick() {
        return textAfterClick.getText();
    }

    @Step("input {name} in 'Назва центру'")
    public BasicInformationCenterComponent inputNameCenterField(String name) {
        fieldNameCenter.sendKeys(name);
        sleep(2000);
        return new BasicInformationCenterComponent(driver);
    }

    public AddLocationComponent clickAddLocationButton() {
        addLocationButton.click();
        sleep(2000);
        return new AddLocationComponent(driver);
    }
}
