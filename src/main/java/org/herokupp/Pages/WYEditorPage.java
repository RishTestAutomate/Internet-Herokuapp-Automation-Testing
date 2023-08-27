package org.herokupp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WYEditorPage extends BasePage{

    @FindBy(xpath = "//div[text()='New document']")
    public WebElement newDocumentButton;

    @FindBy(xpath = "//span[text()='File']")
    public WebElement fileButton;
    @FindBy(xpath = "//span[text()='Format']")
    public WebElement formatButton;

    @FindBy(id = "mce_0_ifr")
    public WebElement writingAreaFrame;

    @FindBy(css = "body#tinymce span")
    public WebElement writingAreaTextAfterFormat;
    @FindBy(tagName = "p")
    public WebElement writingAreaText;

    @FindBy(xpath = "//*[@title='Undo']")
    public WebElement undoButton;

    @FindBy(xpath = "//*[@title='Redo']")
    public WebElement redoButton;

    @FindBy(xpath = "//*[@title='Bold']")
    public WebElement boldButton;

    @FindBy(xpath = "//*[@title='Italic']")
    public WebElement italicButton;

    @FindBy(xpath = "//*[@title='Align left']")
    public WebElement alignLeftButton;

    @FindBy(xpath = "//*[@title='Align right']")
    public WebElement alignRightButton;

    @FindBy(xpath = "//*[@title='Align center']")
    public WebElement alignCenterButton;

    @FindBy(xpath = "//*[@title='Justify']")
    public WebElement justifyButton;

    @FindBy(xpath = "//*[@title='Decrease indent']")
    public WebElement decreaseIndentButton;

    @FindBy(xpath = "//*[@title='Increase indent']")
    public WebElement increaseIndentButton;

    @FindBy(xpath = "//*[@role='button']")
    public WebElement checkValue;

    @FindBy(xpath = "//*[text()='Headings']")
    public WebElement headingsFormatsButton;
    @FindBy(xpath = "//*[@title='Formats']")
    public WebElement formatsButton;

    @FindBy(xpath = "//*[@title='Inline']")
    public WebElement inlineFormatsButton;
    @FindBy(xpath = "//*[@title='Blocks']")
    public WebElement blocksFormatsButton;
    @FindBy(xpath = "//*[@title='Align']")
    public WebElement alignFormatsButton;

    @FindBy(xpath = "//*[@title='Text color']")
    public WebElement textColorButton;

    @FindBy(xpath = "//*[@title='Background color']")
    public WebElement backgroundColorButton;

    @FindBy(xpath = "//*[@title='Clear formatting']")
    public WebElement clearFormattingButton;
    @FindBy(xpath = "//*[@title='Font sizes']")
    public WebElement fontSizesButton;

    @FindBy(xpath = "//*[@title='Line height']")
    public WebElement lineHeightButton;
    @FindBy(xpath = "//*[@title='Fonts']")
    public WebElement fontsButton;

    @FindBy(tagName = "em")
    public WebElement italicText;
    @FindBy(tagName = "strong")
    public WebElement boldText;

    public WYEditorPage(WebDriver driver) {
        super(driver);
    }

    public void createNewFile(){
        fileButton.click();
        newDocumentButton.click();
    }

    public void clickOnElementsWithTitle(String value, WebDriver driver){
        By xpath = By.xpath("//*[@title='"+value+"']");
        driver.findElement(xpath).click();

    }

    public boolean isCheckValuePresent(String expected, WebDriver driver){
       By xpath = By.xpath("//*[@role='button' and  text()='"+expected+"']");
       try{
           return driver.findElement(xpath).isDisplayed();
       }
       catch (NoSuchElementException e){
           return false;
       }
    }

    public String getStyleAttribute(String value, WebDriver driver){
        By xpath = By.xpath("//*[@title='"+value+"']");
        return driver.findElement(xpath).getAttribute("style");
    }

}
