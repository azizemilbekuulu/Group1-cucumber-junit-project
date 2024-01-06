package roman.automation_exercise.step_definitions;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import roman.automation_exercise.pages.Roman_ContactUsPage;

public class Roman_ContactUs_StepDefinitions {
    Roman_ContactUsPage contactUsPage = new Roman_ContactUsPage();

    @When("user on contact_us_page enters name, email, subject and message")
    public void userOnContactUsPageEntersNameEmailSubjectAndMessage() {

        var faker = new Faker();

        contactUsPage.getNameInput().sendKeys(faker.name().name());
        contactUsPage.getEmailInput().sendKeys(faker.internet().emailAddress());
        contactUsPage.getSubjectInput().sendKeys(faker.name().lastName());
        contactUsPage.getMessageInput().sendKeys(faker.address().fullAddress());
    }

    @And("user on contact us page upload file")
    public void userOnContactUsPageUploadFile() {
        contactUsPage.getUploadFile().
                sendKeys("C:\\Users\\Roman\\Desktop\\Cydeo\\Daily stand-up example.png");
    }

    @And("user on contact_us_page page accept alert")
    public void userOnContact_us_pagePageAcceptAlert() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("user landed to the home_page")
    public void userLandedToTheHome_page() {
        Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
    }
}
