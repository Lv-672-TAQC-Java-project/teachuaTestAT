package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import io.qameta.allure.Step;
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
    @FindBy(how = How.XPATH, using = "(//div[@class = 'ant-steps-item-title' and text() = 'Контакти']//ancestor::div[contains(@class, 'ant-steps-item ant-steps-item')])[1]")
    private WebElement contactsTab;
    private final String checkCirclePath = "./ancestor::div[@class = 'ant-form-item-control-input-content']//span[contains(@class, 'feedback-icon')]";

    public ContactsCenterComponent(WebDriver driver) {
        super(driver);
    }

    @Step("check that contact tab is activated")
    public boolean isContactTabActivated() {
        return contactsTab.getAttribute("class")
                .contains("active");
    }

    @Step("input phone number {phoneNumber}")
    public ContactsCenterComponent inputPhoneField(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);

        return this;
    }

    @Step("check that Data in phone number field is accepted")
    public boolean isSuccessPhoneNumberCircleDisplayed() {
        return phoneNumberField.findElement(By.xpath(checkCirclePath))
                .getAttribute("class")
                .contains("success");
    }

    @Step("go to Description tab")
    public DescriptionCenterComponent clickNextButton() {
        nextButton.click();

        return new DescriptionCenterComponent(driver);
    }

    public BasicInformationCenterComponent clickPreviousButton() {
        previousButton.click();

        return new BasicInformationCenterComponent(driver);
    }
}
