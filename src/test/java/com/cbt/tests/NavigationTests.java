package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {
    chromeTest();
    safariTest();
    firefoxTest();

    }

    public static void chromeTest() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.get("https://etsy.com");
        String title1 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title1,driver.getTitle());

        driver.close();
    }

    public  static void safariTest() {
        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.get("https://etsy.com");
        String title1 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title1,driver.getTitle());

        driver.close();
    }

    public  static void firefoxTest() {
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.get("https://etsy.com");
        String title1 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title1,driver.getTitle());
        
        driver.close();
    }


}
