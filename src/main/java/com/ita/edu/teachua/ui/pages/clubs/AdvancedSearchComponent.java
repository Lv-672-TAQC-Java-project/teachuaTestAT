package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdvancedSearchComponent extends CommonPage {
    @FindBy(how = How.XPATH, using = "//span[text()='Центр']")
    private WebElement centerButton;

    public AdvancedSearchComponent(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchComponent clickOnСenterButton() {
        centerButton.click();
        return this;
    }

    public boolean isDisplayedCategory(String nameOfCategory) {
        try {
            return driver.findElement(By.xpath(String.format("//label[@title='%s']/ancestor::div[2]", nameOfCategory))).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }
}
