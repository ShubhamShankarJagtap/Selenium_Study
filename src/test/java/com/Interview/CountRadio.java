package com.Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CountRadio {
    WebDriver driver;
    String url = "https://www.irctc.co.in";

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
    public void countRadio(){

        List<WebElement> radio = driver.findElements(By.xpath("//input[@type= 'radio']"));

        String text = "";
        for (WebElement rad : radio){

            text = rad.getAttribute("type");

        }

        System.out.println(text);
        System.out.println(radio.size());
    }
}
