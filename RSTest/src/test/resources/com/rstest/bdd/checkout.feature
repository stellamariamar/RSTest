
Feature: Checkout as guest user
  Scenario: User can checkout after adding products to basket
    Given I have a product with MPN 'ABX00042' in my basket
    When I proceed to checkout as a guest
    And  I enter my delivery details:
            |Title   | Mr.         |
            |Name    | GuestName   |
            |Surname |GuestSurname |
            |Email   |test@test.com|
            |Address |SomeStreet   |
            |Town    |SomeTown     |
            |Postcode|CB23 6FR     |
    Then I can fill in my payment details


  Scenario: User can checkout after adding products to basket
    Given I have a product with MPN 'ABX00042' in my basket
    When I proceed to checkout as a guest
    And  I enter my delivery details:
            |Title   | Mr.         |
            |Name    | GuestName   |
            |Surname |GuestSurname |
            |Email   |Random       |
            |Address |SomeStreet   |
            |Town    |SomeTown     |
            |Postcode|CB23 6FR     |
    Then I can fill in my payment details




