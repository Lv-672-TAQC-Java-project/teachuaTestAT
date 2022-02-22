package com.ita.edu.teachua.ui.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


}
