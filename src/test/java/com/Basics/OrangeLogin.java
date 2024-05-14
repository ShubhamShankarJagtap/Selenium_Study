package com.Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeLogin {

    WebDriver driver;
    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final By userName = By.name("username");
    private final By passWord = By.name("password");
    private final By loginButton = By.tagName("button");

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
        driver.get(url);
    }

    private void enterText(By by, String text){

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(text);
    }

    private void clickOnElement(By by){

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
    }

    @Test
    public void login(){

        String username = "Admin";
        enterText(userName, username);
        String password = "admin@123";
        enterText(passWord, password);
        clickOnElement(loginButton);
        System.out.println(" Successful login..");
    }

    @AfterMethod
    private void tearDown(){

        driver.quit();
    }
}
