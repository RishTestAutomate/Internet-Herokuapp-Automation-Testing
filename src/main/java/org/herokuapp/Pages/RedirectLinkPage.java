package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RedirectLinkPage extends BasePage{

    @FindBy(id = "redirect")
    public WebElement redirectLink;

    @FindBy(linkText = "200")
    public WebElement status_200;
    @FindBy(linkText = "301")
    public WebElement status_301;

    @FindBy(linkText = "500")
    public WebElement status_500;

    @FindBy(linkText = "404")
    public WebElement status_404;
    @FindBy(linkText = "here")
    public WebElement redirectToStatusCode;


    public RedirectLinkPage(WebDriver driver) {
        super(driver);
    }
}
