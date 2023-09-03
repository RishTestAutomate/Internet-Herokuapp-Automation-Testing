package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengingDomPage extends BasePage{

    @FindBy(tagName = "h3")
    public WebElement challengingDomTextElement;

    @FindBy(css = "a.button:nth-child(1)")
    public WebElement blueButton;

    @FindBy(css = "a.button.alert")
    public WebElement redButton;

    @FindBy(css = "a.button.success")
    public WebElement greenButton;

    public ChallengingDomPage(WebDriver driver) {
        super(driver);
    }
}
