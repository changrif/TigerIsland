Feature: Hex

  Scenario: Hex Creation
    Given a hex is created
    When a tile is initially created
    Then it should have 6 sides

    Given a hex has been created
    When a tile has just been created
    Then it must have one, and only one of the five terrain types
