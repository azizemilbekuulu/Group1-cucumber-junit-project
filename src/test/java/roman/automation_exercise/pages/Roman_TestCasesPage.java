package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_Driver;

public class Roman_TestCasesPage implements BasePage{

    public Roman_TestCasesPage() {
        PageFactory.initElements(Roman_Driver.getDriver(), this);
    }

    @Override
    public WebElement getMessage(String message) {
        return null;
    }

    @Override
    public WebElement getButton(String button) {
        return null;
    }

    @Override
    public void closeAddIfPresent() {

    }
}
