package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import io.qameta.allure.Step;
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


    @FindBy(how = How.XPATH, using = "//label[@class='ant-radio-button-wrapper club-view-button']/span/img")
    private WebElement listIcon;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'content-center-list')]/child::div")
    private List<WebElement> centers;

    @FindBy(how = How.XPATH, using = "//ul/li[contains(@class, 'ant-pagination-item')]")
    private List<WebElement> listOfPaginationButtons;

    @FindBy(how = How.XPATH, using = "//li[@title='Next Page']")
    private WebElement nextPageButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Гурток']/parent::label//input")
    private WebElement clubRadioButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Київ']/parent::div//input")
    private WebElement cityDropdown;

    @FindBy(how = How.XPATH, using = "//span[text()='Виберіть район']/parent::div//input")
    private WebElement districtDropdown;

    @FindBy(how = How.XPATH, using = "//span[text()='Виберіть станцію']/parent::div//input")
    private WebElement subwayStationDropdown;

    @FindBy(how = How.XPATH, using = "//span[text()='Доступний онлайн']/parent::label//input")
    private WebElement availableOnlineCheckbox;

    @FindBy(how = How.XPATH, using = "//span[text()='років']/parent::div//input")
    private WebElement ageField;

    @FindBy(how = How.XPATH, using = "//label[text()='Категорії']/ancestor::div[contains(@class,'club-list-row')]//input")
    private List<WebElement> categoriesCheckboxes;


    public AdvancedSearchComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Click on center button")
    public AdvancedSearchComponent clickOnСenterButton() {
        centerButton.click();
        sleep(3000);
        return this;
    }
    @Step("Click on list icon")
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

    public boolean isAdvancedSearchModalDisplayed() {
        return advancedSearchModal.size() > 0;
    }

    public boolean isClubRadioButtonSelected() {
        return clubRadioButton.isSelected();
    }

    public boolean isCityDropdownActivated() {
        return cityDropdown.isEnabled();
    }

    public boolean isDistrictDropdownActivated() {
        return districtDropdown.isEnabled();
    }

    public boolean isSubwayStationDropdownActivated() {
        return subwayStationDropdown.isEnabled();
    }

    public boolean isAvailableOnlineCheckboxActivated() {
        return availableOnlineCheckbox.isEnabled();
    }

    public boolean isCategoriesCheckboxesActivated() {
        int size = categoriesCheckboxes.size();

        boolean result = false;
        for (int i = 0; i < size; i++) {

            result = categoriesCheckboxes
                    .get(i)
                    .isEnabled();

            if (!result) {
                break;
            }
        }

        return result;
    }

    public boolean isAgeFieldActivated() {
        return ageField.isEnabled();
    }
}

