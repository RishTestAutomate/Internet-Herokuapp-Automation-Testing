package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage{

    @FindBy(id = "file-upload")
    public WebElement chooseFile;

    @FindBy(id = "file-submit")
    public WebElement uploadButton;

    @FindBy(id = "drag-drop-upload")
    public WebElement dragAndDropUpload;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFiles;


    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
}
