
Feature: Search in RS Website
  Scenario Outline: Search for a product using filters
    Given The user enters a "<Search term>" in the search field
    And The user selects the category "<Category>"
    When The user selects "<FilterValue1>" and "<FilterValue2>" for the filter "<Filter>"
    Then The user should see <NoOfProducts> products in the Results

    Examples:
    | Search term   | Category                     |   Filter                |  FilterValue1 |  FilterValue2 | NoOfProducts  |
    | pipe          | Hose Connectors              | Hose Inner Diameter     |  3mm          |   5mm         | 8             |
    | pipe          | Malleable Iron Pipe Fittings | Thread Size 1           |  1in          |   2in         | 71            |