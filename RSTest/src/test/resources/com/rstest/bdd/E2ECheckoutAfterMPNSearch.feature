@execute
Feature: Checkout as guest user
  Scenario: User can proceed to payment after entering sufficient delivery details

    Given I have a list of products with the following Manufacturer's Part Numbers in my basket
            | K000007      | 2 |
            | MIKROE-512   | 3 |
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

  Scenario: User cannot proceed to payment with insufficient delivery details
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
    Then I cannot proceed to payment




