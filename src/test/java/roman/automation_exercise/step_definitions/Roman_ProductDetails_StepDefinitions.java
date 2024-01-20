package roman.automation_exercise.step_definitions;

import io.cucumber.java.en.And;
import roman.automation_exercise.pages.Roman_ProductDetailsPage;

public class Roman_ProductDetails_StepDefinitions {
    @And("user see all product details: product name, category, price, availability, condition, brand")
    public void userSeeAllProductDetailsProductNameCategoryPriceAvailabilityConditionBrand() {
        var pom = new Roman_ProductDetailsPage();
        pom.verifyProductDetailsAreVisible();
    }
}
