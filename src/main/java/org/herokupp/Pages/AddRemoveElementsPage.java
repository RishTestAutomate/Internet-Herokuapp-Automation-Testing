package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemoveElementsPage extends BasePage{

    @FindBy(xpath = "//button[text()='Add Element']")
    public WebElement addElement;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteElement;

    @FindAll({@FindBy(xpath = "//button[@class='added-manually']")})
    public List<WebElement> deleteAllElement;


    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddElement(){
        addElement.click();
    }

    public void clickOnRemoveElement(){
        deleteElement.click();
    }
}
