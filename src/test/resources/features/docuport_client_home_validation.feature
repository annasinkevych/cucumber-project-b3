Feature: Soft Assertion practice

  @moreSoftAssertion
  Scenario: Docuport Client Home Page Validation
    Given user is on Docuport login page
    Then user validates "Login" text is displayed
    When user enters credentials
      | username | b1g1_client@gmail.com |
      | password | Group1                |
    And user clicks "continue" button
    Then user validate "Home" button is displayed
    Then user validate "mmmmm" button is displayed
    Then user validate "My uploads" button is displayed
    Then user validate "Invitations" button is displayed
    Then user validates all assertions