Feature: Forming a new settlement

  Scenario: Forming a New Settlement
    Given there is an empty non-volcanic level 1 hex
    When a player enters their build phase
    Then they can add a Meeple to that hex to form a new settlement
