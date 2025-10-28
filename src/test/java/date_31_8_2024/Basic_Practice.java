package date_31_8_2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Basic_Practice {

    @Test
    private void launchWebSite(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://www.amazon.in");
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();
    }
}
