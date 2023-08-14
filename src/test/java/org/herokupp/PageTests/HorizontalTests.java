package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.GeolocationPage;
import org.herokupp.Pages.HorizontalSliderPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalTests {
    WebDriver driver;
    Utils utils;
    HorizontalSliderPage horizontalSliderPage;

    String min, max, step;
    @BeforeMethod
    public void setUpMethod(){
        driver = new ChromeDriver();
        utils = new Utils(driver);
        horizontalSliderPage = new HorizontalSliderPage(driver);
        horizontalSliderPage.visitHorizontalSlider();
        min = horizontalSliderPage.slider.getAttribute("min");
        max = horizontalSliderPage.slider.getAttribute("max");
        step = horizontalSliderPage.slider.getAttribute("step");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifySliderByKeysForward(){
        for(float i = getFloat(min) ; i <= getFloat(max) ; i+=getFloat(step)){
            if(i != 0.0f)
                horizontalSliderPage.slider.sendKeys(Keys.ARROW_RIGHT);
            Assert.assertEquals(i, getFloat(horizontalSliderPage.rangeText.getText()), "Slider is not working as expected.");
        }
    }

    @Test
    public void TC02_VerifySliderByKeysBackward(){
        Actions actions = new Actions(driver);
        int xOffsetEnd = horizontalSliderPage.slider.getSize().getWidth()/2; //move to end
        actions.moveToElement(horizontalSliderPage.slider, xOffsetEnd,0).click().perform();
        for(float j = getFloat(max) ; j>= getFloat(min) ; j-=getFloat(step)){
            if(j != 5.0f)
                horizontalSliderPage.slider.sendKeys(Keys.ARROW_LEFT);
            Assert.assertEquals(j, getFloat(horizontalSliderPage.rangeText.getText()), "Slider is not working as expected.");
        }
    }

    @Test
    public void TC03_VerifySliderByClick(){
        Actions actions = new Actions(driver);
        int xOffsetStart= horizontalSliderPage.slider.getSize().getWidth()/-2; //move to start
        int xOffsetEnd = horizontalSliderPage.slider.getSize().getWidth()/2; //move to end
        actions.moveToElement(horizontalSliderPage.slider).click().perform();
        System.out.println(horizontalSliderPage.rangeText.getText());
        Assert.assertNotEquals(horizontalSliderPage.rangeText.getText(),"0.0","Slider is not working as expected.");
        utils.wait(2000);
        actions.moveToElement(horizontalSliderPage.slider,xOffsetStart,0).click().perform();
        Assert.assertEquals(horizontalSliderPage.rangeText.getText(),"0","Slider is not working as expected.");
        actions.moveToElement(horizontalSliderPage.slider, xOffsetEnd,0).click().perform();
        Assert.assertEquals(horizontalSliderPage.rangeText.getText(),"5","Slider is not working as expected.");

    }

    public float getFloat(String var){
        return Float.parseFloat(var);
    }
}
