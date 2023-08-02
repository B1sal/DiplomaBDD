Feature: AdminPage Functionality

  Background:
    Given user opens orange hrm website
    And user enters username Admin and password admin123
    When user clicks on navTab Admin
    Then page title should be text Admin

  @TC-07
  Scenario: Verify that a new user can be added
    When user clicks on add new button
    And user enters userID Alice.Duval23, employeeName David Morris, userRole ESS, status Enabled and password test1234
    And user clicks on save button
    Then user validates new employee record of Alice.Duval23 is added

  @TC-06 @smoke
  Scenario Outline: Verify that the user should be able to use search functionality using valid credentials
    And user enters userID <userName>, employeeName <employeeName>, userRole <role> and status <stat>
    And user clicks on search button
    Then user validates correct employee record of <employeeName> is displayed
    Examples:
      | userName        | employeeName  | role    |   stat    |
      | Alice.Duval23   | David Morris  |  ESS    | Enabled   |
      |                 | David Morris  |  ESS    |           |
      | Alice.Duval23   | David Morris  |         | Enabled   |
      |                 | David Morris  |         |           |

  @TC-09
  Scenario: Verify that existing user record can be edited
    And user clicks on edit button of user Alice.Duval23
    And user renames username to Cassidy Hope
    And user clicks on save button
    Then user validates edited employee record of user Alice Duval

  @TC-08
  Scenario: Verify that an existing user record can be deleted
    And user clicks on delete button of user Alice.Duval23
    Then user validates the successful deletion message

  @TC-10
  Scenario: Verify error messages are displayed if user try to add new user with empty details
    And user clicks on add new button
    And user clicks on save button
    Then user validates all error messages Required are shown while adding new user

  @TC-11
  Scenario Outline: Verify user can filter user records based on their different informations
    When user clicks on search filters <filter> from dropdown menu
    Then user validates selected <filter> page is displayed
    Examples:
      |    filter           |
      |   Job Titles        |
      |   Pay Grades        |
      |   Employment Status |
      |   Job Categories    |
      |   Work Shifts       |
