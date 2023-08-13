package org.herokupp.PageTests;

import Utilities.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    WebDriver driver;

    Utils utils;

    JavascriptExecutor jse;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        utils = new Utils(driver);
        jse = (JavascriptExecutor) driver;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
