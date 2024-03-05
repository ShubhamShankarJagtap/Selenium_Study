package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
     Contains function is used to find dynamic web elements.
     You can provide any partial attribute value to find the web element.

     Syntax xpath=//tagname[contains(@Attribute,'value')]
 */
public class Contains {

    WebDriver driver;
    @Test
    public void learn_Contains(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in");
        driver.manage().window().maximize();
        WebElement textBox = driver.findElement(By.xpath("//input[contains(@id,'twotab')]"));
        textBox.sendKeys("Samsung flip 5");
        WebElement search_Icon = driver.findElement(By.id("nav-search-submit-button"));
        search_Icon.click();
    }
}
