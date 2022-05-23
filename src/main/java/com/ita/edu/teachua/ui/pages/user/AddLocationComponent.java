package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import com.ita.edu.teachua.ui.pages.user.addclub.ContactsClubComponent;
import com.ita.edu.teachua.ui.pages.user.models.City;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
    private WebElement cityNameListButton;
    @FindBy(how = How.ID, using = "districtName")
    private WebElement districtListButton;
    @FindBy(how = How.ID, using = "stationName")
    private WebElement stationListButton;
    @FindBy(how = How.XPATH, using = "//div[@class = 'rc-virtual-list-holder-inner']/div")
    private WebElement locationList;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-modal modal-add-club']//*[@data-icon = 'close'])[3]")
    private WebElement closeButton;
    @FindBy(how = How.XPATH, using = "//main[@class = 'ant-layout-content add-club-container']")
    private WebElement addLocationPopUp;
    private final String checkCirclePath = "./ancestor::div[@class = 'ant-form-item-control-input-content']//span[contains(@class, 'feedback-icon')]";

    public AddLocationComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Check that add location pop up is displayed")
    public boolean isAddLocationPopUpDisplayed() {
        return addLocationPopUp.isDisplayed();
    }

    @Step("input location name {locationName}")
    public AddLocationComponent inputLocationNameField(String locationName) {
        locationNameField.sendKeys(locationName);

        return this;
    }

    @Step("check that Data in name field is accepted")
    public boolean isSuccessNameCircleDisplayed() {
        return locationNameField.findElement(By.xpath(checkCirclePath))
                .getAttribute("class")
                .contains("success");
    }

    @Step("input address {address}")
    public AddLocationComponent inputAddressField(String address) {
        addressField.sendKeys(address);
        return this;
    }

    @Step("check that Data in address field is accepted")
    public boolean isSuccessAddressCircleDisplayed() {
        return addressField.findElement(By.xpath(checkCirclePath))
                .getAttribute("class")
                .contains("success");
    }

    @Step("input coordinates {coordinates}")
    public AddLocationComponent inputCoordinatesField(String coordinates) {
        coordinatesField.sendKeys(coordinates);
        return this;
    }

    @Step("check that Data in coordinates field is accepted")
    public boolean isSuccessCoordinatesCircleDisplayed() {
        return coordinatesField.findElement(By.xpath(checkCirclePath))
                .getAttribute("class")
                .contains("success");
    }

    @Step("input phone {phone}")
    public AddLocationComponent inputPhoneField(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    @Step("check that Data in phone number field is accepted")
    public boolean isSuccessPhoneNumberCircleDisplayed() {
        return phoneField.findElement(By.xpath(checkCirclePath))
                .getAttribute("class")
                .contains("success");
    }

    public AddLocationComponent clickCityNameListButton() {
        cityNameListButton.click();
        sleep(1000);
        return this;
    }

    @Step("Verify that city dropdown list contain {city}")
    public boolean isDropDownListContainCity(City cityName) {
        return locationList
                .getAttribute("title")
                .contains(cityName.getName());
    }

    @Step("select {location} element from the dropdown list")
    public AddLocationComponent clickCityFromDropDownList(City location) {
        String str = String.format(".//div[text() = '%s']", location.getName());
        locationList.findElement(By.xpath(str)).click();

        return new AddLocationComponent(driver);
    }

    @Step("check if Data in phone number field is accepted")
    public boolean isSuccessCityCircleDisplayed() {
        return cityNameListButton.findElement(By.xpath(checkCirclePath))
                .getAttribute("class")
                .contains("success");
    }

    @Step("add location in club")
    public ContactsClubComponent clickAddClubLocationButton() {
        addLocationButton.click();

        return new ContactsClubComponent(driver);
    }

    @Step("add location in center")
    public BasicInformationCenterComponent clickAddCenterLocationButton() {
        addLocationButton.click();

        return new BasicInformationCenterComponent(driver);
    }

    @Step("check that add button is enabled ")
    public boolean isAddButtonEnable() {
        return addButton.isEnabled();
    }
}