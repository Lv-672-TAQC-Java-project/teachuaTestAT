package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCenterPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Додати')]")
    private WebElement buttonAdd;
    @FindBy(how = How.XPATH, using = "//body[1]/div[5]/div[1]/div[1]/ul[1]/li[2]/span[1]/div[1]")
    private WebElement buttonAddCenter;

    public AddCenterPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddButton() {
        buttonAdd.click();
    }

    public void clickButtonAddCenter() {
        buttonAddCenter.click();
    }
}
