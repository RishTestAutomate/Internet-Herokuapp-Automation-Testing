package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.InputsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsTests {
    WebDriver driver;

    InputsPage inputsPage;

    Utils utils;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        inputsPage = new InputsPage(driver);
        inputsPage.visitInputs();
        utils = new Utils(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void TC01_VerifyValidInput() {
        String inputValue = "123";
        inputsPage.inputField.sendKeys(inputValue);

        Assert.assertEquals( inputsPage.inputField.getAttribute("value"), inputValue);
    }

    @Test(priority = 3)
    public void TC02_VerifyNegativeInput() {
        String inputValue = "-456";
        inputsPage.inputField.sendKeys(inputValue);

        Assert.assertEquals( inputsPage.inputField.getAttribute("value"), inputValue);
    }

    @Test(priority = 2)
    public void TC03_VerifyNonNumericInput() {
        String inputValue = "abc";
        inputsPage.inputField.sendKeys(inputValue);

        Assert.assertEquals( inputsPage.inputField.getAttribute("value"), "");
    }
    @Test(priority = 4)
    public void TC04_VerifyFunctionKeysInput() {
        String inputValue = "!@#$%^&*()";
        inputsPage.inputField.sendKeys(inputValue);

        Assert.assertEquals( inputsPage.inputField.getAttribute("value"), "");
    }
    @Test(priority = 5)
    public void TC05_VerifyArrowKeysFunctionality() {
        String inputValue = "12345";
        inputsPage.inputField.sendKeys(inputValue);
        for(int i = 0 ; i < 5 ; i++)
            inputsPage.inputField.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals( inputsPage.inputField.getAttribute("value"), "12350");
        for(int i = 0 ; i < 5 ; i++)
            inputsPage.inputField.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals( inputsPage.inputField.getAttribute("value"), inputValue);
    }

}
