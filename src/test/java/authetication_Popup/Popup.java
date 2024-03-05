package authetication_Popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Popup {

    WebDriver driver;

    @Test
    void launch(){

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        System.out.println("Title : " + driver.getTitle());
        System.out.println("URL : " + driver.getCurrentUrl());
        System.out.println("WindowHandle : " + driver.getWindowHandle());

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
             webDriverWait.until(ExpectedConditions.alertIsPresent());

             driver.switchTo().alert().accept();
    }
}
