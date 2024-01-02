package roman.automation_exercise.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Roman_Driver {
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    private Roman_Driver(){};

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = Roman_ConfigReader.getProperty("browser");
            if (browserType.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driverPool.set(new ChromeDriver(options));
            }
            else if (browserType.equalsIgnoreCase("firefox"))
                driverPool.set(new FirefoxDriver());
            else if (browserType.equalsIgnoreCase("edge"))
                driverPool.set(new EdgeDriver());
            else if (browserType.equalsIgnoreCase("headless-chrome")) {
                var options = new ChromeOptions();
                options.addArguments("--headless=new");
                driverPool.set(new ChromeDriver(options));
            }
            else
                throw new IllegalArgumentException();

            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
