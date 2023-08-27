package org.herokupp.PageTests;

import Utilities.Utils;
import org.herokupp.Pages.WYEditorPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class WYEditorTests {
    WebDriver driver;

    Utils utils;
    Actions actions;

    WYEditorPage wyEditorPage;
    JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wyEditorPage = new WYEditorPage(driver);
        utils = new Utils(driver);
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
        wyEditorPage.visitEditor();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void TC01_TestingNewDocumentCreation(){
        String content;
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        content = wyEditorPage.writingAreaText.getText();
        Assert.assertFalse(content.isEmpty());
        driver.switchTo().parentFrame();
        wyEditorPage.createNewFile();
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        content = wyEditorPage.writingAreaText.getText();

        Assert.assertTrue(content.isEmpty());
    }

    @Test
    public void TC02_TestingHeadingsFont(){
        for(int i = 1 ; i < 7 ; i++) {
            wyEditorPage.formatsButton.click();
            wyEditorPage.headingsFormatsButton.click();
            wyEditorPage.clickOnElementsWithTitle("h"+ i, driver);

            Assert.assertTrue(wyEditorPage.checkValue.getText().toLowerCase().contains("h"+ i));
        }
    }
    @Test
    public void TC03_TestingInlineFormats(){
        String[] types = {"Bold", "Italic", "Underline", "Strikethrough","Superscript",
        "Subscript","Code"};
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Bold","strong");
        expectedValues.put("Italic","em");
        expectedValues.put("Underline","span");
        expectedValues.put("Strikethrough","span");
        expectedValues.put("Superscript","sup");
        expectedValues.put("Subscript","sub");
        expectedValues.put("Code","code");
        for(String type : types) {
            wyEditorPage.formatsButton.click();
            wyEditorPage.inlineFormatsButton.click();
            wyEditorPage.clickOnElementsWithTitle(type, driver);
            Assert.assertTrue(wyEditorPage.isCheckValuePresent(expectedValues.get(type), driver));
            wyEditorPage.formatsButton.click();
            wyEditorPage.inlineFormatsButton.click();
            wyEditorPage.clickOnElementsWithTitle(type, driver);
            Assert.assertFalse(wyEditorPage.isCheckValuePresent(expectedValues.get(type), driver));

        }
    }
    @Test
    public void TC04_TestingBlocksFormats(){
        String[] types = {"Paragraph", "Blockquote", "Div", "Pre"};
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Paragraph","p");
        expectedValues.put("Blockquote","blockquote");
        expectedValues.put("Div","div");
        expectedValues.put("Pre","pre");
        for(String type : types) {
            wyEditorPage.formatsButton.click();
            wyEditorPage.blocksFormatsButton.click();
            wyEditorPage.clickOnElementsWithTitle(type, driver);
            Assert.assertTrue(wyEditorPage.isCheckValuePresent(expectedValues.get(type), driver));
            if(!type.equals("Paragraph")) {
                wyEditorPage.formatsButton.click();
                wyEditorPage.blocksFormatsButton.click();
                wyEditorPage.clickOnElementsWithTitle(type, driver);
                Assert.assertFalse(wyEditorPage.isCheckValuePresent(expectedValues.get(type), driver));
            }
        }
    }

    @Test
    public void TC05_TestingAlignFormats(){
        String[] types = {"Left", "Center", "Right", "Justify"};
        for(String type : types) {
            wyEditorPage.formatsButton.click();
            wyEditorPage.alignFormatsButton.click();
            wyEditorPage.clickOnElementsWithTitle(type, driver);
            driver.switchTo().frame(wyEditorPage.writingAreaFrame);
            String style = wyEditorPage.writingAreaText.getAttribute("style");
            driver.switchTo().parentFrame();
            Assert.assertTrue(style.toLowerCase().contains(type.toLowerCase()));
        }
    }

    @Test
    public void TC06_ValidatingDisabledButtonOnInitialWebpageLoad(){
        Assert.assertEquals(wyEditorPage.undoButton.getAttribute("aria-disabled"), "true");
        Assert.assertEquals(wyEditorPage.redoButton.getAttribute("aria-disabled"), "true");
        Assert.assertEquals(wyEditorPage.decreaseIndentButton.getAttribute("aria-disabled"), "true");
    }

    @Test
    public void TC07_ValidatingAlignments(){
        String style;
        wyEditorPage.alignLeftButton.click();
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        style = wyEditorPage.writingAreaText.getAttribute("style");
        driver.switchTo().parentFrame();
        Assert.assertTrue(style.toLowerCase().contains("left"));

        wyEditorPage.alignRightButton.click();
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        style = wyEditorPage.writingAreaText.getAttribute("style");
        driver.switchTo().parentFrame();
        Assert.assertTrue(style.toLowerCase().contains("right"));

        wyEditorPage.justifyButton.click();
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        style = wyEditorPage.writingAreaText.getAttribute("style");
        driver.switchTo().parentFrame();
        Assert.assertTrue(style.toLowerCase().contains("justify"));

        wyEditorPage.alignCenterButton.click();
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        style = wyEditorPage.writingAreaText.getAttribute("style");
        driver.switchTo().parentFrame();
        Assert.assertTrue(style.toLowerCase().contains("center"));
    }

    @Test
    public void TC08_ValidatingIndentations(){
        String style;
        int count = 1;
        for(int i = 1 ; i < 6 ; i++) {
            wyEditorPage.increaseIndentButton.click();
            count = i * 40 ;
        }

        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        style = wyEditorPage.writingAreaText.getAttribute("style");
        Assert.assertTrue(style.toLowerCase().contains(String.valueOf(count)));

        driver.switchTo().parentFrame();
        for(int i = 5 ; i > 0 ; i--) {
            wyEditorPage.decreaseIndentButton.click();
        }

        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        style = wyEditorPage.writingAreaText.getAttribute("style");
        Assert.assertEquals(style, "");

    }

    @Test
    public void TC09_ValidatingUndoRedo(){
        wyEditorPage.boldButton.click();
        Assert.assertTrue(wyEditorPage.isCheckValuePresent("strong", driver));
        wyEditorPage.italicButton.click();
        Assert.assertTrue(wyEditorPage.isCheckValuePresent("em", driver));

        wyEditorPage.undoButton.click();
        Assert.assertFalse(wyEditorPage.isCheckValuePresent("em",driver));
        wyEditorPage.undoButton.click();
        Assert.assertFalse(wyEditorPage.isCheckValuePresent("strong",driver));

        wyEditorPage.redoButton.click();
        Assert.assertTrue(wyEditorPage.isCheckValuePresent("strong", driver));
        wyEditorPage.redoButton.click();
        Assert.assertTrue(wyEditorPage.isCheckValuePresent("em", driver));
    }


    /*This test checks for Bold, Italic and Text Color - Yellow*/
    @Test
    public void TC10_EnterTextAndFormatIt(){
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        wyEditorPage.writingAreaText.clear();
        wyEditorPage.writingAreaText.sendKeys("This is for testing purpose.");

        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("b").keyUp(Keys.CONTROL).build().perform();

        Assert.assertTrue(utils.isEnabled(wyEditorPage.boldText));
        actions.keyDown(Keys.CONTROL).sendKeys("i").keyUp(Keys.CONTROL).build().perform();
        Assert.assertTrue(utils.isEnabled(wyEditorPage.italicText));

        actions.keyDown(Keys.CONTROL).sendKeys("i").keyUp(Keys.CONTROL).build().perform();
        Assert.assertFalse(utils.isEnabled(wyEditorPage.italicText));
        actions.keyDown(Keys.CONTROL).sendKeys("b").keyUp(Keys.CONTROL).build().perform();
        Assert.assertFalse(utils.isEnabled(wyEditorPage.boldText));

        driver.switchTo().parentFrame();
        wyEditorPage.formatButton.click();
        wyEditorPage.textColorButton.click();
        String expectedStyle = wyEditorPage.getStyleAttribute("Yellow", driver).substring(11);
        wyEditorPage.clickOnElementsWithTitle("Yellow", driver);
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        String actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("style");
        Assert.assertEquals(actualStyle, expectedStyle);

    }

    /*Enter the text as "This is a for testing.", set the text Bold, Italic
    * set the background-color to Red
    * set the text color to White*/

    @Test
    public void TC11_ValidatingGivenTestScenario(){
        String expectedStyle, actualStyle;
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        wyEditorPage.writingAreaText.clear();
        wyEditorPage.writingAreaText.sendKeys("This is a for testing.");
        Assert.assertEquals(wyEditorPage.writingAreaText.getText(), "This is a for testing.");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("b").keyUp(Keys.CONTROL).build().perform();

        Assert.assertTrue(utils.isEnabled(wyEditorPage.boldText));
        actions.keyDown(Keys.CONTROL).sendKeys("i").keyUp(Keys.CONTROL).build().perform();
        Assert.assertTrue(utils.isEnabled(wyEditorPage.italicText));

        driver.switchTo().parentFrame();

        wyEditorPage.formatButton.click();
        wyEditorPage.backgroundColorButton.click();
        expectedStyle = wyEditorPage.getStyleAttribute("Red", driver);
        wyEditorPage.clickOnElementsWithTitle("Red", driver);
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("style");
        Assert.assertEquals(actualStyle, expectedStyle);

        driver.switchTo().parentFrame();

        wyEditorPage.formatButton.click();
        wyEditorPage.textColorButton.click();
        expectedStyle = expectedStyle + " " +wyEditorPage.getStyleAttribute("Red", driver).substring(11);
        wyEditorPage.clickOnElementsWithTitle("Red", driver);
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("style");
        Assert.assertEquals(actualStyle, expectedStyle);
    }

    /*Enter a text and set all available text-colors to it.*/
    @Test
    public void TC12_ValidatingGivenTestScenario(){
        String[] colors = {"Light Green", "Light Yellow", "Light Red", "Light Purple", "Light Blue",
        "Green", "Yellow", "Red", "Purple", "Blue", "Dark Turquoise", "Orange", "Dark Red", "Dark Purple",
        "Dark Blue", "Light Gray", "Medium Gray", "Gray", "Dark Gray", "Navy Blue", "Black", "White"};
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        wyEditorPage.writingAreaText.clear();
        wyEditorPage.writingAreaText.sendKeys("This is a for testing.");
        Assert.assertEquals(wyEditorPage.writingAreaText.getText(), "This is a for testing.");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        driver.switchTo().parentFrame();
        for(String color : colors) {
            wyEditorPage.formatButton.click();
            wyEditorPage.textColorButton.click();
            String expectedStyle = wyEditorPage.getStyleAttribute(color, driver).substring(11);
            wyEditorPage.clickOnElementsWithTitle(color, driver);

            driver.switchTo().frame(wyEditorPage.writingAreaFrame);
            String actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("style");
            Assert.assertEquals(actualStyle, expectedStyle);
            driver.switchTo().parentFrame();
        }
    }
    /*Enter a text and set all available background-colors to it.*/
    @Test
    public void TC13_ValidatingGivenTestScenario(){
        String[] colors = {"Light Green", "Light Yellow", "Light Red", "Light Purple", "Light Blue",
        "Green", "Yellow", "Red", "Purple", "Blue", "Dark Turquoise", "Orange", "Dark Red", "Dark Purple",
        "Dark Blue", "Light Gray", "Medium Gray", "Gray", "Dark Gray", "Navy Blue", "Black", "White"};
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        wyEditorPage.writingAreaText.clear();
        wyEditorPage.writingAreaText.sendKeys("This is a for testing.");
        Assert.assertEquals(wyEditorPage.writingAreaText.getText(), "This is a for testing.");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        driver.switchTo().parentFrame();
        for(String color : colors) {
            wyEditorPage.formatButton.click();
            wyEditorPage.backgroundColorButton.click();
            String expectedStyle = wyEditorPage.getStyleAttribute(color, driver);
            wyEditorPage.clickOnElementsWithTitle(color, driver);

            driver.switchTo().frame(wyEditorPage.writingAreaFrame);
            String actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("style");
            Assert.assertEquals(actualStyle, expectedStyle);
            driver.switchTo().parentFrame();
        }
    }


    /*Enter text as "I'm working." and set all available the font-sizes to it.*/
    @Test
    public void TC14_ValidatingGivenTestScenario(){
        String[] fontSizes = {"12pt", "10pt", "8pt", "14pt", "18pt", "24pt", "36pt"};
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        wyEditorPage.writingAreaText.clear();
        wyEditorPage.writingAreaText.sendKeys("I'm working.");
        Assert.assertEquals(wyEditorPage.writingAreaText.getText(), "I'm working.");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        driver.switchTo().parentFrame();
        for(String size : fontSizes){
            wyEditorPage.formatButton.click();
            wyEditorPage.fontSizesButton.click();
            wyEditorPage.clickOnElementsWithTitle(size, driver);

            driver.switchTo().frame(wyEditorPage.writingAreaFrame);
            String actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("style");
            Assert.assertTrue(actualStyle.contains(size));
            driver.switchTo().parentFrame();
        }
    }


    /*Enter text as "I'm working." and set all available the line-height to it.*/
    @Test
    public void TC15_ValidatingGivenTestScenario(){
        String[] lineHeights = {"1", "1.1", "1.2", "1.3", "1.4", "1.5", "2"};
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        wyEditorPage.writingAreaText.clear();
        wyEditorPage.writingAreaText.sendKeys("I'm working.");
        Assert.assertEquals(wyEditorPage.writingAreaText.getText(), "I'm working.");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        driver.switchTo().parentFrame();
        for(String height : lineHeights){
            wyEditorPage.formatButton.click();
            wyEditorPage.lineHeightButton.click();
            wyEditorPage.clickOnElementsWithTitle(height, driver);

            driver.switchTo().frame(wyEditorPage.writingAreaFrame);
            String actualStyle = wyEditorPage.writingAreaText.getAttribute("style");
            Assert.assertTrue(actualStyle.contains(height));
            driver.switchTo().parentFrame();
        }
    }
    /*Enter text as "I'm working." and set all available the fonts to it.*/
    @Test
    public void TC16_ValidatingGivenTestScenario(){
        String[] fonts ={"Andale Mono", "Arial", "Arial Black", "Book Antiqua", "Comic Sans MS", "Courier New",
        "Georgia", "Helvetica", "Impact", "Symbol", "Tahoma", "Terminal", "Times New Roman", "Trebuchet MS", "Verdana",
        "Webdings", "Wingdings"};
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        wyEditorPage.writingAreaText.clear();
        wyEditorPage.writingAreaText.sendKeys("I'm working.");
        Assert.assertEquals(wyEditorPage.writingAreaText.getText(), "I'm working.");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        driver.switchTo().parentFrame();
        for(String font : fonts){
            wyEditorPage.formatButton.click();
            wyEditorPage.fontsButton.click();
            wyEditorPage.clickOnElementsWithTitle(font, driver);

            driver.switchTo().frame(wyEditorPage.writingAreaFrame);
            String actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("data-mce-style");
            Assert.assertTrue(actualStyle.toLowerCase().contains(font.toLowerCase()));
            driver.switchTo().parentFrame();
        }
    }

    /*Testing clear format button*/
    @Test
    public void TC17_ValidateClearFormatButton(){
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        wyEditorPage.writingAreaText.clear();
        wyEditorPage.writingAreaText.sendKeys("Test clear format button.");
        Assert.assertEquals(wyEditorPage.writingAreaText.getText(), "Test clear format button.");
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        driver.switchTo().parentFrame();

        String actualStyle;
        wyEditorPage.formatButton.click();
        wyEditorPage.fontsButton.click();
        wyEditorPage.clickOnElementsWithTitle("Times New Roman", driver);
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("data-mce-style");
        driver.switchTo().parentFrame();
        Assert.assertTrue(actualStyle.toLowerCase().contains("Times New Roman".toLowerCase()));

        wyEditorPage.formatButton.click();
        wyEditorPage.fontSizesButton.click();
        wyEditorPage.clickOnElementsWithTitle("18pt", driver);
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("style");
        driver.switchTo().parentFrame();
        Assert.assertTrue(actualStyle.contains("18pt"));

        wyEditorPage.formatButton.click();
        wyEditorPage.textColorButton.click();
        String expectedStyle = wyEditorPage.getStyleAttribute("Red", driver).substring(11);
        wyEditorPage.clickOnElementsWithTitle("Red", driver);
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        actualStyle = wyEditorPage.writingAreaTextAfterFormat.getAttribute("style");
        driver.switchTo().parentFrame();
        Assert.assertTrue(actualStyle.contains(expectedStyle));

        wyEditorPage.formatButton.click();
        wyEditorPage.clearFormattingButton.click();
        driver.switchTo().frame(wyEditorPage.writingAreaFrame);
        actualStyle = wyEditorPage.writingAreaText.getAttribute("style");
        Assert.assertEquals(actualStyle, "");
    }
}
