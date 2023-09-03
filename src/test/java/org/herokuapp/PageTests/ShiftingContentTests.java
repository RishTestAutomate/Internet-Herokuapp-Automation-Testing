package org.herokuapp.PageTests;

import Utilities.Utils;
import org.herokuapp.Pages.ShiftingContentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShiftingContentTests {
    WebDriver driver;

    Utils utils;

    ShiftingContentPage shiftingContentPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        shiftingContentPage = new ShiftingContentPage(driver);
        utils = new Utils(driver);
        shiftingContentPage.visitShiftingContent();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TC01_TestingMenuElement_VerifyingTheShiftingElement(){
        shiftingContentPage.menuElementLink.click();
        utils.wait(1000);
        int homeInitialXLocation = shiftingContentPage.menuItems.get(0).getLocation().getX();
        int aboutInitialXLocation = shiftingContentPage.menuItems.get(1).getLocation().getX();
        int contactInitialXLocation = shiftingContentPage.menuItems.get(2).getLocation().getX();
        int portfolioInitialXLocation = shiftingContentPage.menuItems.get(3).getLocation().getX();
        int galleryInitialXLocation = shiftingContentPage.menuItems.get(4).getLocation().getX();

        driver.navigate().refresh();
        utils.wait(1000);
        int homeAfterShiftXLocation = shiftingContentPage.menuItems.get(0).getLocation().getX();
        int aboutAfterShiftXLocation = shiftingContentPage.menuItems.get(1).getLocation().getX();
        int contactAfterShiftXLocation = shiftingContentPage.menuItems.get(2).getLocation().getX();
        int portfolioAfterShiftXLocation = shiftingContentPage.menuItems.get(3).getLocation().getX();
        int galleryAfterShiftXLocation = shiftingContentPage.menuItems.get(4).getLocation().getX();

        Assert.assertEquals(homeInitialXLocation, homeAfterShiftXLocation);
        Assert.assertEquals(aboutAfterShiftXLocation, aboutInitialXLocation);
        Assert.assertEquals(contactAfterShiftXLocation, contactInitialXLocation);
        Assert.assertEquals(portfolioAfterShiftXLocation, portfolioInitialXLocation);
        Assert.assertNotEquals(galleryAfterShiftXLocation, galleryInitialXLocation);
    }

    @Test
    public void TC02_TestingMenuElement_VerifyingRandomShift(){
        shiftingContentPage.menuElementLink.click();
        utils.wait(1000);
        shiftingContentPage.randomModeClick.click();
        int count = 0 ;
        for(int i = 0 ; i < 5 ; i++) {
            int galleryInitialXLocation = shiftingContentPage.menuItems.get(4).getLocation().getX();
            driver.navigate().refresh();
            utils.wait(1000);
            int galleryAfterShiftXLocation = shiftingContentPage.menuItems.get(4).getLocation().getX();
            if(galleryInitialXLocation != galleryAfterShiftXLocation)
                count++;
        }
        System.out.printf("In 5 Iterations, Gallery Menu shifted %d times", count);
    }
    @Test
    public void TC03_TestingMenuElement_VerifyingShiftByPixel(){
        shiftingContentPage.menuElementLink.click();
        utils.wait(1000);
        shiftingContentPage.pixelShiftClick.click();
        int galleryInitialXLocation = shiftingContentPage.menuItems.get(4).getLocation().getX();
        driver.navigate().refresh();
        utils.wait(1000);
        int galleryAfterShiftXLocation = shiftingContentPage.menuItems.get(4).getLocation().getX();

        Assert.assertEquals(galleryAfterShiftXLocation - 100 , galleryInitialXLocation , "Gallery is not shifted by 100 pixel.");
    }

    @Test
    public void TC04_TestingMenuElement_VerifyingRandomPixelShift(){
        shiftingContentPage.menuElementLink.click();
        utils.wait(1000);
        shiftingContentPage.bothShiftClick.click();
        int count = 0 ;
        for(int i = 0 ; i < 5 ; i++) {
            int galleryInitialXLocation = shiftingContentPage.menuItems.get(4).getLocation().getX();
            driver.navigate().refresh();
            utils.wait(1000);
            int galleryAfterShiftXLocation = shiftingContentPage.menuItems.get(4).getLocation().getX();
            if(galleryInitialXLocation != galleryAfterShiftXLocation)
                count++;
        }
        System.out.printf("In 5 Iterations, Gallery Menu shifted %d times", count);
    }

    @Test
    public void TC05_TestingImageElement_VerifyingImageShift() {
        shiftingContentPage.imageElementLink.click();
        utils.wait(1000);
        shiftingContentPage.randomModeClick.click();
        int imageInitialXLocation = shiftingContentPage.image.getLocation().getX();
        driver.navigate().refresh();
        utils.wait(2000);
        int imageAfterShiftXLocation = shiftingContentPage.image.getLocation().getX();

        Assert.assertNotEquals(imageAfterShiftXLocation, imageInitialXLocation, "Image did not shift.");
    }
    @Test
    public void TC06_TestingImageElement_VerifyingRandomShift(){
        shiftingContentPage.imageElementLink.click();
        utils.wait(1000);
        shiftingContentPage.randomModeClick.click();
        int count = 0 ;
        for(int i = 0 ; i < 5 ; i++) {
            int imageInitialXLocation = shiftingContentPage.image.getLocation().getX();
            driver.navigate().refresh();
            utils.wait(1000);
            int imageAfterShiftXLocation = shiftingContentPage.image.getLocation().getX();
            if(imageInitialXLocation == imageAfterShiftXLocation - 100)
                count++;
        }
        System.out.printf("In 5 Iterations, Image shifted %d times", count);
    }
    @Test
    public void TC07_TestingImageElement_VerifyingShiftByPixel() {
        shiftingContentPage.imageElementLink.click();
        utils.wait(1000);
        shiftingContentPage.pixelShiftClick.click();
        int imageInitialXLocation = shiftingContentPage.image.getLocation().getX();
        driver.navigate().refresh();
        utils.wait(1000);
        int imageAfterShiftXLocation = shiftingContentPage.image.getLocation().getX();

        Assert.assertEquals(imageAfterShiftXLocation - 100 , imageInitialXLocation ,
                "Image is not shifted by 100 pixel.");
    }

    @Test
    public void TC08_TestingImageElement_VerifyingRandomPixelShift(){
        shiftingContentPage.imageElementLink.click();
        utils.wait(1000);
        shiftingContentPage.bothShiftClick.click();
        int count = 0 ;
        for(int i = 0 ; i < 5 ; i++) {
            int imageInitialXLocation = shiftingContentPage.image.getLocation().getX();
            driver.navigate().refresh();
            utils.wait(1000);
            int imageAfterShiftXLocation = shiftingContentPage.image.getLocation().getX();
            if(imageInitialXLocation == imageAfterShiftXLocation - 100)
                count++;
        }
        System.out.printf("In 5 Iterations, Image shifted %d times", count);
    }

    @Test
    public void TC09_TestingImageElement_VerifyingImageChangeShift(){
        shiftingContentPage.imageElementLink.click();
        utils.wait(1000);
        String expectedImgSrc = shiftingContentPage.image.getAttribute("src");
        shiftingContentPage.imageChangeClick.click();
        utils.wait(500);
        String actualImgSrc = shiftingContentPage.image.getAttribute("src");

        Assert.assertNotEquals(actualImgSrc, expectedImgSrc, "Image is not changed.");
        int imageInitialXLocation = shiftingContentPage.image.getLocation().getX();

        driver.navigate().refresh();
        int imageAfterShiftXLocation = shiftingContentPage.image.getLocation().getX();

        Assert.assertNotEquals(imageAfterShiftXLocation, imageInitialXLocation, "Image did not shift.");
    }

    @Test
    public void TC10_TestingListElement(){
        shiftingContentPage.listElementLink.click();
        utils.wait(1000);
        for(int i = 0 ; i < 5 ; i++){
            String expectedText = shiftingContentPage.listElementDiv.getText();

            driver.navigate().refresh();

            String actualText = shiftingContentPage.listElementDiv.getText();

            Assert.assertNotEquals(actualText, expectedText, "Text did not change.");
        }
    }

}
