package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfiniteScrollPage extends BasePage{

    @FindBy(tagName = "h3")
    public WebElement infiniteScrollText;


    public InfiniteScrollPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
