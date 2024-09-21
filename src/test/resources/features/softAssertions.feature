Feature: Practice soft assertions

  @soft
  Scenario: Soft assertions practice
    Given user is on Docuport login page
    Then user validates "mmmm" text is displayed
    Then user validates "Login" text is displayed
#    And user validates "forgot password" text is displayed
    When user enters credentials
      | username | b1g1_client@gmail.com |
      | password | Group1|
    And user validates "Choose account" text is displayed
    And user clicks "continue" button
    And user clicks "home" button
    And user clicks "Invitations" button
    And user validates all assertions