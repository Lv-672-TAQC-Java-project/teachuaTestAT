package com.ita.edu.teachua.ui.pages.user.addcenter;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClubsComponent extends BasePage {
    @FindBy(how = How.ID, using = "clubs")
    private WebElement checkBoxClubs;

    @FindBy(how = How.XPATH, using = "//button[@class = 'finish-btn']")
    private WebElement finishButton;

    public ClubsComponent(WebDriver driver) {
        super(driver);
    }

    public ClubsComponent clickSelectedClubs(String[] nameClubs) {

        for(String location: nameClubs) {
            String nameLocationPath = String.format(".//label//span[text() = '%s']", location);
            checkBoxClubs.findElement(By.xpath(nameLocationPath)).click();
            sleep(1000);
        }

        return new ClubsComponent(driver);
    }

    public boolean isCheckBoxClubsSelected(String[] nameClubs) {
        boolean checkList = false;

        for(String location: nameClubs) {
            String nameLocationPath = String.format(".//label//input", location);
            checkList = checkBoxClubs.findElement(By.xpath(nameLocationPath)).isSelected();
            sleep(1000);
        }

        return checkList;
    }

    public MyProfilePage clickFinishButton() {
        finishButton.click();
        sleep(1000);

        return new MyProfilePage(driver);
    }
}
