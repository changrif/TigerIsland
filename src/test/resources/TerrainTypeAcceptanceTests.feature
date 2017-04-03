Feature: Terrain Types

  Scenario: Comparing adjacent terrains
    Given a type of terrain,
    When the tile has been placed,
    Then it cannot be compared with non-adjacent terrains.

    Given a type of terrain,
    When the tile has been placed,
    Then it can be compared with all adjacent terrains.

  Scenario: Volcano Terrain
    Given a tile that has been created,
    When the tile is placed on the board,
    Then it must contain exactly one volcano terrain.
