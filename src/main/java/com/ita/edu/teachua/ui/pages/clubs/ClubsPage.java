package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.WebDriver;

public class ClubsPage extends CommonPage {

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public ClubsPage login(String email, String password) {
        this.getHeader().login(email, password);
        return new ClubsPage(driver);
    }
}
