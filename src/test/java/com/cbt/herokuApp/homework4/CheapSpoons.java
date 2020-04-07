package com.cbt.herokuApp.homework4;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * CHEAP SPOONS
 * 1.go to https://amazon.com
 * 2.search for "wooden spoon"
 * 3.click on Price option Under $25 on the left
 * 4.verify that all results are cheaper than $25
 */

public class CheapSpoons {

    private WebDriver driver = BrowserFactory.getDriver("chrome");


    @Test(description = "Verify that all results are cheaper than $25")
    public void test(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        driver.findElement(By.linkText("Under $25")).click();

        //we collect only dollar values from the price of every item
        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
        // we convert collection of web element intocollectionof strings
        List<String> pricesText = BrowserWait.getTextFromWebElements(prices);
        System.out.println(pricesText);
            for(String price : pricesText){
                //we convert every price as a String into integer
                int priceConverted = Integer.parseInt(price);
                //checking if the price of every item is under 25
                Assert.assertTrue(priceConverted <25);
            }
            driver.quit();


    }
}
