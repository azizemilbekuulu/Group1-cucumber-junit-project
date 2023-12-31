package roman.automation_exercise.step_definitions;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import roman.automation_exercise.pages.*;
import roman.automation_exercise.utils.Roman_AutoExercise_Utils;
import roman.automation_exercise.utils.Roman_BrowserUtils;
import roman.automation_exercise.utils.Roman_ConfigReader;
import roman.automation_exercise.utils.Roman_Driver;

import java.time.Duration;

public class Roman_Login_StepDefinitions {
    Faker faker = new Faker();



    @Then("user see page is loaded")
    public void userSeeLoaded() {
        Assert.assertTrue(Roman_Driver.getDriver().findElement(By.tagName("body")).isDisplayed());
    }

    @When("user enters name and email address to signup")
    public void userEntersNameAndEmailAddress() {
        var loginPage = new Roman_LoginPage();

        var firstName = faker.name().firstName();
        //storing temp property to re-use it further in registration
        Roman_ConfigReader.addProperty("tempFirstName", firstName);
        loginPage.getFirstNameInput().sendKeys(firstName);

        var email = faker.internet().emailAddress();
        loginPage.getEmailInputToSignup().sendKeys(email);
    }

    @When("user fill details: Title, Name, Email, Password, Date of birth")
    public void userFillDetailsTitleNameEmailPasswordDateOfBirth() {
        var signupPage = new Roman_SignupPage();
        signupPage.getGenderMale().click();

        var password = faker.internet().password();
        signupPage.getPasswordInput().sendKeys(password);

        signupPage.selectDateOfBirth(13, 12, 1992);
    }

    @And("user select checkbox {string}")
    public void userOnSelectCheckbox(String checkbox) {
        var signupPage = new Roman_SignupPage();
        signupPage.getCheckbox(checkbox).click();
    }

    @And("user fill details: First name, Last name, Company, both Address lines, Country, State, City, Zipcode, Mobile Number")
    public void userFillDetailsFirstNameLastNameCompanyBothAddressLinesCountryStateCityZipcodeMobileNumber() {
        var signupPage = new Roman_SignupPage();
        signupPage.getFirstNameInput().sendKeys(Roman_ConfigReader.getProperty("tempFirstName"));

        var lastName = faker.name().lastName();
        signupPage.getLastNameInput().sendKeys(lastName);

        var company = faker.company().name();
        signupPage.getCompanyInput().sendKeys(company);

        var address1 = faker.address().fullAddress();
        signupPage.getAddress1_Input().sendKeys(address1);

        var zipCode = faker.address().zipCode();
        signupPage.getAddress2_Input().sendKeys(zipCode);

        signupPage.selectCountry("United States");

        var state = faker.address().state();
        signupPage.getStateInput().sendKeys(state);

        var city = faker.address().city();
        signupPage.getCityInput().sendKeys(city);

        signupPage.getZipcodeInput().sendKeys(zipCode);

        var phoneNumber = faker.phoneNumber().phoneNumber();
        signupPage.getPhoneNumberInput().sendKeys(phoneNumber);
    }

    @When("user enters {string} email and password to login")
    public void userEntersEmailAndPasswordToLogin(String validOrInvalid) {
        var loginPage = new Roman_LoginPage();
        if (validOrInvalid.equals("valid")) {
            loginPage.getEmailInputToLogin().sendKeys(Roman_ConfigReader.getProperty("AP_validEmail"));
            loginPage.getPasswordInput().sendKeys(Roman_ConfigReader.getProperty("AP_validPassword"));
        }
        else if (validOrInvalid.equals("invalid")) {
            var faker = new Faker();
            var email = faker.internet().emailAddress();
            var password = faker.internet().password();
            loginPage.getEmailInputToLogin().sendKeys(email);
            loginPage.getPasswordInput().sendKeys(password);
        }
        else
            throw new IllegalArgumentException();
    }

    @When("user enters existing name and email address to signup")
    public void userEntersExistingNameAndEmailAddressToSignup() {
        var loginPage = new Roman_LoginPage();
        loginPage.getFirstNameInput().sendKeys(Roman_ConfigReader.getProperty("AP_validUserName"));
        loginPage.getEmailInputToSignup().sendKeys(Roman_ConfigReader.getProperty("AP_validEmail"));
    }
}
