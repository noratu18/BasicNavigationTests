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

public class MoreSpoons {


    private WebDriver driver = BrowserFactory.getDriver("chrome");


    @Test
    public void test1() {

        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        BrowserWait.wait(2);
        List<WebElement> allBrands = driver.findElements(By.id("brandsRefinements"));
        List<String> brandNames = BrowserWait.getTextFromWebElements(allBrands);

        BrowserWait.wait(4);

        driver.findElement(By.id("p_85/2470955011")).click();

        //driver.findElement(By.xpath("//div[@id='primeRefinements']//i[@class='a-icon a-icon-checkbox']")).click();

        Assert.assertTrue(driver.findElement(By.id("brandsRefinements")).isDisplayed());

        driver.quit();


    }
}
