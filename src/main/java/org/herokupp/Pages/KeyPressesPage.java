package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends BasePage{
    @FindBy(id = "target")
    public WebElement keyInput;

    @FindBy(id = "result")
    public WebElement keyResult;

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }
}
