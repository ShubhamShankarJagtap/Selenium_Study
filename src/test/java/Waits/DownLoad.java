package Waits;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class DownLoad {

    WebDriver driver;

    @Test
    public void download() {

        driver = new ChromeDriver();
        driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");

        String path = "C:\\Users\\hp\\Downloads";
        String name = "jenkins";

        File file = new File(path, name);

        FluentWait<File> fileFluentWait = new FluentWait<File>(file)
                .withTimeout(Duration.ofMinutes(10))
                .pollingEvery(Duration.ofMinutes(1))
                .ignoring(Exception.class)
                .withMessage("Unable to download the file");

        try {

          boolean isDownLoaded = fileFluentWait.until(f -> f.exists() && f.canRead());
            if (isDownLoaded)
                System.out.println("Download is completed...");

        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
