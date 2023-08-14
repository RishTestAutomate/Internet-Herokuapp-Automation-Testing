package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.ForgotPasswordPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTests{

    WebDriver driver;
    Utils utils;
    ForgotPasswordPage forgotPasswordPage;
    @BeforeMethod
    public void setUpMethod(){
        driver = new ChromeDriver();
        utils = new Utils(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.visitForgotPassword();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyRetrievePassword(){
        forgotPasswordPage.emailTextBox.sendKeys("Test@gmail.com");
        forgotPasswordPage.retrievePassword.click();

        utils.wait(1000);
        Assert.assertTrue(forgotPasswordPage.header1.getText().contains("Internal Server Error"));
    }
}
