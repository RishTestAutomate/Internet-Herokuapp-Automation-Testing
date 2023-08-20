package org.herokupp.PageTests;

import Utilities.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.herokupp.Pages.SecureFileDownloadPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.KeyFactorySpi;

public class SecureFileDownloadTests {
    WebDriver driver;

    Utils utils;
    SecureFileDownloadPage secureFileDownloadPage;
    Actions actions;

    @BeforeMethod
    public void setUp(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("notifications-disable");
        driver = new ChromeDriver(co);
        secureFileDownloadPage = new SecureFileDownloadPage(driver);
        utils = new Utils(driver);
        actions = new Actions(driver);
        secureFileDownloadPage.visitSecureFileDownload();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingValidUserHasAccess(){
        final String BASE_URL = "https://the-internet.herokuapp.com/download_secure";
        String username = "admin";
        String password = "admin";
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured.given().auth().basic(username, password)
                .when()
                .get();
        int actualStatusCode = response.getStatusCode();

        Assert.assertEquals(actualStatusCode, 200, "Failed to access the page with valid credentials");

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Secure File"), "Page content verification failed");
    }

    @Test
    public void TC02_VerifyingInvalidUserHasNoAccess(){
        final String BASE_URL = "https://the-internet.herokuapp.com/download_secure";
        String username = "admin";
        String password = "admin1";
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured.given().auth().basic(username, password)
                .when()
                .get();
        int actualStatusCode = response.getStatusCode();

        Assert.assertEquals(actualStatusCode, 401, "Access is provided with Invalid credentials");
    }

    @Test
    public void TC03_VerifyAllDownload(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/download_secure");

        for (WebElement file : secureFileDownloadPage.allDownloads){
            if(!file.getText().contains(".js") && !file.getText().contains(".tmp") && !file.getText().contains(".xml")){
                utils.highlight_and_click(file);
                if(file.getText().contains(".zip") || file.getText().contains("ss.png") || file.getText().contains("IMG_9780.JPG")
                        || file.getText().contains("5mb script.xml")){
                    utils.wait(7000);
                } else if (file.getText().contains(".png")) {
                    utils.wait(2000);
                } else if (file.getText().contains(".txt")) {
                    utils.wait(1500);
                }
                else
                    utils.wait(2000);
                Assert.assertTrue(utils.checkFilePresence(file.getText()));
            }
        }


    }
}
