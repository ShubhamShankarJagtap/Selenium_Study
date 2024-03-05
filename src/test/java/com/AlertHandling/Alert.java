package com.AlertHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alert {
    WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void okAlert(){

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        driver.switchTo().alert().accept();
    }
    @Test
    public void Cancel_Alert(){

        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void alertWithTextBox(){

        driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        driver.switchTo().alert().sendKeys("Shubham Shankarrao Jagtaop.");
    }

}
