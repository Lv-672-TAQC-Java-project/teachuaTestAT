package com.ita.edu.teachua.newclub.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.ui.tests.TestRunnerWithValueProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClubDescriptionFieldTest extends TestRunnerWithValueProvider {

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
                        .enterSymbols(20)
                        .getAlertMsg()
                        .contains(expectedErrorMessage),
                "Error message 'Некоректний опис гуртка' should be displayed" +
                        "if entered only 20 symbols to description field");
        softAssert.assertTrue(descriptionClubComponent
                        .clearDescriptionField()
                        .enterSymbols(1)
                        .getAlertMsg()
                        .contains(expectedErrorMessage),
                "Error message 'Некоректний опис гуртка' should be displayed" +
                        "if entered only 1 symbol to description field");
        softAssert.assertTrue(descriptionClubComponent
                        .clearDescriptionField()
                        .enterSymbols(39)
                        .getAlertMsg()
                        .contains(expectedErrorMessage),
                "Error message 'Некоректний опис гуртка' should be displayed" +
                        "if entered only 39 symbols to description field");
        softAssert.assertAll();
    }

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
                .enterDescriptionText(descriptionWithEnglishAndUkrainianLetters)
                .isCreateClubButtonEnabled());
        softAssert.assertTrue(descriptionClubComponent
                .clearDescriptionField()
                .enterDescriptionText(descriptionWithNumbers)
                .isCreateClubButtonEnabled());
        softAssert.assertTrue(descriptionClubComponent
                .clearDescriptionField()
                .enterDescriptionText(descriptionWithSpecialCharacters)
                .isCreateClubButtonEnabled());
        softAssert.assertAll();
    }
}