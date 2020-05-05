package com.cbt.herokuApp.homework4;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserWait;
import com.cbt.utilities.Setup;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DepartmentsSort {

    private WebDriver driver = BrowserFactory.getDriver("chrome");


    @Test(description = "Verify that default value of the All departments is All")
    public void test1(){
        driver.get("https://www.amazon.com");

        String actual = driver.findElement(By.xpath("//span[@class='nav-search-label']")).getText();
        String expected = "All";
        Assert.assertEquals(actual, expected, "The dropdown All is not matching!");


    }

    @Test(description = "Verify that All dropdown is not sorted alphabetically")
    public void test2(){
        driver.get("https://www.amazon.com");
        List<WebElement> allDepartments = driver.findElements(By.id("searchDropdownBox"));
        List<String> text = BrowserWait.getTextFromWebElements(allDepartments);

        for(int i=0; i < text.size()-1; i ++){
            String value = text.get(i);
            String nextValue = text.get(i+1);

            System.out.println(value.compareTo(nextValue));

            Assert.assertTrue(value.compareTo(nextValue)>0, "not alphabetically sorted");

        }

        driver.quit();


    }



}
