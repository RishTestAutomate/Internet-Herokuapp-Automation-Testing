
import org.herokupp.Pages.DragAndDropPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests {

    WebDriver driver;

    DragAndDropPage dragAndDropPage;
    Actions actions;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.visitDragAndDrop();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void TC01_DragAndDropFromSrcToDest(){
        actions.dragAndDrop(dragAndDropPage.sourceElement, dragAndDropPage.destElement).build().perform();
        Assert.assertTrue(dragAndDropPage.srcHeader.getText().contains("B"));
    }
    @Test
    public void TC02_DragAndDropFromDestToSrc(){
        actions.clickAndHold(dragAndDropPage.destElement).moveToElement(dragAndDropPage.sourceElement)
                .release().build().perform();

        Assert.assertTrue(dragAndDropPage.destHeader.getText().contains("A"));
    }
}
