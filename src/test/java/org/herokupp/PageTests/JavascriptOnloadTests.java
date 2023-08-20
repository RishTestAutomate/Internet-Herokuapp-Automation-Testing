package org.herokupp.PageTests;

import org.herokupp.Pages.JavascriptOnloadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptOnloadTests {

    WebDriver driver;

    JavascriptOnloadPage javascriptOnloadPage;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        javascriptOnloadPage = new JavascriptOnloadPage(driver);
        javascriptOnloadPage.visitJavascriptOnload();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyOnLoad(){
        Assert.assertTrue(javascriptOnloadPage.js_error.getText().contains("error in the onload event"));
    }
}
