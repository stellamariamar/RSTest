@execute
Feature: Filters in search
  Scenario Outline: Search for a product and apply filters to narrow results
    Given I search for a product using the search term "<Search term>"
    And I select the sub category "<SubCategory>" under "<Category>"
    When I apply "<FilterValue1>" and "<FilterValue2>" for the filter "<Filter>"
    Then I should see the search results narrow down.

    Examples:
      | Search term   |Category                     | SubCategory          |   Filter      |  FilterValue1 |  FilterValue2 |
      | head torch    | Torches & Inspection Lamps  | Head Torches         | Range         |  20 m         |  21 m         |
      | pipe          | Pipes & Pipe Fittings       | Plastic Pipe Fittings| Brand         |  Polyplumb    |  RS PRO       |

