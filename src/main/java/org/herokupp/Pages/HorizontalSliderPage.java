package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage extends BasePage{

    @FindBy(css = "input[type='range']")
    public WebElement slider;
    @FindBy(id = "range")
    public WebElement rangeText;

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
