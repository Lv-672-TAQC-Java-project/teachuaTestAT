package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Collections;
import java.util.List;

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

    public EditMyProfileComponent setWorkshopNameField(String nameField) {
        workshopNameField.click();
        workshopNameField.sendKeys(nameField);

        return new EditMyProfileComponent(driver);
    }

    public EditMyProfileComponent setWorkshopCategory(String categoryNumber) {
        workshopCategory.sendKeys(categoryNumber);
        workshopCategory.click();

        return new EditMyProfileComponent(driver);
    }

    public EditMyProfileComponent setWorkshopAgeRange(String ageFrom, String ageTo) {
        workshopAgeFromField.click();
        workshopAgeFromField.sendKeys(ageFrom);
        workshopAgeToField.click();
        workshopAgeToField.sendKeys(ageTo);

        return new EditMyProfileComponent(driver);
    }

    public EditMyProfileComponent clickWorkshopNextStageButton() {
        workshopNextStageButton.click();

        return new EditMyProfileComponent(driver);
    }

    public EditMyProfileComponent setWorkshopPhoneNumber(String phoneNumber) {
        workshopPhoneNumberField.click();
        workshopPhoneNumberField.sendKeys(phoneNumber);

        return new EditMyProfileComponent(driver);
    }

    public EditMyProfileComponent setWorkshopDescriptionField(String descriptionText) {
        workshopDescriptionField.click();
        workshopDescriptionField.clear();
        workshopDescriptionField.sendKeys(descriptionText);

        return new EditMyProfileComponent(driver);
    }

    public boolean isWorkshopFinishButtonEnable() {
        return workshopFinishButton.isEnabled();
    }

    public EditMyProfileComponent setFirstName(String name) {
        fieldFirstName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldFirstName.sendKeys(Keys.DELETE);
//        fieldFirstName.clear();
       fieldFirstName.sendKeys(name);
        sleep(1000);

       return this;
    }

    public EditMyProfileComponent setLastName(String lastName) {
        fieldLastName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fieldLastName.sendKeys(Keys.DELETE);
//        fieldFirstName.clear();
        fieldLastName.sendKeys(lastName);
        sleep(1000);

        return this;
    }

    public String getErrorTextAfterInput() {

        return textErrorMessages.getText();
    }

    public boolean isButtonSaveChangedDisabled() {
        List<WebElement> button = Collections.singletonList(buttonSaveChanges);
        if (button.size() > 0 && button.get(0).isDisplayed())
        {
            return false;
        }
        return true;
    }


}
