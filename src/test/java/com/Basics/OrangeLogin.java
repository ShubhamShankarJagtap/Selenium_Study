package com.Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class OrangeLogin {

    WebDriver driver;
    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final By userName = By.name("username");
    private final By passWord = By.name("password");
    private final By loginButton = By.tagName("button");
    private final By PIM_Module = By.xpath("//span[normalize-space()='PIM']");
    private final By addEmployee = By.linkText("Add Employee");
    private final By firstName = By.name("firstName");
    private final By middleName = By.name("middleName");
    private final By lastName = By.linkText("lastName");
    private final By createLoginDetails = By.xpath("//input[@type='checkbox']/following-sibling::span");

    @BeforeClass
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

    @Test(priority = 0)
    public void login(){

        String username = "Admin";
        enterText(userName, username);
        String password = "admin@123";
        enterText(passWord, password);
        clickOnElement(loginButton);
        System.out.println(" Successful login..");
    }

    @AfterClass
    private void tearDown(){

        driver.quit();
    }

    @Test(priority = 1)
    public void AddEmployee(){

        clickOnElement(PIM_Module);
        clickOnElement(addEmployee);
        enterText(firstName, "Rakesh");
        enterText(middleName, "Asan");
        enterText(lastName, "Damani");
        clickOnElement(createLoginDetails);
    }
}
