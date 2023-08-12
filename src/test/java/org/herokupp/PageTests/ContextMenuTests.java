package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTests {

    WebDriver driver;

    Utils utils;
    ContextMenuPage contextMenuPage;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.visitContextMenu();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingTheUserIsOnContextMenuPage(){
        Assert.assertTrue(contextMenuPage.contextMenuTextElement.getText().contains("Context"));
    }

    @Test
    public void TC02_VerifyingContextMenuIsWorking(){
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuPage.contextElement).perform();

        Alert alert = driver.switchTo().alert();

        Assert.assertNotNull(alert);

        alert.accept();

        try{
            alert = driver.switchTo().alert();
        }
        catch (NoAlertPresentException e){
            Assert.assertTrue(true);
        }
    }
}
