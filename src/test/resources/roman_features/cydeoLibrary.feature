Feature: testing webelements
  Scenario: wrong email
    When user inputs wrong email format
    Then user see invalid email error message

  Scenario: no password provided
    When user doesn't input password
    Then user see enter correct password error message

  Scenario:
