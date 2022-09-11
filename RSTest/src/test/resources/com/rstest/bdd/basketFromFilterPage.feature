@execute
Feature: Add to basket from Filter Page
  Scenario Outline: Select a product and add it to the basket from the Filter Page
    Given I am viewing the products in "<SubCategory>" under "<Category>" for the search term "<Search Term>"
    When I sort by "<SortBy>", "<SortType>"
    Then I can add the top product in my basket

    Examples:
        |Search Term | SubCategory          | Category            | SortBy   | SortType |
        | Laser Level| Laser Levels         | Measuring & Marking |Price     |  ASC     |
        | Stem Robot | STEM Robot Kits      | STEM education      |Robot Kit Type     |  DESC    |
