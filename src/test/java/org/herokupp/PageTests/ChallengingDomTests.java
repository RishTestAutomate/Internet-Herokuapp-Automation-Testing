package org.herokupp.PageTests;


import Utilities.Utils;
import org.herokupp.Pages.ChallengingDomPage;
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
        String redButtonTextAfter = challengingDomPage.redButton.getText();

        String greenButtonTextBefore = challengingDomPage.greenButton.getText();
        utils.highlight_and_click(challengingDomPage.greenButton);
        String greenButtonTextAfter = challengingDomPage.greenButton.getText();

        String blueButtonTextBefore = challengingDomPage.blueButton.getText();
        utils.highlight_and_click(challengingDomPage.blueButton);
        String blueButtonTextAfter = challengingDomPage.blueButton.getText();

        Assert.assertNotEquals(redButtonTextBefore, redButtonTextAfter);
        Assert.assertNotEquals(greenButtonTextBefore, greenButtonTextAfter);
        Assert.assertNotEquals(blueButtonTextBefore, blueButtonTextAfter);



    }
}
