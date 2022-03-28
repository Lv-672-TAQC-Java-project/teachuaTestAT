package com.ita.edu.teachua.ui.pages.user.addclub;

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

    public BasicInformationClubComponent(WebDriver driver) {
        super(driver);
    }

    public BasicInformationClubComponent enterClubName() {
        fieldName.sendKeys(RandomStringUtils.randomAlphabetic(8));
        return this;
    }

    public BasicInformationClubComponent selectCheckboxes() {
        WebElement randomCheckbox = newClubCheckboxes.get(new Random().nextInt(newClubCheckboxes.size()));
        randomCheckbox.click();
        return this;
    }

    public BasicInformationClubComponent enterAge() {
        minimumAgeField.clear();
        minimumAgeField.sendKeys("4");
        maximumAgeField.clear();
        maximumAgeField.sendKeys("16");
        return this;
    }

    public ContactsClubComponent fillBasicInfo() {
        enterClubName();
        selectCheckboxes();
        enterAge();
        getNextStepBtn().click();
        return new ContactsClubComponent(driver);
    }
}
