package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.addclub.DescriptionClubComponent;
import com.ita.edu.teachua.utils.TestRunnerWithValueProvider;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClubDescriptionFieldTest extends TestRunnerWithValueProvider {

    @BeforeMethod
    public void loggingIn() {
        HomePage home = new HomePage(driver);
        home.login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .getHeader()
                .clickOnAddNewClubBtn();
    }

    @Description("Verify that error message ‘Опис гуртка закороткий’ appears when the user enters " +
            "less than 40 symbols into the field")
    @Issue("TUA-176")
    @Test(description = "TUA-176")
    public void verifyThatErrorMessageAppearsWhenNotEnoughSymbolsInClubDescriptionField() {
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

    @Description("Verify that error message ‘Опис гуртка задовгий’ appears " +
            "when the user enters more than 1500 symbols into the field," +
            "and that no error messages appear when the user" +
            "enters precisely 1500 symbols into the field.")
    @Issue("TUA-177")
    @Test(description = "TUA-177")
    public void tooManySymbolsClubDescriptionTest() {
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        String expectedMsg = "Опис гуртка може містити від 40 до 1500 символів.";
        descriptionClub
                .fillBasicInfo()
                .fillContactsInfo()
                .enterSymbols(1501);
        Assert.assertTrue(descriptionClub.getAlertMsg().contains(expectedMsg));

        descriptionClub
                .clearDescriptionField()
                .enterSymbols(1500);
        Assert.assertTrue(descriptionClub.isSuccessCheckCircleVisible());
    }

    @Description("Verify that error message appears when user enters letters in " +
            "Russian language into the field.")
    @Issue("TUA-178")
    @Test(description = "TUA-178")
    public void russianLettersTest() {
        String russianLettersString = "эъы" + RandomStringUtils.randomAlphabetic(90);
        String expectedMsg = "Опис гуртка не може містити російські літери";
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        descriptionClub
                .fillBasicInfo()
                .fillContactsInfo()
                .enterDescriptionText(russianLettersString);
        Assert.assertTrue(descriptionClub.getAlertMsg().contains(expectedMsg));
    }

    @Description("Verify that error message appears when user enters letters in " +
            "German language into the field.")
    @Issue("TUA-178")
    @Test(description = "TUA-178")
    public void germanLettersTest() {
        String expectedMsg = "Некоректний опис гуртка";
        String germanLettersString = "äöüß" + RandomStringUtils.randomAlphabetic(90);
        DescriptionClubComponent descriptionClub = new DescriptionClubComponent(driver);
        descriptionClub
                .fillBasicInfo()
                .fillContactsInfo()
                .enterDescriptionText(germanLettersString);
        Assert.assertTrue(descriptionClub.getAlertMsg().contains(expectedMsg));
    }
}