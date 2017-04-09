Feature: Tigers

  Scenario: A Tiger is created
    Given the Tigers are not initialized
    When before the game begins _TIGER
    Then 2 Tigers are created for each player

  Scenario: Placing a tiger
    Given a Tiger is being placed
    When a player builds _TIGER
    Then decrement the number of Tiger from the player’s total

    Given a Tiger
    When a player enters their build phase
    Then it cannot be placed on a hex that is already occupied by a piece

    Given a player does not have a settlement adjacent to a tile on level 3 with an empty non-volcanic adjacent hex
    When a player tries to place a tiger during the build phase
    Then they will not be allowed to add a tiger

    Given a player does have a settlement adjacent to a tile on level 3 with an empty non-volcanic adjacent hex
    When a player enters their build phase
    Then they can add a Tiger to the empty hex

  Scenario: Adding a Tiger to a Settlement that already has one
    Given a player has a settlement with a Tiger
    When a player tries to add another Tiger to that settlement
    Then they are not allowed to place the Tiger

  Scenario: Attempting to place Tiger on volcano
    Given a terrain that is of type volcano
    When a Tiger tries to occupy the terrain,
    Then tiger will be prohibited from doing so.