package com.Interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class NewWindow {

    WebDriver driver;
    String url = "https://www.amazon.in";
    String amazonWindowHandle;
    String facebookWindowHandle;
    Set<String> handles;
    @BeforeClass
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        String expectedPageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(driver.getTitle(), expectedPageTitle);
        amazonWindowHandle = driver.getWindowHandle();
        System.out.println("amazonWindowHandle : " + amazonWindowHandle);

    }
    @Test
    public void newTab(){

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.facebook.com");
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        facebookWindowHandle = driver.getWindowHandle();
        System.out.println("faceWindowHandle : " + facebookWindowHandle);

    }

    @Test
    public void windoHandle(){

        handles = driver.getWindowHandles();

        for (String handle : handles){
            System.out.println(handle);
        }

        driver.switchTo().window(amazonWindowHandle);
    }
}
