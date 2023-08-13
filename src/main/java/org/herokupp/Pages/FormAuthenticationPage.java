package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage extends BasePage{

    @FindBy(id = "username")
    public WebElement usernameTextBox;

    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(id = "flash")
    public WebElement errorMessage;

    @FindBy(css = "a[href='/logout']")
    public WebElement logoutButton;
    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
