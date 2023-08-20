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

    @FindBy(xpath = "//a[text()='Frames']")
    public WebElement frames;
    @FindBy(xpath = "//a[text()='Geolocation']")
    public WebElement geoLocation;

    @FindBy(xpath = "//a[text()='Horizontal Slider']")
    public WebElement horizontalSlider;

    @FindBy(xpath = "//a[text()='Hovers']")
    public WebElement hovers;

    @FindBy(xpath = "//a[text()='Infinite Scroll']")
    public WebElement infiniteScroll;

    @FindBy(xpath = "//a[text()='Inputs']")
    public WebElement inputs;

    @FindBy(xpath = "//a[text()='JQuery UI Menus']")
    public WebElement jQueryUIMenus;

    @FindBy(xpath = "//a[text()='JavaScript Alerts']")
    public WebElement javascriptAlerts;

    @FindBy(xpath = "//a[text()='JavaScript onload event error']")
    public WebElement javascriptOnload;

    @FindBy(xpath = "//a[text()='Key Presses']")
    public WebElement keyPresses;

    @FindBy(xpath = "//a[text()='Large & Deep DOM']")
    public WebElement largeAndDeepDom;

    @FindBy(xpath = "//a[text()='Multiple Windows']")
    public WebElement multipleWindows;
    @FindBy(xpath = "//a[text()='Notification Messages']")
    public WebElement notificationMessage;

    @FindBy(xpath = "//a[text()='Redirect Link']")
    public WebElement redirectLink;


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

    public void visitFrames(){
        frames.click();
    }

    public void visitGeolocation(){
        geoLocation.click();
    }
    public void visitHorizontalSlider(){
        horizontalSlider.click();
    }

    public void visitHovers(){
        hovers.click();
    }

    public void visitInfiniteScroll(){
        infiniteScroll.click();
    }

    public void visitInputs(){
        inputs.click();
    }
    public void visitJQueryUIMenus(){
        jQueryUIMenus.click();
    }

    public void visitJavascriptAlerts(){
        javascriptAlerts.click();
    }
    public void visitJavascriptOnload(){
        javascriptOnload.click();
    }

    public void visitKeyPresses(){
        keyPresses.click();
    }

    public void visitLargeDeepDom(){
        largeAndDeepDom.click();
    }

    public void visitMultipleWindows(){
        multipleWindows.click();
    }

    public void visitNotificationMessages(){
        notificationMessage.click();
    }

    public void visitRedirectLink(){
        redirectLink.click();
    }
}
