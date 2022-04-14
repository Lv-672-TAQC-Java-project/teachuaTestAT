package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddLocationComponent extends BasePage {
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[2]/div/div[2]/div/main/div[2]/form/div[6]/button")
    private WebElement addButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'add-location-button')]//button[@type = 'submit']")
    private WebElement addLocationButton;

    @FindBy(how = How.ID, using = "name")
    private WebElement locationNameField;

    @FindBy(how = How.ID, using = "address")
    private WebElement addressField;

    @FindBy(how = How.ID, using = "coordinates")
    private WebElement coordinatesField;

    @FindBy(how = How.ID, using = "phone")
    private WebElement phoneField;

    @FindBy(how = How.ID, using = "cityName")
    private WebElement cityListButton;

    @FindBy(how = How.ID, using = "districtName")
    private WebElement districtListButton;

    @FindBy(how = How.ID, using = "stationName")
    private WebElement stationListButton;

    @FindBy(how = How.XPATH, using = "//div[@class = 'rc-virtual-list-holder-inner']//div")
    private WebElement locationList;

    private String checkCirclePath = "./..//*[@aria-label ='check-circle']";

    public AddLocationComponent(WebDriver driver) {
        super(driver);
    }


    @Step("input location name {locationName}")
    public AddLocationComponent inputLocationNameField(String locationName) {
        locationNameField.sendKeys(locationName);
        return new AddLocationComponent(driver);
    }

    @Step("Check if Data in name field is displayed")
    public boolean isCheckCircleOfLocationNameFieldDisplayed() {
        return locationNameField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    @Step("input address {address}")
    public AddLocationComponent inputAddressField(String address) {
        addressField.sendKeys(address);
        return new AddLocationComponent(driver);
    }

    @Step("Check if address is displayed")
    public boolean isCheckCircleOfLocationAddressFieldDisplayed() {
        return addressField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    @Step("input coordinates {coordinates}")
    public AddLocationComponent inputCoordinatesField(String coordinates) {
        coordinatesField.sendKeys(coordinates);
        return new AddLocationComponent(driver);
    }

    @Step("Check if coordinates is displayed")
    public boolean isCheckCircleOfLocationCoordinatesFieldDisplayed() {
        return coordinatesField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    @Step("input phone {phone}")
    public AddLocationComponent inputPhoneField(String phone) {
        phoneField.sendKeys(phone);
        return new AddLocationComponent(driver);
    }

    @Step("Check if phone number is displayed")
    public boolean isCheckCircleOfLocationPhoneFieldDisplayed() {
        return phoneField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    public AddLocationComponent clickCityListButton() {
        cityListButton.click();
        sleep(1000);
        return new AddLocationComponent(driver);
    }

    public AddLocationComponent clickDistrictListButton() {
        districtListButton.click();
        sleep(1000);
        return new AddLocationComponent(driver);
    }

    public AddLocationComponent clickStationListButton() {
        stationListButton.click();
        sleep(1000);
        return new AddLocationComponent(driver);
    }

    @Step("Verify that listBox contain {location}")
    public boolean isElementFromDropDownListDisplayed(String location) {
        String str = String.format(".//div[text() = '%s']", location);
        try {
            boolean isContainsLocation = locationList.findElement(By.xpath(str)).isDisplayed();
            return isContainsLocation;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    @Step("select {location} element from the drop-down list")
    public AddLocationComponent clickElementFromDropDownList(String location) {

        String str = String.format(".//div[text() = '%s']", location);
        locationList.findElement(By.xpath(str)).click();

        return new AddLocationComponent(driver);
    }

    @Step("check is Add Button Enable ")
    public boolean isAddLocationButtonEnable() {
        return addLocationButton.isEnabled();
    }

    @Step("add location")
    public BasicInformationCenterComponent clickAddLocationButton() {
        addLocationButton.click();
        sleep(2000);
        return new BasicInformationCenterComponent(driver);
    }

    public boolean isAddLocationButtonEnabled() {
        return addLocationButton.isEnabled();
    }

    @Step("check is Add Button Enable ")
    public boolean isAddButtonEnable() {
        return addButton.isEnabled();
    }
}