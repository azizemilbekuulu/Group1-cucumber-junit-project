package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //create a private constructor to remove access to this object

    private Driver() {
    }

    /*
    we make the driver private because we want to close access from outside of class
     */
    private static WebDriver driver; //default value is null when we call on this driver.
    // hence in the if condition below it is null.
    /*
    Create a re-usable utility which will return a same driver instance once we call it
    If an instance does not exist it will create first, and then it will always return same instance.
     */

    public static WebDriver getDriver() {
        if (driver == null) {
            /*
            We will read our browserType from configuration.properties file.
            This way, we can control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");
            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the matching browser.
             */
            switch (browserType) {
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            }
        }

        //if not null
        return driver;
    }

    /*
   Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
    */
    public static void closeDriver(){
        if(driver != null){
            driver.quit(); //terminates the existing driver completely. It won't exist going further.
            driver = null; //we assign the value back to null so that my singleton can create a new one.
        }
    }
}
