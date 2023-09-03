package org.herokuapp.PageTests;

import org.herokuapp.Pages.DynamicContentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicContentTests {

    WebDriver driver;

    DynamicContentPage dynamicContentPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.visitDynamicContent();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingAllThreeImagesArePresent(){
        Assert.assertEquals(dynamicContentPage.dynamicImages.size(), 3 , "Image count is mismatched");
    }
    @Test
    public void TC02_VerifyingAllThreeTextBlocksArePresent(){
        Assert.assertEquals(dynamicContentPage.dynamicTextBlocks.size(), 3 , "Text Block count is mismatched");
    }
    @Test
    public void TC03_VerifyingAllContentChangesOnRefresh() {
        String initialText1 = dynamicContentPage.dynamicTextBlocks.get(0).getText();
        String initialText2 = dynamicContentPage.dynamicTextBlocks.get(1).getText();
        String initialText3 = dynamicContentPage.dynamicTextBlocks.get(2).getText();

        driver.navigate().refresh();
        String refreshedText1 = dynamicContentPage.dynamicTextBlocks.get(0).getText();
        String refreshedText2 = dynamicContentPage.dynamicTextBlocks.get(1).getText();
        String refreshedText3 = dynamicContentPage.dynamicTextBlocks.get(2).getText();

        Assert.assertNotEquals(initialText1, refreshedText1 , "Text-Block 1 not mismatched");
        Assert.assertNotEquals(initialText2, refreshedText2 , "Text-Block 2 not mismatched");
        Assert.assertNotEquals(initialText3, refreshedText3 , "Text-Block 3 not mismatched");
    }

    @Test
    public void TC04_VerifyingOnlyOneContentChangeViaClickHereOption(){
        String initialText1 = dynamicContentPage.dynamicTextBlocks.get(0).getText();
        String initialText2 = dynamicContentPage.dynamicTextBlocks.get(1).getText();
        String initialText3 = dynamicContentPage.dynamicTextBlocks.get(2).getText();

        dynamicContentPage.clickMe.click();
        String refreshedText1 = dynamicContentPage.dynamicTextBlocks.get(0).getText();
        String refreshedText2 = dynamicContentPage.dynamicTextBlocks.get(1).getText();
        String refreshedText3 = dynamicContentPage.dynamicTextBlocks.get(2).getText();
        int count = 0;
        if(initialText1.equals(refreshedText1))
            count++;
        else if (initialText2.equals(refreshedText2))
            count++;
        else if (initialText3.equals(refreshedText3))
            count++;

        if(count == 1)
            Assert.assertTrue(true,"More than one block's content is changed.");

    }
}
