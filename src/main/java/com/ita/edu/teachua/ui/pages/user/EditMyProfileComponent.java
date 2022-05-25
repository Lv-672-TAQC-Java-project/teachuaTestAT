package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditMyProfileComponent extends CommonPage {
    @FindBy(how = How.XPATH, using = "//*[@id='basic_name']")
    private WebElement workshopNameField;

    @FindBy(how = How.XPATH, using = "//*[@id='basic_categories']/label[\"%s\"]")
    private WebElement workshopCategory;

    @FindBy(how = How.XPATH, using = "//*[@id='basic_ageFrom']")
    private WebElement workshopAgeFromField;

    @FindBy(how = How.XPATH, using = "//*[@id='basic_ageTo']")
    private WebElement workshopAgeToField;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Наступний крок')]")
    private WebElement workshopNextStageButton;

    @FindBy(how = How.XPATH, using = "//input[@id='basic_contactТелефон']")
    private WebElement workshopPhoneNumberField;

    @FindBy(how = How.XPATH, using = "//textarea[@id='basic_description']")
    private WebElement workshopDescriptionField;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Завершити')]")
    private WebElement workshopFinishButton;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_firstName']")
    private WebElement fieldFirstName;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-form-item-explain-error']")
    private WebElement textErrorMessages;

    @FindBy(how = How.XPATH, using = "//button[@class='ant-btn ant-btn-default submit-button']/span")
    private WebElement buttonSaveChanges;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_lastName']")
    private WebElement fieldLastName;

    public EditMyProfileComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Set Workshop Name as \"{nameField}\"")
    public EditMyProfileComponent setWorkshopNameField(String nameField) {
        workshopNameField.click();
        workshopNameField.sendKeys(nameField);

        return new EditMyProfileComponent(driver);
    }

    @Step("Set Workshop Category as \"{categoryNumber}\"")
    public EditMyProfileComponent setWorkshopCategory(String categoryNumber) {
        workshopCategory.sendKeys(categoryNumber);
        workshopCategory.click();

        return new EditMyProfileComponent(driver);
    }

    @Step("Set Workshop age range from {ageFrom} to {ageTo}")
    public EditMyProfileComponent setWorkshopAgeRange(String ageFrom, String ageTo) {
        workshopAgeFromField.click();
        workshopAgeFromField.sendKeys(ageFrom);
        workshopAgeToField.click();
        workshopAgeToField.sendKeys(ageTo);

        return new EditMyProfileComponent(driver);
    }

    @Step("Click Workshop Next Stage Button")
    public EditMyProfileComponent clickWorkshopNextStageButton() {
        workshopNextStageButton.click();

        return new EditMyProfileComponent(driver);
    }

    @Step("Set Workshop phone number \"{phoneNumber}\"")
    public EditMyProfileComponent setWorkshopPhoneNumber(String phoneNumber) {
        workshopPhoneNumberField.click();
        workshopPhoneNumberField.sendKeys(phoneNumber);

        return new EditMyProfileComponent(driver);
    }

    @Step("Set Workshop description field")
    public EditMyProfileComponent setWorkshopDescriptionField(String descriptionText) {
        workshopDescriptionField.click();
        workshopDescriptionField.clear();
        workshopDescriptionField.sendKeys(descriptionText);

        return new EditMyProfileComponent(driver);
    }

    public boolean isWorkshopFinishButtonEnable() {
        return workshopFinishButton.isEnabled();
    }

    @Step("set First Name in profile edit")
    public EditMyProfileComponent setFirstName(String name) {
        fieldFirstName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldFirstName.sendKeys(Keys.DELETE);
        fieldFirstName.sendKeys(name);
        sleep(1000);

        return this;
    }

    @Step("set Last Name in profile edit")
    public EditMyProfileComponent setLastName(String lastName) {
        fieldLastName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldLastName.sendKeys(Keys.DELETE);
        fieldLastName.sendKeys(lastName);
        sleep(1000);

        return this;
    }

    @Step("get error text after type in input field")
    public String getErrorTextAfterInput() {

        return textErrorMessages.getText();
    }

    public boolean isButtonSaveChangedDisabled() {

        return buttonSaveChanges.isDisplayed();
    }
}