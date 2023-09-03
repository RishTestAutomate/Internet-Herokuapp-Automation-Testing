package org.herokuapp.PageTests;

import Utilities.Utils;
import org.herokuapp.Pages.FileUploadPage;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTests {
    WebDriver driver;

    FileUploadPage fileUploadPage;
    Utils utils;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.visitFileUpload();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingTheUploadProcess(){
        String cwd = System.getProperty("user.dir");
        fileUploadPage.chooseFile.sendKeys(cwd+"/src/main/resources/Test.txt");
        fileUploadPage.uploadButton.click();
        utils.waitUntilIsDisplayed(fileUploadPage.uploadedFiles);
        Assert.assertTrue(fileUploadPage.uploadedFiles.getText().contains("Test.txt"));
    }

    @Test
    public void TC02_VerifyingMultipleFileUploadProcess(){
        String cwd = System.getProperty("user.dir");
        String multipleFilePaths = cwd + "/src/main/resources/Test.txt"
                + "\n" + cwd + "/src/main/resources/Test1.txt"
                + "\n" + cwd + "/src/main/resources/Test2.txt";
        try{
            fileUploadPage.chooseFile.sendKeys(multipleFilePaths);
            fileUploadPage.uploadButton.click();
            utils.waitUntilIsDisplayed(fileUploadPage.uploadedFiles);
            Assert.assertTrue(fileUploadPage.uploadedFiles.getText().contains("Test.txt"));
        }
        catch (InvalidArgumentException e){
            System.out.println("Multiple file upload is not supported.");
        }
    }
    @Test
    public void TC03_VerifyingUploadProcessViaDragAndDrop(){
        /*Not yet tested*/
    }
}
