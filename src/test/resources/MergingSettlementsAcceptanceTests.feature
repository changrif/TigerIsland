Feature: Merging Settlements
  Scenario: Merging Settlement
    Given a settlement is added next to an adjacent hex of an existing settlement of the same color
    When a player ends their turn
    Then the settlements will merge into one
