Feature: Login Functionality

  Background:
    Given user opens orange hrm website

  @TC-01 @smoke
  Scenario: Verify that user should be able to login to application using correct username and password
    And user enters username Admin and password admin123

  @TC-02
  Scenario Outline: Verify that user should not be able to login using incorrect username and password
    And user enters username <userName>, password <password> and submit
    Then user validates Invalid credentials error message
    Examples:
      | userName  | password |
      | Admin     | admin    |
      | admin123  | admin123 |
      | test123   | test123  |
      | $$$$$     | &&&&&    |

  @TC-03
  Scenario: Verify error messages are displayed if user try to login with empty username and password
    And user clicks on login button
    Then user validates error messages for missing username and password


  @TC-04
  Scenario: Verify that forgot your password link is working
    When user clicks on forgot your password link
    Then user is redirected to reset password page

  @TC-05
  Scenario: Verify that user can log out of the application
    And user enters username Admin and password admin123
    And user clicks on logout button
    Then user validates that login page is shown again
