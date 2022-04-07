package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class BasicInformationCenterComponent extends BasePage {
    public BasicInformationCenterComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "basic_name")
    private WebElement nameCenterField;

    @FindBy(how = How.XPATH, using = "//*[@id = 'basic']//button[contains(@class, 'add-location')]")
    private WebElement addLocationButton;

    @FindBy(how = How.XPATH, using = "//*[@id = 'basic']//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;

    @FindBy(how = How.XPATH, using = "//*[@id='basic_locations']//label")
    private List<WebElement> checkBoxLocationList;

    public BasicInformationCenterComponent inputNameCenterField(String name) {
        nameCenterField.sendKeys(name);
        sleep(2000);
        return new BasicInformationCenterComponent(driver);
    }

    public AddLocationComponent clickAddLocationButton() {
        addLocationButton.click();
        sleep(2000);
        return new AddLocationComponent(driver);
    }

    public boolean addLocationButtonIsEnabled() {
        return addLocationButton.isDisplayed();
    }

    public ContactsCenterComponent clickNextStepButton() {
        nextStepButton.click();
        sleep(2000);
        return new ContactsCenterComponent(driver);
    }

    public boolean IsNextStepButtonEnabled() {
        return nextStepButton.isEnabled();
    }

    public BasicInformationCenterComponent clickSelectedLocations(String[] nameLocations) {
        for (WebElement webElem : checkBoxLocationList) {
            for (String location : nameLocations) {
                if (webElem.getText().equals(location)) {
                    webElem.click();
                    sleep(1000);
                }
            }
        }
        return new BasicInformationCenterComponent(driver);
    }

    public boolean isCheckBoxLocationSelected(String[] nameLocations) {
        boolean checkList = false;
        for (WebElement webElem : checkBoxLocationList) {
            for (String location : nameLocations) {
                if (webElem.getText().equals(location)) {
                    checkList = webElem.findElement(By.xpath(".//input")).isSelected();
                }
            }
        }

        return checkList;
    }
}
