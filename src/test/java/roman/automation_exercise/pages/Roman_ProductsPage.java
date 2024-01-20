package roman.automation_exercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_Driver;

public class Roman_ProductsPage implements Roman_BasePage {

    public Roman_ProductsPage() {
        PageFactory.initElements(Roman_Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement product1_Button;

    @Override
    public WebElement getMessage(String message) {
        throw new IllegalStateException();
    }

    @Override
    public WebElement getButton(String button) {
        if (button.equals("view_product"))
            return product1_Button;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void verifyPageIsLoaded() {
        Assert.assertTrue(Roman_Driver.getDriver().getTitle().contains("Products"));
    }

    @Override
    public void closeAddIfPresent() {
        throw new IllegalStateException();
    }
}
