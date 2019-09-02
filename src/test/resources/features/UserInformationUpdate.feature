Feature: User information update

  Scenario: To verify existing user can update account information successfully
    Given User logged in with valid login id and password
    When User go to user settings
    And User update account information
    Then User account information updated successfully