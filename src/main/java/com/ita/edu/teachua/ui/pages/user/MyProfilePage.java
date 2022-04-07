package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import com.ita.edu.teachua.ui.pages.user.addcenter.BasicInformationCenterComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyProfilePage extends CommonPage {
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id = 'root']//button[@classname = 'add-button']")
    private WebElement addButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div/ul/li[2]/span/div")
    private WebElement addCenterButton;

    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'selection-item')]")
    private WebElement myClubsButton;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'select-item-option-content')])[2]")
    private WebElement myCenterButton;

    public MyProfilePage clickMyClubsButton() {
        myClubsButton.click();
        sleep(2000);
        return new MyProfilePage(driver);
    }

    public MyProfilePage clickMyCenterButton() {
        myCenterButton.click();
        sleep(2000);
        return new MyProfilePage(driver);
    }

    public MyProfilePage clickAddButton() {
        addButton.click();
        sleep(2000);
        return new MyProfilePage(driver);
    }

    public boolean addButtonIsEnabled(){
        return addButton.isEnabled();
    }

    public BasicInformationCenterComponent clickAddCenterInDropDownButton() {
        addCenterButton.click();
        sleep(2000);
        return new BasicInformationCenterComponent(driver);
    }

    public boolean addCenterButtonIsEnabled(){
        return addCenterButton.isEnabled();
    }

}
