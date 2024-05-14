package com.cookie_handling;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

/*
Cookie:- It is an information about user & their preferences.
         It is a small pieces of data sent from web application & stores in a web browser, while the user is browsing that website.
 */
public class Cookies_Handling {

    WebDriver driver;

    @Test
    public void cookies(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.navigate().to("https://www.amazon.com");
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
    }
}
