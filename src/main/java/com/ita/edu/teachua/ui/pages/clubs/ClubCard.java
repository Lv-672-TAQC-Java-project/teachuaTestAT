package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.BaseComponent;
import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClubCard extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//li[@class='ant-rate-star ant-rate-star-full']")
    private List<WebElement> rating;

    @FindBy(how = How.XPATH, using = ".//div[@class='name']")
    private WebElement name;

    public ClubCard(WebDriver driver, WebElement clubCardNode) {
        super(driver, clubCardNode);


//        this.rootElementPath = String.format("//div[@class='content-clubs-list content-clubs-block']/div[%d]",
//                clubCardNumber);

//        WebElement clubCard = driver.findElement(By.xpath(rootElementPath));
//        actions.moveToElement(clubCard).perform();
    }

    public int getRating() {
        return rating.size();
    }

    public String getName() {
        return name.getText();
    }
}
