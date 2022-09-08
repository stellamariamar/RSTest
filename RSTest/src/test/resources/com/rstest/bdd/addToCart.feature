@execute
Feature: Using search functionality and adding items to cart
  Scenario Outline: Search for a product and add items to the cart
    Given The user is on the homepage of the website
    When The user enters the "<Product>" description in the search field
    Then The user gets the result page containing matching products with "<Product>"
    And can add items of a selected product to the cart.

    Examples:
      | Product                                       |
      | Raspberry pi 4                                |