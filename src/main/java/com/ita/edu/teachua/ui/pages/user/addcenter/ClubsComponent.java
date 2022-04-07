package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ClubsComponent extends BasePage {

    public ClubsComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//button[@class = 'finish-btn']")
    private WebElement finishButton;

    @FindBy(how = How.XPATH, using = "//*[@id='clubs']//label")
    private List<WebElement> checkBoxClubsList;

    public ClubsComponent clickSelectedClubs(String[] nameClubs) {
        for (WebElement webElem : checkBoxClubsList) {
            for (String club : nameClubs) {
                if (webElem.getText().equals(club)) {
                    webElem.click();
                    sleep(1000);
                }
            }
        }

        return new ClubsComponent(driver);
    }

    public boolean isCheckBoxClubsSelected(String[] nameLocations) {
        boolean checkList = false;
        for (WebElement webElem : checkBoxClubsList) {
            for (String location : nameLocations) {
                if (webElem.getText().equals(location)) {
                    checkList = webElem.findElement(By.xpath(".//input")).isSelected();
                }
            }
        }

        return checkList;
    }

    public MyProfilePage clickFinishButton() {
        finishButton.click();
        sleep(1000);

        return new MyProfilePage(driver);
    }
}
