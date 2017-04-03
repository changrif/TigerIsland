Feature: Totoro Sanctuary
  Scenario: Adding a Totoro
    Given a player does not have a settlement of size 5 or larger with an empty non-volcanic adjacent hex
    When a player tries to place a totoro during the build phase
    Then they will not be allowed to add a totoro

    Given a player has a settlement of size 5 or larger with an empty non-volcanic adjacent hex
    When a player enters their build phase
    Then they can add a Totoro to the empty hex

    Given a player that has a certain amount of totoros,
    When he/she places a totoro on the board,
    Then the amount of totoros available to the player decrease by one

  Scenario: Adding a Totoro to a Settlement that already has one
    Given a player has a settlement with a Totoro
    When a player tries to add another Totoro to that settlement
    Then they are not allowed to place the Totoro



