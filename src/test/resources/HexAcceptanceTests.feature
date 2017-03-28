Feature: Hex

  Scenario: Hex Creation
    Given a hex is created
    When a tile is created
    Then it should have 6 sides

    Given a hex is created
    When a tile is created
    Then it must have one, and only one of the four terrain types
