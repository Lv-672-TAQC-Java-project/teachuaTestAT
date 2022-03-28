package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AdvancedSearchComponent extends CommonPage {
    @FindBy(how = How.XPATH, using = "//span[text()='Центр']")
    private WebElement centerButton;

    @FindBy(how = How.XPATH, using = "//div[text()='Розширений пошук']/parent::div")
    private List<WebElement> advancedSearchModal;

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

    public boolean isAdvancedSearchModalDisplayed() {
        return advancedSearchModal.size() > 0;
    }
}