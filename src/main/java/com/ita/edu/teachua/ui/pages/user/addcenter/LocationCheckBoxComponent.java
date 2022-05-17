package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LocationCheckBoxComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = ".//span[2]")
    private WebElement name;
    @FindBy(how = How.XPATH, using = "./label//span")
    private WebElement checkBox;

    public LocationCheckBoxComponent(WebDriver driver, WebElement root) {
        super(driver, root);
    }

    public BasicInformationCenterComponent clickCheckBox() {
        checkBox.click();
        return new BasicInformationCenterComponent(driver);
    }

    public String getName() {
        return name.getText();
    }

}
