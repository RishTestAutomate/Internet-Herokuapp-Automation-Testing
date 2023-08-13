package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends BasePage{

    @FindBy(partialLinkText = "Example 1")
    public WebElement example1;

    @FindBy(partialLinkText = "Example 2")
    public WebElement example2;

    @FindBy(xpath = "//button[text()='Start']")
    public WebElement startButton;
    @FindBy(id = "finish")
    public WebElement loadedMessage;

    @FindBy(tagName = "h4")
    public WebElement loadedPageContent;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
