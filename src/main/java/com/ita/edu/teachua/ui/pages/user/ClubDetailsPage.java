package com.ita.edu.teachua.ui.pages.user;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClubDetailsPage extends CommonPage {

    public ClubDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "club-name")
    private WebElement clubName;

    @FindBy(how = How.CLASS_NAME, using = "years")
    private WebElement ageRange;

    @FindBy(how = How.XPATH, using = "//*[@class = 'center'] //*[@class = 'name']")
    private WebElement clubCenterName;

    @FindBy(how = How.XPATH, using = "//*[@class = 'contact-name']")
    private WebElement contactsInfo;

    @FindBy(how = How.XPATH, using = "//div[@class = 'content']")
    private WebElement description;

    @FindBy(how = How.XPATH, using = "//div[@class = 'address']")
    private WebElement address;

    public String getClubName() {
        return clubName.getText();
    }

    public String getAgeRange() {
        return ageRange.getText();
    }

    public int getAgeFrom() {
        String age = String.valueOf(getAgeRange().substring(4,5));
        int ageFrom = Integer.valueOf(age);
        return ageFrom;
    }

    public int getAgeTo() {
        String age = String.valueOf(getAgeRange().substring(9,10));
        int ageTo = Integer.valueOf(age);
        return ageTo;
    }

    public String getClubCenterName() {
        return clubCenterName.getText();
    }

    public String getContactsInfo() {
        return contactsInfo.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getAddress() {
        return address.getText();
    }

}
