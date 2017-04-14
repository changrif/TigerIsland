# TigerIsland Team_I
TigerIsland is a two-player tile-placement game. Players alternate turns placing tiles and building until one player either forfeits or a player wins by placing all of two types of pieces.

*Members:* Kyle Griffey (KGriffey), Charles 'Chandler' Griffin (changrif), Nicholas Kroeger (kroegern1), David Machin (git4Dave), Michelle Palumbo (mpalumbo6), Aizey Pineda (az2cool)

## Game Functionality

The following **required** functionality is completed:

- [X] The Board, Tiles (including the unique first tile), Hexes, Terrains, Meeples, Totoros, Tigers, Players, PlayerBrain(AI), Settlements, Client (+ String Parser code), and related exceptions to check for invalid placements has been implemented. 
- [X] Unit Tests run with coverage cover: 83% of classes
- [X] Acceptance Tests run with coverage cover: 100% of classes 

(*NOTE*: IntelliJ says 56% coverage on Acceptance tests, but these include depreciated classes and source code related to the server, which is not relevant to acceptance tests. All relevant classes/lines run with coverage of 100%)

## AI Functionality

The following **required** functionality is completed:

- [X] The AI places Meeples, Tigers, and Totoro with an emphasis on Tigers and Meeples.
- [X] The AI stacks/nukes tiles building upwards and places tiles on level one with an emphasis on stacking (to get to level 3).
- [X] The AI makes sure it does not prevent itself from building by checking available build actions before placing a tile.
- [X] The AI plays itself both in unit tests (see BrainBuildActionTests) and client-server tests where one of the AI implementations always wins, there is never a forfeit.

(*NOTE*: On Monday, we finished in last place timing out of every game. This is Friday's tournament scoreboard where we are listed as the highest scoring team by placing all of our Tigers and Meeples in multiple games.)

## Server Functionality

The following **required** functionality is completed:
- [X] The client is fully functional and parses all server input for multiple rounds and challenges. Strings are parsed in the class, String Parser. The client communicates with the server in TournamentClient and PlayerBrain (our AI). We ran without any exceptions or bugs in Friday's implementation of the tournament.

## Non-implemented Functionality

The following **required** functionality has **NOT** been completed:

- [X] All known functionality has been implemented to the best of our knowledge.
