package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.about.AboutPage;
import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.clubs.ClubsPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id='root']/section/header/div[1]/a/div")
    private WebElement logo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/section/header/div[2]/ul/li[3]")
    private WebElement aboutButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'user-profile')]")
    private WebElement userProfileButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div")
    private WebElement dropDownMenuNode;

    @FindBy(xpath = "//div[@class='search']//span[@class='ant-select-selection-search']/input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@aria-label='control']")
    private WebElement advancedSearch;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickLogo() {
        logo.click();
        return new HomePage(driver);
    }

    public AboutPage clickAboutBtn() {
        aboutButton.click();
        return new AboutPage(driver);
    }

    public GuestMenuDropDownComponent clickUserProfile() {
        userProfileButton.click();
        return new GuestMenuDropDownComponent(driver, dropDownMenuNode);
    }

    public void login(String email, String password) {
        this.clickUserProfile()
                .clickLogin()
                .setEmail(email)
                .setPassword(password)
                .clickLoginButton();
        sleep(2000);
    }

    public ClubsPage clickAdvancedSearchBtn() {
        advancedSearch.click();
        return new ClubsPage(driver);
    }

    public ClubsPage enterSearch(String keyWords){
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(keyWords);
        searchInput.sendKeys(Keys.ENTER);
        return new ClubsPage(driver);
    }
    public ClubsPage parseSearch(String keyWords){
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(keyWords);
        return new ClubsPage(driver);
    }

}
