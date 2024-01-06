package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Roman_DeleteAccountPage implements BasePage {

    public Roman_DeleteAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2/b")
    private WebElement accountDeletedMessage;

    @Override
    public WebElement getMessage(String message) {
        return accountDeletedMessage;
    }

    @Override
    public WebElement getButton(String button) {
        return null;
    }

    @Override
    public void closeAddIfPresent() {}
}
