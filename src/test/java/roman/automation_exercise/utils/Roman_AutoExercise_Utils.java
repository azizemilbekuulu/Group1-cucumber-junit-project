package roman.automation_exercise.utils;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import roman.automation_exercise.pages.*;

import java.util.ArrayList;
import java.util.List;

public class Roman_AutoExercise_Utils {

    public static void createNewAccountAndLogOut() {
        var driver = Roman_Driver.getDriver();
        var homePage = new Roman_HomePageRoman();
        var loginPage = new Roman_LoginPageRoman();
        var signupPage = new Roman_SignupPageRoman();
        var accountCreatedPage = new Roman_AccountCreatedPageRoman();

        driver.get("https://automationexercise.com");

        homePage.getButton("Signup/Login").click();

        Faker faker = new Faker();
        var firstName = faker.name().firstName();
        loginPage.getFirstNameInput().sendKeys(firstName);

        var email = faker.internet().emailAddress();
        System.out.println("Email: " + email);
        loginPage.getEmailInputToSignup().sendKeys(email);

        loginPage.getSignUpButton().click();

        signupPage.getGenderMale().click();

        var password = faker.internet().password();
        System.out.println("Password: " + password);
        signupPage.getPasswordInput().sendKeys(password);

        signupPage.getFirstNameInput().sendKeys(firstName);

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

        signupPage.getCreateAccountButton().click();

        accountCreatedPage.getContinueButton().click();
        homePage.getLogoutLink().click();

        /*Roman_ConfigReader.addProperty("TEMP_VALID_USER", firstName);
        Roman_ConfigReader.addProperty("TEMP_VALID_EMAIL", email);
        Roman_ConfigReader.addProperty("TEMP_VALID_PASSWORD", password);*/
    }

    //to login with valid credentials
    public static void login() {
        var driver = Roman_Driver.getDriver();
        driver.get("https://automationexercise.com");
        Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Roman_ConfigReader.getProperty("AP_validEmail"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Roman_ConfigReader.getProperty("AP_validPassword"));
        driver.findElement(By.xpath("//button[.='Login']")).click();

        var userName = Roman_ConfigReader.getProperty("AP_validUserName");
        var loggedStatus = driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]")).getText();

        Assert.assertTrue(loggedStatus.contains(userName));
    }

    //to login with provided email and password
    public static void login(String email, String password) {
        var driver = Roman_Driver.getDriver();
        driver.get("https://automationexercise.com");
        Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[.='Login']")).click();
    }

    public static Roman_BasePage getPom(String page) {
        Roman_BasePage pom;
        if (page.equals("login_page"))
            pom = new Roman_LoginPageRoman();
        else if (page.equals("signup_page"))
            pom = new Roman_SignupPageRoman();
        else if (page.equals("account_created_page"))
            pom = new Roman_AccountCreatedPageRoman();
        else if (page.equals("home_page"))
            pom = new Roman_HomePageRoman();
        else if (page.equals("delete_account_page"))
            pom = new Roman_DeleteAccountPageRoman();
        else if (page.equals("contact_us_page"))
            pom = new Roman_ContactUsPageRoman();
        else if (page.equals("products_page"))
            pom = new Roman_ProductsPage();
        else if (page.equals("product_details"))
            pom = new Roman_ProductDetailsPage();
        else
            throw new IllegalArgumentException();

        return pom;
    }

    public static void closeAddIfPresent() {
        var driver = Roman_Driver.getDriver();
        List<WebElement> frames;
        List<WebElement> adds = new ArrayList<>();

        //on some pages parent frame may be different, but child frame is always the same
        try {
            frames = driver.findElements(By.id("aswift_1"));
            if (frames.isEmpty())
                frames = driver.findElements(By.id("aswift_5"));
            if (frames.isEmpty())
                frames = driver.findElements(By.id("aswift_2"));

            driver.switchTo().frame(frames.get(0));

            adds = driver.findElements(By.id("dismiss-button"));
            //in case if add is not in parent iframe
            if (adds.isEmpty()) {
                driver.switchTo().frame("ad_iframe");
                adds = driver.findElements(By.id("dismiss-button"));
            }
        } catch (NoSuchFrameException e) {}

        /*var wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dismiss-button")));*/
        for (WebElement add : adds) {
            add.click();
        }
        driver.switchTo().defaultContent();
    }
}
