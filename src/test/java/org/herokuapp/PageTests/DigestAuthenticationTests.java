package org.herokuapp.PageTests;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.herokuapp.Pages.DigestAuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DigestAuthenticationTests {

    WebDriver driver;

    DigestAuthenticationPage digestAuthenticationPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        digestAuthenticationPage = new DigestAuthenticationPage(driver);
        digestAuthenticationPage.visitDigestAuthentication();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingValidUserHasAccess(){
        final String BASE_URL = "https://the-internet.herokuapp.com/digest_auth";
        String username = "admin";
        String password = "admin";
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured.given().auth().basic(username, password)
                .when()
                .get();
        int actualStatusCode = response.getStatusCode();

        Assert.assertEquals(actualStatusCode, 200, "Failed to access the page with valid credentials");

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Digest Auth"), "Page content verification failed");
    }

    @Test
    public void TC02_VerifyingInvalidUserHasNoAccess(){
        final String BASE_URL = "https://the-internet.herokuapp.com/digest_auth";
        String username = "admin";
        String password = "admin1";
        RestAssured.baseURI = BASE_URL;
        Response response = RestAssured.given().auth().basic(username, password)
                .when()
                .get();
        int actualStatusCode = response.getStatusCode();

        Assert.assertEquals(actualStatusCode, 401, "Access is provided with Invalid credentials");
    }
}
