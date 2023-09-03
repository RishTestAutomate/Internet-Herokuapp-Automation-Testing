package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryAdPage extends BasePage{

    @FindBy(id = "restart-ad")
    public WebElement restartAdButton;
    @FindBy(id = "modal")
    public WebElement adPopupDiv;

    @FindBy(xpath = "//p[text()='Close']")
    public WebElement closeAdButton;


    public EntryAdPage(WebDriver driver) {
        super(driver);
    }
}
