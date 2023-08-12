package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.CheckboxesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTests {

    WebDriver driver;
    Utils utils;
    CheckboxesPage checkboxesPage;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.visitCheckboxes();
        utils = new Utils(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingTheUserIsOnCheckboxesPage(){
        Assert.assertTrue(checkboxesPage.checkboxesTextElement.getText().contains("Checkbox"));
    }

    @Test
    public void TC02_VerifyingCheckboxSelectionIsEnabled(){
        for(WebElement checkbox : checkboxesPage.allCheckboxes){
            if(checkbox.isSelected()){
                checkbox.click();
            }
        }
        checkboxesPage.firstCheckbox.click();
        Assert.assertTrue(checkboxesPage.firstCheckbox.isSelected());
        checkboxesPage.firstCheckbox.click();
        Assert.assertFalse(checkboxesPage.firstCheckbox.isSelected());

        checkboxesPage.secondCheckbox.click();
        Assert.assertTrue(checkboxesPage.secondCheckbox.isSelected());
        checkboxesPage.secondCheckbox.click();
        Assert.assertFalse(checkboxesPage.secondCheckbox.isSelected());
    }

    @Test
    public void TC03_VerifyingMultipleSelectionIsEnabled(){
        for(WebElement checkbox : checkboxesPage.allCheckboxes){
            if(checkbox.isSelected()){
                checkbox.click();
            }
        }
        checkboxesPage.firstCheckbox.click();
        checkboxesPage.secondCheckbox.click();

        Assert.assertTrue(checkboxesPage.firstCheckbox.isSelected());
        Assert.assertTrue(checkboxesPage.secondCheckbox.isSelected());
    }
}
