package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ClubsPage extends CommonPage {

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='content-clubs-list content-clubs-block']/div")
    List<WebElement> clubCardsNode;

    public ClubsPage login(String email, String password) {
        this.getHeader().login(email, password);
        return new ClubsPage(driver);
    }

    public List<WebElement> getClubCards() {
        return clubCardsNode;
    }
}
