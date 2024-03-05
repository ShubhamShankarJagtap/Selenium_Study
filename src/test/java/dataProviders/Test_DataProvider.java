package dataProviders;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Test_DataProvider {

WebDriver driver;
    @Test(dataProvider = "provider")
    void search(String country, String monument) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchTextBox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchTextBox.sendKeys(country + " " + monument);
        searchTextBox.sendKeys(Keys.ENTER);


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")));
//        searchButton.click();

    }

    @DataProvider
    private Object[][] provider() {

        Object[][] searchData = new Object[2][2];
        searchData[0][0] = "India";
        searchData[0][1] = "DagduSheth Temple";
        searchData[1][0] = "United States of America";
        searchData[1][1] = "Columbia university";

        return searchData;
    }

    @AfterMethod
    public void getScreen(){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(".//ScreenShot//images.jpeg");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
