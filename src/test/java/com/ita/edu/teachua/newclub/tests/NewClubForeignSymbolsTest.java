package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Description("Verify that error message appears when user enters letters in " +
        "Russian or German languages into the field.")
@Issue("TUA-178")
public class NewClubForeignSymbolsTest extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void loggingIn() {
        HomePage home = new HomePage(driver);
        home.login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .getHeader()
                .clickOnAddNewClubBtn();
    }

    @Test(description = "TUA-178")
    public void russianLettersTest() {
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        String expectedMsg = "Опис гуртка не може містити російські літери";
        descriptionClub
                .fillBasicInfo()
                .fillContactsInfo()
                .enterRussianSymbols();
        Assert.assertTrue(descriptionClub.getAlertMsg().contains(expectedMsg));
    }

    @Test(description = "TUA-178")
    public void germanLettersTest() {
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        String expectedMsg = "Некоректний опис гуртка";
        descriptionClub
                .fillBasicInfo()
                .fillContactsInfo()
                .enterGermanSymbols();
        Assert.assertTrue(descriptionClub.getAlertMsg().contains(expectedMsg));
    }
}
