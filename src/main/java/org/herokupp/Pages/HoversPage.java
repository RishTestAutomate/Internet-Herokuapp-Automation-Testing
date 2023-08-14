package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage extends BasePage{

    @FindBy(xpath = "//div[@class='example']/div[1]")
    public WebElement image1;
    @FindBy(xpath = "//div[@class='example']/div[2]")
    public WebElement image2;
    @FindBy(xpath = "//div[@class='example']/div[3]")
    public WebElement image3;

    @FindBy(xpath = "//div[@class='example']/div[1]//h5")
    public WebElement user1Text;
    @FindBy(xpath = "//div[@class='example']/div[2]//h5")
    public WebElement user2Text;
    @FindBy(xpath = "//div[@class='example']/div[3]//h5")
    public WebElement user3Text;
    @FindBy(xpath = "//div[@class='example']/div[1]//a")
    public WebElement viewProfile1;
    @FindBy(xpath = "//div[@class='example']/div[2]//a")
    public WebElement viewProfile2;
    @FindBy(xpath = "//div[@class='example']/div[3]//a")
    public WebElement viewProfile3;


    public HoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
