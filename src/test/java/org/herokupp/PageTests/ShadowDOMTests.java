package org.herokupp.PageTests;

import Utilities.Utils;

import org.herokupp.Pages.ShadowDOMPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShadowDOMTests {
    WebDriver driver;

    Utils utils;

    ShadowDOMPage shadowDOMPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        shadowDOMPage = new ShadowDOMPage(driver);
        utils = new Utils(driver);
        shadowDOMPage.visitShadowDom();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TC01_testingDOM() {
        try{
            shadowDOMPage.shadowText.isDisplayed();
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
        Assert.assertTrue(shadowDOMPage.getShadowElement1().getText().toLowerCase().contains("some different text"));
        Assert.assertTrue(shadowDOMPage.getShadowElement2().getText().toLowerCase().contains("in a list"));
    }
}
