package org.herokupp.PageTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.herokupp.Pages.BrokenImagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImageTests {

    WebDriver driver;
    BrokenImagePage brokenImagePage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        brokenImagePage = new BrokenImagePage(driver);
        brokenImagePage.visitBrokenImage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingCountOfBrokenImages(){
        int imageCount = brokenImagePage.images.size();
        int brokenImageCount = 0 ;
        int imageWithNoSrcCount = 0 ;
        for(WebElement image : brokenImagePage.images){
            String imageUrl = image.getAttribute("src");
            if (imageUrl != null && !imageUrl.isEmpty()) {
                Response response = RestAssured.get(imageUrl);
                int statusCode = response.getStatusCode();
                if (statusCode != 200) {
                    brokenImageCount++ ;
                }
            }
            else imageWithNoSrcCount++;
        }

        System.out.print("Number of Image on Broken Image Page : " + imageCount + "\n"
                + "Number of broken images on this page : " + brokenImageCount+ "\n"
                + "Number of images with no URL on this page : " + imageWithNoSrcCount);
    }
}
