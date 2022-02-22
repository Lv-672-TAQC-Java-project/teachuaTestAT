package com.ita.edu.teachua.ui.pages.about;

import com.ita.edu.teachua.ui.pages.base.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class AboutPage extends CommonPage {
    @FindBy(how = How.CSS, using = ".title-content")
    protected List<WebElement> titleContent;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (WebElement element : titleContent) {
            titles.add(element.getText());
        }
        return titles;
    }
}
