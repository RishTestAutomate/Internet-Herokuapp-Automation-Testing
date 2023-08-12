package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.ChallengingDomPage;
import org.herokupp.Pages.DynamicControlsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControlsTest {

    WebDriver driver;

    DynamicControlsPage dynamicControlsPage;

    Utils utils;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.visitDynamicControl();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingAddAndRemoveOption(){
        dynamicControlsPage.dynamic_checkbox.click();
        dynamicControlsPage.removeCheckboxButton.click();

        utils.waitUntilIsDisplayed(dynamicControlsPage.message);
        Assert.assertTrue(dynamicControlsPage.message.getText().contains("It's gone"));

        dynamicControlsPage.addCheckBoxButton.click();
        utils.waitUntilIsDisplayed(dynamicControlsPage.removeCheckboxButton);
        Assert.assertTrue(dynamicControlsPage.removeCheckboxButton.isDisplayed());

    }

    @Test
    public void TC02_VerifyingTextBoxActions(){
       Assert.assertFalse(dynamicControlsPage.dynamic_textBox.isEnabled());

       dynamicControlsPage.enableTextBoxButton.click();

       utils.waitUntilIsDisplayed(dynamicControlsPage.message);
        Assert.assertTrue(dynamicControlsPage.dynamic_textBox.isEnabled());

        dynamicControlsPage.disableTextBoxButton.click();
        utils.waitUntilIsDisplayed(dynamicControlsPage.enableTextBoxButton);

        Assert.assertFalse(dynamicControlsPage.dynamic_textBox.isEnabled());

    }

    @Test
    public void TC03_VerifyingTheBug(){
        dynamicControlsPage.removeCheckboxButton.click();
        dynamicControlsPage.enableTextBoxButton.click();

        utils.waitUntilIsDisplayed(dynamicControlsPage.addCheckBoxButton);

        dynamicControlsPage.disableTextBoxButton.click();
        utils.waitUntilIsDisplayed(dynamicControlsPage.enableTextBoxButton);
        dynamicControlsPage.enableTextBoxButton.click();
        utils.waitUntilIsDisplayed(dynamicControlsPage.disableTextBoxButton);

        utils.takeScreenshot("Screenshots", "DynamicControlTest_TC03.png");
    }
}
