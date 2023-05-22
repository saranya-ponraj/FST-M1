@activity4
Feature: Data driven test without Example

  Scenario: Testing with Data from Scenario
    Given User2 is on Login page
    When User enters "admin" and "password"
    Then Read the page title and confirmation message2
    And Close the Browser2