package com.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdown {

    WebDriver driver;
    WebElement dropdown ;
    String url = "https://www.amazon.in";
    Select select;
    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        dropdown = driver.findElement(By.cssSelector("select#searchDropdownBox"));
        dropdown.click();
        select = new Select(dropdown);
    }

    @Test
    public boolean isMultiSelectable(){

        return select.isMultiple();
    }

    @Test
    public void getOptions(){

        System.out.println("All options available are : " + select.getOptions());
    }
    @Test
    public void dropdown_with_value() {

        select.selectByValue("search-alias=fashion");
        if (isMultiSelectable())
        select.deselectByValue("search-alias=fashion");
        System.out.println("Successfully passed dropdown_with_value");
    }

    @Test
    public void with_Visible_Text() {

        select.selectByVisibleText("Apps & Games");
        if (isMultiSelectable())
        select.deselectByVisibleText("Apps & Games");
        System.out.println("Successfully passed dropdown_with_Text");
    }

    @Test
    public void With_index() {

        select.selectByIndex(4);
        if (isMultiSelectable())
        select.deselectByIndex(4);
        System.out.println("Successfully passed dropdown_with_index");
    }
}
