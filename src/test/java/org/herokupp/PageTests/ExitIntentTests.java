package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.ExitIntentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ExitIntentTests {
    WebDriver driver;

    ExitIntentPage exitIntentPage;
    Utils utils;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        exitIntentPage = new ExitIntentPage(driver);
        exitIntentPage.visitExitIntent();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingPopComesUpWhenCursorIsMovedOutOfViewportBoundary(){
        /*It's not possible to move out of viewport Boundary using Automation*/
    }
}
