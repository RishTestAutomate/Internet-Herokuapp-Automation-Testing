package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExitIntentPage extends BasePage{

    @FindBy(id = "ouibounce-modal")
    public WebElement adPopupDiv;
    @FindBy(tagName = "h3")
    public WebElement exitIntentText;

    @FindBy(xpath = "//p[text()='Close']")
    public WebElement closeAdButton;
    public ExitIntentPage(WebDriver driver) {
        super(driver);
    }
}
