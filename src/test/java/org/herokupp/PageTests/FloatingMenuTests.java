package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.FileUploadPage;
import org.herokupp.Pages.FloatingMenuPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FloatingMenuTests {
    WebDriver driver;

FloatingMenuPage floatingMenuPage;
    Utils utils;
    JavascriptExecutor jse;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.visitFloatingMenu();
        utils = new Utils(driver);
        jse = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingFloatingMenu(){
        long scrollHeight = (long) jse.executeScript("return document.body.scrollHeight;");
        long scrollRise = 0 ;
        while(scrollRise <= scrollHeight) {
            jse.executeScript("window.scrollTo(0, "+scrollRise+")");
            assertAll();
            scrollRise += 100 ;
        }
    }

    public void assertAll(){
        Assert.assertTrue(floatingMenuPage.home.isDisplayed());
        Assert.assertTrue(floatingMenuPage.news.isDisplayed());
        Assert.assertTrue(floatingMenuPage.contact.isDisplayed());
        Assert.assertTrue(floatingMenuPage.about.isDisplayed());
    }
}
