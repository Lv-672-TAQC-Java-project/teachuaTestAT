package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddLocationComponent extends BasePage {
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[2]/div/div[2]/div/main/div[2]/form/div[6]/button")
    private WebElement addButton;

    public AddLocationComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isAddButtonEnable() {
        if (addButton.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }
}
