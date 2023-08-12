package org.herokupp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(xpath = "//a[text()='Add/Remove Elements']")
    public WebElement addRemoveElement;

    @FindBy(xpath = "//a[text()='Broken Images']")
    public WebElement brokenImage;

    @FindBy(xpath = "//a[text()='Challenging DOM']")
    public WebElement challengingDom;

    @FindBy(xpath = "//a[text()='Checkboxes']")
    public WebElement checkboxes;

    @FindBy(xpath = "//a[text()='Context Menu']")
    public WebElement contextMenu;

    @FindBy(xpath = "//a[text()='Digest Authentication']")
    public WebElement digestAuthentication;

    @FindBy(xpath = "//a[text()='Disappearing Elements']")
    public WebElement disappearingElements;


    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void visitAddRemoveElement(){
        addRemoveElement.click();
    }

    public void visitBrokenImage(){
        brokenImage.click();
    }

    public void visitChallengingDom(){
        challengingDom.click();
    }

    public void visitCheckboxes(){
        checkboxes.click();
    }

    public void visitContextMenu(){
        contextMenu.click();
    }

    public void visitDigestAuthentication(){
        digestAuthentication.click();
    }

    public void visitDisappearingElements(){
        disappearingElements.click();
    }
}
