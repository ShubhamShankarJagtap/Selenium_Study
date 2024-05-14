package Analyze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAnalyzer {

    WebDriver driver;
    @Test()
    public void launch(){

        driver = new FirefoxDriver();
        Assert.fail();
    }

}
