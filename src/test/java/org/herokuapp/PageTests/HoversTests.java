package org.herokuapp.PageTests;

import Utilities.Utils;
import org.herokuapp.Pages.HoversPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTests {
    WebDriver driver;

    HoversPage hoversPage;
    Actions actions;
    Utils utils;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        hoversPage = new HoversPage(driver);
        hoversPage.visitHovers();
        actions = new Actions(driver);
        utils = new Utils(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyUser1(){
        actions.moveToElement(hoversPage.image1).perform();
        Assert.assertTrue(hoversPage.user1Text.isDisplayed());

        actions.moveToElement(hoversPage.viewProfile1).click().build().perform();

        Assert.assertTrue(driver.getCurrentUrl().contains("users/1"));
    }
    @Test
    public void TC02_VerifyUser2(){
        actions.moveToElement(hoversPage.image2).perform();
        Assert.assertTrue(hoversPage.user2Text.isDisplayed());

        actions.moveToElement(hoversPage.viewProfile2).click().build().perform();

        Assert.assertTrue(driver.getCurrentUrl().contains("users/2"));
    }
    @Test
    public void TC03_VerifyUser3(){
        actions.moveToElement(hoversPage.image3).perform();
        Assert.assertTrue(hoversPage.user3Text.isDisplayed());

        actions.moveToElement(hoversPage.viewProfile3).click().build().perform();
        Assert.assertTrue(driver.getCurrentUrl().contains("users/3"));
    }
    @Test
    public void TC04_VerifyUsersAfterNavigation(){
        actions.moveToElement(hoversPage.image3).perform();
        Assert.assertTrue(hoversPage.user3Text.isDisplayed());

        actions.moveToElement(hoversPage.viewProfile3).click().build().perform();
        Assert.assertTrue(driver.getCurrentUrl().contains("users/3"));

        driver.navigate().back();
        utils.waitUntilIsDisplayed(hoversPage.image2);
        actions.moveToElement(hoversPage.image2).perform();
        actions.moveToElement(hoversPage.viewProfile2).click().build().perform();

        Assert.assertTrue(driver.getCurrentUrl().contains("users/2"));
    }
}
