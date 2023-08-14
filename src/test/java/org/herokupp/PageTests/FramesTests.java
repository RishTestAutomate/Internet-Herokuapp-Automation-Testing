package org.herokupp.PageTests;

import org.herokupp.Pages.FramesPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends BaseTests{

    FramesPage framesPage;
    @BeforeMethod
    public void setUpMethod(){
        framesPage = new FramesPage(driver);
        framesPage.visitFrames();
    }

    @Test
    public void TC01_VerifyNestedFrames(){

        framesPage.nestedFramesButton.click();

        driver.switchTo().frame(framesPage.nested_frameTop);

        driver.switchTo().frame(framesPage.nested_frameLeft);
        Assert.assertTrue(framesPage.nested_frameLeftText.getText().contains("LEFT"));
        Assert.assertFalse(framesPage.nested_frameLeftText.getText().contains("RIGHT"));

        driver.switchTo().parentFrame();

        driver.switchTo().frame(framesPage.nested_frameRight);
        Assert.assertTrue(framesPage.nested_frameRightText.getText().contains("RIGHT"));
        Assert.assertFalse(framesPage.nested_frameRightText.getText().contains("LEFT"));

        driver.switchTo().parentFrame();

        driver.switchTo().frame(framesPage.nested_frameMiddle);
        Assert.assertTrue(framesPage.nested_frameMiddleText.getText().contains("MIDDLE"));
        Assert.assertFalse(framesPage.nested_frameMiddleText.getText().contains("LEFT"));

        driver.switchTo().defaultContent();

        driver.switchTo().frame(framesPage.nested_frameBottom);
        Assert.assertTrue(framesPage.nested_frameBottomText.getText().contains("BOTTOM"));
        Assert.assertFalse(framesPage.nested_frameBottomText.getText().contains("LEFT"));
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
