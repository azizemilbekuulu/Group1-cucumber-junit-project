package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Roman_LoginPage implements BasePage {

    public Roman_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[.='New User Signup!']")
    private WebElement newUserSignupMessage;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    private WebElement emailInputToSignup;

    @FindBy(xpath = "//button[.='Signup']")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class='login-form']/h2")
    private WebElement loginToYourAccMessage;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    private WebElement emailInputToLogin;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[.='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(., 'incorrect')]")
    private WebElement incorrectEmailOrPassMessage;

    @FindBy(xpath = "//p[contains(., 'already exist')]")
    private WebElement alreadyExistMessage;

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getEmailInputToSignup() {
        return emailInputToSignup;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getEmailInputToLogin() {
        return emailInputToLogin;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    @Override
    public WebElement getButton(String button) {
        if (button.equals("Signup"))
            return signUpButton;
        else if (button.equals("Login"))
            return loginButton;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public WebElement getMessage(String message) {
        if (message.equals("New User Signup!"))
            return newUserSignupMessage;
        else if (message.equals("Login to your account"))
            return loginToYourAccMessage;
        else if (message.equals("Your email or password is incorrect!"))
            return incorrectEmailOrPassMessage;
        else if (message.equals("Email Address already exist!"))
            return alreadyExistMessage;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void closeAddIfPresent() {
    }


}
