package com.ita.edu.teachua.ui.pages.user.addclub;

import com.ita.edu.teachua.ui.pages.base.BasePage;
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

    public DescriptionClubComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Get text of alert message")
    public String getAlertMsg() {
        return alert.getText();
    }

    public DescriptionClubComponent enterCorrectAmountOfSymbols() {
        clubDescriptionField.sendKeys(RandomStringUtils.randomAlphabetic(50));
        return this;
    }

    public DescriptionClubComponent enterNotEnoughSymbols() {
        clubDescriptionField.sendKeys(RandomStringUtils.randomAlphabetic(25));
        return this;
    }

    public DescriptionClubComponent enterTooManySymbols() {
        clubDescriptionField.sendKeys(RandomStringUtils.randomAlphabetic(1502));
        return this;
    }

    public DescriptionClubComponent enterRussianSymbols() {
        clubDescriptionField.sendKeys("эъы" + RandomStringUtils.randomAlphabetic(40));
        return this;
    }

    public DescriptionClubComponent enterGermanSymbols() {
        clubDescriptionField.sendKeys("äöüß" + RandomStringUtils.randomAlphabetic(40));
        return this;
    }

    public BasePage finishClubCreation() {
        getCreateClubBtn().click();
        return new BasePage(driver);
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
}
