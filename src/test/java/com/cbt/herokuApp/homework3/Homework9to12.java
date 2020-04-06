package com.cbt.herokuApp.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Homework9to12 {

    private WebDriver driver;

    @DataProvider(name="testData")
    public static  Object[] testData(){
        return new Object[] {"404","500","301","200"};
    }


   @Test(dataProvider = "testData")
    public void test9to12(String code){

       driver.get("https://practice-cybertekschool.herokuapp.com/");
       WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
       statusCodeLink.click();

       WebElement statusCode = driver.findElement(By.linkText(code));
       statusCode.click();

       String expected = "This page returned a "+code+" status code";
       WebElement displayedMessage = driver.findElement(By.xpath("//p"));
       String actual = displayedMessage.getText();

       Assert.assertTrue(actual.contains(expected), "The status code does not exist");



   }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        // driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
