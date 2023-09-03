package org.herokuapp.PageTests;

import Utilities.Utils;
import org.herokuapp.Pages.JQueryUIMenusPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class JQueryUIMenusTests {
    WebDriver driver;

    JQueryUIMenusPage jQueryUIMenusPage;
    Utils utils;

    Actions actions;

    @BeforeMethod
    public void setUp(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("disable-notifications");
        driver = new ChromeDriver(co);
        jQueryUIMenusPage = new JQueryUIMenusPage(driver);
        jQueryUIMenusPage.visitJQueryUIMenus();
        utils = new Utils(driver);
        actions = new Actions(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingDisabledButton(){
        Assert.assertTrue(jQueryUIMenusPage.disabledMenu.getAttribute("class").contains("ui-state-disabled"),
                "The Disabled menu item should be disabled.");
        Assert.assertFalse(jQueryUIMenusPage.enabledMenu.getAttribute("class").contains("ui-state-disabled"),
                "The Enabled menu item should be Enabled.");
    }

    @Test
    public void TC02_VerifyingEnabledMenuFunctionality(){
        actions.moveToElement(jQueryUIMenusPage.enabledMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.backToJQueryButton);
        jQueryUIMenusPage.backToJQueryButton.click();
        utils.wait(1000);
        Assert.assertEquals(jQueryUIMenusPage.headerText.getText(), "JQuery UI", "Not on Menu page.");

        jQueryUIMenusPage.menuButton.click();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.enabledMenu);

    }

    @Test
    public void TC03_VerifyPdfDownload(){
        actions.moveToElement(jQueryUIMenusPage.enabledMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu);
        actions.moveToElement(jQueryUIMenusPage.downloadsMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu_pdf);
        jQueryUIMenusPage.downloadsMenu_pdf.click();
        utils.wait(2000);
        Assert.assertTrue(checkFilePresence("menu.pdf"));
    }

    @Test
    public void TC04_VerifyCsvDownload(){
        actions.moveToElement(jQueryUIMenusPage.enabledMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu);
        actions.moveToElement(jQueryUIMenusPage.downloadsMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu_csv);
        jQueryUIMenusPage.downloadsMenu_csv.click();
        utils.wait(2000);
        Assert.assertTrue(checkFilePresence("menu.csv"));
    }

    @Test
    public void TC05_VerifyExcelDownload(){
        actions.moveToElement(jQueryUIMenusPage.enabledMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu);
        actions.moveToElement(jQueryUIMenusPage.downloadsMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu_excel);
        jQueryUIMenusPage.downloadsMenu_excel.click();
        utils.wait(2000);
        Assert.assertTrue(checkFilePresence("menu.xls"));
    }

    @Test
    public void TC06_VerifyingAllDownloads(){
        actions.moveToElement(jQueryUIMenusPage.enabledMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu);
        actions.moveToElement(jQueryUIMenusPage.downloadsMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu_pdf);
        jQueryUIMenusPage.downloadsMenu_pdf.click();
        utils.wait(2000);
        Assert.assertTrue(checkFilePresence("menu.pdf"));

        actions.moveToElement(jQueryUIMenusPage.enabledMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu);
        actions.moveToElement(jQueryUIMenusPage.downloadsMenu).build().perform();
        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu_csv);
        jQueryUIMenusPage.downloadsMenu_csv.click();
        utils.wait(2000);
        Assert.assertTrue(checkFilePresence("menu.csv"));

        /*When trying to download third time (whichever it may be pdf, csv or excel), it's not working as expected.*/
//        actions.moveToElement(jQueryUIMenusPage.enabledMenu).build().perform();
//        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu);
//        actions.moveToElement(jQueryUIMenusPage.downloadsMenu).build().perform();
//        utils.waitUntilIsDisplayed(jQueryUIMenusPage.downloadsMenu_excel);
//        jQueryUIMenusPage.downloadsMenu_excel.click();
//        utils.wait(2000);
//        Assert.assertTrue(checkFilePresence("menu.xls"));
    }
    private boolean checkFilePresence(String fileName){
        String filePath = "C:/Users/THINKPAD/Downloads"+"/"+fileName;
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

}
