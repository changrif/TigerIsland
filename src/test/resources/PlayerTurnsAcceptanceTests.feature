Feature: Player Turns

  Scenario: A player exists
    Given the start of a game
    When two people want to play a game
    Then they should be able to have the role of a player to enter the game

  Scenario: A player is prompted to place a tile
    Given there are still tiles available
    When a player draws a tile
    Then the player must place the tile in a valid spot before executing a build action

  Scenario: A player is prompted to complete a build action
    Given has build actions available
    When a player has just placed a tile
    Then the player must complete the build action before ending their turn

  Scenario: Ending a Turn with Meeples and/or Totoro left
    Given a new settlement is added or expanded
    When a player ends their build phase
    Then the turn ends, settlements are merged (if necessary)

  Scenario: It’s a player’s turn
    Given A player
    When a player made an illegal move
    Then the player loses the game

    Given the start of a game
    When the first player is about to play
    Then the first player will have its turn
    Then the second player will have its turn after the first player completes their turn

  Scenario: Player ends turn
    Given a player 1 and a player 2
    When player 1 has finished his/her turn
    Then it becomes player 2’s turn
