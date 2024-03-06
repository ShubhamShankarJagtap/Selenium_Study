package Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(ListenerDemo.class)
public class TestClass {

    WebDriver driver;

    @Test
    public void launchBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void navigate() {

        driver.navigate().to("https://demo.opencart.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Your Store";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void register() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.cssSelector("input#input-firstname")).sendKeys("Sam");
        driver.findElement(By.cssSelector("input#input-lastname")).sendKeys("Billings");
        driver.findElement(By.cssSelector("input#input-email")).sendKeys("sam78@gmail.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement check = wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
        check.click();

        WebDriverWait continueWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement continueButton = continueWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        continueButton.click();


    }
}
