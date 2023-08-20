package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptAlertsPage extends BasePage{

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    public WebElement js_alert;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    public WebElement js_confirm;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    public WebElement js_prompt;

    @FindBy(id = "result")
    public WebElement js_message;


    public JavascriptAlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
