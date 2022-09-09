@execute
Feature: Category page

  Scenario Outline: Reach a category page through browsing
    Given I visit the Homepage
    When I browse from "<L0Category>" through "<L1Category>" to "<L2Category>"
    Then I see a grid of sub-categories

    Examples:
      | L0Category                        | L1Category        | L2Category             |
      | Mechanical Products & Tools       | Hand Tools        | Specialist Tools       |
      | Mechanical Products & Tools       | Bearings & Seals  | Linear Motion          |

