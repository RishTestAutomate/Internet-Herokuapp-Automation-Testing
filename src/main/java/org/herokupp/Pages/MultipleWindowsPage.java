package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindowsPage extends BasePage{

    @FindBy(linkText = "Click Here")
    public WebElement nextWindowButton;

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }
}
