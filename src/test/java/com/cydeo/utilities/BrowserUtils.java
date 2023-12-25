package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {
    /*
       This method will accept int (in seconds)
       and execute Thread.sleep method for given duration
       Arg: int second
        */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerifyTitle(String actualTitle, String expectedTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
            if(Driver.getDriver().getCurrentUrl().contains(actualTitle)){
                Driver.getDriver().switchTo().window(each);
                break;
            }
        }

        String actual = Driver.getDriver().getTitle();
        Assert.assertTrue(actual.contains(expectedTitle));

    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }
    public static void verifyTitleContains(String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    public static void verifyMessageAfterSignUp(String expectedMessage){
        String actualMessage = Driver.getDriver().findElement(By.xpath("//p[1]")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }
    /*
    This method accepts web element and waits for that element to become invisible.
     */
    public static void waitForInvisibilityOf(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.invisibilityOf(target));

    }
    /*
    This method accepts string and waits until the title contains the given string.
     */
    public static void waitForTitleContains(String title){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.titleContains(title));
    }
}
