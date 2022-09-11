@execute
Feature: View the Sub-Category page

  Scenario Outline: Reach a sub-category page through browsing
    Given I visit the Homepage
    When  I browse from "<L0Category>" through "<L1Category>" to "<L2Category>"
    And I select the sub-category "<subCategory>"
    Then I see the sub-category page

    Examples:
      | L0Category                        | L1Category        | L2Category             | subCategory    |
      | Mechanical Products & Tools       | Hand Tools        | Specialist Tools       | Tweezers       |
      | Mechanical Products & Tools       | Bearings & Seals  | Linear Motion          | Linear Bearings|

