package com.FileUpload_Download;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class Upload {

    WebDriver driver;
    WebElement upload;

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/buttons");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test(description = "This method is used to upload a file using sendKeys method.")
    public void upload_sendKeys(){

        driver.findElement(By.xpath("//span[text()='Upload and Download']")).click();

//        You can use upload a file using sendKeys method only when input tag have attribute type & its value should be a file.
       upload = driver.findElement(By.xpath("//input[@type='file']"));
       upload.sendKeys("E:\\InterviewQuestions\\Selenium Interview questions & answers.pdf");
    }

    @Test(description = "This method is used to upload a file using Robot class.")
    public void usingRobot(){

        Actions actions = new Actions(driver);
        actions.moveToElement(upload).click().perform();

        try {
            Robot robot = new Robot();
            robot.delay(2000);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }
}
