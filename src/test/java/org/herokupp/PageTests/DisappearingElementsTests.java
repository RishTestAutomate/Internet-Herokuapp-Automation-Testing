package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.DisappearingElementsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisappearingElementsTests {

    WebDriver driver;
    DisappearingElementsPage disappearingElementsPage;

    Utils utils;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        disappearingElementsPage = new DisappearingElementsPage(driver);
        disappearingElementsPage.visitDisappearingElements();
        utils = new Utils(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingTheNumberOfTimesElementsDisappeared(){
        int count = 0;
        int i = 0;
        do{
            try{
                disappearingElementsPage.gallery.isDisplayed();
                count++;
            }
            catch (NoSuchElementException ignored){
            }
            driver.navigate().refresh();
            i++;
            utils.wait(1000);
        }while (i < 10);

        System.out.println("The disappearing elements disappeared "+count+" times in 10 page reload.");
    }

}
