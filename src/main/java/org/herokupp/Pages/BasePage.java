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

    @FindBy(xpath = "//a[text()='Drag and Drop']")
    public WebElement dragAndDrop;

    @FindBy(xpath = "//a[text()='Dropdown']")
    public WebElement dropdown;

    @FindBy(xpath = "//a[text()='Dynamic Content']")
    public WebElement dynamicContent;

    @FindBy(xpath = "//a[text()='Dynamic Controls']")
    public WebElement dynamicControls;

    @FindBy(xpath = "//a[text()='Dynamic Loading']")
    public WebElement dynamicLoading;

    @FindBy(xpath = "//a[text()='Entry Ad']")
    public WebElement entryAd;

    @FindBy(xpath = "//a[text()='Exit Intent']")
    public WebElement exitIntent;

    @FindBy(xpath = "//a[text()='File Download']")
    public WebElement fileDownload;

    @FindBy(xpath = "//a[text()='File Upload']")
    public WebElement fileUpload;

    @FindBy(xpath = "//a[text()='Floating Menu']")
    public WebElement floatingMenu;

    @FindBy(xpath = "//a[text()='Forgot Password']")
    public WebElement forgotPassword;
    @FindBy(xpath = "//a[text()='Form Authentication']")
    public WebElement formAuthentication;


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

    public void visitDragAndDrop(){
        dragAndDrop.click();
    }

    public void visitDropdown(){
        dropdown.click();
    }

    public void visitDynamicContent(){
        dynamicContent.click();
    }

    public void visitDynamicControl(){
        dynamicControls.click();
    }

    public void visitDynamicLoading(){
        dynamicLoading.click();
    }

    public void visitEntryAd(){
        entryAd.click();
    }

    public void visitExitIntent(){
        exitIntent.click();
    }
    public void visitFileDownload(){
        fileDownload.click();
    }

    public void visitFileUpload(){
        fileUpload.click();
    }
    public void visitFloatingMenu(){
        floatingMenu.click();
    }

    public void visitForgotPassword(){
        forgotPassword.click();
    }
    public void visitFormAuthentication(){
        formAuthentication.click();
    }
}
