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
import roman.automation_exercise.utils.Roman_Driver;

public class Roman_Generic_StepDefinitions {

    @Then("user on {string} see {string} message")
    public void userOnSeeMessage(String page, String message) {
        BasePage pom = Roman_AutoExercise_Utils.getPom(page);
        Assert.assertEquals(message, pom.getMessage(message).getText());
    }

    @Given("user is on {string}")
    public void userIsOn(String page) {
        var pageAddress = Roman_ConfigReader.getProperty(page);
        Roman_Driver.getDriver().get(pageAddress);
    }

    @When("user click close add button")
    public void userOnClickCloseAddButton() {
        /*Roman_AutoExercise_Utils.closeAddIfPresent();*/
    }

    @When("user on {string} click {string} button")
    public void userOnClickButton(String page, String button) {
        BasePage pom = Roman_AutoExercise_Utils.getPom(page);
        pom.getButton(button).click();
    }

    @Then("user on {string} see login confirmation {string} message")
    public void userOnSeeLoginConfirmationMessage(String page, String message) {
        BasePage pom = Roman_AutoExercise_Utils.getPom(page);
        var actualMessage = pom.getMessage(message).getText();

        //in case if it's automatically created account:
        String username;
        if (message.contains("new_username")) {
            username = Roman_ConfigReader.getProperty("tempFirstName");
            message = message.replaceFirst("new_username", username);
        }
        //in case if using pre-validated credentials:
        else if (message.contains("valid_username")) {
            username = Roman_ConfigReader.getProperty("AP_validUserName");
            message = message.replaceFirst("valid_username", username);
        }

        Assert.assertEquals(message, actualMessage);
    }

    @When("user dismiss alert if present")
    public void userOnAlert() {
        Roman_BrowserUtils.dismissAlertIfPresent();
    }
}
