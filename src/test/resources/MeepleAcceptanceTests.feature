Feature: Meeples

  Scenario: A Meeple is created
    Given the Meeples are not initialized
    When before the game begins
    Then 20 Meeples are created for each player

  Scenario: Placing a meeple
    Given a meeple
    When a player enters their build phase
    Then it can be placed on a habitable terrain

    Given a meeple
    When a player enters their build phase
    Then it cannot be placed on a volcano terrain

    Given a Meeple is being placed
    When a player builds
    Then decrement the number of Meeples from the player’s total

    Given a meeple
    When a player enters their build phase
    Then it cannot be placed on a hex that is already occupied by meeples

  Scenario: Attempting to place meeple on volcano
    Given a terrain that is of type volcano,
    When a meeple tries to occupy the terrain,
    Then it will be prohibited from doing so.
