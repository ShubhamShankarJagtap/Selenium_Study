package com.Interview;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ListIterator;

public class Basic {
     WebDriver driver;
     String url = "https://www.amazon.in/";
    @Test
    @Parameters({"browser"})
     void launchBrowser(String browser) {

        switch (browser) {
            case "chrome":

                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "edge":

                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;

            case "firefox":

                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "ie":

                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;

            case "safari":

                driver = new SafariDriver();
                driver.manage().window().maximize();
                break;

            default:
                break;
        }
    }

    @Test(dependsOnMethods = "launchBrowser", description = "This method is for navigating to the url.")
    public void navigateUrl(){

        driver.navigate().to(url);
        String pageTitle = driver.getTitle();
        System.out.println("The title of this page is : " + pageTitle);
        driver.findElement(By.xpath("//a[contains(text() ,'Electronics')]")).click();
    }

    @Test(dependsOnMethods = "navigateUrl", description = "this method is for printing the tv names.")
    public void printTv(){

        WebElement tv_Electronics_Menu = driver.findElement(By.xpath(" //span[contains (text(), 'TV & Home Entertainment')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tv_Electronics_Menu).click(driver.findElement(By.xpath(" //a[contains (text(), '4K TVs')]"))).perform();

        List<WebElement> tv_names = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));

        for (WebElement names : tv_names){

            System.out.println(names.getText());
        }
    }
}
