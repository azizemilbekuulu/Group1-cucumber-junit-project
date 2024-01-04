package roman.automation_exercise.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import roman.automation_exercise.pages.Library_LoginPage;

public class Cydeo_Library_StepDefinitions {
    @When("user inputs wrong email format")
    public void userInputsWrongEmailFormat() {
    }

    @When("user doesn't input password")
    public void userDoesnTInputPassword() {
    }

    @Then("user see invalid email error message")
    public void userSeeInvalidEmailErrorMessage() {
        var libraryPage = new Library_LoginPage();
        var actualErrorMessage = libraryPage.getInvalidEmailFormatMessage().getText();
        Assert.assertEquals("Please enter a valid email address.", actualErrorMessage);
    }

    @Then("user see enter correct password error message")
    public void userSeeEnterCorrectPasswordErrorMessage() {
        var libraryPage = new Library_LoginPage();
        var actualErrorMessage = libraryPage.getEnterValidPasswordMessage().getText();
        Assert.assertEquals("Error: Please enter a valid password", actualErrorMessage);
    }
}
