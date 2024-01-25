package roman.automation_exercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import roman.automation_exercise.utils.Roman_Driver;

import java.util.List;

public class Roman_ProductsPage implements Roman_BasePage {

    public Roman_ProductsPage() {
        PageFactory.initElements(Roman_Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement product1_Button;

    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='features_items']/h2")
    private WebElement searchedProductsMessage;

    @FindBy(xpath = "//div[contains(@class, 'productinfo')]/p")
    private List<WebElement> productNames;

    @Override
    public WebElement getMessage(String message) {
        if (message.equals("SEARCHED PRODUCTS"))
            return searchedProductsMessage;
        else
            throw new IllegalStateException();
    }

    @Override
    public WebElement getButton(String button) {
        if (button.equals("view_product"))
            return product1_Button;
        else if (button.equals("search"))
            return searchButton;
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

    public WebElement getSearchInput() {
        return searchInput;
    }

    public List<WebElement> getProductNames() {
        return productNames;
    }
}
