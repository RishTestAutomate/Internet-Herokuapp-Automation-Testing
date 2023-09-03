package org.herokuapp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SecureFileDownloadPage extends BasePage{

    @FindAll({@FindBy(xpath = "//div[@id='content']//a")})
    public List<WebElement> allDownloads;
    public SecureFileDownloadPage(WebDriver driver) {
        super(driver);
    }
}
