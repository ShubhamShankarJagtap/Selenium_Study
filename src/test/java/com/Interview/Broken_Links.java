package com.Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Broken_Links {


    WebDriver driver;
    String url = "https://www.amazon.in";
    List<WebElement> links;
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
    public void broken_Links(){

        links = driver.findElements(By.tagName("a"));

        for (WebElement link : links){

            try {

                String linkText = link.getAttribute("href");
                URL url1 = new URL(linkText);
                URLConnection urlConnection = url1.openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
                httpURLConnection.connect();

                if (httpURLConnection.getResponseCode()>=300 && httpURLConnection.getResponseCode()<=199){

                    System.out.println(linkText + "It is a broken link...");
                }

                else {
                    System.out.println(linkText + "It is not a broken link...");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
