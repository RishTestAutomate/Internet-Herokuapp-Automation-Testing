package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends BasePage{

    @FindBy(css = "div#checkbox > input")
    public WebElement dynamic_checkbox;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeCheckboxButton;

    @FindBy(xpath = "//button[text()='Enable']")
    public WebElement enableTextBoxButton;
    @FindBy(xpath = "//button[text()='Disable']")
    public WebElement disableTextBoxButton;
    @FindBy(xpath = "//button[text()='Add']")
    public WebElement addCheckBoxButton;
    @FindBy(css = "form#input-example > input")
    public WebElement dynamic_textBox;

    @FindBy(id = "message")
    public WebElement message;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
