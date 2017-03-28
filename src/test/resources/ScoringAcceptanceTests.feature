Feature: Scoring

  Scenario: A Meeple is Placed
    Given a player has placed Meeple(s)
    When they successfully complete a build phase
    Then increment their score by 1 pt per level per Meeple

  Scenario: A Totoro is Placed
    Given a player placed a Totoro
    When they successfully complete a build phase
    Then increment their score by 200 points

  Scenario: A Tiger is Placed
    Given a player placed a Tiger
    When they successfully complete a build phase
    Then increment their score by 75 points
