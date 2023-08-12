package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage{

    @FindBy(tagName = "h3")
    public WebElement contextMenuTextElement;

    @FindBy(id = "hot-spot")
    public WebElement contextElement;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }
}
