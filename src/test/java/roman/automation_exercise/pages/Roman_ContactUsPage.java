package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_AutoExercise_Utils;

public class Roman_ContactUsPage implements BasePage {

    public Roman_ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='contact-form']/h2")
    private WebElement getInTouchText;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='contact-form']//div[contains(., 'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@id='form-section']/a")
    private WebElement genericHomeButton;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "subject")
    private WebElement subjectInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(name = "upload_file")
    private WebElement uploadFile;

    @Override
    public WebElement getMessage(String message) {
        if (message.equals("GET IN TOUCH"))
            return getInTouchText;
        else if (message.contains("successfully"))
            return successMessage;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public WebElement getButton(String button) {
        if (button.equalsIgnoreCase("submit"))
            return submitButton;
        else if (button.equals("Home"))
            return genericHomeButton;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void closeAddIfPresent() {
        Roman_AutoExercise_Utils.closeAddIfPresent();
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getSubjectInput() {
        return subjectInput;
    }

    public WebElement getMessageInput() {
        return messageInput;
    }

    public WebElement getUploadFile() {
        return uploadFile;
    }
}
