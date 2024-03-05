package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*
Syntax         //tagName[starts-with(@attribute, 'value')]
 */
public class Starts_With {

    WebDriver driver;
    @Test
    public void learn_Starts_With(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in");
        driver.manage().window().maximize();
        WebElement search_Button = driver.findElement(By.xpath("//input[starts-with(@name,'field-')]"));
        search_Button.sendKeys("HP Pavilion");
        WebElement search_Icon = driver.findElement(By.id("nav-search-submit-button"));
        search_Icon.click();
    }
}
