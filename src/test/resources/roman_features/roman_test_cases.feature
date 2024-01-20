@Roman
Feature: Test cases page

  Background: User launch home page
    Given user is on "home_page"
    Then user see page is loaded

  Scenario: Test Case 7: Verify Test Cases Page
    When user on "home_page" clicks "Test cases" button
    Then user landed to the test_cases_page

