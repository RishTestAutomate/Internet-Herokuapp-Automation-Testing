package org.herokuapp.PageTests;

import org.herokuapp.Pages.FramesPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests{

    WebDriver driver;

    FramesPage framesPage;
    @BeforeMethod
    public void setUpMethod(){
        driver = new ChromeDriver();
        framesPage = new FramesPage(driver);
        framesPage.visitFrames();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void TC01_VerifyNestedFrames(){

        framesPage.nestedFramesButton.click();

        driver.switchTo().frame(framesPage.nested_frameTop);

        driver.switchTo().frame(framesPage.nested_frameLeft);
        Assert.assertTrue(framesPage.nested_frameLeftText.getText().contains("LEFT"));

        driver.switchTo().parentFrame();

        driver.switchTo().frame(framesPage.nested_frameRight);
        Assert.assertTrue(framesPage.nested_frameRightText.getText().contains("RIGHT"));

        driver.switchTo().parentFrame();

        driver.switchTo().frame(framesPage.nested_frameMiddle);
        Assert.assertTrue(framesPage.nested_frameMiddleText.getText().contains("MIDDLE"));

        driver.switchTo().defaultContent();

        driver.switchTo().frame(framesPage.nested_frameBottom);
        Assert.assertTrue(framesPage.nested_frameBottomText.getText().contains("BOTTOM"));
    }

    @Test
    public void TC02_VerifyIframes(){
        framesPage.iFramesButton.click();

        driver.switchTo().frame(framesPage.iFrame_iFrameArea);

        Assert.assertTrue(framesPage.iFrame_ContentText.getText().contains("Your content"));

        driver.switchTo().defaultContent();

        try{
            framesPage.iFrame_ContentText.getText();
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }
}
