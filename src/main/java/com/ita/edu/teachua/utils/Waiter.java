package com.ita.edu.teachua.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiter {

    protected static WebDriver driver;

    public Waiter(WebDriver driver) {
        Waiter.driver = driver;
    }

    public static void waitInvisibilityOfElementWithText(String text, int time, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(locator), text));
    }

    public static void waitVisibilityOfAllElements(List<WebElement> webElements, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    public static void waitVisibilityOfElementLocated(String locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
