package roman.automation_exercise.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import roman.automation_exercise.pages.BasePage;
import roman.automation_exercise.utils.Roman_AutoExercise_Utils;
import roman.automation_exercise.utils.Roman_BrowserUtils;
import roman.automation_exercise.utils.Roman_ConfigReader;

public class Roman_Generic_StepDefinitions {

    @Then("user on {string} see {string} message")
    public void userOnSeeMessage(String page, String message) {
        BasePage pom = Roman_AutoExercise_Utils.getPom(page);
        Assert.assertEquals(message, pom.getMessage(message).getText());
    }

    @Given("user is on {string}")
    public void userIsOn(String page) {
        var pageAddress = Roman_ConfigReader.getProperty(page);
        Driver.getDriver().get(pageAddress);
    }

    @When("user on {string} click close add button")
    public void userOnClickCloseAddButton(String page) {
        BasePage pom = Roman_AutoExercise_Utils.getPom(page);
        pom.closeAddIfPresent();
    }

    @When("user dismiss alert if present")
    public void userOnAlert() {
        Roman_BrowserUtils.dismissAlertIfPresent();
    }

    @Then("user landed to the {string}")
    public void userLandedToThe(String page) {
        var pom = Roman_AutoExercise_Utils.getPom(page);
    }
}
