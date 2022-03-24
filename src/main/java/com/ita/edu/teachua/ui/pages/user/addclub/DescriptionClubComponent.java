package com.ita.edu.teachua.ui.pages.user.addclub;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DescriptionClubComponent extends ContactsClubComponent {
    @FindBy(how = How.XPATH, using = "//*[@id='basic_description']")
    private WebElement clubDescriptionField;
    @FindBy(how = How.XPATH, using = "//*[@role = 'alert']")
    private WebElement alert;

    public DescriptionClubComponent(WebDriver driver) {
        super(driver);
    }

    public DescriptionClubComponent correctAmountOfSymbolsCheck() {
        clubDescriptionField.sendKeys(RandomStringUtils.randomAlphabetic(50));
        return this;
    }

    public DescriptionClubComponent notEnoughSymbolsCheck() {
        clubDescriptionField.sendKeys(RandomStringUtils.randomAlphabetic(25));
        String expected = "Некоректний опис гуртка";
        Assert.assertTrue(alert.getText().contains(expected));
        return this;
    }

    public DescriptionClubComponent tooManySymbolsCheck() {
        clubDescriptionField.sendKeys(RandomStringUtils.randomAlphabetic(1502));
        String expected = "Опис гуртка може містити від 40 до 1500 символів.";
        Assert.assertTrue(alert.getText().contains(expected));
        return this;
    }

    public BasePage finishClubCreation() {
        getCreateClubBtn().click();
        return new BasePage(driver);
    }

}
