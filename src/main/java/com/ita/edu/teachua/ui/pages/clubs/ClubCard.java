package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.ita.edu.teachua.utils.Waiter.waitVisibilityOfAllElements;

public class ClubCard extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//li[@class='ant-rate-star ant-rate-star-full']")
    private List<WebElement> ratingStarFull;

    @FindBy(how = How.XPATH, using = ".//ul[@class='ant-rate ant-rate-disabled rating']/li[1]")
    private List<WebElement> firstRatingStar;

    @FindBy(how = How.XPATH, using = ".//div[@class='name']")
    private WebElement name;

    public ClubCard(WebDriver driver, WebElement clubCardNode) {
        super(driver, clubCardNode);
    }

    public int getRating() {
        waitVisibilityOfAllElements(firstRatingStar, 40);

        return (ratingStarFull.isEmpty() ? 0 : ratingStarFull.size());
    }

    public String getName() {
        return name.getText();
    }
}
