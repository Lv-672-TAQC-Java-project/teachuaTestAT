package com.ita.edu.teachua.ui.pages.base;

import com.ita.edu.teachua.ui.pages.header.HeaderPage;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage {
    protected HeaderPage headerPage;

    public CommonPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
    }

    public HeaderPage getHeader() {
        return headerPage;
    }
}
