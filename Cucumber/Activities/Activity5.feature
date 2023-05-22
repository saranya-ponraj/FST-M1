@activity5
Feature: Data driven test with Example

  Scenario Outline: Testing with Data from Scenario
    Given User3 is on Login page
    When User3 enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message3
    And Close the Browser3

    Examples:
      | Usernames | Passwords |
      | admin     | password  |
      | adminUser | Password  |