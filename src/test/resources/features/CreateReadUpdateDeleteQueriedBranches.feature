Feature: Create, Read, Update, Delete, Queried Branches

  Background:
    Given User logged in with valid login id and password
    When User navigate to Branch

  Scenario: To verify user can create new branch successfully
    And User create new branch
    Then User see new branch created successfully

  Scenario: To verify user can view existing branch
    And User view existing branch
    Then User see branch details

  Scenario: To verify user can edit existing branch
    And User edit existing branch
    Then User see updated branch details

  Scenario: To verify user can delete existing branch
    And User delete existing branch
    Then User can not see that branch in branches

  Scenario: To verify user can search existing branch
    And User search existing branch
    Then User can see only that branch in branches