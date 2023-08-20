package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputsPage extends BasePage{

    @FindBy(css = "input[type='number']")
    public WebElement inputField;

    public InputsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
