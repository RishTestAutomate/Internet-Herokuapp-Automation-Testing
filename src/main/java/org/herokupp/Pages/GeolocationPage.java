package org.herokupp.Pages;

import org.herokupp.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeolocationPage extends BasePage {

    @FindBy(css = "button[onClick='getLocation()']")
    public WebElement location;
    @FindBy(id = "lat-value")
    public WebElement latitude;
    @FindBy(id = "long-value")
    public WebElement longitude;

    @FindBy(linkText = "See it on Google")
    public WebElement locationOnGoogleButton;
   @FindBy(id = "searchbox")
    public WebElement coordinatesOnGoogle;


    public GeolocationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}