package roman.automation_exercise.pages;

import org.openqa.selenium.WebElement;

public interface LoginPages extends BasePage {
    WebElement getMessage(String message);
    WebElement getButton(String button);
    void closeAddIfPresent();
}
