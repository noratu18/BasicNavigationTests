package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com", "https://walmart.com","https:westelm.com/");


        WebDriver driver = BrowserFactory.getDriver("chrome");

        for(String each : urls){
            driver.get(each);
            if(each.contains(driver.getTitle().replace(" ","").toLowerCase())){ //
                System.out.println("Passed!" + each);
            }else{
                System.out.println("Failed!"+each);
            }

        }

        driver.close();

    }
}
