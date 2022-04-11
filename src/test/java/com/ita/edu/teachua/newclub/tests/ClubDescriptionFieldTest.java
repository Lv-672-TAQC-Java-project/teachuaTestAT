package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClubDescriptionFieldTest extends TestRunnerWithValueProvider {

    @Description("Verify that error message ‘Опис гуртка закороткий’ appears when the user enters " +
            "less than 40 symbols into the field")
    @Issue("TUA-176")
    @Test(description = "TUA-176")
    public void verifyThatErrorMessageAppearsWhenNotEnoughSymbolsInClubDescriptionField() {
        HomePage homePage = new HomePage(driver);
        homePage
                .login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .getHeader()
                .clickOnAddNewClubBtn();

        DescriptionClubComponent descriptionClubComponent = new DescriptionClubComponent(driver);
        descriptionClubComponent
                .fillBasicInfo()
                .fillContactsInfo();

        String expectedErrorMessage = "Некоректний опис гуртка";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(descriptionClubComponent
                        .clearDescriptionField()
                        .enterSymbols(20)
                        .getAlertMsg()
                        .contains(expectedErrorMessage),
                "Error message 'Некоректний опис гуртка' should be displayed " +
                        "if entered only 20 symbols to description field");
        softAssert.assertTrue(descriptionClubComponent
                        .clearDescriptionField()
                        .enterSymbols(1)
                        .getAlertMsg()
                        .contains(expectedErrorMessage),
                "Error message 'Некоректний опис гуртка' should be displayed " +
                        "if entered only 1 symbol to description field");
        softAssert.assertTrue(descriptionClubComponent
                        .clearDescriptionField()
                        .enterSymbols(39)
                        .getAlertMsg()
                        .contains(expectedErrorMessage),
                "Error message 'Некоректний опис гуртка' should be displayed " +
                        "if entered only 39 symbols to description field");
        softAssert.assertAll();
    }

    @Description("Verify that the ‘Опис’ text field is filled in with valid data")
    @Issue("TUA-173")
    @Test(description = "TUA-173")
    public void verifyThatDescriptionFieldIsFilledInWithValidData() {
        HomePage homePage = new HomePage(driver);
        homePage
                .login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .getHeader()
                .clickOnAddNewClubBtn();

        DescriptionClubComponent descriptionClubComponent = new DescriptionClubComponent(driver);
        descriptionClubComponent
                .fillBasicInfo()
                .fillContactsInfo();

        String descriptionWithEnglishAndUkrainianLetters = "Education students Освіта студентів Ballet school Школа балету";
        String descriptionWithNumbers = "1234567890123456789012345678901234567890";
        String descriptionWithSpecialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{}~!#$%&'()*+,-./:;<=>?@[]^_`{}~";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(descriptionClubComponent
                        .clearDescriptionField()
                        .enterDescriptionText(descriptionWithEnglishAndUkrainianLetters)
                        .isCreateClubButtonEnabled(),
                "Data with letters in English and Ukrainian languages (from 40-1500 symbols) should be valid");
        softAssert.assertTrue(descriptionClubComponent
                        .clearDescriptionField()
                        .enterDescriptionText(descriptionWithNumbers)
                        .isCreateClubButtonEnabled(),
                "Data with numbers (from 40-1500 symbols) should be valid");
        softAssert.assertTrue(descriptionClubComponent
                        .clearDescriptionField()
                        .enterDescriptionText(descriptionWithSpecialCharacters)
                        .isCreateClubButtonEnabled(),
                "Data with special characters (from 40 to 1500 symbols) should be valid");
        softAssert.assertAll();
    }
}