package com.Mouse_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hover_Over {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.in");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void hover(){

//        driver.findElement().click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement electronics = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Electronics")));
        electronics.click();

        WebElement tv = driver.findElement(By.xpath("//div[@id='nav-subnav']//descendant::span[6]"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(tv));

        actions = new Actions(driver);
        actions.moveToElement(tv).perform();
    }

}
