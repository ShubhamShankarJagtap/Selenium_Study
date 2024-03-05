package Frames_Iframes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/*
FRAME:-  It is a html tag that is used to divide the web page into various frames/windows.
         Each window can load a separate HTML document.

IFRAME : - It is also a tag used in HTML, but it specifies an inline frame.
           Which means it is used to embed content of other document/sources within the current HTML document
 */
public class Demo {

    WebDriver driver;
    String url = "https://demoqa.com/frames";

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterMethod
    public void tearDown() {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(".//ScreenShot//FrameImage.jpeg");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void switchFrame() {

        driver.switchTo().frame("DAsis");
        driver.quit();
    }

    @Test
    public void switchWithIndex(){

        driver.switchTo().frame(1);
    }
}
