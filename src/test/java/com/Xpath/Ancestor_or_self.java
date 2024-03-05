package com.Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Ancestor_or_self {

    WebDriver driver;

    @Test
    public void learn(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in");
        driver.manage().window().maximize();
        WebElement sign_in = driver.findElement(By.xpath("//div[@id='rhf']//ancestor-or-self::div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sign_in).click().perform();
    }
}
