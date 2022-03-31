package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AdvancedSearchComponent extends CommonPage {
    @FindBy(how = How.XPATH, using = "//span[text()='Центр']")
    private WebElement centerButton;

    @FindBy(how = How.XPATH, using = "//label[@class='ant-radio-button-wrapper club-view-button']/span/img")
    private WebElement listIcon;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'content-center-list')]/child::div")
    private List<WebElement> centers;

    @FindBy(how = How.XPATH, using = "//ul/li[contains(@class, 'ant-pagination-item')]")
    private List<WebElement> listOfPaginationButtons;

    @FindBy(how = How.XPATH, using = "//li[@title='Next Page']")
    private WebElement nextPageButton;

    public AdvancedSearchComponent(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchComponent clickOnСenterButton() {
        centerButton.click();
        sleep(3000);
        return this;
    }

    public AdvancedSearchComponent clickOnListIcon() {
        listIcon.click();
        sleep(4000);
        return this;
    }

    public boolean isCentersDisplayedAsAList(int expectedWidth, int expectedHeight) {
        for (WebElement numberOfPageButton : listOfPaginationButtons) {
            for (WebElement element : centers) {
                if (!(element.getSize().height == expectedHeight && element.getSize().width == expectedWidth)) {
                    return false;
                }
                sleep(4000);
            }
            if (numberOfPageButton.getAttribute("class").contains("active")) {
                nextPageButton.click();
                sleep(4000);
            }
        }
        return true;
    }

    public boolean isDisplayedCategory(String nameOfCategory) {
        try {
            return driver.findElement(By.xpath(String.format("//label[@title='%s']/ancestor::div[2]", nameOfCategory))).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }
}
