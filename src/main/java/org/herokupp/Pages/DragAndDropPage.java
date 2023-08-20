package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage{
    @FindBy(id = "column-a")
    public WebElement sourceElement;

    @FindBy(id = "column-b")
    public WebElement destElement;

    @FindBy(css = "div#column-a header")
    public WebElement srcHeader;

    @FindBy(css = "div#column-b header")
    public WebElement destHeader;


    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

}
