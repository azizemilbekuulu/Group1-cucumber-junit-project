package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Library_LoginPage {
    public Library_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@id='inputEmail-error']")
    private WebElement invalidEmailFormatMessage;

    @FindBy(xpath = "(//div[contains(., 'Error:')])[2]")
    private WebElement enterValidPasswordMessage;

    public WebElement getInvalidEmailFormatMessage() {
        return invalidEmailFormatMessage;
    }

    public WebElement getEnterValidPasswordMessage() {
        return enterValidPasswordMessage;
    }
}
