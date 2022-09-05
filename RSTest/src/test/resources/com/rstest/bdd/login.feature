Feature: Logging in to RS Website
  Scenario Outline: Users with valid credentials logging in to website
    Given I have visited the RS login page
    When I enter my "<Username>" and "<Password>"
    And the credentials are correct
    Then I should see the user's name "<Name>"

    Examples:
      | Username        | Password        |   Name     |
      | testaccount001  | testpassword001 |   Testname |
      | dummyuser       | dummypass       |   Dummy    |