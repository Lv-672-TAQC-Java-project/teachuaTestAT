package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
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
}
