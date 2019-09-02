Feature: Login/Log off

  Scenario: To verify existing user can login into the application successfully
    When User logged in with valid login id and password
    Then User is on homepage

  Scenario: To verify user can log off from the application successfully
    Given User logged in with valid login id and password
    When User log off from the application
    Then User is on welcome page
