package org.herokupp.PageTests;

import org.herokupp.Pages.FormAuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FormAuthenticationTests{
    WebDriver driver;
    FormAuthenticationPage formAuthenticationPage;

    WebElement username , password , login , errorMessage , logout ;

    String user , pass ;
    @BeforeMethod
    public void setUpMethod(){
        driver = new ChromeDriver();
        formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.visitFormAuthentication();
        username = formAuthenticationPage.usernameTextBox;
        password = formAuthenticationPage.passwordTextBox;
        login = formAuthenticationPage.loginButton;
        errorMessage = formAuthenticationPage.errorMessage;
        logout = formAuthenticationPage.logoutButton;
        user = "tomsmith";
        pass = "SuperSecretPassword!";
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void TC01_VerifyLoginFailureForEmptyUsername(){
        username.sendKeys("");
        password.sendKeys("xyz");
        login.click();

        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void TC02_VerifyLoginFailureForEmptyPassword(){
        username.sendKeys("test");
        password.sendKeys("");
        login.click();

        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void TC03_VerifyLoginFailureForIncorrectUsername(){
        username.sendKeys(user+"test");
        password.sendKeys(pass);
        login.click();

        Assert.assertTrue(errorMessage.getText().contains("username"));
    }

    @Test
    public void TC04_VerifyLoginFailureForIncorrectPassword(){
        username.sendKeys(user);
        password.sendKeys(pass+"test");
        login.click();

        Assert.assertTrue(errorMessage.getText().contains("password"));
    }

    @Test
    public void TC05_VerifyingValidUserHasAccess(){
        username.sendKeys(user);
        password.sendKeys(pass);

        login.click();

        Assert.assertTrue(errorMessage.getText().contains("logged in"));
    }

    @Test
    public void TC06_VerifyingNavigateBackIsNotAllowedAfterImmediateLogin(){
        username.sendKeys(user);
        password.sendKeys(pass);

        login.click();

        driver.navigate().back();

        Assert.assertFalse(username.isDisplayed(), "BUG : Navigation is not disabled after immediate login.");

    }
    @Test
    public void TC07_VerifyingLogout(){
        username.sendKeys(user);
        password.sendKeys(pass);

        login.click();

        logout.click();

        Assert.assertTrue(username.isDisplayed(), "BUG : Logout is not working.");

    }

    @Test
    public void TC08_VerifyingAfterLogoutNavigationDoesNotLogsIn(){
        username.sendKeys(user);
        password.sendKeys(pass);

        login.click();

        logout.click();
        driver.navigate().back();

        Assert.assertFalse(errorMessage.getText().contains("logged in"), "BUG : After logout, navigating back logs you into the app.");

    }


}
