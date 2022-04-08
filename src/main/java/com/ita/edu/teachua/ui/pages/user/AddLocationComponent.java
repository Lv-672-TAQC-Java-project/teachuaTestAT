package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddLocationComponent extends BasePage {
    public AddLocationComponent(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'add-club-content-next')]")
    private WebElement addLocationButton;

    private String checkCirclePath = "./..//*[@aria-label ='check-circle']";
    
    public AddLocationComponent inputLocationNameField(String locationName) {
        locationNameField.sendKeys(locationName);
        return new AddLocationComponent(driver);
    }

    public boolean isCheckCircleOfLocationNameFieldDisplayed() {
        return locationNameField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    public AddLocationComponent inputAddressField(String address) {
        addressField.sendKeys(address);
        return new AddLocationComponent(driver);
    }

    public boolean isCheckCircleOfLocationAddressFieldDisplayed() {
        return addressField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    public AddLocationComponent inputCoordinatesField(String coordinates) {
        coordinatesField.sendKeys(coordinates);
        return new AddLocationComponent(driver);
    }

    public boolean isCheckCircleOfLocationCoordinatesFieldDisplayed() {
        return coordinatesField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    public AddLocationComponent inputPhoneField(String phone) {
        phoneField.sendKeys(phone);
        sleep(2000);
        return new AddLocationComponent(driver);
    }

    public boolean isCheckCircleOfLocationPhoneFieldDisplayed() {
        return phoneField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    public LocationListBoxDropDownComponent clickCityListButton() {
        cityListButton.click();
        sleep(1000);
        return new LocationListBoxDropDownComponent(driver);
    }

    public boolean isCityListButtonEnabled() {
        return cityListButton.isEnabled();
    }

    public boolean isCheckCircleOfCityListButtonDisplayed() {
        return cityListButton.findElement(By.xpath("./../..//..//*[@aria-label = 'check-circle']")).isDisplayed();
    }

    public LocationListBoxDropDownComponent clickDistrictListButton() {
        districtListButton.click();
        sleep(1000);
        return new LocationListBoxDropDownComponent(driver);
    }

    public boolean isDistrictListButtonEnabled() {
        return districtListButton.isEnabled();
    }

    public LocationListBoxDropDownComponent clickStationListButton() {
        stationListButton.click();
        return new LocationListBoxDropDownComponent(driver);
    }

    public boolean isStationListButtonEnabled() {
        return stationListButton.isEnabled();
    }

    public BasicInformationCenterComponent clickAddLocationButton() {
        addLocationButton.click();
        sleep(2000);
        return new BasicInformationCenterComponent(driver);
    }

    public boolean isAddLocationButtonEnabled() {
        return addLocationButton.isEnabled();
    }
}
