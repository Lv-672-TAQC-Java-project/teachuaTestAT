package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasicInformationCenterComponent extends BasePage {
    @FindBy(how = How.XPATH, using = "//span[@class='ant-input-affix-wrapper']/input")
    private WebElement fieldNameCenter;
    @FindBy(how = How.XPATH, using = "//button[@class='ant-btn ant-btn-default next-btn']/span")
    private WebElement clickToNextButton;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Некоректна назва центру')]")
    private WebElement textAfterClick;

    public BasicInformationCenterComponent(WebDriver driver) {
        super(driver);
    }

    @Step("get input field in 'Назва центру'")
    public String getFieldNameCenter() {
        return fieldNameCenter.getText();
    }

    @Step("click Next button")
    public BasicInformationCenterComponent clickNextButton() {
        clickToNextButton.click();
        return this;
    }

    @Step("get text after click")
    public String getTextAfterClick() {
        return textAfterClick.getText();
    }
}
