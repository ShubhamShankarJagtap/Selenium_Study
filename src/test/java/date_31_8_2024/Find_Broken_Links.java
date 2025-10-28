package date_31_8_2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Find_Broken_Links {

    @Test
    public void find_Broken_links(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links){

           String linkText = link.getAttribute("href");
            System.out.println(linkText + "/t");
            try {

                URL url = new URL(linkText);
                URLConnection urlConnection = url.openConnection();
                HttpURLConnection urlConnection1 = (HttpURLConnection) urlConnection;
                urlConnection1.connect();

                if (urlConnection1.getResponseCode()>= 300 && urlConnection1.getResponseCode()<= 199){

                    System.out.println("The " + linkText + " is a broken link..");
                }

                else System.out.println("The " + linkText + " is a not a broken link..");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
