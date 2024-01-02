Feature: Login

  Scenario: Test Case 1: Register User and delete account

    Given user is on "home_page"
    Then user see page is loaded
    When user on "home_page" click "Signup/Login" button
    Then user on "login_page" see "New User Signup!" message
    When user enters name and email address to signup
    And user on "login_page" click "Signup" button
    Then user on "signup_page" see "ENTER ACCOUNT INFORMATION" message
    When user fill details: Title, Name, Email, Password, Date of birth
    And user on select checkbox "Sign up for our newsletter"
    And user on select checkbox "Receive special offers from our partners!"
    And user fill details: First name, Last name, Company, both Address lines, Country, State, City, Zipcode, Mobile Number
    And user on "signup_page" click "Create Account" button
    Then user on "account_created_page" see "ACCOUNT CREATED!" message
    When user dismiss alert if present
    And user on "account_created_page" click "Continue" button
    And user on "account_created_page" click close add button
    Then user on "home_page" see login confirmation "Logged in as username" message
    When user on "home_page" click "Delete account" button
    Then user on "delete_account_page" see "ACCOUNT DELETED!" message

  Scenario: Test Case 2: Login User with correct email and password
    Given user is on "home_page"
    Then user see page is loaded
    When user on "home_page" click "Signup/Login" button
    Then user on "login_page" see "Login to your account" message
    When user enters "valid" email and password to login
    And user on "login_page" click "Login" button
    Then user on "home_page" see login confirmation "Logged in as username" message




