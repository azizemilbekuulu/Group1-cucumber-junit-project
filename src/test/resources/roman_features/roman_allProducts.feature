@Roman
Feature: All products page, list of products, product details

  Background: User launch home page
    Given user is on "home_page"
    Then user see page is loaded

  Scenario: Test Case 8: Verify All Products and product detail page
    When user on "home_page" clicks "products" button
    Then user sees "products_page" page is loaded
    When user on "products_page" clicks "view_product" button
    Then user sees "product_details" page is loaded
    And user see all product details: product name, category, price, availability, condition, brand

