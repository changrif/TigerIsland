Feature: String Parser
  Scenario: A message is received by the player
    Given A message is sent by the server
    When it contain an opponent's move
    Then  the move will be parsed

    When it contains the state of the game
    Then the state will be parsed

    When it contains a forfeit
    Then the forfeit will be parsed

    When it contains a playerID for both players
    Then it parses the PlayerID

    When it contains a ChallengeID
    Then it parses the ChallengeID

    When it contains the RoundID
    Then It parses the RoundID

    When it contains the number of Rounds
    Then it parses the number of rounds

    When it contains the GameID
    Then it parses the GameID

    When it contains an Opponent ID
    Then the opponentID is parsed

    When a string array needs to be merged into a string
    Then it is merged into a string

    When it contains a build option
    Then it parses the build option

    When it contains a tile orientation
    Then it parses the tile orientation

    When it contains a TileID
    Then it parses the TileID

    When it contains a Terrain
    Then it parses the Terrain

    When it Contains coordinates
    Then it parses the coordinates

    When it contains the score for both players and status
    Then it parses the score and game status

    When the game ends and it sends playerID
    Then it parses the ID for the end game

