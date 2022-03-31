package com.ita.edu.teachua.ui.pages.home;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String email, String password) {
        this.getHeader().login(email, password);
        return new HomePage(this.driver);
    }
}
