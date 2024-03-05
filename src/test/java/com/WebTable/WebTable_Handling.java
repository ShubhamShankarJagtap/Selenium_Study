package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable_Handling {

WebDriver driver;
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

    @Test
    public void webTableHandLing(){


        driver.findElement(By.xpath("//span[text()='Web Tables']")).click();

        List<WebElement> table = driver.findElements(By.xpath("//div[@class='rt-td']"));

        for (WebElement text : table){

            System.out.println(text.getText());
        }

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("Bill");
    }
}
