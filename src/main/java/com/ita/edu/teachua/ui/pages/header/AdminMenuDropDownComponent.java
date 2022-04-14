package com.ita.edu.teachua.ui.pages.header;

import com.ita.edu.teachua.ui.pages.base.BaseComponent;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.addcenter.AddCenterPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminMenuDropDownComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = ".//ul/li[2]")
    private WebElement addCenter;

    @FindBy(how = How.XPATH, using = ".//ul/li[3]")
    private WebElement myProfileBtn;

    public AdminMenuDropDownComponent(WebDriver driver, WebElement root) {
        super(driver, root);
    }

    @Step("click add Center")
    public AddCenterPage clickAddCenter() {
        addCenter.click();

        return new AddCenterPage(driver);
    }

    public MyProfilePage clickMyProfileButton() {
        myProfileBtn.click();
        return new MyProfilePage(driver);
    }
}
