package roman.automation_exercise.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import roman.automation_exercise.pages.Roman_ProductDetailsPage;
import roman.automation_exercise.pages.Roman_ProductsPage;

public class Roman_Products_StepDefinitions {
    @And("user see all product details: product name, category, price, availability, condition, brand")
    public void userSeeAllProductDetailsProductNameCategoryPriceAvailabilityConditionBrand() {
        var pom = new Roman_ProductDetailsPage();
        pom.verifyProductDetailsAreVisible();
    }

    @When("user enters {string} in search input")
    public void userEntersInSearchInput(String product) {
        var pom = new Roman_ProductsPage();
        pom.getSearchInput().sendKeys(product);
    }

    @And("user see all products related to search are visible")
    public void userSeeAllProductsRelatedToSearchAreVisible() {
        var pom = new Roman_ProductsPage();
        boolean areRelevantProducts = true;
        for (WebElement productName : pom.getProductNames()) {
            if (!productName.isDisplayed())
                areRelevantProducts = false;
        }

        Assert.assertTrue(areRelevantProducts);
    }
}
