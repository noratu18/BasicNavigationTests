package com.cbt.herokuApp.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework7and8 {

    private WebDriver driver;


    @Test(description = "Verify that file uploaded")
    public void testNumber7() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/Baktyiar/Desktop/TestNG.txt");
        driver.findElement(By.id("file-submit")).submit();
        String expected = "File Uploaded!";
        String actual = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actual, expected);

        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(fileName.isDisplayed());
    }


        @Test(description = "Verify that You Selected United States of America message displayed")
           public void testNumber8(){
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            driver.findElement(By.linkText("Autocomplete")).click();
            driver.findElement(By.id("myCountry")).sendKeys("United States of America");
            driver.findElement(By.xpath("//input[@type='button']")).submit();

            WebElement message = driver.findElement(By.id("result"));
            Assert.assertTrue(message.isDisplayed());


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
