Feature: DashboardPage Functionality

  Background:
    Given user opens orange hrm website
    And user enters username Admin and password admin123
    Then page title should be text Dashboard

  @TC-13
  Scenario Outline: Verify that all the informational sections are displayed
    Then user validates all the info sections <sectionTitle> are displayed
    Examples:
      |  sectionTitle                      |
      |  Time at Work                      |
      |  My Actions                        |
      |  Quick Launch                      |
      |  Buzz Latest Posts                 |
      |  Employees on Leave Today          |
      |  Employee Distribution by Sub Unit |
      |  Employee Distribution by Sub Unit |

  @TC-14
  Scenario: Verify that help button is working properly
    When user clicks on help button
    Then user should be redirected to help page

  @TC-15
  Scenario: Verify that About popup page is shown properly
    When user clicks on About option
    Then user validates About popup is displayed