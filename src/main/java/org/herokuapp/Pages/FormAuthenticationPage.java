package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    }
}
