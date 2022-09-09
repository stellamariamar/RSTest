
Feature: Checkout page for guest user
  Scenario Outline: User can checkout after adding to basket
    Given I have a "<Product>" in my basket
    And   I adjust the quantity to <Quantity>
    When I enter my delivery details '<Name>', '<Surname>', '<email>', '<Address>', '<Town>', '<PostCode>'
    Then I can proceed to the payment page

    Examples:
      | Product            | Quantity  | Name   | Surname | email              | Address    | Town     | PostCode |
      | Petzl Head Torch   | 3         | GuestN | GuestS |blank                | SomeStreet |  Sometown| CB23 6FR|
      | Osram UV Light     | 3         | GuestN | GuestS |guest@somewhere.com  | SomeStreet |  Sometown| CB23 6FR|
