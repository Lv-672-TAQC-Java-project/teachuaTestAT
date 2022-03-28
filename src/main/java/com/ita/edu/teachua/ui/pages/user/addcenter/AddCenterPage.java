package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.header.AdminMenuDropDownComponent;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCenterPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@id='basic']/div[1]/span/button")
    private WebElement addLocationButton;

    public AddCenterPage(WebDriver driver) {
        super(driver);
    }

    public AddLocationComponent clickAddLocationBtn() {
        addLocationButton.click();

        return new AddLocationComponent(driver);
    }
}
