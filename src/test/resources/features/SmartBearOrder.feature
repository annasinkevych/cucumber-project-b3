Feature: practice smart bear

  @smartBear
  Scenario Outline: user should be able to place order and order should be seen in page
    Given user is already logged in and navigated to order page
    When user selects product type "<ProductType>"
    And user enters quantity "<Quantity>"
    And user enters customer name "<CustomerName>"
    And user enters street "<Street>"
    And user enters city "<City>"
    And user enters state "<State>"
    And user enters zip "<Zip>"
    And user selects credit card type "<CreditCardType>"
    And user enters credit car number "<CreditCardNumber>"
    And user enters expiration date "<ExpirationDate>"
    And user enters process order button
    Then user should see "<CustomerName>" in the first row of the table

    Examples:
      | ProductType | Quantity | CustomerName | Street           | City      | State    | Zip   | CreditCardType   | CreditCardNumber | ExpirationDate |
      | FamilyAlbum | 2        | Chuck Norris | 1100 Long way dr | Chantilly | Virginia | 22011 | American Express | 1111222233334444 | 12/25          |
      | ScreenSaver | 5        | Bruce Lee    | 123 Dragon Rd    | Hollywood | Florida  | 33021 | Visa             | 5555666677778888 | 08/24          |