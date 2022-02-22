package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.about.AboutPage;
import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[@id='root']/section/header/div[1]/a/div")
    private WebElement logo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/section/header/div[2]/ul/li[3]")
    private WebElement aboutButton;


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

}
