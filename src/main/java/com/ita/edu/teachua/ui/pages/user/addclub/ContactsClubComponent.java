package com.ita.edu.teachua.ui.pages.user.addclub;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactsClubComponent extends BasicInformationClubComponent {

    @FindBy(how = How.XPATH, using = "//*[@name = 'Телефон']")
    private WebElement contactPhone;

    public ContactsClubComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Fill contact phone")
    public ContactsClubComponent fillContactPhone() {
        contactPhone.sendKeys("0" + RandomStringUtils.randomNumeric(9));
        return this;
    }

    @Step("Fill contacts information and click next step button")
    public DescriptionClubComponent fillContactsInfo() {
        fillContactPhone();
        getNextStepBtn().click();
        return new DescriptionClubComponent(driver);
    }
}
