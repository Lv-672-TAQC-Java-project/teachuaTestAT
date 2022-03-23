package com.ita.edu.teachua.ui.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BaseComponent {
    protected DefaultElementLocatorFactory parentContext;
    protected WebDriver driver;

    public BaseComponent(WebDriver driver, WebElement root){
        this.driver = driver;
        parentContext = new DefaultElementLocatorFactory(root);
        PageFactory.initElements(parentContext, this);
    }
}
