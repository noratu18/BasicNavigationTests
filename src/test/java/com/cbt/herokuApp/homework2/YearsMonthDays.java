package com.cbt.herokuApp.homework2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.Random;

/**
 * YEARS, MONTHS, DAYS
 * 1. go to http://practice.cybertekschool.com/dropdown
 * 2. select a random year under Select your date of birth
 * 3. select month January
 * 4. verify that days dropdown has current number of days
 * 5. repeat steps 3, 4 for all the months
 * <p>
 * NOTE: if you randomly select a leap year, verify February has 29 days
 */

public class YearsMonthDays {
    private WebDriver driver = BrowserFactory.getDriver("chrome");

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));

        Random random = new Random();

        for(int i=0; i< 12; i++) {
            int yearToSelect = random.nextInt(year.getOptions().size());
            year.selectByIndex(yearToSelect);
            month.selectByIndex(i);
        }


    }

    public static boolean isLeapYear(int year){
        if(year % 4 ==0){
            if(year % 100 == 0){
                return year %400 ==0;
            }
        }
        return year %4 == 0;
    }
}
