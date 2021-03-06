package com.ita.edu.teachua.ui.pages.user.addclub;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.utils.Waiter;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.ita.edu.teachua.utils.Waiter.waitInvisibilityOfElementLocated;

public class DescriptionClubComponent extends ContactsClubComponent {
    @FindBy(how = How.XPATH, using = "//*[@id='basic_description']")
    private WebElement clubDescriptionField;
    @FindBy(how = How.XPATH, using = "//*[@role = 'alert']")
    private WebElement alert;
    @FindBy(how = How.XPATH, using = "//*[@data-icon = 'check-circle']")
    private WebElement successCheckCircle;
    private final Waiter waiter = new Waiter(driver);

    public DescriptionClubComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Get text of alert message")
    public String getAlertMsg() {
        return alert.getText();
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


    @Step("Create Club")
    public HomePage createClub() {
        getCreateClubBtn().click();

        return new HomePage(driver);
    }

    @Step("fill description information and click finish button")
    public HomePage fillDescriptionInfo() {
        enterSymbols(50);
        createClub();

        waitInvisibilityOfElementLocated("//span[@class = 'ant-modal-close-x']", 10);

        return new HomePage(driver);
    }
}

