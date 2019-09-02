Feature: New User Registration

  Scenario: To validate user is able to register successfully
    Given User is on registration page
    When user register with valid details
    Then User is on homepage