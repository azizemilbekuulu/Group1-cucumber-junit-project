package roman.automation_exercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_Driver;

public class Roman_TestCasesPageRoman implements Roman_BasePage {

    public Roman_TestCasesPageRoman() {
        PageFactory.initElements(Roman_Driver.getDriver(), this);
    }

    @Override
    public WebElement getMessage(String message) {
        throw new IllegalStateException();
    }

    @Override
    public WebElement getButton(String button) {
        throw new IllegalStateException();
    }

    @Override
    public void verifyPageIsLoaded() {
        throw new IllegalStateException();
    }

    @Override
    public void closeAddIfPresent() {
        throw new IllegalStateException();
    }
}
