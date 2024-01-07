package roman.automation_exercise.runners;

import com.cydeo.utilities.Driver;
import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/roman_features",
        glue = "roman/automation_exercise/step_definitions",
        tags = "",
        dryRun = false
)

public class Roman_CukesRunner {}
