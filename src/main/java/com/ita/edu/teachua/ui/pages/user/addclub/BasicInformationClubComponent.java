package com.ita.edu.teachua.ui.pages.user.addclub;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Random;

public class BasicInformationClubComponent extends AddClubPage {

    @FindBy(how = How.ID, using = "basic_name")
    private WebElement fieldName;
    @FindBy(how = How.ID, using = "basic_categories")
    private List<WebElement> newClubCheckboxes;
    @FindBy(how = How.ID, using = "basic_ageFrom")
    private WebElement minimumAgeField;
    @FindBy(how = How.ID, using = "basic_ageTo")
    private WebElement maximumAgeField;
    @FindBy(how = How.ID, using = "basic_centerId")
    private WebElement openCentersMenu;
    @FindBy(how = How.XPATH, using = "//*[@class = 'rc-virtual-list-holder-inner']//following-sibling::div")
    private List<WebElement> centerOptions;

    public BasicInformationClubComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Enter club name")
    public BasicInformationClubComponent enterClubName(String clubName) {
        fieldName.sendKeys(clubName);
        return this;
    }

    @Step("Select checkboxes")
    public BasicInformationClubComponent selectCheckboxes() {
        WebElement randomCheckbox = newClubCheckboxes.get(new Random().nextInt(newClubCheckboxes.size()));
        randomCheckbox.click();
        return this;
    }

    @Step("Enter age")
    public BasicInformationClubComponent enterAge(int ageFrom, int ageTo) {
        minimumAgeField.clear();
        minimumAgeField.sendKeys(String.valueOf(ageFrom));
        maximumAgeField.clear();
        maximumAgeField.sendKeys(String.valueOf(ageTo));
        return this;
    }

    @Step("Select center")
    public BasicInformationClubComponent selectCenter() {
        openCentersMenu.click();
        centerOptions.get(new Random().nextInt(centerOptions.size())).click();
        return this;
    }

    @Step("Press 'next step' button")
    public ContactsClubComponent goToContactsClubComponent() {
        getNextStepBtn().click();
        return new DescriptionClubComponent(driver);
    }

    @Step("Fill basic information and click next step button")
    public ContactsClubComponent fillBasicInfo() {
        enterClubName(RandomStringUtils.randomAlphabetic(8));
        selectCheckboxes();
        enterAge(4, 16);
        getNextStepBtn().click();
        return new ContactsClubComponent(driver);
    }
}
