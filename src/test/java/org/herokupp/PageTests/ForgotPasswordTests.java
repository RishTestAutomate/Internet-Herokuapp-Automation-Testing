package org.herokupp.PageTests;

import org.herokupp.Pages.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTests extends BaseTests{

    ForgotPasswordPage forgotPasswordPage;
    @BeforeMethod
    public void setUpMethod(){
        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.visitForgotPassword();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void TC01_VerifyRetrievePassword(){
        forgotPasswordPage.emailTextBox.sendKeys("Test@gmail.com");
        forgotPasswordPage.retrievePassword.click();

        utils.wait(1000);
        Assert.assertTrue(forgotPasswordPage.header1.getText().contains("Internal Server Error"));
    }
}
