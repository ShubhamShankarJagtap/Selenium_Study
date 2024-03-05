package jsExecutor;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
JavaScriptExecutor:-
                      it is an interface that helps to execute "JAVASCRIPT" through selenium webDriver.

Syntax:-
            JavaScriptExecutor js = (JavaScriptExecutor) driver;

            js.executeScript(Script, Argument)

 Script: This is javaScript that need to be executed.

 Arguments:- It is the argument to the script, It is optional.

 Returns: it could be anything from boolean, Long, String, List, WebElement or null.
 */
public class Demo {

    WebDriver driver;

    String url = "https://www.amazon.in";
    JavascriptExecutor javascriptExecutor;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test(enabled = false)
    public void gettingTitle() {

        Object o = javascriptExecutor.executeScript("return document.title", "");
        System.out.println(o.toString());
    }

    @Test(description = "This method is for enter a text in a textBox using javaScript & click on a button", enabled = false)
    public void demo() {

        javascriptExecutor.executeScript("document.getElementById('twotabsearchtextbox').value='SAMSUNG'", "");
        WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
        javascriptExecutor.executeScript("arguments[0].click();", searchIcon);
    }

    @Test(description = "to refresh a browser", enabled = false)
    public void refresh(){

        javascriptExecutor.executeScript("history.go(0)");
    }

    @Test
    public void domain(){

        String name = javascriptExecutor.executeScript("return document.domain;").toString();
        System.out.println("The domain name is : " + name);
    }
}
