package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DescriptionCenterComponent extends BasePage {
    @FindBy(how = How.ID, using = "basic_description")
    private WebElement descriptionField;

    @FindBy(how = How.XPATH, using = "//*[@id='basic']//button[contains(@class, 'next-btn')]")
    private WebElement nextButton;

    @FindBy(how = How.XPATH, using = "//*[@id='basic']//button[contains(@class, 'prev-btn')]")
    private WebElement previousButton;

    public DescriptionCenterComponent(WebDriver driver) {
        super(driver);
    }

    public DescriptionCenterComponent inputDescriptionField(String description) {
        descriptionField.sendKeys(description);
        sleep(2000);
        return new DescriptionCenterComponent(driver);
    }

    public boolean isCheckCircleOfDescriptionFieldDisplayed() {
        String checkCirclePath = "./..//*[contains(@aria-label, 'check-circle')]";

        return descriptionField.findElement(By.xpath(checkCirclePath)).isDisplayed();
    }

    public ClubsComponent clickNextButton() {
        nextButton.click();
        sleep(1000);
        return new ClubsComponent(driver);
    }

    public boolean IsNextButtonEnabled() {
        return nextButton.isEnabled();
    }

    public ContactsCenterComponent clickPreviousButton() {
        previousButton.click();
        sleep(1000);
        return new ContactsCenterComponent(driver);
    }
}
