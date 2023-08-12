package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisappearingElementsPage extends BasePage{

    @FindBy(linkText = "Gallery")
    public WebElement gallery;
    public DisappearingElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

}
