package com.Mouse_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mouse {

    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/buttons");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test(description = "This method is used to perform click operation using Actions class")
    public void clickUsingAction(){

        WebElement click_on_button = driver.findElement(By.cssSelector("button#b7qOp"));
        actions = new Actions(driver);
        actions.click(click_on_button).perform();
    }

    @Test(description = "This method is used to perform double click operation using Actions class")
    public void doubleClickUsingAction(){

        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();
    }

    @Test(description = "This method is used to perform right click operation using Actions class")
    public void rightClickUsingAction(){

        WebElement rightClick = driver.findElement(By.id("rightClickMessage"));
        actions = new Actions(driver);
        actions.contextClick(rightClick).perform();
    }
}
