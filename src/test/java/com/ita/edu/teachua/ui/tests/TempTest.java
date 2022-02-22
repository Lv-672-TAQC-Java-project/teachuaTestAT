package com.ita.edu.teachua.ui.tests;


import com.ita.edu.teachua.ui.pages.about.AboutPage;
import com.ita.edu.teachua.ui.pages.home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class TempTest extends TestRunner {

    @Test
    public void test1() {
        String path = driver.getCurrentUrl();
        Assert.assertEquals(path, "https://speak-ukrainian.org.ua/dev/");
    }

    @Test
    public void test2() {
        HomePage home = new HomePage(driver);
        SoftAssert softAssert = new SoftAssert();
        String path = home.getCurrentUrl();
        softAssert.assertEquals(path, "https://speak-ukrainian.org.ua/dev/", "home page url");
        AboutPage aboutPage = home
                .getHeader()
                .clickAboutBtn();

        path = aboutPage.getCurrentUrl();
        softAssert.assertEquals(path, "https://speak-ukrainian.org.ua/dev/about", "about page url");
        List<String> expectedTitles = new ArrayList<>(List.of("Про ініціативу",
                "Ініціатива \"Навчай українською\" закликає викладачів спортивних секцій, тренерів навчати дітей українською мовою.",
                "Амбасадори проєкту",
                "Відгуки учасників челенджу"));
        softAssert.assertEquals(aboutPage.getTitles(), expectedTitles, "list titles");
        path = aboutPage.getHeader().clickLogo().getCurrentUrl();

        softAssert.assertEquals(path, "https://speak-ukrainian.org.ua/dev/", "home page url");
        softAssert.assertAll();

    }
}
