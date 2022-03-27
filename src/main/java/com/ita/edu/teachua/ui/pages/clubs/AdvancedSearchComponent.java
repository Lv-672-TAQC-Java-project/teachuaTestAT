package com.ita.edu.teachua.ui.pages.clubs;

import com.ita.edu.teachua.ui.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AdvancedSearchComponent extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[text()='Розширений пошук']/parent::div")
    private List<WebElement> advancedSearchModal;

    public AdvancedSearchComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isAdvancedSearchModalDisplayed() {
        return advancedSearchModal.size() > 0;
    }
}
