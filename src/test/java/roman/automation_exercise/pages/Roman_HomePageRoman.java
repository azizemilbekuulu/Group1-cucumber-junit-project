package roman.automation_exercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_Driver;

public class Roman_HomePageRoman implements Roman_BasePage {

    public Roman_HomePageRoman() {
        PageFactory.initElements(Roman_Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[contains(@href, 'delete')]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement loggedAsUserMessage;

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[@href='/test_cases']")
    private WebElement testCasesButton;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsButton;

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
            case "Contact us" -> contactUsButton;
            case "Test cases" -> testCasesButton;
            case "products" -> productsButton;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    public void verifyPageIsLoaded() {
        throw new IllegalArgumentException();
    }

    @Override
    public void closeAddIfPresent() {
        throw new IllegalStateException();
    }
}
