@Roman
Feature: All products page, list of products, product details

  Background: User launch home page
    Given user is on "home_page"
    Then user see page is loaded

  Scenario: Test Case 10: Verify Subscription in home page
    When user scrolls down to the footer of the page
    Then user on "home_page" see "SUBSCRIPTION" message
    When user enters email address in email input
    And user on "home_page" clicks "subscribe" button
    Then user on "home_page" see "You have been successfully subscribed!" message

  Scenario: Test Case 11: Verify Subscription in Cart page
    When user on "home_page" clicks "cart" button
    And user scrolls down to the footer of the page
    Then user on "home_page" see "SUBSCRIPTION" message
    When user enters email address in email input
    And user on "home_page" clicks "subscribe" button
    Then user on "home_page" see "You have been successfully subscribed!" message