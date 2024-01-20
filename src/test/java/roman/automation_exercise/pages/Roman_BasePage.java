package roman.automation_exercise.pages;

import org.openqa.selenium.WebElement;

public interface Roman_BasePage {
    WebElement getMessage(String message);
    WebElement getButton(String button);
    void verifyPageIsLoaded();
    void closeAddIfPresent();
}
