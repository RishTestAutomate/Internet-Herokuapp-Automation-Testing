package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.NotificationMessagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMessageTests {
    WebDriver driver;

    Utils utils;
    NotificationMessagePage notificationMessagePage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        notificationMessagePage = new NotificationMessagePage(driver);
        utils = new Utils(driver);
        notificationMessagePage.visitNotificationMessages();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyNotification(){
        /* Below test case was failing because of wrong spelling of Unsuccessful on WebPage */
        for (int i = 0 ; i < 10 ; i++){
            notificationMessagePage.notifyButton.click();
            Assert.assertTrue(notificationMessagePage.notificationMsg.getText().contains("successful")
                    || notificationMessagePage.notificationMsg.getText().contains("unsuccesful"));
        }

    }
}
