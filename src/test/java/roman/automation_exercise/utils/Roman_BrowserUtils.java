package roman.automation_exercise.utils;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoAlertPresentException;

public class Roman_BrowserUtils {
    public static void sleep(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dismissAlertIfPresent() {
        try {
            Roman_Driver.getDriver().switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {}
    }
}
