package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptOnloadPage extends BasePage{

    @FindBy(tagName = "p")
    public WebElement js_error;
    public JavascriptOnloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
