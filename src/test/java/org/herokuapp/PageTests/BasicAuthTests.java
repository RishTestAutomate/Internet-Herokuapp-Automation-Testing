package org.herokuapp.PageTests;

import org.herokuapp.Pages.BasicAuthPage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuthTests {

    WebDriver driver;
    BasicAuthPage basicAuthPage;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        basicAuthPage = new BasicAuthPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void TC01_VerifyingValidUserCanLogin(){
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth/");
        Assert.assertTrue(basicAuthPage.successMsgElement.isDisplayed());
    }

    @Test
    public void TC02_VerifyingInvalidUserCannotLogin(){
        driver.get("http://admin:adm@the-internet.herokuapp.com/basic_auth/");
        try{
            basicAuthPage.successMsgElement.isDisplayed();
        }
        catch (NoSuchElementException e){Assert.assertTrue(true);};
    }


}
