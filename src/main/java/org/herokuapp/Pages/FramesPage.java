package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage{

    @FindBy(xpath = "//a[text()='Nested Frames']")
    public WebElement nestedFramesButton;
    @FindBy(css = "frame[name='frame-top']")
    public WebElement nested_frameTop;

    @FindBy(xpath = "//a[text()='iFrame']")
    public WebElement iFramesButton;

    @FindBy(css = "frame[name='frame-left']")
    public WebElement nested_frameLeft;
    @FindBy(css = "frame[name='frame-middle']")
    public WebElement nested_frameMiddle;
    @FindBy(css = "frame[name='frame-right']")
    public WebElement nested_frameRight;
    @FindBy(css = "frame[name='frame-bottom']")
    public WebElement nested_frameBottom;
    @FindBy(xpath = "//body[contains(text(),'LEFT')]")
    public WebElement nested_frameLeftText;

    @FindBy(xpath = "//body[contains(text(),'RIGHT')]")
    public WebElement nested_frameRightText;
    @FindBy(xpath = "//body[contains(text(),'BOTTOM')]")
    public WebElement nested_frameBottomText;
    @FindBy(id = "content")
    public WebElement nested_frameMiddleText;

    @FindBy(id = "mce_0_ifr")
    public WebElement iFrame_iFrameArea;
    @FindBy(xpath = "//p[contains(text(),'Your content')]")
    public WebElement iFrame_ContentText;
    @FindBy(tagName = "h3")
    public WebElement headerText;


    public FramesPage(WebDriver driver) {
        super(driver);
    }
}
