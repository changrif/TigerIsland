Feature: Forming a new settlement

  Scenario: Forming a New Settlement
    Given there is an empty non-volcanic level one hex
    When a player has the option to build
    Then a meeple can be placed on that hex to form a new settlement


    Given there is an empty volcanic level one hex
    When a player can build
    Then a meeple cannot be placed on that hex to form a new settlement