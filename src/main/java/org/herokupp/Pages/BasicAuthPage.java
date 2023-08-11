package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicAuthPage{

    @FindBy(tagName = "p")
    public WebElement successMsgElement;

    @FindBy(xpath = "/html/body")
    public WebElement errorMsgElement;

    public BasicAuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
