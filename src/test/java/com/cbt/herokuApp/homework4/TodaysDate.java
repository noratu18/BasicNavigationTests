package com.cbt.herokuApp.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Verify that dropdowns under Select your date of birth display current year, month, day

public class TodaysDate {

    private WebDriver driver = BrowserFactory.getDriver("chrome");


    @Test(description = "Verify the current year, month, day displayed")
    public void test(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select year = new Select(driver.findElement(By.id("year")));
        String actualYear = year.getFirstSelectedOption().getText();
        String expectedYear = LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY"));
        Assert.assertEquals(actualYear,expectedYear, "Year not showing the current year!");
        System.out.println("actualYear = " + actualYear);

        Select month = new Select(driver.findElement(By.id("month")));
        String actualMonth = month.getFirstSelectedOption().getText();
        String expectedMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));
        Assert.assertEquals(actualMonth, expectedMonth, "The month is not showing current month!");
        System.out.println(actualMonth);

        Select day = new Select(driver.findElement(By.id("day")));
        String actualDay = day.getFirstSelectedOption().getText();
        String expectedDay = LocalDate.now().format(DateTimeFormatter.ofPattern("d"));
        Assert.assertEquals(actualDay, expectedDay, " The day is not showing current day!");
        System.out.println(actualDay);








    }
}
