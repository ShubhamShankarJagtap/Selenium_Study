package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Text_Xpath {

    WebDriver driver;

    @Test
    public void learn_Text(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in");
        driver.manage().window().maximize();
        WebElement computers = driver.findElement(By.xpath("//a[text()='Mobiles']"));
        computers.click();
    }
}
