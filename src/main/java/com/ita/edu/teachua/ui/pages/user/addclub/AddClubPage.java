package com.ita.edu.teachua.ui.pages.user.addclub;

import com.ita.edu.teachua.ui.pages.header.HeaderPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddClubPage extends HeaderPage {

    @FindBy(how = How.XPATH, using = "//*[contains(span, 'Наступний крок')]")
    private WebElement nextStepBtn;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Назад')]")
    private WebElement returnBtn;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Завершити')]")
    private WebElement createClubBtn;

    public AddClubPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get next step button")
    public WebElement getNextStepBtn() {
        return nextStepBtn;
    }

    public WebElement getReturnBtn() {
        return returnBtn;
    }

    public WebElement getCreateClubBtn() {
        return createClubBtn;
    }
}
