package com.AlertHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Alert {

    private WebDriver driver;
    private WebDriverWait wait;
    private By button = (By.xpath("//button[@class='btn btn-danger']"));
    private By buttonAlert= (By.xpath("//a[text()='Alert with OK & Cancel ']"));
    private By confirmBox = (By.xpath("//button[@class='btn btn-primary']"));
    private By alertWithTextBox= (By.xpath("//a[text()='Alert with Textbox ']"));
    private By confirmTextBox = (By.xpath("//button[@class='btn btn-info']"));

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    private void clickElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    @Test
    public void okAlert(){

        clickElement(button);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }
    @Test
    public void Cancel_Alert(){

        clickElement(buttonAlert);
        clickElement(confirmBox);
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void alertWithTextBox(){


        clickElement(alertWithTextBox);
        clickElement(confirmTextBox);
        driver.switchTo().alert().sendKeys("Shubham Shankarrao Jagtap.");
    }

}
