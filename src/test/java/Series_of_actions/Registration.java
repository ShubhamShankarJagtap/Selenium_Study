package Series_of_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Registration {

    WebDriver driver;

    @Test(priority = 0)
    public void setUp() {

        driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Your Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement click = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='My Account']")));
        click.click();

        WebDriverWait registerWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement register = registerWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Register")));
        register.click();
    }

    @Test(dependsOnMethods = "setUp")
    void fill() {

        Actions actions = new Actions(this.driver);
        actions.moveToElement(driver.findElement(By.cssSelector("input#input-firstname")))
                .click()
                .sendKeys("sam", Keys.TAB)
                .sendKeys("curran", Keys.TAB)
                .sendKeys("sam23@gmail.com", Keys.TAB)
                .sendKeys("1234", Keys.TAB, Keys.TAB, Keys.TAB)
                .click()
                .sendKeys(Keys.ENTER).perform();
    }
}
