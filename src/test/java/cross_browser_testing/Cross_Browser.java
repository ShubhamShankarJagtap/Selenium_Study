package cross_browser_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
CBT:-  It is a process to perform tests on multiple browsers.

       It is done to verify how a website performs on different browsers.

       It gives the confidence that website behaviour is consistent across various browsers.
 */
public class Cross_Browser {

    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void launchBrowser(String browser){

        switch (browser.toLowerCase()){

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

            default:
                driver = null;
                break;
        }
    }
    @Test
    public void cross(){

        driver.navigate().to("https://demo.opencart.com/");
        String expectedTitle = "Your Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
