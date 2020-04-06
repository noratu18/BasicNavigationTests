package com.cbt.herokuApp.homework3;

import com.cbt.utilities.BrowserWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Homework6 {
    private WebDriver driver;


    @Test(description = "Verify that temporariry email cretaed and received a feedback")
    public void testNumber6() {
        driver.get("https://www.tempmailaddress.com/");
        // String email = "ranvir.luther@aallaa.org"; // hard coded was not good
        String email = driver.findElement(By.id("email")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserWait.wait(2);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("nora tu");
        driver.findElement(By.name("email")).sendKeys(email);
        //  driver.findElement(By.cssSelector("input[type='email']")).sendKeys("ranvir.luther@aallaa.org");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserWait.wait(2);

        WebElement message = driver.findElement(By.xpath("//h3[text()='Thank you for signing up. Click the button below to return to the home page.']"));
        Assert.assertTrue(message.isDisplayed());
        BrowserWait.wait(2);

        driver.navigate().to("https://www.tempmailaddress.com/");

        WebElement isEmailReceived = driver.findElement(By.xpath("//*[@id='schranka']/tr[1]/td[1]"));
        Assert.assertTrue(isEmailReceived.isDisplayed());

        isEmailReceived.click();
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        String actualEmail = driver.findElement(By.id("odesilatel")).getText();
        Assert.assertEquals(actualEmail, expectedEmail);

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(actualSubject, expectedSubject);


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
