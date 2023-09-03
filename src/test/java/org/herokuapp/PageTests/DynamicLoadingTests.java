package org.herokuapp.PageTests;

import Utilities.Utils;
import org.herokuapp.Pages.DynamicLoadingPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadingTests {

    WebDriver driver;
    DynamicLoadingPage dynamicLoadingPage;

    Utils utils;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.visitDynamicLoading();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingTheNavigationBetweenWebpageExample1(){
        utils.highlight_and_click(dynamicLoadingPage.example1);
        Assert.assertTrue(dynamicLoadingPage.loadedPageContent.getText().contains("Example 1"));
    }

    @Test
    public void TC02_VerifyingTheNavigationBetweenWebpageExample2(){
        utils.highlight_and_click(dynamicLoadingPage.example2);
        Assert.assertTrue(dynamicLoadingPage.loadedPageContent.getText().contains("Example 2"));
    }

    @Test
    public void TC03_VerifyingTheProcessExample1(){
        utils.highlight_and_click(dynamicLoadingPage.example1);
        utils.highlight_and_click(dynamicLoadingPage.startButton);

        utils.waitUntilIsDisplayed(dynamicLoadingPage.loadedMessage);
        Assert.assertTrue(dynamicLoadingPage.loadedMessage.getText().contains("Hello"));
    }
    @Test
    public void TC04_VerifyingTheProcessExample2(){
        utils.highlight_and_click(dynamicLoadingPage.example2);
        utils.highlight_and_click(dynamicLoadingPage.startButton);

        utils.waitUntilIsDisplayed(dynamicLoadingPage.loadedMessage);
        Assert.assertTrue(dynamicLoadingPage.loadedMessage.getText().contains("Hello"));
    }

    @Test
    public void TC05_VerifyingElementIsPresentInDomBeforeRendering(){
        utils.highlight_and_click(dynamicLoadingPage.example1);
        Assert.assertTrue(dynamicLoadingPage.loadedMessage.isEnabled());

        utils.highlight_and_click(dynamicLoadingPage.startButton);
        utils.waitUntilIsDisplayed(dynamicLoadingPage.loadedMessage);
        Assert.assertTrue(dynamicLoadingPage.loadedMessage.isDisplayed());
    }

    @Test
    public void TC06_VerifyingElementIsPresentInDomAfterRendering(){
        utils.highlight_and_click(dynamicLoadingPage.example2);
        try{
            dynamicLoadingPage.loadedMessage.isEnabled();
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }

        utils.highlight_and_click(dynamicLoadingPage.startButton);
        utils.waitUntilIsDisplayed(dynamicLoadingPage.loadedMessage);
        Assert.assertTrue(dynamicLoadingPage.loadedMessage.isDisplayed());
    }
}
