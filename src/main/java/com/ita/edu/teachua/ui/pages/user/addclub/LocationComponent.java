package com.ita.edu.teachua.ui.pages.user.addclub;

import com.ita.edu.teachua.ui.pages.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LocationComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//h4")
    private WebElement name;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'description')]")
    private WebElement address;

    public LocationComponent(WebDriver driver, WebElement root) {
        super(driver, root);
    }

    public String getName(){
        return name.getText();
    }

    public String getAddress(){
        return address.getText();
    }

}
