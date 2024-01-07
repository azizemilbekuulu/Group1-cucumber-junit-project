package roman.automation_exercise.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import roman.automation_exercise.utils.Roman_Driver;

public class Roman_TestCases_StepDefinitions {

    @Then("user landed to the test_cases_page")
    public void userLandedToTheTest_cases_page() {
        var expectedTitle = "Automation Practice Website for UI Testing - Test Cases";
        Assert.assertEquals(expectedTitle, Roman_Driver.getDriver().getTitle());
    }
}
