Feature: Merging Settlements
  Scenario: Merging Settlement
    Given a settlement is added next to an adjacent hex of an existing settlement of the same color
    When a player ends their turn
    Then the settlements will merge into one

    Given a settlement is not added next to an adjacent hex of an existing settlement of the same player
    When a players turn ends
    Then the settlements will not merge into one

    Given a settlement is added next to an adjacent hex of an existing settlement of a different player
    When a players finishes their turn
    Then the settlements will not be merged