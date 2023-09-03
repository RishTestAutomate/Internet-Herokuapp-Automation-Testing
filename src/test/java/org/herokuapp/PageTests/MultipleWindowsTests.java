package org.herokuapp.PageTests;

import org.herokuapp.Pages.MultipleWindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleWindowsTests {
    WebDriver driver;

    MultipleWindowsPage multipleWindowsPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        multipleWindowsPage = new MultipleWindowsPage(driver);
        multipleWindowsPage.visitMultipleWindows();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingAllWindowsUsingSet(){
        String parentWindow = driver.getWindowHandle();
        multipleWindowsPage.nextWindowButton.click();
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if(window.equals(parentWindow)){
                driver.switchTo().window(window);
                String currentWindow = driver.getWindowHandle();
                Assert.assertEquals(parentWindow, currentWindow);
            }
            else{
                driver.switchTo().window(window);
                String currentWindow = driver.getWindowHandle();
                Assert.assertNotEquals(parentWindow, currentWindow);
            }
        }
    }
    @Test
    public void TC01_VerifyingAllWindowsUsingList(){
        String parentWindow = driver.getWindowHandle();
        multipleWindowsPage.nextWindowButton.click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        for(String window : windows){
            if(window.equals(parentWindow)){
                driver.switchTo().window(window);
                String currentWindow = driver.getWindowHandle();
                Assert.assertEquals(parentWindow, currentWindow);
            }
            else{
                driver.switchTo().window(window);
                String currentWindow = driver.getWindowHandle();
                Assert.assertNotEquals(parentWindow, currentWindow);
            }
        }
    }
}
