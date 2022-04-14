package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCenterPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//body[1]/div[5]/div[1]/div[1]/ul[1]/li[2]/span[1]/div[1]")
    private WebElement buttonAddCenter;
    @FindBy(how = How.XPATH, using = "//*[@id='basic']/div[1]/span/button")
    private WebElement addLocationButton;

    public AddCenterPage(WebDriver driver) {
        super(driver);
    }

    public BasicInformationCenterComponent clickButtonAddCenter() {
        buttonAddCenter.click();
        return new BasicInformationCenterComponent(driver);
    }

    @Step("click add Location Btn")
    public AddLocationComponent clickAddLocationBtn() {
        addLocationButton.click();

        return new AddLocationComponent(driver);
    }
}