package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactsCenterComponent extends BasePage {
    @FindBy(how = How.ID, using = "contacts_contactТелефон")
    private WebElement phoneNumberField;

    @FindBy(how = How.XPATH, using = "//*[@id='contacts']//button[contains(@class, 'next-btn')]")
    private WebElement nextButton;

    @FindBy(how = How.XPATH, using = "//*[@id='contacts']//button[contains(@class, 'prev-btn')]")
    private WebElement previousButton;

    public ContactsCenterComponent(WebDriver driver) {
        super(driver);
    }

    public ContactsCenterComponent inputPhoneField(String phoneNumber){
        phoneNumberField.sendKeys(phoneNumber);
        sleep(1000);
        return new ContactsCenterComponent(driver);
    }

    public boolean isCheckCircleOfPhoneNumberFieldDisplayed() {
        String checkCirclePath = "./..//*[contains(@aria-label, 'check-circle')]";

        return phoneNumberField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    public DescriptionCenterComponent clickNextButton() {
        nextButton.click();
        sleep(1000);
        return new DescriptionCenterComponent(driver);
    }

    public boolean IsNextButtonEnabled() {
        return nextButton.isEnabled();
    }

    public BasicInformationCenterComponent clickPreviousButton() {
        previousButton.click();
        sleep(1000);
        return new BasicInformationCenterComponent(driver);
    }
}
