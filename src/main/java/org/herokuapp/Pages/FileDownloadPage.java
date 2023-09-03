package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BasePage{

    @FindBy(linkText = "delhi.jpg")
    public WebElement delhi_jpg;

    @FindBy(linkText = "sample.pdf")
    public WebElement sample_pdf;

    @FindBy(linkText = "dummy.txt")
    public WebElement dummy_txt;

    @FindBy(linkText = "2.34-MB.bmp")
    public WebElement MB_bmp;

    @FindBy(linkText = "example.json")
    public WebElement example_json;

    @FindBy(linkText = "5mb script.xml")
    public WebElement script_xml;

    @FindBy(linkText = "test.pdf")
    public WebElement test_pdf;

    @FindBy(linkText = "Ahmed_Saeed_QC_Engineer.pdf")
    public WebElement engineer_pdf;

   @FindBy(linkText = "licensed-image.png")
    public WebElement licensed_image_png;

   @FindBy(linkText = "sample-zip-file.zip")
    public WebElement sample_zip;

   @FindBy(linkText = "test.docx")
    public WebElement test_docx;

   @FindBy(linkText = "chromedriver.exe")
    public WebElement chromedriver_exe;

   @FindBy(linkText = "exemplo.txt")
    public WebElement example_txt;

   @FindBy(linkText = "test.png")
    public WebElement test_png;

   @FindBy(linkText = "pic.jpg")
    public WebElement pic_jpg;

   @FindBy(linkText = "call_101.wav")
    public WebElement call_101_wav;

   @FindBy(linkText = "some-file.txt")
    public WebElement some_file_txt;

   @FindBy(linkText = "image.png.jfif")
    public WebElement image_png_jfif;

  @FindBy(linkText = "customPdfFile.pdf")
    public WebElement customPdfFile_pdf;

  @FindBy(linkText = "consent letter.docx")
    public WebElement consent_letter_docx;

  @FindBy(linkText = "my.txt")
    public WebElement my_txt;

  @FindBy(linkText = "resume.doc")
    public WebElement resume_doc;

  @FindBy(linkText = "LambdaTest.pdf")
    public WebElement LambdaTest_pdf;

  @FindBy(linkText = "evening.png")
    public WebElement evening_png;

  @FindBy(linkText = "sample.png")
    public WebElement sample_png;

  @FindBy(linkText = "1952CE24-EE1F-4703-B91D-A2F896B3C9B1.png")
    public WebElement A2F896B3C9B1_png;

 @FindBy(linkText = "LambdaTest.txt")
    public WebElement LambdaTest_txt;

 @FindBy(linkText = "file_example_JPG_2500kB.jpg")
    public WebElement file_example_JPG_2500kB_jpg;

 @FindBy(linkText = "md.jpg")
    public WebElement md_jpg;

 @FindBy(linkText = "webdriverIO.png")
    public WebElement webdriverIO_png;

 @FindBy(linkText = "upload-file.txt")
    public WebElement upload_file_txt;


    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }
}
