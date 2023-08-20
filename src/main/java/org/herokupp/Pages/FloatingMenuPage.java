package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage{

    @FindBy(linkText = "Home")
    public WebElement home;
    @FindBy(linkText = "News")
    public WebElement news;
    @FindBy(linkText = "Contact")
    public WebElement contact;
    @FindBy(linkText = "About")
    public WebElement about;


    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }
}
