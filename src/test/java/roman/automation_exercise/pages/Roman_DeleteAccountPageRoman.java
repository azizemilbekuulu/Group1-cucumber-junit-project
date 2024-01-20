package roman.automation_exercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_Driver;

public class Roman_DeleteAccountPageRoman implements Roman_BasePage {

    public Roman_DeleteAccountPageRoman() {
        PageFactory.initElements(Roman_Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2/b")
    private WebElement accountDeletedMessage;

    @Override
    public WebElement getMessage(String message) {
        return accountDeletedMessage;
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
