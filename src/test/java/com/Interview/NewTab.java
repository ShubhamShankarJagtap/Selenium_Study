package com.Interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTab {

    WebDriver driver;
    String url = "https://www.amazon.in";

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        String expectedPageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(driver.getTitle(), expectedPageTitle);

    }
    @Test
    public void newTab(){

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com");
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
