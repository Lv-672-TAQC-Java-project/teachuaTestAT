package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.about.AboutPage;
import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.clubs.AdvancedSearchComponent;
import com.ita.edu.teachua.ui.pages.clubs.ClubsPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addclub.AddClubPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HeaderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id='root']/section/header/div[1]/a/div")
    private WebElement logo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/section/header/div[2]/ul/li[3]")
    private WebElement aboutButton;

    @FindBy(how = How.XPATH, using = "//span[@title = 'Розширений пошук']")
    private WebElement advancedSearchButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'user-profile')]")
    private WebElement userProfileButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div")
    private WebElement dropDownMenuNode;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Додати гурток')]")
    private WebElement addNewClubBtn;
  
    @FindBy(how = How.XPATH, using = "//header/div[3]/div[2]/span[2]/*[1]")
    private WebElement adminProfileButton;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Додати центр')]")
    private WebElement locationBtn;


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

    public AdvancedSearchComponent clickAdvancedSearchBtn(){
        advancedSearchButton.click();
        return new AdvancedSearchComponent(driver);
    }

    public GuestMenuDropDownComponent clickUserProfile() {
        userProfileButton.click();
        return new GuestMenuDropDownComponent(driver, dropDownMenuNode);
    }

    public AddClubPage clickOnAddNewClubBtn() {
        addNewClubBtn.click();
        return new AddClubPage(driver);
    }

    public AdminMenuDropDownComponent clickAdminProfile() {
        adminProfileButton.click();

        return new AdminMenuDropDownComponent(driver, dropDownMenuNode);
    }

    public HeaderPage clickAddLocation() {
        locationBtn.click();

        return this;
    }

    public void login(String email, String password) {
        this.clickUserProfile()
                .clickLogin()
                .setEmail(email)
                .setPassword(password)
                .clickLoginButton();
        sleep(2000);
    }
}
