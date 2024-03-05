package com.ScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Demo {
    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.in");
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
    @Test(enabled = false)
    public void getScreenShot(){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(".//ScreenShot//image.jpeg");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void particularSectionGetScreenShot(){

        WebElement watches = driver.findElement(By.id("nav-logo-sprites"));
        File srcFile = watches.getScreenshotAs(OutputType.FILE);
        File destFile = new File(".//ScreenShot//section.jpeg");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
