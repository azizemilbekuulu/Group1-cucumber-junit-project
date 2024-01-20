package roman.automation_exercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_AutoExercise_Utils;
import roman.automation_exercise.utils.Roman_Driver;

public class Roman_AccountCreatedPageRoman implements Roman_BasePage {

    public Roman_AccountCreatedPageRoman() {
        PageFactory.initElements(Roman_Driver.getDriver(), this);
    }

    @FindBy(xpath = "//b[contains(text(), 'Account')]")
    private WebElement confirmationMessage;

    @FindBy(id = "dismiss-button")
    private WebElement closeAddButton;

    @FindBy(xpath = "//a[.='Continue']")
    private WebElement continueButton;

    public WebElement getContinueButton() {
        return continueButton;
    }

    @Override
    public WebElement getMessage(String message) {
        return confirmationMessage;
    }

    @Override
    public WebElement getButton(String button) {
        WebElement targetButton = null;
        if (button.equals("Continue"))
            targetButton = continueButton;

        return targetButton;
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
