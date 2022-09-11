Feature: Logging in to RS Website
  Scenario Outline: Users with valid credentials logging in to website
    Given I have visited the RS login page
    When I enter my "<Username>" and "<Password>"
    And the credentials are correct
    Then I should see the Welcome Page showing my "<Name>"

    Examples:
      | Username        | Password        |   Name     |
      | testaccount001  | testpassword001 |   Testname |
      | randomaccount   | random          |   WhoamI   |
