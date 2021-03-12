package com.thehartford.library.step_definitions;

import com.thehartford.library.pages.HomePage;
import com.thehartford.library.utilities.BrowserUtils;
import com.thehartford.library.utilities.ConfigurationReader;
import com.thehartford.library.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class Navigation_StepDefs {
    HomePage homePageObj = new HomePage();
    BrowserUtils browserUtils = new BrowserUtils();

    @Given("I am on the {string} page")
    public void i_am_on_the_Login_page(String pageName) {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @Given("I click on every link in the top menu")
    public void i_click_allMenu_links() throws InterruptedException {
        homePageObj.menu_auto.click();
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);
        int sizeOfMenu = Driver.getDriver().findElements(By.xpath("//ul[@id='primary-nav']/li//span")).size();
        assertEquals(5, sizeOfMenu);
        for (int j = 0; j < sizeOfMenu; j++) {
            Thread.sleep(1000);
            Driver.getDriver().findElement(By.xpath("//ul[@id='primary-nav']/li[" + (j + 1) + "]//span")).click();
            Driver.getDriver().navigate().refresh();
        }
    }

    @Given("I navigate to {}")
    public void navigate_to_url(String link) {
        if (link.equalsIgnoreCase("default")) {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        } else {
            Driver.getDriver().get(link);
        }
    }

}
