package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagePage extends BasePage{

    @FindAll({@FindBy(tagName = "img")})
    public List<WebElement> images;
    public BrokenImagePage(WebDriver driver) {
        super(driver);
    }
}
