Feature: Tiles

  Scenario: Checking proper number of tiles
    Given no tiles have been placed
    When before the first turn
    Then there are 48 tiles

    Given no tiles have been placed
    When before the first turn
    Then there are 3 tiles of each of the 16 terrain combinations

  Scenario: Checking correct number of configuration of tiles
    Given there are 48 tiles
    When before the first turn
    When there is more than three tiles of the same type
    Then an exception is thrown

  Scenario: Tile Creation
    Given all the tiles in the deck
    When the game begins
    Then each tile should have 3 hexes with the proper configuration of one volcano and a terrain combination

  Scenario: Placing Tile for the first time
    Given the board is empty
    When a tile is being placed
    Then the tile is placed at the origin, in any orientation

  Scenario: Placing Tile
    Given the board is not empty
    When a tile is being placed not adjacent to another tile
    Then the player will be disqualified

    Given a random tile that is not the first tile,
    When the game is in session,
    Then the tile is prohibited from not being placed adjacent to another tile.

    Given a tile
    When it is placed,
    When it is the 48th tile
    Then the game ends.

    Given there is a fixed number of tiles available
    When they successfully place a tile
    Then that tile should be removed from the list of available tiles / combination type



  Scenario: Placing Tile on level 1
    Given the board is not empty
    When a tile is being placed on level 1
    Then at least one side of the tile being placed must touch an existing tile on the board

  Scenario: Stacking A Tile
    Given the board is not empty and has a valid level 1 configuration
    When a tile is in the process of being stacked
    Then it can be stacked so long as it follows stacking restrictions

    Given the board is not empty and has a valid level 1 configuration
    When a tile is being stacked and
    When it has space beneath it
    Then it is prohibited from being stacked

    Given the board is not empty and has a valid level 1 configuration
    When a tile is being stacked
    When its volcano hex is not over a volcano hex
    Then the tile is prohibited from being stacked

    Given a tile
    When it is placed over an area of the board
    Then the level of that area of the board increases by 1

    Given a tile
    When it is placed over an area of the board
    Then it can not be placed directly over a single tile

    Given a tile
    When it is placed over an area of the board
    Then the tiles being covered must be at the same level

    Given a tile
    When it is placed over an area of the board
    Then it can not cover a size 1 settlement

    Given a tile
    When it is placed over an area of the board
    Then none of the hexes contain a totoro

    Given a tile
    When it is placed over an area of the board
    Then at least one of the hexes must be a volcano

    Given a tile
    When  a player attempts to nuke an area of the board
    Then the volcano terrain of the tile must be placed over a volcano terrain on the board

    Given a tile
    When  a player attempts to nuke an area of the board
    Then it will completely cover the hexes with no blank board space under it

  Scenario: Nuking
    Given a tile
    When  a player attempts to nuke an area of the board that completely overlaps a tile
    Then the player will be prohibited from doing so

    Given a tile
    When  a player attempts to nuke an area of the board that will split a settlement
    Then the new settlement is created
    Then both settlement sizes are updated

    Given a tile
    When  a player attempts to nuke an area of the board that contains a totoro
    Then the player will be prohibited from doing so

    Given a tile
    When  a player attempts to nuke a settlement of size one
    Then the player will be prohibited from doing so

    Given a tile
    When  a player attempts to nuke a settlement of size greater than one
    When  a player attempts to nuke an area of the board that does not contain a totoro
    When  a player attempts to nuke an area of the board that does not completely overlap a tile
    Then the player will not be prohibited from doing so

    Given a tile is being stacked
    When a settlement exists on the tiles being covered
    Then the settlements are destroyed, so the meeples are no longer in play
