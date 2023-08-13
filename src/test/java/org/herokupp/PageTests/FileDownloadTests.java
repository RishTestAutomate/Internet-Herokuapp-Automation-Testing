package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.FileDownloadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTests {
    WebDriver driver;

    FileDownloadPage fileDownloadPage;
    Utils utils;
    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        fileDownloadPage = new FileDownloadPage(driver);
        fileDownloadPage.visitFileDownload();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingDownloads(){
        fileDownloadPage.some_file_txt.click();
        utils.wait(2000);

        Assert.assertTrue(checkFilePresence(fileDownloadPage.some_file_txt.getText()));

        fileDownloadPage.script_xml.click();
        utils.wait(2000);

        Assert.assertTrue(checkFilePresence(fileDownloadPage.script_xml.getText()));
    }

    private boolean checkFilePresence(String fileName){
        File file = new File("C:/Users/THINKPAD/Downloads/"+fileName);
        return file.exists() && file.isFile();
    }
}
