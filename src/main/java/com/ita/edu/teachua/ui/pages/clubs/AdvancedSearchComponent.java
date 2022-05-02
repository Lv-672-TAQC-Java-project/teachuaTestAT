package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import com.ita.edu.teachua.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
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

    @FindBy(how = How.XPATH, using = "//span[text()='за рейтингом']")
    private WebElement byRatingOption;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'content-center-list')]/child::div//following::div[@class='center-name']")
    private List<WebElement> centersName;

    @FindBy(how = How.XPATH, using = "//label[@for='basic_cityName']/following::div[1]//span[@class='ant-select-clear']")
    private WebElement clearCityNameButton;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'content-center-list')]/child::div//following::div[@class='center-name'])[1]")
    private WebElement firstCenterName;

    @FindBy(how = How.XPATH, using = "//span[@aria-label='arrow-up']")
    private WebElement arrowUpLabel;

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    private Waiter waiter = new Waiter(driver);

    private static String firstCenterTextXpath = "(//div[contains(@class,'content-center-list')]/child::div//following::div[@class='center-name'])[1]";

    public AdvancedSearchComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Click on center button")
    public AdvancedSearchComponent clickOnСenterButton() {
        centerButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(centers));
        return this;
    }

    @Step("Click on list icon")
    public AdvancedSearchComponent clickOnListIcon() {
        listIcon.click();
        return this;
    }

    @Step("Click on clear city name button")
    public AdvancedSearchComponent clickOnClearCityNameButton() {
        clearCityNameButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[@title='12']")));
        return this;
    }

    @Step("Click on 'by rating' sorting option")
    public AdvancedSearchComponent clickOnByRatingOption() {
        String nameBeforeSorting = firstCenterName.getText();
        byRatingOption.click();
        waiter.waitUntilInvisibilityOfCenterWithText(nameBeforeSorting, 40, firstCenterTextXpath);
        return this;
    }

    @Step("Click on {pageNumber} page number")
    public AdvancedSearchComponent clickOnPaginationButton(int pageNumber) {
        String centerName = firstCenterName.getText();
        driver.findElement(By.xpath(String.format("//li[@title='%s']", pageNumber))).click();
        waiter.waitUntilInvisibilityOfCenterWithText(centerName, 40, firstCenterTextXpath);
        return this;
    }

    @Step("Click on arrow up label")
    public AdvancedSearchComponent clickOnArrowUpLabel() {
        String nameBeforeSorting = firstCenterName.getText();
        arrowUpLabel.click();
        waiter.waitUntilInvisibilityOfCenterWithText(nameBeforeSorting, 40, firstCenterTextXpath);
        return this;
    }

    public boolean isCentersDisplayedAsAList(int expectedWidth, int expectedHeight) {
        for (WebElement element : centers) {
                if (!(element.getSize().height == expectedHeight && element.getSize().width == expectedWidth)) {
                    return false;
                }
            }
        return true;
    }

    public boolean isCategoryDisplayed(String categoryName) {
        try {
            return driver.findElement(By.xpath(String.format("//label[@title='%s']/ancestor::div[2]", categoryName))).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    public boolean isCheckBoxDisplayed(String labelName, String checkBoxName) {
        try {
            return driver.findElement(By.xpath(String.format("//label[@title='%s']/ancestor::div[2]//label/span[contains(text(),'%s')]", labelName, checkBoxName))).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    @Step("Verified that advanced search modal is displayed")
    public boolean isAdvancedSearchModalDisplayed() {
        return advancedSearchModal.size() > 0;
    }

    @Step("Verified that club radio button is selected")
    public boolean isClubRadioButtonSelected() {
        return clubRadioButton.isSelected();
    }

    @Step("Verified that city dropdown is activated")
    public boolean isCityDropdownActivated() {
        return cityDropdown.isEnabled();
    }

    @Step("Verified that district dropdown is activated")
    public boolean isDistrictDropdownActivated() {
        return districtDropdown.isEnabled();
    }

    @Step("Verified that subway station dropdown is activated")
    public boolean isSubwayStationDropdownActivated() {
        return subwayStationDropdown.isEnabled();
    }

    @Step("Verified that available online checkbox is activated")
    public boolean isAvailableOnlineCheckboxActivated() {
        return availableOnlineCheckbox.isEnabled();
    }

    @Step("Verified that categories checkboxes is activated")
    public boolean isCategoriesCheckboxesActivated() {
        for (WebElement category : categoriesCheckboxes) {
            if (!category.isEnabled()) {
                return false;
            }
        }
        return true;
    }

    @Step("Verified that age field is activated")
    public boolean isAgeFieldActivated() {
        return ageField.isEnabled();
    }

    public List<String> getCenterName() {
        List<String> listCenterName = new ArrayList<>();

        for (WebElement name : centersName) {
            listCenterName.add(name.getText());
        }

        while (nextPageButton.getAttribute("aria-disabled").contains("false")) {
            String centerName = centersName.get(0).getText();
            nextPageButton.click();
            waiter.waitUntilInvisibilityOfCenterWithText(centerName, 45, firstCenterTextXpath);

            for (WebElement name : centersName) {
                listCenterName.add(name.getText());
            }
        }
        return listCenterName;
    }
}

