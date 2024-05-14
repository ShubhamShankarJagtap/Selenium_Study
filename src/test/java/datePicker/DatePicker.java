package datePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Calendar;

public class DatePicker {

    public int targetDate, targetMonth, targetYear, currentDay, currentMonth, currentYear, jumpToMonth;
    public boolean increment = true;
    WebDriver driver;

    @Test
    public void calenderHandling() {

        String dateToSet = "22/10/2024";
        getCurrentDateMonthAndYear();
        System.out.println("current date is : " + currentDay + "/" + currentMonth + "/" + currentYear);

        getTargetDateMonthAndYear(dateToSet);
        System.out.println(targetDate + "/" + targetMonth + "/" + targetMonth);

        howManyMonthToJump();
        System.out.println("The number of months to be jumped is : " + jumpToMonth);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.navigate().to("https://jqueryui.com/datepicker");

//        Date picker is in the iframe, so we have to switch to the iframe & then we can access the elements inside the iframe.
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement dateInputBox = driver.findElement(By.id("datepicker"));
        dateInputBox.click();

        for (int i=0; i<jumpToMonth; i++){
            if (increment){

                driver.findElement(By.xpath("//span[text()='Next']")).click();
            }
            else {

                driver.findElement(By.xpath("//span[text()='Prev']")).click();
                increment = false;
            }
        }

//        Now we have to enter the date
        driver.findElement(By.linkText(String.valueOf(targetDate))).click();
    }

    void getCurrentDateMonthAndYear() {

        Calendar calendar = Calendar.getInstance();
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentMonth = calendar.get(Calendar.MONTH) + 1;
        currentYear = calendar.get(Calendar.YEAR);
    }

    void getTargetDateMonthAndYear(String dateToSet) {

        String[] dates = dateToSet.split("/");
        String day = "";
        String month = "";
        String year = "";

        for (int i = 0; i < dates.length; i++) {
            day = dates[0];
            month = dates[1];
            year = dates[2];
        }
        targetDate = Integer.parseInt(day);
        targetMonth = Integer.parseInt(month);
        targetYear = Integer.parseInt(year);
    }

    void howManyMonthToJump() {

        if ((targetMonth - currentMonth) > 0) {
            jumpToMonth = targetMonth - currentMonth;
        } else {
            jumpToMonth = currentMonth - targetMonth;
            increment = false;
        }
    }
}
