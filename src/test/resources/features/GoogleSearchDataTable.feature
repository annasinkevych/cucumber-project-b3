Feature: Passing multiple parameters to the same step

  @ann
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searched the following item
      | items         |
      | loop academy |
      | java         |
      | selenium     |
      | cucumber bdd |
      | andrew       |
      | anna         |

    # option + command + L