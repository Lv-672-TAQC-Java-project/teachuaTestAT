package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
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
                .enterCorrectAmountOfSymbols();
                Assert.assertTrue(descriptionClub.isSuccessCheckCircleVisible());
    }

    @Description("Verify that error message ‘Опис гуртка задовгий’ appears " +
            "when the user enters more than 1500 symbols into the field.")
    @Issue("TUA-177")
    @Test(description = "TUA-177")
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
