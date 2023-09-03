package org.herokuapp.PageTests;

import Utilities.Utils;
import org.herokuapp.Pages.GeolocationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeolocationTests {
    WebDriver driver;
    Utils utils;
    GeolocationPage geolocationPage;
    @BeforeMethod
    public void setUpMethod(){
        driver = new ChromeDriver();
        utils = new Utils(driver);
        geolocationPage = new GeolocationPage(driver);
        geolocationPage.visitGeolocation();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyGeoLocation(){
        geolocationPage.location.click();
        utils.wait(1000);
        Assert.assertTrue(geolocationPage.latitude.isDisplayed());
        Assert.assertTrue(geolocationPage.longitude.isDisplayed());

    }

    @Test
    public void TC02_VerifyLocationOnGoogle(){
        geolocationPage.location.click();
        utils.wait(1000);
        String coordinateOnGeolocationPage = geolocationPage.latitude.getText() +","+geolocationPage.longitude.getText();
        geolocationPage.locationOnGoogleButton.click();
        utils.waitUntilIsDisplayed(geolocationPage.coordinatesOnGoogle);

        String coordinateOnGoogle = geolocationPage.coordinatesOnGoogle.getAttribute("aria-label");

        Assert.assertEquals(coordinateOnGoogle, coordinateOnGeolocationPage, "Both co-ordinates differ.");
    }
}
