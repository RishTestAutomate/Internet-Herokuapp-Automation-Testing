package org.herokupp.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;
    private JavascriptExecutor jse;

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


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jse = (JavascriptExecutor) driver;
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
}
