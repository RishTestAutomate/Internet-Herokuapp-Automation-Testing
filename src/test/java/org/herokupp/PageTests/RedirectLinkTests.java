package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.RedirectLinkPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedirectLinkTests {
    WebDriver driver;

    Utils utils;
    RedirectLinkPage redirectLinkPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        redirectLinkPage = new RedirectLinkPage(driver);
        utils = new Utils(driver);
        redirectLinkPage.visitRedirectLink();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingAllRedirections(){
        String beforeUrl = driver.getCurrentUrl();
        redirectLinkPage.redirectLink.click();
        String afterUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(beforeUrl, afterUrl);

        redirectLinkPage.status_200.click();
        String curUrl = driver.getCurrentUrl();
        Assert.assertTrue(curUrl.contains("200"));

        redirectLinkPage.redirectToStatusCode.click();

        redirectLinkPage.status_301.click();
        curUrl = driver.getCurrentUrl();
        Assert.assertTrue(curUrl.contains("301"));

        redirectLinkPage.redirectToStatusCode.click();

        redirectLinkPage.status_404.click();
        curUrl = driver.getCurrentUrl();
        Assert.assertTrue(curUrl.contains("404"));

        redirectLinkPage.redirectToStatusCode.click();

        redirectLinkPage.status_500.click();
        curUrl = driver.getCurrentUrl();
        Assert.assertTrue(curUrl.contains("500"));

        redirectLinkPage.redirectToStatusCode.click();


        Assert.assertTrue(redirectLinkPage.status_200.isDisplayed());
    }
}
