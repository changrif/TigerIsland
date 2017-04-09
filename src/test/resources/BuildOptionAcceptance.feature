Feature: Build Option
  Scenario: The Player is Choosing a Build Option
    Given It is a players turn
    When a player chooses a build option
    Then the correct build option will be chosen