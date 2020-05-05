package com.cbt.herokuApp.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class Links {


    private WebDriver driver=BrowserFactory.getDriver("chrome");




    /*
    1. Go to https://www.w3schools.com/
    2. find all the elements in th page with the tag a
    3. for each of those elements, if it is displayed on the page, print the text and href of that element.
     */

    @Test
    public void test1(){
        driver.get("https://www.w3schools.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement each : links){
            if(each.isDisplayed()){
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }

    }

    @Test
    public void test2(){
        driver.get("https://www.selenium.dev/documentation/en/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(int i=0; i< links.size(); i++){
            String href = links.get(i).getAttribute("href");
            System.out.println(href);
            //HttpURLConnection class is an abstract class directly extending from URLConnection class.
            // used for the more secured HTTPS protocol
            try {
                URL url = new URL(href);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(2000);
                httpURLConnection.connect();
                Assert.assertEquals(httpURLConnection.getResponseCode(),200 );
                //Syntax :  public String getResponseMessage()
                //200 - OK
                //404 - NOT FOUND

            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }






    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
