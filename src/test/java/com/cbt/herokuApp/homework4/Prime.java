package com.cbt.herokuApp.homework4;

import com.cbt.utilities.BrowserFactory;

import com.cbt.utilities.BrowserWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Prime {

    private WebDriver driver = BrowserFactory.getDriver("chrome");

    @Test
    public void test1(){

        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//input[@value='Go']")).click();
        String expected = "OXO 1130880 Good Grips Wooden Corner Spoon & Scraper,Brown";
        BrowserWait.wait(3);
        driver.findElement(By.xpath("//div[@id='primeRefinements']//i[@class='a-icon a-icon-checkbox']")).click();
        BrowserWait.wait(3);
        String actual = driver.findElement(By.cssSelector("div[data-asin='B008H2JLPS'] div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) span:nth-of-type(1)")).getText();
        Assert.assertEquals(actual, expected);

        String lastCheckbox = driver.findElement(By.cssSelector("li[aria-label='Scanwood'] .a-icon")).getText();
        Assert.assertNotEquals(expected, lastCheckbox);


        driver.quit();



    }
}
