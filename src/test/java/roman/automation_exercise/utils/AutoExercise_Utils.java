package roman.automation_exercise.utils;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoExercise_Utils {

    public static void createNewAccountAndLogOut(WebDriver driver, SoftAssert softAssert) {
        driver.get("https://automationexercise.com");
        Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        var signUpText = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertTrue(signUpText.isDisplayed());

        Faker faker = new Faker();
        var firstName = faker.name().firstName();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(firstName);

        var email = faker.internet().emailAddress();
        System.out.println("Email: " + email);
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);

        driver.findElement(By.xpath("//button[.='Signup']")).click();
        var actualText = driver.findElement(By.xpath("//h2/b")).getText();
        var expectedText = "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(actualText, expectedText);

        driver.findElement(By.id("id_gender1")).click();

        var password = faker.internet().password();
        System.out.println("Password: " + password);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("first_name")).sendKeys(firstName);

        var lastName = faker.name().lastName();
        driver.findElement(By.id("last_name")).sendKeys(lastName);

        var company = faker.company().name();
        driver.findElement(By.id("company")).sendKeys(company);

        var address1 = faker.address().fullAddress();
        driver.findElement(By.id("address1")).sendKeys(address1);

        var zipCode = faker.address().zipCode();
        driver.findElement(By.id("address2")).sendKeys(zipCode);

        Select country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        country.selectByValue("United States");

        var state = faker.address().state();
        driver.findElement(By.id("state")).sendKeys(state);

        var city = faker.address().city();
        driver.findElement(By.id("city")).sendKeys(city);

        driver.findElement(By.id("zipcode")).sendKeys(zipCode);

        var phoneNumber = faker.phoneNumber().phoneNumber();
        driver.findElement(By.id("mobile_number")).sendKeys(phoneNumber);

        driver.findElement(By.xpath("//button[.='Create Account']")).click();

        actualText = driver.findElement(By.xpath("//b[contains(text(), 'Account')]")).getText();
        expectedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualText, expectedText);

        driver.findElement(By.xpath("//a[.='Continue']")).click();
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        ConfigReader.addProperty("TEMP_VALID_USER", firstName);
        ConfigReader.addProperty("TEMP_VALID_EMAIL", email);
        ConfigReader.addProperty("TEMP_VALID_PASSWORD", password);
    }

    //to login with valid credentials
    public static void login(WebDriver driver) {
        driver.get("https://automationexercise.com");
        Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ConfigReader.getProperty("AP_validEmail"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ConfigReader.getProperty("AP_validPassword"));
        driver.findElement(By.xpath("//button[.='Login']")).click();

        var userName = ConfigReader.getProperty("AP_validUserName");
        var loggedStatus = driver.findElement(By.xpath("//a[contains(text(), 'Logged in as')]")).getText();

        Assert.assertTrue(loggedStatus.contains(userName));
    }

    //to login with provided email and password
    public static void login(WebDriver driver, String email, String password) {
        driver.get("https://automationexercise.com");
        Assert.assertTrue(driver.findElement(By.tagName("body")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[.='Login']")).click();
    }
}
