package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Roman_HomePage implements LoginPages {

    public Roman_HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[contains(@href, 'delete')]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement loggedAsUserMessage;

    public WebElement getLogoutLink() {
        return logoutLink;
    }

    @Override
    public WebElement getMessage(String message) {
        return loggedAsUserMessage;
    }

    @Override
    public WebElement getButton(String button) {
        return switch (button) {
            case "Signup/Login" -> signupLoginLink;
            case "Delete account" -> deleteAccountButton;
            case "Logout" -> logoutLink;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public void closeAddIfPresent() {}
}
