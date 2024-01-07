package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_AutoExercise_Utils;
import roman.automation_exercise.utils.Roman_Driver;

import java.util.List;

public class Roman_AccountCreatedPage implements BasePage {

    public Roman_AccountCreatedPage() {
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
    public void closeAddIfPresent() {
        Roman_AutoExercise_Utils.closeAddIfPresent();
    }
}
