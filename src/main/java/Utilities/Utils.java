package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Utils {
    private final WebDriver driver;
    private final JavascriptExecutor jse;

    private final WebDriverWait webDriverWait;

    public Utils(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void highlightElement(WebElement element){
        String highlightStyle = "border: 2px solid red;";

        try{
            String originalStyle = element.getAttribute("style");
            jse.executeScript("arguments[0].setAttribute('style','"+highlightStyle+"');", element);
            wait(2000);
            jse.executeScript("arguments[0].setAttribute('style','"+originalStyle+"');", element);
        }
        catch (NoSuchElementException e){
            System.out.println("No such element is present");
        }
    }

    public void highlight_and_click(WebElement element){
        highlightElement(element);
        element.click();
    }
    public void wait(int milliSeconds){
        try{
            Thread.sleep(milliSeconds);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public void waitUntilIsDisplayed(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void takeScreenshot(String destinationPath, String fileName){
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(destinationPath, fileName);
        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
