package org.herokupp.PageTests;

import org.herokupp.Pages.DropdownPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests {

    WebDriver driver;

    DropdownPage dropdownPage;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        dropdownPage = new DropdownPage(driver);
        dropdownPage.visitDropdown();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_VerifyingDropdownIsWorking(){
        Select select = new Select(dropdownPage.dropdownElement);
        select.selectByValue("1");

        Assert.assertFalse(dropdownPage.firstOption.isEnabled());
        Assert.assertTrue(dropdownPage.secondOption.isSelected());

        select.selectByValue("2");
        Assert.assertFalse(dropdownPage.firstOption.isEnabled());
        Assert.assertTrue(dropdownPage.thirdOption.isSelected());
    }
}
