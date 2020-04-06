package com.cbt.herokuApp.homework3;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserWait;
import com.cbt.utilities.Setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkFrom1To5 {

    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private WebDriver driver;
    private By registrationForm = By.linkText("Registration Form");



    @Test(description = "Verify the birth date is wrong")
    public void testNumber1(){
        driver.get(URL);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserWait.wait(5);
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        BrowserWait.wait(5);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @Test(description = "Verify the languages are displayed")
    public void testNumber2(){
        driver.get(URL);
        driver.findElement(registrationForm).click();
        BrowserWait.wait(5);
        WebElement cplusplus = driver.findElement(By.xpath("//*[@id='inlineCheckbox1']"));
        Assert.assertTrue(cplusplus.isDisplayed());
        BrowserWait.wait(2);
        WebElement java = driver.findElement(By.xpath("//*[@id='inlineCheckbox2']"));
        Assert.assertTrue(java.isDisplayed());
        BrowserWait.wait(2);
        WebElement javaScript = driver.findElement(By.xpath("//*[@id='inlineCheckbox3']"));
        BrowserWait.wait(2);
        Assert.assertTrue(javaScript.isDisplayed());


    }

    @Test(description = "Verify the first name more than 2 letters")
    public void testNumber3(){
        driver.get(URL);
        driver.findElement(registrationForm).click();
        BrowserWait.wait(5);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("w");
        BrowserWait.wait(3);
        WebElement warningMesage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMesage.isDisplayed());

    }
    @Test(description = "Verify the last name more than 2 letters")
    public void testNumber4(){
        driver.get(URL);
        driver.findElement(registrationForm).click();
        BrowserWait.wait(5);
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("p");
        BrowserWait.wait(3);
        WebElement warningMesage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMesage.isDisplayed());

    }

    @Test(description = "Verify that you've successfully completed registration!")
    public void testNumber5(){
        driver.get(URL);;
        driver.findElement(registrationForm).click();
        BrowserWait.wait(3);
        driver.findElement(By.name("firstname")).sendKeys("Nora");
        driver.findElement(By.name("lastname")).sendKeys("Tuse");
        driver.findElement(By.name("username")).sendKeys("userTa");
        driver.findElement(By.name("email")).sendKeys("user@cybertek.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("phone")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//*[@name='gender'][@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("12/12/2000");

        Select departmentSelect =new Select(driver.findElement(By.name("department")));
        departmentSelect.selectByVisibleText("Accounting Office");

        Select jobTitleSelect = new Select(driver.findElement(By.name("job_title")));
        jobTitleSelect.selectByVisibleText("QA");

//        Select languageSelect = new Select(driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::input")));
//        languageSelect.selectByVisibleText("java");
        driver.findElement(By.xpath("//label[text()='Java']")).click();

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserWait.wait(3);

        //WebElement message = driver.findElement(By.tagName("p")).getText();
       // Assert.assertTrue(message.isDisplayed());
        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual,expected);




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
