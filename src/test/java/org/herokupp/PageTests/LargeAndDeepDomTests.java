package org.herokupp.PageTests;

import org.herokupp.Pages.LargeAndDeepDomPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LargeAndDeepDomTests {
    WebDriver driver;

    LargeAndDeepDomPage largeAndDeepDomPage;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        largeAndDeepDomPage = new LargeAndDeepDomPage(driver);
        largeAndDeepDomPage.visitLargeDeepDom();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingXPathsInDom(){
        for(WebElement sibling : largeAndDeepDomPage.allSiblings){
            System.out.println(sibling.getText());
        }

    }

    @Test
    public void TC02_VerifyingAllTableData(){
        WebElement tableBody = largeAndDeepDomPage.largeTable.findElement(By.tagName("tbody"));
        List<WebElement> allRows = tableBody.findElements(By.tagName("tr"));

        for(int i = 1 ; i <= allRows.size() ; i++){
            List<WebElement> allCols = allRows.get(i-1).findElements(By.tagName("td"));
            for (int j = 1 ; j <= allCols.size() ; j++){
                String number = i + "."+ j ;
                Assert.assertEquals(allCols.get(j-1).getText(), number);
            }
        }
    }
}
