package com.ita.edu.teachua.ui.pages.user.addclub;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DescriptionClubComponent extends ContactsClubComponent {
    @FindBy(how = How.XPATH, using = "//*[@id='basic_description']")
    private WebElement clubDescriptionField;
    @FindBy(how = How.XPATH, using = "//*[@role = 'alert']")
    private WebElement alert;
    @FindBy(how = How.XPATH, using = "//*[@data-icon = 'check-circle']")
    private WebElement successCheckCircle;

    public DescriptionClubComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Get text of alert message")
    public String getAlertMsg() {
        return alert.getText();
    }

    @Step("Type in 40 symbols description with russian letters")
    public DescriptionClubComponent enterRussianSymbols() {
        clubDescriptionField.sendKeys("эъы" + RandomStringUtils.randomAlphabetic(90));
        return this;
    }

    @Step("Type in 40 symbols description with german letters")
    public DescriptionClubComponent enterGermanSymbols() {
        clubDescriptionField.sendKeys("äöüß" + RandomStringUtils.randomAlphabetic(90));
        return this;
    }

    @Step("Visibility of description field success check circle")
    public boolean isSuccessCheckCircleVisible() {
        return successCheckCircle.isDisplayed();
    }

    @Step("Clear description field")
    public DescriptionClubComponent clearDescriptionField() {
        clubDescriptionField.clear();
        return this;
    }

    @Step("Enter text in the description field")
    public DescriptionClubComponent enterDescriptionText(String descriptionText) {
        clubDescriptionField.sendKeys(descriptionText);
        return this;
    }

    @Step("Enter {numberOfSymbols} symbols in the description field")
    public DescriptionClubComponent enterSymbols(int numberOfSymbols) {
        clubDescriptionField.sendKeys(RandomStringUtils.randomAlphabetic(numberOfSymbols));
        return this;
    }

    @Step("Verify that create club button is enabled")
    public boolean isCreateClubButtonEnabled() {
        return getCreateClubBtn().isEnabled();
    }

    @Step("Create new club")
    public HomePage clickCreateClubButton() {
        getCreateClubBtn().click();
        return new HomePage(driver);
    }
}