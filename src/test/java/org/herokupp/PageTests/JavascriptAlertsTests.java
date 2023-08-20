package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.JQueryUIMenusPage;
import org.herokupp.Pages.JavascriptAlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptAlertsTests {
    WebDriver driver;

    JavascriptAlertsPage javascriptAlertsPage;


    @BeforeMethod
    public void setUp(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("disable-notifications");
        driver = new ChromeDriver(co);
        javascriptAlertsPage = new JavascriptAlertsPage(driver);
        javascriptAlertsPage.visitJavascriptAlerts();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyAllActions(){
        javascriptAlertsPage.js_alert.click();
        driver.switchTo().alert().accept();

        Assert.assertEquals(javascriptAlertsPage.js_message.getText(), "You successfully clicked an alert");

        javascriptAlertsPage.js_confirm.click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(javascriptAlertsPage.js_message.getText(), "You clicked: Ok");

        javascriptAlertsPage.js_confirm.click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(javascriptAlertsPage.js_message.getText(), "You clicked: Cancel");

        javascriptAlertsPage.js_prompt.click();
        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().accept();
        Assert.assertEquals(javascriptAlertsPage.js_message.getText(), "You entered: Test");

        javascriptAlertsPage.js_prompt.click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(javascriptAlertsPage.js_message.getText(), "You entered: null");

    }
}
