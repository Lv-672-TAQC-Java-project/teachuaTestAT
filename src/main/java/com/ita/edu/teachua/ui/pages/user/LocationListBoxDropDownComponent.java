package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LocationListBoxDropDownComponent extends BasePage {

    public LocationListBoxDropDownComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[8]/div/div/div/div[2]/div[1]/div/div")
    private WebElement locationList;

    public AddLocationComponent clickSelectedElements(String location) {

        String str = String.format(".//div[text() = '%s']", location);
        locationList.findElement(By.xpath(str)).click();

        return new AddLocationComponent(driver);
    }
}
