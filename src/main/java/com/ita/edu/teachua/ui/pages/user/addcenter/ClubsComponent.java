package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Random;

public class ClubsComponent extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@id = 'clubs']//div[@class = 'checkbox-item']")
    private List<WebElement> checkBoxClubs;
    @FindBy(how = How.XPATH, using = "//button[@class = 'finish-btn']")
    private WebElement finishButton;
    @FindBy(how = How.XPATH, using = "(//div[@class = 'ant-steps-item-title' and text() = 'Гуртки']//ancestor::div[contains(@class, 'ant-steps-item ant-steps-item')])[1]")
    private WebElement ClubsTab;

    public ClubsComponent(WebDriver driver) {
        super(driver);
    }

    @Step("check that clubs tab is activated")
    public boolean isClubsTabActivated() {
        return ClubsTab
                .getAttribute("class")
                .contains("active");
    }

    @Step("choose element in check box")
    public ClubsComponent clickCheckBoxClub() {
        WebElement randomCheckbox = checkBoxClubs
                .get(new Random().nextInt(checkBoxClubs.size()))
                .findElement(By.xpath(".//input"));
        randomCheckbox.click();

        return this;
    }

    @Step("create new center")
    public MyProfilePage clickFinishButton() {
        finishButton.click();
        //sleep(1000);
        return new MyProfilePage(driver);
    }
}
