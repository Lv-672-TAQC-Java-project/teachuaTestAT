package com.ita.edu.teachua.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    protected WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilInvisibilityOfCenterWithText(String nameBeforeSorting, int time, String centerNameXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(centerNameXpath), nameBeforeSorting));
    }
}
