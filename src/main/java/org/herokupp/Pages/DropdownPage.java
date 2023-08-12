package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage extends BasePage{

    @FindBy(id = "dropdown")
    public WebElement dropdownElement;

    @FindBy(css = "select#dropdown option:nth-child(1)")
    public WebElement firstOption;
    @FindBy(css = "select#dropdown option:nth-child(2)")
    public WebElement secondOption;
    @FindBy(css = "select#dropdown option:nth-child(3)")
    public WebElement thirdOption;



    public DropdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
