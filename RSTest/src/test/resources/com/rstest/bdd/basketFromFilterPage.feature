
Feature:

  Scenario Outline: Checking out items after adding them to basket from a sorted list of products
    Given I am viewing the products in "<SubCategory>" under "<Category>" for the search term "<Search Term>"
    And I have sorted the results by "<SortBy>", "<SortType>"
    When I add the top product to the basket
    Then I can proceed to checkout and enter my delivery details
      |Title   |Mr.         |
      |Name    |GuestName   |
      |Surname |GuestSurname |
      |Email   |test@test.com|
      |Address |SomeStreet   |
      |Town    |SomeTown     |
      |Postcode|CB23 6FR     |


    Examples:
        |Search Term | SubCategory          | Category            | SortBy            | SortType |
        | Laser Level| Laser Levels         | Measuring & Marking |Price              |  ASC     |
        | Stem Robot | STEM Robot Kits      | STEM education      |Robot Kit Type     |  DESC    |
