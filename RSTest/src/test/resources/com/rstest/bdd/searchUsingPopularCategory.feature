@execute
Feature: Search using Popular Categories
  Scenario Outline: Search for a product found in a popular category
    Given I am on the HomePage and I search using the search term "<Search term>"
    And I select the popular category "<popCategory>"
    When I select to see "<NumPerPage>" results on the page
    Then I should see "<NumPerPage>" products on the page, if there are enough

    Examples:
      | Search term   | popCategory         |   NumPerPage |
      | 3D Printer    | 3D Printer Parts    |     100      |
      | 3D Printer    | 3D Printer Software |     50       |
