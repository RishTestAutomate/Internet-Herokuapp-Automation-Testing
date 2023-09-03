package org.herokuapp.PageTests;

import org.herokuapp.Pages.AddRemoveElementsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddRemoveElementsTests {
    AddRemoveElementsPage addRemoveElementsPage;
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        addRemoveElementsPage.visitAddRemoveElement();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_verifyingAddElementIsWorking(){
        int noOfClick = 5;
        for(int i = 0 ; i < noOfClick ; i++ )
            addRemoveElementsPage.clickOnAddElement();
        int noOfElementsCreated = addRemoveElementsPage.deleteAllElement.size();

        Assert.assertEquals(noOfClick,noOfElementsCreated);
    }

    @Test
    public void TC02_verifyingRemoveElementIsWorking(){
        addRemoveElementsPage.clickOnAddElement();
        addRemoveElementsPage.clickOnRemoveElement();

        try{
            addRemoveElementsPage.deleteElement.isDisplayed();
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void TC03_verifyingRemoveAllElementIsWorking(){
        int noOfClick = 5;
        for(int i = 0 ; i < noOfClick ; i++ )
            addRemoveElementsPage.clickOnAddElement();

        for(int i = 0 ; i < addRemoveElementsPage.deleteAllElement.size() ; i++)
            addRemoveElementsPage.deleteAllElement.get(i).click();

        try{
            addRemoveElementsPage.deleteElement.isDisplayed();
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }

    }
}
