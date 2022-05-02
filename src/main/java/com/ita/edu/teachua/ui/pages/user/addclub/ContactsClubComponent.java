package com.ita.edu.teachua.ui.pages.user.addclub;

import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactsClubComponent extends BasicInformationClubComponent {

    @FindBy(how = How.XPATH, using = "//*[@name = 'Телефон']")
    private WebElement contactPhone;

    @FindBy(how = How.XPATH, using = "//*[@class = 'add-club-location']")
    private WebElement addLocationButton;

    public ContactsClubComponent(WebDriver driver) {
        super(driver);
    }

    public AddLocationComponent clickAddLocationButton() {
        addLocationButton.click();
        return new AddLocationComponent(driver);
    }

    @Step("Fill contact phone")
    public ContactsClubComponent fillContactPhone(String phoneNumber) {
        contactPhone.sendKeys(phoneNumber);
        return this;
    }

    @Step("Fill contact phone")
    public ContactsClubComponent fillContactPhone() {
        contactPhone.sendKeys("0" + RandomStringUtils.randomNumeric(9));
        return this;
    }

    @Step("Click 'next step' button")
    public DescriptionClubComponent goToDescriptionClubComponent() {
        getNextStepBtn().click();
        return new DescriptionClubComponent(driver);
    }

    @Step("Fill contacts information and click next step button")
    public DescriptionClubComponent fillContactsInfo() {
        fillContactPhone();
        getNextStepBtn().click();
        return new DescriptionClubComponent(driver);
    }
}
