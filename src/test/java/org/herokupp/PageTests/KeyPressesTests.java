package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.JavascriptOnloadPage;
import org.herokupp.Pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyPressesTests {
    WebDriver driver;

    Utils utils;
    KeyPressesPage keyPressesPage;

    Actions actions;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        keyPressesPage = new KeyPressesPage(driver);
        utils = new Utils(driver);
        actions = new Actions(driver);
        keyPressesPage.visitKeyPresses();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingAllTheKeyPresses(){
        actions.sendKeys(Keys.ENTER).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("enter"));

        actions.sendKeys(Keys.ESCAPE).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("escape"));

        actions.sendKeys(Keys.ARROW_UP).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("up"));

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("down"));

        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("left"));

        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("right"));

        actions.sendKeys(Keys.BACK_SPACE).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("back_space"));

        actions.sendKeys(Keys.DELETE).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("delete"));

        actions.sendKeys(Keys.CONTROL).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("control"));

        actions.sendKeys(Keys.ALT).perform();
        Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains("alt"));

        String alphabets = "abcdefghijklmnopqrstuvwxyz1234567890";
        for (char c : alphabets.toCharArray()) {
            String enter = String.valueOf(c);
            keyPressesPage.keyInput.sendKeys(enter);
            Assert.assertTrue(keyPressesPage.keyResult.getText().toLowerCase().contains(enter));
        }
    }
}
