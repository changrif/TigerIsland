Feature: Settlement Expansion

  Scenario: Expanding a Settlement
    Given there is an adjacent non-volcanic hex to a player’s existing settlement
    When they expand
    Then they must be able to occupy all contiguous hexes of the chosen terrain

    Given a player that has a certain amount of meeples
    When he/she attempts to expand to a terrain
    Then they must have the necessary amount of meeples to expand

    Given a player that has a certain amount of totoros
    When he/she attempts to expand to a terrain adjacent to a settlement of length 5+
    Then they must have the necessary amount of totoros to expand

  Scenario: Adding Meeples to an expansion
    Given a player has enough Meeples left
    When they expand
    Then the must place 1 Meeple per level on each hex

  Scenario: Attempting to expand to non-adjacent terrains
    Given a non-adjacent terrain
    When a meeple tries to expand to the terrain
    Then it will be prohibited from doing so

  Scenario: Successful Expansion
    Given a successful expansion of a settlement
    When a player’s turn has ended
    Then  the settlement size will increase by the number of added territories