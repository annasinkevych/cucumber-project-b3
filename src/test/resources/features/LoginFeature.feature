Feature: Docuport Login Logout Feature


 @smoke
 Scenario: Login as a client
   Given user is on Docuport login page
   When user enters username fir client
   And user enters password for client
   And user clicks login button
   Then user should be able to see the homepage for client

@smoke
  Scenario: Login as an employee
    Given user is on Docuport login page
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    Then user should see the home page for employee