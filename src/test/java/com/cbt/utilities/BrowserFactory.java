package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    /**
     * Create a public static method getDriver which takes a string argument
     * @param browserName
     * @return
     */
    public static WebDriver getDriver(String browserName){
        String osName = System.getProperty("os.name");
        if((osName.contains("mac")&&browserName.equalsIgnoreCase("edge"))){
            return null;
        }else if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }else if(browserName.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        }else{
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        }

    }
}
