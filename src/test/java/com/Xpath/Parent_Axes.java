package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parent_Axes {

    WebDriver driver;

    @Test
    public void learn_Parent_Axes(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Mobiles']//parent::div")).click();

    }
}
