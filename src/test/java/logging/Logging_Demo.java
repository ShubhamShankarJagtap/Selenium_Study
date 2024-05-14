package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Logging_Demo {
    WebDriver driver;
    Logger logger;

    @Test
    public void launch() {

        System.out.println("Inside logger demo...");
        logger = LogManager.getLogger("LoggerDemo");
        logger.info("Print this message.....");
    }
}
