package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewClubDescriptionTest extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void loggingIn() {
        HomePage home = new HomePage(driver);
        home.login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .getHeader()
                .clickOnAddNewClubBtn();
    }

    @Test
    public void validClubDescriptionTest() {
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        descriptionClub
                .fillBasicInfo()
                .fillContactsInfo()
                .enterCorrectAmountOfSymbols()
                .finishClubCreation();
    }

    @Test
    public void notEnoughSymbolsClubDescriptionTest() {
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        String expectedMsg = "Некоректний опис гуртка";
        descriptionClub
                .fillBasicInfo()
                .fillContactsInfo()
                .enterNotEnoughSymbols();
        Assert.assertTrue(descriptionClub.getAlertMsg().contains(expectedMsg));
    }

    @Test
    public void tooManySymbolsClubDescriptionTest() {
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        String expectedMsg = "Опис гуртка може містити від 40 до 1500 символів.";
        descriptionClub
                .fillBasicInfo()
                .fillContactsInfo()
                .enterTooManySymbols();
        Assert.assertTrue(descriptionClub.getAlertMsg().contains(expectedMsg));
    }
}
