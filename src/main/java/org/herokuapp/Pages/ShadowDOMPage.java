package org.herokuapp.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShadowDOMPage extends BasePage{

    @FindBy(xpath = "//*[contains(text(),'In a list')]")
    public WebElement shadowText;

    @FindAll({
            @FindBy(tagName = "my-paragraph")})
    public List<WebElement> shadowHosts;



    public ShadowDOMPage(WebDriver driver) {
        super(driver);


    }
    public WebElement getShadowElement1(){
            SearchContext searchArea =  shadowHosts.get(0).getShadowRoot();
            return searchArea.findElement(By.cssSelector("p"));
    }
    public WebElement getShadowElement2(){
        SearchContext searchArea =  shadowHosts.get(1).getShadowRoot();
        return searchArea.findElement(By.cssSelector("p"));
    }

}
