package com.ita.edu.teachua.ui.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestRunner {
    protected WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://speak-ukrainian.org.ua/dev/");
    }

    @AfterMethod
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
