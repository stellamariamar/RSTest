Feature: Search in RS Website
  Scenario Outline: Browse to a product via Categories
    Given the user is on the homepage
    When the user nagivates from "<Category1>", and "<Category2>", to "<Category3>"
    Then the user should see the products under "<Category3>"

    Examples:
      | Category1      |   Category2    |  Category3    |
      | IT, Test       |   Computing    |  3D Printing  |