package roman.automation_exercise.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Roman_AccountCreatedPage implements LoginPages {

    public Roman_AccountCreatedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//b[contains(text(), 'Account')]")
    private WebElement confirmationMessage;

    @FindBy(id = "dismiss-button")
    private WebElement closeAddButton;

    @FindBy(xpath = "//a[.='Continue']")
    private WebElement continueButton;

    public WebElement getContinueButton() {
        return continueButton;
    }

    @Override
    public WebElement getMessage(String message) {
        return confirmationMessage;
    }

    @Override
    public WebElement getButton(String button) {
        WebElement targetButton = null;
        if (button.equals("Continue"))
            targetButton = continueButton;

        return targetButton;
    }

    @Override
    public void closeAddIfPresent() {
        var driver = Driver.getDriver();
        driver.switchTo().frame("aswift_1");
        List<WebElement> adds = driver.findElements(By.id("dismiss-button"));
        //sometimes add is in first level iframe
        if (adds.isEmpty()) {
            driver.switchTo().frame("ad_iframe");
            adds = driver.findElements(By.id("dismiss-button"));
        }
        /*var wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dismiss-button")));*/
        for (WebElement add : adds) {
            add.click();
        }
        driver.switchTo().defaultContent();
    }

}
