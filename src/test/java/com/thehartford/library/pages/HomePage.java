package com.thehartford.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage  extends BasePage{

    @FindBy(xpath = "//ul[@id='primary-nav']/li//span[.='Auto']")
    public WebElement menu_auto;

    @FindBy(xpath = "//ul[@id='primary-nav']/li//span")
    public List<WebElement> menu_allLinks;
}
