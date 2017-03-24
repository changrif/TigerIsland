Feature: Gameboard

  Scenario: The Map has not been created
    Given the board is not initialized
    When the players begin the game
    Then a board data structure should be initialized to empty
