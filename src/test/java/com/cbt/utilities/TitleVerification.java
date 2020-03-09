package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TitleVerification {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

           List<String> title = new ArrayList<>();
        for (String each : urls) {
            driver.get(each);

            title.add(driver.getTitle());

            //   StringUtility.verifyEquals(each,driver.getTitle());

        }

        // this fori verifies that they all have the same title
        for (int i = 0; i < title.size() - 1; i++) {
            StringUtility.verifyEquals(title.get(i), title.get(i + 1));
        }
        StringUtility.verifyEquals(title.get(0), title.get(2));


        // this fori checks if each url starts with http://practice.cybertekschool.com
        for (String each : urls) {
            if (each.startsWith("http://practice.cybertekschool.com")) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }


        driver.close();

    }
}
