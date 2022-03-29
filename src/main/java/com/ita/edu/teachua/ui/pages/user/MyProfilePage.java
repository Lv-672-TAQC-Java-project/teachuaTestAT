package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
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
    private WebElement addCircle;
    @FindBy(how = How.XPATH, using = "//*[@id='basic_name']")
    private WebElement circleNameField;
    @FindBy(how = How.XPATH, using = "//*[@id='basic_categories']/label[\"%s\"]")
    private WebElement circleCategory;
    @FindBy(how = How.XPATH, using = "//*[@id='basic_ageFrom']")
    private WebElement circleAgeFromField;
    @FindBy(how = How.XPATH, using = "//*[@id='basic_ageTo']")
    private WebElement circleAgeToField;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Наступний крок')]")
    private WebElement circleNextStageButton;
    @FindBy(how = How.XPATH, using = "//input[@id='basic_contactТелефон']")
    private WebElement circlePhoneNumberField;
    @FindBy(how = How.XPATH, using = "//textarea[@id='basic_description']")
    private WebElement circleDescriptionField;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Завершити')]")
    private WebElement circleFinishButton;

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public MyProfilePage clickDropDownProfileButton() {
        dropDownProfileButton.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage clickMyProfileButton() {
        myProfileButton.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage clickAddButton() {
        addButton.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage clickAddCircle() {
        addCircle.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage setCircleNameField(String nameField) {
        circleNameField.click();
        circleNameField.sendKeys(nameField);

        return new MyProfilePage(driver);
    }

    public MyProfilePage setCircleCategory(String categoryNumber) {
        circleCategory.sendKeys(categoryNumber);
        circleCategory.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage setCircleAgeRange(String ageFrom, String ageTo) {
        circleAgeFromField.click();
        circleAgeFromField.sendKeys(ageFrom);
        circleAgeToField.click();
        circleAgeToField.sendKeys(ageTo);

        return new MyProfilePage(driver);
    }

    public MyProfilePage clickCircleNextStageButton() {
        circleNextStageButton.click();

        return new MyProfilePage(driver);
    }

    public MyProfilePage setCirclePhoneNumber(String phoneNumber) {
        circlePhoneNumberField.click();
        circlePhoneNumberField.sendKeys(phoneNumber);

        return new MyProfilePage(driver);
    }

    public MyProfilePage setDescriptionField(String descriptionText) {
        circleDescriptionField.click();
        circleDescriptionField.clear();
        circleDescriptionField.sendKeys(descriptionText);

        return new MyProfilePage(driver);
    }

    public boolean isCircleFinishButtonEnable() {
        return circleFinishButton.isEnabled();
    }
}
