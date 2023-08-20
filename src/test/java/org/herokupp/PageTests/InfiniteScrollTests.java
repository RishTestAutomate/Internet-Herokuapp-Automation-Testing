package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.InfiniteScrollPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InfiniteScrollTests {

    WebDriver driver;

    InfiniteScrollPage infiniteScrollPage;

    Utils utils;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        infiniteScrollPage = new InfiniteScrollPage(driver);
        infiniteScrollPage.visitInfiniteScroll();
        utils = new Utils(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyInfiniteScrolling(){
        int scrollHeight = utils.getCurrentScrollHeight();
        utils.scrollDownBy(15);
        int newScrollHeight = utils.getCurrentScrollHeight();
        System.out.println(scrollHeight);
        Assert.assertNotEquals(scrollHeight, newScrollHeight, "Content still loading after scrolling.");
    }

}
