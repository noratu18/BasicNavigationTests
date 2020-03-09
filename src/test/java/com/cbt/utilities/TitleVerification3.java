package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com","https://westelm.com/");


        for(String each : urls){
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(each);

            if(each.contains(driver.getTitle().replace(" ","").toLowerCase())){ //
                System.out.println("Passed!" + each);
            }else{
                System.out.println("Failed!"+each);
            }

            driver.close();
        }



//       WebDriver driver = BrowserFactory.createDriver("safari");
//       WebDriver driver1 = BrowserFactory.createDriver("chrome");
//       WebDriver driver2 = BrowserFactory.createDriver("firefox");

//        for(int i =0; i<urls.size(); i++){
//            driver.get(urls.get(i));
//            driver1.get(urls.get(i));
//            driver2.get(urls.get(i));
//
//        }





   }
}
