package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Descendant_or_self {
    WebDriver driver;

    @Test
    public void learn(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@id='nav-xshop']//descendant-or-self::a[9]")).click();
    }
}
