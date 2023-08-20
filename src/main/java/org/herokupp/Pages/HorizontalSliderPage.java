package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends BasePage{

    @FindBy(css = "input[type='range']")
    public WebElement slider;
    @FindBy(id = "range")
    public WebElement rangeText;

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }
}
