package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import com.ita.edu.teachua.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ita.edu.teachua.utils.Waiter.*;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

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

    @FindBy(how = How.XPATH, using = "//span[@class='control-sort-option'][contains(text(), 'за рейтингом')]")
    private WebElement sortByRatingLink;

    @FindBy(how = How.XPATH, using = "//span[text()='за алфавітом']")
    private WebElement sortAlphabeticallyButton;

    @FindBy(how = How.XPATH, using = "//span[@class='ant-select-clear']")
    private WebElement removeFilterButton;

    @FindBy(how = How.XPATH, using = "//div[@class='center-name']")
    List<WebElement> centerLabels;

    @FindBy(how = How.XPATH, using = "//span[@class='anticon anticon-arrow-up control-sort-arrow']")
    private WebElement sortArrowUpIcon;

    @FindBy(how = How.XPATH, using = "//span[@title='Київ']")
    private WebElement kyivCityFilter;

    @FindBy(how = How.XPATH, using = "//a[@rel='nofollow']")
    List<WebElement> pagesButtons;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @FindBy(how = How.XPATH, using = "//span[text()='за рейтингом']")
    private WebElement byRatingOption;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'content-center-list')]/child::div//following::div[@class='center-name']")
    private List<WebElement> centersName;

    @FindBy(how = How.XPATH, using = "//label[@for='basic_cityName']/following::div[1]//span[@class='ant-select-clear']")
    private WebElement clearCityNameButton;

    @FindBy(how = How.XPATH, using = "//span[@aria-label='arrow-up']")
    private WebElement arrowUpLabel;

    private final List<ClubCard> clubCards = new ArrayList<>();

    private Waiter waiter = new Waiter(driver);

    private static String firstCenterTextXpath = "(//div[contains(@class,'content-center-list')]/child::div//following::div[@class='center-name'])[1]";

    public AdvancedSearchComponent(WebDriver driver) {
        super(driver);
        initCards();
    }

    public WebElement getNextPageButton() {
        return nextPageButton;
    }

    @Step("Sorting by rating")
    public AdvancedSearchComponent sortByRating() {
        sortByRatingLink.click();
        sleep(1000);
        initCards();

        return this;
    }

    @Step("Sorting Clubs in {clubSortingArrowDirection} direction")
    public AdvancedSearchComponent clickSortArrowButton(ClubSortingArrowDirection clubSortingArrowDirection) {
        driver
                .findElement(By.xpath(clubSortingArrowDirection.getClubSortingArrowDirectionPath()))
                .click();

        sleep(1000);

        initCards();

        return this;
    }

    private void initCards() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='ant-card ant-card-bordered card']"));

        clubCards.clear();

        for (WebElement element : list) {
            clubCards.add(new ClubCard(driver, element));
        }
    }

    public List<ClubCard> getClubCards() {
        return clubCards;
    }

    public ClubCard getClubCard(int clubCardNumber) {
        return clubCards.get(clubCardNumber);
    }

    public int getClubCardsPerPageAmount() {
        return driver
                .findElements(By.xpath("//div[@class='ant-card ant-card-bordered card']"))
                .size();
    }

    @Step("Click on center button")
    public AdvancedSearchComponent clickOnСenterButton() {
        centerButton.click();
        waitVisibilityOfAllElements(centers, 40);
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
        waitVisibilityOfElementLocated("//ul/li[@title='13']", 40);
        return this;
    }

    @Step("Click on 'by rating' sorting option")
    public AdvancedSearchComponent clickOnByRatingOption() {
        String firstCenterName = centersName.get(0).getText();
        byRatingOption.click();
        waitInvisibilityOfElementWithText(firstCenterName, 40, firstCenterTextXpath);
        return this;
    }

    @Step("Click on {pageNumber} page number")
    public AdvancedSearchComponent clickOnPaginationButton(int pageNumber) {
        String firstCenterName = centersName.get(0).getText();
        driver.findElement(By.xpath(String.format("//li[@title='%s']", pageNumber))).click();
        waitInvisibilityOfElementWithText(firstCenterName, 40, firstCenterTextXpath);
        return this;
    }

    @Step("Click on arrow up label")
    public AdvancedSearchComponent clickOnArrowUpLabel() {
        String firstCenterName = centersName.get(0).getText();
        arrowUpLabel.click();
        waitInvisibilityOfElementWithText(firstCenterName, 40, firstCenterTextXpath);
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

    public List<String> getCenterName() {
        List<String> listCenterName = new ArrayList<>();

        for (WebElement name : centersName) {
            listCenterName.add(name.getText());
        }

        while (nextPageButton.getAttribute("aria-disabled").contains("false")) {
            String firstCenterName = centersName.get(0).getText();
            nextPageButton.click();
            waitInvisibilityOfElementWithText(firstCenterName, 45, firstCenterTextXpath);

            for (WebElement name : centersName) {
                listCenterName.add(name.getText());
            }
        }
        return listCenterName;
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

    @Step("Clicked sort alphabetically button ")
    public AdvancedSearchComponent clickSortAlphabeticallyButton() {
        String firstCenterName = centerLabels.get(0).getText();
        sortAlphabeticallyButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(format("//div[@class='center-name' and text()='%s']", firstCenterName))));

        return this;
    }

    @Step("Clicked remove filter button")
    public AdvancedSearchComponent clickRemoveFilterButton() {
        removeFilterButton.click();
        wait.until(ExpectedConditions.invisibilityOf(kyivCityFilter));

        return this;
    }

    @Step("Clicked on arrow-up button")
    public AdvancedSearchComponent clickArrowUpButton() {
        String firstCenterName = centerLabels.get(0).getText();
        sortArrowUpIcon.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(format("//div[@class='center-name' and text()='%s']", firstCenterName))));

        return this;
    }

    public List<String> getCenterLabels() {
        List<String> centerLabelNames = new LinkedList<>();
        int amountOfCenters = centerLabels.size();

        for (int i = 1; i <= amountOfCenters; i++) {
            centerLabelNames.add(driver.findElement(By.xpath(String.format("(//div[@class='center-name'])[%d]", i))).getText().trim());
        }

        return centerLabelNames
                .stream()
                .collect(toList());
    }
}

