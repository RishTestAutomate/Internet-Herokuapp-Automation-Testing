package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JQueryUIMenusPage extends BasePage{

    @FindBy(id = "ui-id-1")
    public WebElement disabledMenu;
    @FindBy(id = "ui-id-3")
    public WebElement enabledMenu;
    @FindBy(linkText = "Menu")
    public WebElement menuButton;
    @FindBy(id = "ui-id-4")
    public WebElement downloadsMenu;

    @FindBy(id = "ui-id-8")
    public WebElement backToJQueryButton;

    @FindBy(tagName = "h3")
    public WebElement headerText;

    @FindBy(id = "ui-id-5")
    public WebElement downloadsMenu_pdf;
    @FindBy(id = "ui-id-6")
    public WebElement downloadsMenu_csv;

    @FindBy(id = "ui-id-7")
    public WebElement downloadsMenu_excel;

    public JQueryUIMenusPage(WebDriver driver) {
        super(driver);
    }
}
