package org.herokuapp.PageTests;


import Utilities.Utils;
import org.herokuapp.Pages.ChallengingDomPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChallengingDomTests {

    WebDriver driver;
    ChallengingDomPage challengingDomPage;

    Utils utils;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        challengingDomPage = new ChallengingDomPage(driver);
        challengingDomPage.visitChallengingDom();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void TC01_VerifyingTheUserIsOnChallengingDomPage(){
        Assert.assertTrue(challengingDomPage.challengingDomTextElement.getText().contains("Challenging"));
    }
    @Test
    public void TC02_VerifyingAllTheButtonsAreGettingClicked(){

        String redButtonTextBefore = challengingDomPage.redButton.getText();
        utils.highlight_and_click(challengingDomPage.redButton);
        utils.wait(1000);
        String redButtonTextAfter = challengingDomPage.redButton.getText();
        Assert.assertNotEquals(redButtonTextBefore, redButtonTextAfter, "BUG : Some issue with Red button.");

        String greenButtonTextBefore = challengingDomPage.greenButton.getText();
        utils.highlight_and_click(challengingDomPage.greenButton);
        utils.wait(1000);
        String greenButtonTextAfter = challengingDomPage.greenButton.getText();
        Assert.assertNotEquals(greenButtonTextBefore, greenButtonTextAfter, "BUG : Some issue with Green button.");

        String blueButtonTextBefore = challengingDomPage.blueButton.getText();
        utils.highlight_and_click(challengingDomPage.blueButton);
        utils.wait(1000);
        String blueButtonTextAfter = challengingDomPage.blueButton.getText();
        Assert.assertNotEquals(blueButtonTextBefore, blueButtonTextAfter, "BUG : Some issue with Blue button.");



    }
}
