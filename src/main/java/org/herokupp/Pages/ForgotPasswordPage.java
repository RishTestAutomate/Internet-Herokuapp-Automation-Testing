package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage{

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "form_submit")
    public WebElement retrievePassword;
    @FindBy(tagName = "h1")
    public WebElement header1;


    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
