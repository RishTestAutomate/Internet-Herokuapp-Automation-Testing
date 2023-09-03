package org.herokuapp.PageTests;

import Utilities.Utils;
import org.herokuapp.Pages.EntryAdPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EntryAdTests {
    WebDriver driver;

    EntryAdPage entryAdPage;
    Utils utils;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        entryAdPage = new EntryAdPage(driver);
        entryAdPage.visitEntryAd();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingAdIsDisplayed(){
        utils.waitUntilIsDisplayed(entryAdPage.adPopupDiv);
    }

    @Test
    public void TC02_VerifyingAdIsDisplayedOnlyOnce(){
        utils.waitUntilIsDisplayed(entryAdPage.adPopupDiv);
        entryAdPage.closeAdButton.click();
        Assert.assertFalse(entryAdPage.adPopupDiv.isDisplayed());

        for(int i = 0 ; i < 5 ; i++){
            driver.navigate().refresh();
            utils.wait(1000);
            Assert.assertFalse(entryAdPage.adPopupDiv.isDisplayed(), "BUG : Ad is shown on subsequent Page load.");
        }
    }

    @Test
    public void TC03_VerifyingAfterReEnablingAdItsDisplayedOnlyOnce(){
        utils.waitUntilIsDisplayed(entryAdPage.adPopupDiv);
        entryAdPage.closeAdButton.click();
        utils.wait(500);
        Assert.assertFalse(entryAdPage.adPopupDiv.isDisplayed());

        entryAdPage.restartAdButton.click();

        driver.navigate().refresh();
        try{
            utils.waitUntilIsDisplayed(entryAdPage.adPopupDiv);
        }catch (TimeoutException e)
        {
            Assert.assertTrue(true, "BUG : Some issue in loading Entry Ad.");
        }
        Assert.assertTrue(entryAdPage.adPopupDiv.isDisplayed());
        entryAdPage.closeAdButton.click();
        utils.wait(500);
        Assert.assertFalse(entryAdPage.adPopupDiv.isDisplayed());
        for(int i = 0 ; i < 5 ; i++){
            driver.navigate().refresh();
            utils.wait(500);
            Assert.assertFalse(entryAdPage.adPopupDiv.isDisplayed());
        }
    }

    @Test
    public void TC04_VerifyingIfAdNotClosedThenAppearsOnEveryReload(){
        utils.waitUntilIsDisplayed(entryAdPage.adPopupDiv);
        for(int i = 0 ; i < 5 ; i++){
            driver.navigate().refresh();
            utils.waitUntilIsDisplayed(entryAdPage.adPopupDiv);
            Assert.assertTrue(entryAdPage.adPopupDiv.isDisplayed());
        }
    }
}
