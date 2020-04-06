package com.cbt.herokuApp.homework2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/**
 * 1.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox2.Randomlyselect a checkbox.
 * As soon as you check any day, print the name of the day and uncheck immediately.
 * After you check and uncheck Friday for the third time, exit the program.
 */

public class RandomSelection {

    /*
    1.Go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
     */
    private WebDriver driver = BrowserFactory.getDriver("chrome");


    @Test
    public void test(){
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserWait.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
        int counter = 0;

        while(counter <3){
            Random random = new Random();
            int checkboxToSelect = random.nextInt(checkBoxes.size());

            if(checkBoxes.get(checkboxToSelect).isEnabled()) {
                checkBoxes.get(checkboxToSelect).click();
                System.out.println("Selected :: " + labels.get(checkboxToSelect).getText());

                checkBoxes.get(checkboxToSelect).click();

                if (labels.get(checkboxToSelect).getText().equals("Friday")) {
                    counter++;
                }
            }

        }

        driver.quit();
    }

}
