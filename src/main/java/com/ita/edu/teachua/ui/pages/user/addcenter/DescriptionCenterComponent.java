package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import io.qameta.allure.Step;
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
    @FindBy(how = How.XPATH, using = "(//div[@class = 'ant-steps-item-title' and text() = 'Опис']//ancestor::div[contains(@class, 'ant-steps-item ant-steps-item')])[1]")
    private WebElement DescriptionTab;
    private final String checkCirclePath = "./ancestor::div[@class = 'ant-form-item-control-input-content']//span[contains(@class, 'feedback-icon')]";

    public DescriptionCenterComponent(WebDriver driver) {
        super(driver);
    }

    @Step("input address {description}")
    public DescriptionCenterComponent inputDescriptionField(String description) {
        descriptionField.sendKeys(description);

        return this;
    }

    @Step("check that description tab is activated")
    public boolean isDescriptionTabActivated() {
        return DescriptionTab.getAttribute("class")
                .contains("active");
    }

    @Step("check that Data in description field is accepted")
    public boolean isSuccessDescriptionCircleDisplayed() {
        return descriptionField.findElement(By.xpath(checkCirclePath))
                .getAttribute("class")
                .contains("success");
    }

    @Step("go to clubs tab")
    public ClubsComponent clickNextButton() {
        nextButton.click();

        return new ClubsComponent(driver);
    }

    public ContactsCenterComponent clickPreviousButton() {
        previousButton.click();

        return new ContactsCenterComponent(driver);
    }
}
