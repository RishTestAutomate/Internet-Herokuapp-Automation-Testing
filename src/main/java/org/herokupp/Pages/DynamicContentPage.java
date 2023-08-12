package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DynamicContentPage extends BasePage{

    @FindAll ({@FindBy(xpath = "//div[@class='large-2 columns']/img")})
    public List<WebElement> dynamicImages;
    @FindAll ({@FindBy(xpath = "//div[@class='large-10 columns']")})
    public List<WebElement> dynamicTextBlocks;

    @FindBy(xpath = "//a[text()='click here']")
    public WebElement clickMe;


    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }
}
