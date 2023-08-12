package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage extends BasePage{

    @FindBy(tagName = "h3")
    public WebElement checkboxesTextElement;

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement firstCheckbox;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElement secondCheckbox;

    @FindAll({@FindBy(xpath ="//form[@id='checkboxes']/input" )})
    public List<WebElement> allCheckboxes;


    public CheckboxesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
