package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShiftingContentPage extends BasePage{

    @FindBy(partialLinkText = "Menu Element")
    public WebElement menuElementLink;
    @FindBy(partialLinkText = "image")
    public WebElement imageElementLink;

    @FindAll({
            @FindBy(xpath = "//li/a")}
    ) public List<WebElement> menuItems;

    @FindBy(css = "img.shift")
    public WebElement image;

    @FindBy(partialLinkText = "List")
    public WebElement listElementLink;

    @FindBy(xpath = "//code[text()='?mode=random']/following-sibling::a")
    public WebElement randomModeClick;

    @FindBy(xpath = "//code[text()='?pixel_shift=100']/following-sibling::a")
    public WebElement pixelShiftClick;
    @FindBy(xpath = "//code[contains(text(),'?mode=random&pixel')]/following-sibling::a")
    public WebElement bothShiftClick;
    @FindBy(xpath = "//code[contains(text(),'image')]/following-sibling::a")
    public WebElement imageChangeClick;

    @FindBy(css = "div.large-6")
    public WebElement listElementDiv;


    public ShiftingContentPage(WebDriver driver) {
        super(driver);
    }
}
