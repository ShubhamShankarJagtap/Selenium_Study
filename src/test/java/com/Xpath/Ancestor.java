package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ancestor {
    WebDriver driver;
    @Test
    public void learn(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@id='rhf']//ancestor::div")).click();
    }
}
