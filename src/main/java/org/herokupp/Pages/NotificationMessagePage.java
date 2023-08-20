package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends BasePage{

    @FindBy(linkText = "Click here")
    public WebElement notifyButton;
    @FindBy(id = "flash")
    public WebElement notificationMsg;
    public NotificationMessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
