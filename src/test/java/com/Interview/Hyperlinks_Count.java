package com.Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Hyperlinks_Count {
    WebDriver driver;
    String url = "https://www.amazon.in";
    @BeforeSuite
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @Test
    public void countHyperLinks(){

        List<WebElement> hyperLinks =driver.findElements(By.tagName("a"));

        for (WebElement link : hyperLinks){

            System.out.println(link.getText());
        }

        System.out.println("There are " + hyperLinks.size() + " " + "hyperlinks on current webpage.");
    }
}
