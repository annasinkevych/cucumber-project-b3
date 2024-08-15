Feature: Docuport Login Logout Feature

  Background: # Runs like a prerequisite for first step only
    Given user is on Docuport login page


  Scenario: Login as a client

    When user enters username fir client
    And user enters password for client
    And user clicks login button
    Then user should be able to see the homepage for client


  Scenario: Login as an employee
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    Then user should see the home page for employee
    And user is crazy


  Scenario: Login as an advisor
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    Then user should see the home page for advisor


  Scenario: Login as an supervisor
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks login button
    Then user should see the home page for supervisor


  @dataTableMap
  Scenario: Login as a client map practice
    When user enters credentials
      | username | b1g1_client@gmail.com |
      | password | Group1                |
    Then user should see the home page for client