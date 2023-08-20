package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LargeAndDeepDomPage extends BasePage{

    @FindBy(xpath = "//div[@id='siblings']//following-sibling::*")
    public List<WebElement> allSiblings;

    @FindBy(id = "large-table")
    public WebElement largeTable;

    public LargeAndDeepDomPage(WebDriver driver) {
        super(driver);
    }
}
