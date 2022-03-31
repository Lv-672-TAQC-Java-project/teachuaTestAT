package com.ita.edu.teachua.ui.pages.user.addclub;

import com.ita.edu.teachua.ui.pages.base.BasePage;
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
}
