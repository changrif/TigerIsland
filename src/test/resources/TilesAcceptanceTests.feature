Feature: Tiles

  Scenario: Checking proper number of tiles
  Given no tiles have been placed
  When before the first turn
  Then there are 48 tiles

  Given no tiles have been placed
  When before the first turn
  Then there are 3 tiles of each of the 16 terrain combinations

