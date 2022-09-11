
Feature: Checkout MPN products
  Scenario: Search for products by MPN and checkout
    Given I have a list of products with the following Manufacturer's Part Number

      | K000007      | 2 |
      | MIKROE-512   | 3 |

    And  I add them to the basket
    When I fill in my delivery details
    Then I should be prompted to fill in the payment details.
