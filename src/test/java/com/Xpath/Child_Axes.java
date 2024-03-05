package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Child_Axes {
    WebDriver driver;

    @Test
    public void learn_Child_Axes() {

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@id='nav-xshop']//child::a[5]")).click();
    }
}
