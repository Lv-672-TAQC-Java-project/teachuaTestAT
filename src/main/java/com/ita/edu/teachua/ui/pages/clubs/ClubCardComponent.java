package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClubCardComponent extends BasePage {

    private final WebElement rootElement;

    public ClubCardComponent(WebDriver driver, WebElement rootElement) {
        super(driver);
        this.rootElement = rootElement;
    }

    public String getName() {

        return rootElement.findElement(By.xpath(".//div[@class='name']")).getText();
    }

}
