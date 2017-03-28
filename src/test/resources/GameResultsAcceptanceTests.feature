Feature: Game Result
  Scenario: Inability to Build
    Given a player has Totoros or Tigers left
    When cannot successfully complete their build phase
    Then the player loses the game

  Scenario: Ending a Turn w/o Meeples or Totoro left
    Given a player has no Meeples or Totoro left
    When they successfully complete a build phase
    Then the game ends and scores are calculated, and the player with the higher score wins

  Scenario: Ending a Turn w/o Meeples, but with Totoro left
    Given a game that is in progress
    When the player has no meeples on his/her turn, but has not completed his/her build,
    When the player still has totoro
    Then that player loses
