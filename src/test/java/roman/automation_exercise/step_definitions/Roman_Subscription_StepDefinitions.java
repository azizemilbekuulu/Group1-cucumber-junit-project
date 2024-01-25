package roman.automation_exercise.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import roman.automation_exercise.pages.Roman_HomePageRoman;

public class Roman_Subscription_StepDefinitions {
    @When("user enters email address in email input")
    public void userEntersEmailAddressInEmailInput() {
        var pom = new Roman_HomePageRoman();
        var faker = new Faker();
        var email = faker.internet().emailAddress();
        pom.getSubscribeEmailInput().sendKeys(email);
    }
}
