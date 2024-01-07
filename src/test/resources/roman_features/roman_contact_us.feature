@Roman
Feature: Contact Us
  Background: User launch home page
    Given user is on "home_page"
    Then user see page is loaded

  Scenario: Test Case 6: Contact Us Form
    When user on "home_page" click "Contact us" button
    Then user on "contact_us_page" see "GET IN TOUCH" message
    When user on contact_us_page enters name, email, subject and message
    And user on contact us page upload file
    And user on "contact_us_page" click "Submit" button
    And user on contact_us_page page accept alert
    Then user on "contact_us_page" see "Success! Your details have been submitted successfully." message
    When user on "contact_us_page" click "Home" button
    And user click close add button
    Then user landed to the home_page
    
