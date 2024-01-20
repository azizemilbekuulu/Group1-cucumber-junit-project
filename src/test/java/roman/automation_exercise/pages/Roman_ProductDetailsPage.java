package roman.automation_exercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_Driver;

import java.util.List;

public class Roman_ProductDetailsPage implements Roman_BasePage{

    public Roman_ProductDetailsPage() {
        PageFactory.initElements(Roman_Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='product-information']/p[contains(text(), 'Category')]")
    private WebElement productCategory;

    @FindBy(xpath = "//div[@class='product-information']//span[contains(text(), 'Rs')]")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='product-information']//b[contains(text(), 'Availability')]/..")
    private WebElement productAvailability;

    @FindBy(xpath = "//div[@class='product-information']//b[contains(text(), 'Condition')]/..")
    private WebElement productCondition;

    @FindBy(xpath = "//div[@class='product-information']//b[contains(text(), 'Brand')]/..")
    private WebElement productBrand;



    @Override
    public WebElement getMessage(String message) {
        throw new IllegalStateException();
    }

    @Override
    public WebElement getButton(String button) {
        throw new IllegalStateException();
    }

    @Override
    public void verifyPageIsLoaded() {
        Assert.assertTrue(Roman_Driver.getDriver().getTitle().contains("Product Details"));
    }

    @Override
    public void closeAddIfPresent() {
        throw new IllegalStateException();
    }

    public void verifyProductDetailsAreVisible() {
        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(productCategory.isDisplayed());
        Assert.assertTrue(productPrice.isDisplayed());
        Assert.assertTrue(productAvailability.isDisplayed());
        Assert.assertTrue(productCondition.isDisplayed());
        Assert.assertTrue(productBrand.isDisplayed());
    }
}
