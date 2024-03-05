package com.css_selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CSS_Basics {

    WebDriver driver;
    String url = "https://www.amazon.in";

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
    @Test
    public void learn_With_id(){

        driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("samsung s9 ultra tablet 14.6 inches");
        driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
    }

    @Test
    public void with_class(){

        driver.findElement(By.cssSelector("div.nav-fill")).click();
    }

    @Test
    public void with_mixed(){

        driver.findElement(By.cssSelector("input#twotabsearchtextbox[type='text']")).sendKeys("samsung s9 tablet 14.6 inches");
        driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
    }


    @Test
    public void with_prefix(){

        driver.findElement(By.cssSelector("input[id^='twotab']")).sendKeys("samsung watch 6");
        driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
    }


    @Test
    public void with_suffix(){

        driver.findElement(By.cssSelector("input[id$='searchtextbox']")).sendKeys("samsung watch 6");
        driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
    }


    @Test
    public void with_subString(){

        driver.findElement(By.cssSelector("input[id*='search']")).sendKeys("samsung watch 6");
        driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
    }
}
