$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BuildTotoroSanctuaryAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Totoro Sanctuary",
  "description": "",
  "id": "totoro-sanctuary",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Adding a Totoro",
  "description": "",
  "id": "totoro-sanctuary;adding-a-totoro",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "a player does not have a settlement of size 5 or larger with an empty non-volcanic adjacent hex",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "a player tries to place a totoro during the build phase",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "they will not be allowed to add a totoro",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "a player has a settlement of size 5 or larger with an empty non-volcanic adjacent hex",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "a player enters their build phase",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "they can add a Totoro to the empty hex",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "a player that has a certain amount of totoros,",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "he/she places a totoro on the board,",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the amount of totoros available to the player decrease by one",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 15,
  "name": "Adding a Totoro to a Settlement that already has one",
  "description": "",
  "id": "totoro-sanctuary;adding-a-totoro-to-a-settlement-that-already-has-one",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "a player has a settlement with a Totoro",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "a player tries to add another Totoro to that settlement",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "they are not allowed to place the Totoro",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("ExpandingASettlementAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Settlement Expansion",
  "description": "",
  "id": "settlement-expansion",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Expanding a Settlement",
  "description": "",
  "id": "settlement-expansion;expanding-a-settlement",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "there is an adjacent non-volcanic hex to a player’s existing settlement",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "they expand",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "they must be able to occupy all contiguous hexes of the chosen terrain",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "a player that has a certain amount of meeples",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he/she attempts to expand to a terrain",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "they must have the necessary amount of meeples to expand",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "a player that has a certain amount of totoros",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "he/she attempts to expand to a terrain adjacent to a settlement of length 5+",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "they must have the necessary amount of totoros to expand",
  "keyword": "Then "
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.there_is_an_adjacent_non_volcanic_hex_to_a_player_s_existing_settlement()"
});
formatter.result({
  "duration": 190644181,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat ExpandingASettlementAcceptanceTests.there_is_an_adjacent_non_volcanic_hex_to_a_player_s_existing_settlement(ExpandingASettlementAcceptanceTests.java:14)\n\tat ✽.Given there is an adjacent non-volcanic hex to a player’s existing settlement(ExpandingASettlementAcceptanceTests.feature:4)\n",
  "status": "pending"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_expand()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_must_be_able_to_occupy_all_contiguous_hexes_of_the_chosen_terrain()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_player_that_has_a_certain_amount_of_meeples()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.he_she_attempts_to_expand_to_a_terrain()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_must_have_the_necessary_amount_of_meeples_to_expand()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_player_that_has_a_certain_amount_of_totoros()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 74
    }
  ],
  "location": "ExpandingASettlementAcceptanceTests.he_she_attempts_to_expand_to_a_terrain_adjacent_to_a_settlement_of_length(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_must_have_the_necessary_amount_of_totoros_to_expand()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 16,
  "name": "Adding Meeples to an expansion",
  "description": "",
  "id": "settlement-expansion;adding-meeples-to-an-expansion",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "a player has enough Meeples left",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "they expand",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "the must place 1 Meeple per level on each hex",
  "keyword": "Then "
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_player_has_enough_Meeples_left()"
});
formatter.result({
  "duration": 428489,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat ExpandingASettlementAcceptanceTests.a_player_has_enough_Meeples_left(ExpandingASettlementAcceptanceTests.java:68)\n\tat ✽.Given a player has enough Meeples left(ExpandingASettlementAcceptanceTests.feature:17)\n",
  "status": "pending"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_expand()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 15
    }
  ],
  "location": "ExpandingASettlementAcceptanceTests.the_must_place_Meeple_per_level_on_each_hex(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 21,
  "name": "Attempting to expand to non-adjacent terrains",
  "description": "",
  "id": "settlement-expansion;attempting-to-expand-to-non-adjacent-terrains",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "a non-adjacent terrain",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "a meeple tries to expand to the terrain",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "it will be prohibited from doing so",
  "keyword": "Then "
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_non_adjacent_terrain()"
});
formatter.result({
  "duration": 513404,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat ExpandingASettlementAcceptanceTests.a_non_adjacent_terrain(ExpandingASettlementAcceptanceTests.java:80)\n\tat ✽.Given a non-adjacent terrain(ExpandingASettlementAcceptanceTests.feature:22)\n",
  "status": "pending"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_meeple_tries_to_expand_to_the_terrain()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.it_will_be_prohibited_from_doing_so()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 26,
  "name": "Successful Expansion",
  "description": "",
  "id": "settlement-expansion;successful-expansion",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 27,
  "name": "a successful expansion of a settlement",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "a player’s turn has ended",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "the settlement size will increase by the number of added territories",
  "keyword": "Then "
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_successful_expansion_of_a_settlement()"
});
formatter.result({
  "duration": 442776,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat ExpandingASettlementAcceptanceTests.a_successful_expansion_of_a_settlement(ExpandingASettlementAcceptanceTests.java:98)\n\tat ✽.Given a successful expansion of a settlement(ExpandingASettlementAcceptanceTests.feature:27)\n",
  "status": "pending"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_player_s_turn_has_ended()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.the_settlement_size_will_increase_by_the_number_of_added_territories()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("FoundingANewSettlement.feature");
formatter.feature({
  "line": 1,
  "name": "Forming a new settlement",
  "description": "",
  "id": "forming-a-new-settlement",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Forming a New Settlement",
  "description": "",
  "id": "forming-a-new-settlement;forming-a-new-settlement",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "there is an empty non-volcanic level one hex",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "a player has the option to build",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "a meeple can be placed on that hex to form a new settlement",
  "keyword": "Then "
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.there_is_an_empty_non_volcanic_level_one_hex()"
});
formatter.result({
  "duration": 154040,
  "status": "passed"
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.a_player_has_the_option_to_build()"
});
formatter.result({
  "duration": 37421,
  "status": "passed"
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.they_can_add_a_Meeple_to_that_hex_to_form_a_new_settlement()"
});
formatter.result({
  "duration": 16370758,
  "error_message": "InvalidTilePlacement\n\tat Map.placeTile(Map.java:37)\n\tat FoundingANewSettlementAcceptanceTests.they_can_add_a_Meeple_to_that_hex_to_form_a_new_settlement(FoundingANewSettlementAcceptanceTests.java:33)\n\tat ✽.Then a meeple can be placed on that hex to form a new settlement(FoundingANewSettlement.feature:6)\n",
  "status": "failed"
});
formatter.uri("GameResultsAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Game Result",
  "description": "",
  "id": "game-result",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Inability to Build",
  "description": "",
  "id": "game-result;inability-to-build",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "a player has Totoros or Tigers left",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "cannot successfully complete their build phase",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the player loses the game",
  "keyword": "Then "
});
formatter.match({
  "location": "GameResultAcceptanceTests.a_player_has_Totoros_or_Tigers_left()"
});
formatter.result({
  "duration": 314637,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat GameResultAcceptanceTests.a_player_has_Totoros_or_Tigers_left(GameResultAcceptanceTests.java:13)\n\tat ✽.Given a player has Totoros or Tigers left(GameResultsAcceptanceTests.feature:3)\n",
  "status": "pending"
});
formatter.match({
  "location": "GameResultAcceptanceTests.cannot_successfully_complete_their_build_phase()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GameResultAcceptanceTests.the_player_loses_the_game()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 7,
  "name": "Ending a Turn w/o Meeples or Totoro left",
  "description": "",
  "id": "game-result;ending-a-turn-w/o-meeples-or-totoro-left",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "a player has no Meeples or Totoro left",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "they successfully complete a build phase",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the game ends and scores are calculated, and the player with the higher score wins",
  "keyword": "Then "
});
formatter.match({
  "location": "GameResultAcceptanceTests.a_player_has_no_Meeples_or_Totoro_left()"
});
formatter.result({
  "duration": 645521,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat GameResultAcceptanceTests.a_player_has_no_Meeples_or_Totoro_left(GameResultAcceptanceTests.java:31)\n\tat ✽.Given a player has no Meeples or Totoro left(GameResultsAcceptanceTests.feature:8)\n",
  "status": "pending"
});
formatter.match({
  "location": "GameResultAcceptanceTests.they_successfully_complete_a_build_phase()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GameResultAcceptanceTests.the_game_ends_and_scores_are_calculated_and_the_player_with_the_higher_score_wins()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 12,
  "name": "Ending a Turn w/o Meeples, but with Totoro left",
  "description": "",
  "id": "game-result;ending-a-turn-w/o-meeples,-but-with-totoro-left",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "a game that is in progress",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the player has no meeples on his/her turn, but has not completed his/her build,",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the player still has totoro",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "that player loses",
  "keyword": "Then "
});
formatter.match({
  "location": "GameResultAcceptanceTests.a_game_that_is_in_progress()"
});
formatter.result({
  "duration": 430506,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat GameResultAcceptanceTests.a_game_that_is_in_progress(GameResultAcceptanceTests.java:49)\n\tat ✽.Given a game that is in progress(GameResultsAcceptanceTests.feature:13)\n",
  "status": "pending"
});
formatter.match({
  "location": "GameResultAcceptanceTests.the_player_has_no_meeples_on_his_her_turn_but_has_not_completed_his_her_build()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GameResultAcceptanceTests.the_player_still_has_totoro()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GameResultAcceptanceTests.that_player_loses()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("HexAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Hex",
  "description": "",
  "id": "hex",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Hex Creation",
  "description": "",
  "id": "hex;hex-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "a hex is created",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "a tile is initially created",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "it should have 6 sides",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "a hex has been created",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "a tile has just been created",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "it must have one, and only one of the five terrain types",
  "keyword": "Then "
});
formatter.match({
  "location": "HexAcceptanceTests.a_hex_is_created()"
});
formatter.result({
  "duration": 184967,
  "status": "passed"
});
formatter.match({
  "location": "HexAcceptanceTests.a_tile_is_created()"
});
formatter.result({
  "duration": 72268,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 15
    }
  ],
  "location": "HexAcceptanceTests.it_should_have_sides(int)"
});
formatter.result({
  "duration": 7180651,
  "status": "passed"
});
formatter.match({
  "location": "HexAcceptanceTests.a_hex_has__been_created()"
});
formatter.result({
  "duration": 50129,
  "status": "passed"
});
formatter.match({
  "location": "HexAcceptanceTests.a_tile_has_been_created()"
});
formatter.result({
  "duration": 81809,
  "status": "passed"
});
formatter.match({
  "location": "HexAcceptanceTests.it_must_have_one_and_only_one_of_the_five_terrain_types()"
});
formatter.result({
  "duration": 250744,
  "status": "passed"
});
formatter.uri("MapAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Gameboard",
  "description": "",
  "id": "gameboard",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "The Map has not been created",
  "description": "",
  "id": "gameboard;the-map-has-not-been-created",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the board is not initialized",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the players begin the game",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "a board data structure should be initialized to empty",
  "keyword": "Then "
});
formatter.match({
  "location": "MapAcceptanceTests.the_board_is_not_initialized()"
});
formatter.result({
  "duration": 179785,
  "status": "passed"
});
formatter.match({
  "location": "MapAcceptanceTests.the_players_begin_the_game()"
});
formatter.result({
  "duration": 57145,
  "status": "passed"
});
formatter.match({
  "location": "MapAcceptanceTests.a_board_data_structure_should_be_initialized_to_empty()"
});
formatter.result({
  "duration": 179135807,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Board Creation",
  "description": "",
  "id": "gameboard;board-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "the board is not initialized",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "the players begin the game",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "a board data structure containing data will produce errors.",
  "keyword": "Then "
});
formatter.match({
  "location": "MapAcceptanceTests.the_board_is_not_initialized()"
});
formatter.result({
  "duration": 33060,
  "status": "passed"
});
formatter.match({
  "location": "MapAcceptanceTests.the_players_begin_the_game()"
});
formatter.result({
  "duration": 12885,
  "status": "passed"
});
formatter.match({
  "location": "MapAcceptanceTests.a_board_data_structure_containing_data_will_produce_errors()"
});
formatter.result({
  "duration": 9210737,
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat MapAcceptanceTests.a_board_data_structure_containing_data_will_produce_errors(MapAcceptanceTests.java:45)\n\tat ✽.Then a board data structure containing data will produce errors.(MapAcceptanceTests.feature:11)\n",
  "status": "failed"
});
formatter.uri("MeepleAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Meeples",
  "description": "",
  "id": "meeples",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "A Meeple is created",
  "description": "",
  "id": "meeples;a-meeple-is-created",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the Meeples are not initialized",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "before the game begins",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "20 Meeples are created for each player",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 8,
  "name": "Placing a meeple",
  "description": "",
  "id": "meeples;placing-a-meeple",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "a meeple",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "a player enters their build phase",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "it can be placed on a habitable terrain",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "a meeple",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "a player enters their build phase",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "it cannot be placed on a volcano terrain",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "a Meeple is being placed",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "a player builds",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "decrement the number of Meeples from the player’s total",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "a meeple",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "a player enters their build phase",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "it cannot be placed on a hex that is already occupied by meeples",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 25,
  "name": "Attempting to place meeple on volcano",
  "description": "",
  "id": "meeples;attempting-to-place-meeple-on-volcano",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "a terrain that is of type volcano,",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "a meeple tries to occupy the terrain,",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "it will be prohibited from doing so.",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("MergingSettlementsAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Merging Settlements",
  "description": "",
  "id": "merging-settlements",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Merging Settlement",
  "description": "",
  "id": "merging-settlements;merging-settlement",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "a settlement is added next to an adjacent hex of an existing settlement of the same color",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "a player ends their turn",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the settlements will merge into one",
  "keyword": "Then "
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.a_settlement_is_added_next_to_an_adjacent_hex_of_an_existing_settlement_of_the_same_color()"
});
formatter.result({
  "duration": 656777,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat MergingSettlementsAcceptanceTests.a_settlement_is_added_next_to_an_adjacent_hex_of_an_existing_settlement_of_the_same_color(MergingSettlementsAcceptanceTests.java:13)\n\tat ✽.Given a settlement is added next to an adjacent hex of an existing settlement of the same color(MergingSettlementsAcceptanceTests.feature:3)\n",
  "status": "pending"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.a_player_ends_their_turn()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.the_settlements_will_merge_into_one()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("PlayerTurnsAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Player Turns",
  "description": "",
  "id": "player-turns",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "A player exists",
  "description": "",
  "id": "player-turns;a-player-exists",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the start of a game",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "two people want to play a game",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "they should be able to have the role of a player to enter the game",
  "keyword": "Then "
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_start_of_a_game()"
});
formatter.result({
  "duration": 642023,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat PlayerTurnsAcceptanceTests.the_start_of_a_game(PlayerTurnsAcceptanceTests.java:14)\n\tat ✽.Given the start of a game(PlayerTurnsAcceptanceTests.feature:4)\n",
  "status": "pending"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.two_people_want_to_play_a_game()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.they_should_be_able_to_have_the_role_of_a_player_to_enter_the_game()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 8,
  "name": "A player is prompted to place a tile",
  "description": "",
  "id": "player-turns;a-player-is-prompted-to-place-a-tile",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "there are still tiles available",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "a player draws a tile",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the player must place the tile in a valid spot before executing a build action",
  "keyword": "Then "
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.there_are_still_tiles_available()"
});
formatter.result({
  "duration": 551336,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat PlayerTurnsAcceptanceTests.there_are_still_tiles_available(PlayerTurnsAcceptanceTests.java:32)\n\tat ✽.Given there are still tiles available(PlayerTurnsAcceptanceTests.feature:9)\n",
  "status": "pending"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_player_draws_a_tile()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_player_must_place_the_tile_in_a_valid_spot_before_executing_a_build_action()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 13,
  "name": "A player is prompted to complete a build action",
  "description": "",
  "id": "player-turns;a-player-is-prompted-to-complete-a-build-action",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "has build actions available",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "a player has just placed a tile",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the player must complete the build action before ending their turn",
  "keyword": "Then "
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.has_build_actions_available()"
});
formatter.result({
  "duration": 464278,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat PlayerTurnsAcceptanceTests.has_build_actions_available(PlayerTurnsAcceptanceTests.java:50)\n\tat ✽.Given has build actions available(PlayerTurnsAcceptanceTests.feature:14)\n",
  "status": "pending"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_player_has_just_placed_a_tile()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_player_must_complete_the_build_action_before_ending_their_turn()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 18,
  "name": "Ending a Turn with Meeples and/or Totoro left",
  "description": "",
  "id": "player-turns;ending-a-turn-with-meeples-and/or-totoro-left",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "a new settlement is added or expanded",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "a player ends their build phase",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the turn ends, settlements are merged (if necessary)",
  "keyword": "Then "
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_new_settlement_is_added_or_expanded()"
});
formatter.result({
  "duration": 558872,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat PlayerTurnsAcceptanceTests.a_new_settlement_is_added_or_expanded(PlayerTurnsAcceptanceTests.java:68)\n\tat ✽.Given a new settlement is added or expanded(PlayerTurnsAcceptanceTests.feature:19)\n",
  "status": "pending"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_player_ends_their_build_phase()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_turn_ends_settlements_are_merged_if_necessary()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 23,
  "name": "It’s a player’s turn",
  "description": "",
  "id": "player-turns;it’s-a-player’s-turn",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "A player",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "a player made an illegal move",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "the player loses the game",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the start of a game",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "the first player is about to play",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "the first player will have its turn",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "the second player will have its turn after the first player completes their turn",
  "keyword": "Then "
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_player()"
});
formatter.result({
  "duration": 460590,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat PlayerTurnsAcceptanceTests.a_player(PlayerTurnsAcceptanceTests.java:86)\n\tat ✽.Given A player(PlayerTurnsAcceptanceTests.feature:24)\n",
  "status": "pending"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_player_made_an_illegal_move()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GameResultAcceptanceTests.the_player_loses_the_game()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_start_of_a_game()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_first_player_is_about_to_play()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_first_player_will_have_its_turn()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_second_player_will_have_its_turn_after_the_first_player_completes_their_turn()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 33,
  "name": "Player ends turn",
  "description": "",
  "id": "player-turns;player-ends-turn",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 34,
  "name": "a player 1 and a player 2",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "player 1 has finished his/her turn",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "it becomes player 2’s turn",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 9
    },
    {
      "val": "2",
      "offset": 24
    }
  ],
  "location": "PlayerTurnsAcceptanceTests.a_player_and_a_player(int,int)"
});
formatter.result({
  "duration": 879346,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat PlayerTurnsAcceptanceTests.a_player_and_a_player(PlayerTurnsAcceptanceTests.java:116)\n\tat ✽.Given a player 1 and a player 2(PlayerTurnsAcceptanceTests.feature:34)\n",
  "status": "pending"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 7
    }
  ],
  "location": "PlayerTurnsAcceptanceTests.player_has_finished_his_her_turn(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 18
    }
  ],
  "location": "PlayerTurnsAcceptanceTests.it_becomes_player_s_turn(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("ScoringAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Scoring",
  "description": "",
  "id": "scoring",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "A Meeple is Placed",
  "description": "",
  "id": "scoring;a-meeple-is-placed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "a player has placed Meeple(s)",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "they successfully complete a build phase",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "increment their score by 1 pt per level per Meeple",
  "keyword": "Then "
});
formatter.match({
  "location": "ScoringAcceptanceTests.a_player_has_placed_Meeple_s()"
});
formatter.result({
  "duration": 646238,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat ScoringAcceptanceTests.a_player_has_placed_Meeple_s(ScoringAcceptanceTests.java:13)\n\tat ✽.Given a player has placed Meeple(s)(ScoringAcceptanceTests.feature:4)\n",
  "status": "pending"
});
formatter.match({
  "location": "GameResultAcceptanceTests.they_successfully_complete_a_build_phase()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 25
    }
  ],
  "location": "ScoringAcceptanceTests.increment_their_score_by_pt_per_level_per_Meeple(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 8,
  "name": "A Totoro is Placed",
  "description": "",
  "id": "scoring;a-totoro-is-placed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "a player placed a Totoro",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "they successfully complete a build phase",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "increment their score by 200 points",
  "keyword": "Then "
});
formatter.match({
  "location": "ScoringAcceptanceTests.a_player_placed_a_Totoro()"
});
formatter.result({
  "duration": 500795,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat ScoringAcceptanceTests.a_player_placed_a_Totoro(ScoringAcceptanceTests.java:25)\n\tat ✽.Given a player placed a Totoro(ScoringAcceptanceTests.feature:9)\n",
  "status": "pending"
});
formatter.match({
  "location": "GameResultAcceptanceTests.they_successfully_complete_a_build_phase()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 25
    }
  ],
  "location": "ScoringAcceptanceTests.increment_their_score_by_points(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 13,
  "name": "A Tiger is Placed",
  "description": "",
  "id": "scoring;a-tiger-is-placed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "a player placed a Tiger",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "they successfully complete a build phase",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "increment their score by 75 points",
  "keyword": "Then "
});
formatter.match({
  "location": "ScoringAcceptanceTests.a_player_placed_a_Tiger()"
});
formatter.result({
  "duration": 656088,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat ScoringAcceptanceTests.a_player_placed_a_Tiger(ScoringAcceptanceTests.java:37)\n\tat ✽.Given a player placed a Tiger(ScoringAcceptanceTests.feature:14)\n",
  "status": "pending"
});
formatter.match({
  "location": "GameResultAcceptanceTests.they_successfully_complete_a_build_phase()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "75",
      "offset": 25
    }
  ],
  "location": "ScoringAcceptanceTests.increment_their_score_by_points(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("TerrainTypeAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Terrain Types",
  "description": "",
  "id": "terrain-types",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Comparing adjacent terrains",
  "description": "",
  "id": "terrain-types;comparing-adjacent-terrains",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "a type of terrain,",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the tile has been placed,",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "it cannot be compared with non-adjacent terrains.",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "a type of terrain,",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the tile has been placed,",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "it can be compared with all adjacent terrains.",
  "keyword": "Then "
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.a_type_of_terrain()"
});
formatter.result({
  "duration": 706146,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat TerrainTypesAcceptanceTests.a_type_of_terrain(TerrainTypesAcceptanceTests.java:15)\n\tat ✽.Given a type of terrain,(TerrainTypeAcceptanceTests.feature:4)\n",
  "status": "pending"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.the_tile_has_been_placed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.it_cannot_be_compared_with_non_adjacent_terrains()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.a_type_of_terrain()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.the_tile_has_been_placed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.it_can_be_compared_with_all_adjacent_terrains()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 12,
  "name": "Volcano Terrain",
  "description": "",
  "id": "terrain-types;volcano-terrain",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "a tile that has been created,",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the tile is placed on the board,",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "it must contain exactly one volcano terrain.",
  "keyword": "Then "
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.a_tilePiece()"
});
formatter.result({
  "duration": 114601,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.the_tile_is_placed_on_the_board()"
});
formatter.result({
  "duration": 53257,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.it_must_contain_one_and_only_one_volcano_terrain()"
});
formatter.result({
  "duration": 408989,
  "status": "passed"
});
formatter.uri("TilesAcceptanceTests.feature");
formatter.feature({
  "line": 1,
  "name": "Tiles",
  "description": "",
  "id": "tiles",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Checking proper number of tiles",
  "description": "",
  "id": "tiles;checking-proper-number-of-tiles",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "no tiles have been placed",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "before the first turn",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "there are 48 tiles",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "no tiles have been placed",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "before the first turn",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "there are 3 tiles of each of the 16 terrain combinations",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 12,
  "name": "Checking correct number of configuration of tiles",
  "description": "",
  "id": "tiles;checking-correct-number-of-configuration-of-tiles",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "there are 48 tiles",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "before the first turn",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "there is more than three tiles of the same type",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "an exception is thrown",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 18,
  "name": "Tile Creation",
  "description": "",
  "id": "tiles;tile-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "all the tiles in the deck",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "the game begins",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "each tile should have 3 hexes with the proper configuration of one volcano and a terrain combination",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 23,
  "name": "Placing Tile for the first time",
  "description": "",
  "id": "tiles;placing-tile-for-the-first-time",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "the board is empty",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "a tile is being placed",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "the tile is placed at the origin, in any orientation",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 28,
  "name": "Placing Tile",
  "description": "",
  "id": "tiles;placing-tile",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 29,
  "name": "the board is not empty",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "a tile is being placed not adjacent to another tile",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "the player will be disqualified",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "a random tile that is not the first tile,",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "the game is in session,",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "the tile is prohibited from not being placed adjacent to another tile.",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "it is placed,",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "it is the 48th tile",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "the game ends.",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "there is a fixed number of tiles available",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "they successfully place a tile",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "that tile should be removed from the list of available tiles / combination type",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 48,
  "name": "Placing Tile on level 1",
  "description": "",
  "id": "tiles;placing-tile-on-level-1",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 49,
  "name": "the board is not empty",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "a tile is being placed on level 1",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "at least one side of the tile being placed must touch an existing tile on the board",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 53,
  "name": "Stacking A Tile",
  "description": "",
  "id": "tiles;stacking-a-tile",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 54,
  "name": "the board is not empty and has a valid level 1 configuration",
  "keyword": "Given "
});
formatter.step({
  "line": 55,
  "name": "a tile is in the process of being stacked",
  "keyword": "When "
});
formatter.step({
  "line": 56,
  "name": "it can be stacked so long as it follows stacking restrictions",
  "keyword": "Then "
});
formatter.step({
  "line": 58,
  "name": "the board is not empty and has a valid level 1 configuration",
  "keyword": "Given "
});
formatter.step({
  "line": 59,
  "name": "a tile is being stacked and",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "it has space beneath it",
  "keyword": "When "
});
formatter.step({
  "line": 61,
  "name": "it is prohibited from being stacked",
  "keyword": "Then "
});
formatter.step({
  "line": 63,
  "name": "the board is not empty and has a valid level 1 configuration",
  "keyword": "Given "
});
formatter.step({
  "line": 64,
  "name": "a tile is being stacked",
  "keyword": "When "
});
formatter.step({
  "line": 65,
  "name": "its volcano hex is not over a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "the tile is prohibited from being stacked",
  "keyword": "Then "
});
formatter.step({
  "line": 68,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 69,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 70,
  "name": "the level of that area of the board increases by 1",
  "keyword": "Then "
});
formatter.step({
  "line": 72,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 73,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 74,
  "name": "it can not be placed directly over a single tile",
  "keyword": "Then "
});
formatter.step({
  "line": 76,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 77,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "the tiles being covered must be at the same level",
  "keyword": "Then "
});
formatter.step({
  "line": 80,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 81,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 82,
  "name": "it can not cover a size 1 settlement",
  "keyword": "Then "
});
formatter.step({
  "line": 84,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 85,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 86,
  "name": "none of the hexes contain a totoro",
  "keyword": "Then "
});
formatter.step({
  "line": 88,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 89,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 90,
  "name": "at least one of the hexes must be a volcano",
  "keyword": "Then "
});
formatter.step({
  "line": 92,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 93,
  "name": "a player attempts to nuke an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 94,
  "name": "the volcano terrain of the tile must be placed over a volcano terrain on the board",
  "keyword": "Then "
});
formatter.step({
  "line": 96,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 97,
  "name": "a player attempts to nuke an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 98,
  "name": "it will completely cover the hexes with no blank board space under it",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 100,
  "name": "Nuking",
  "description": "",
  "id": "tiles;nuking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 101,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 102,
  "name": "a player attempts to nuke an area of the board that completely overlaps a tile",
  "keyword": "When "
});
formatter.step({
  "line": 103,
  "name": "the player will be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 105,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 106,
  "name": "a player attempts to nuke an area of the board that will split a settlement",
  "keyword": "When "
});
formatter.step({
  "line": 107,
  "name": "the new settlement is created",
  "keyword": "Then "
});
formatter.step({
  "line": 108,
  "name": "both settlement sizes are updated",
  "keyword": "Then "
});
formatter.step({
  "line": 110,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 111,
  "name": "a player attempts to nuke an area of the board that contains a totoro",
  "keyword": "When "
});
formatter.step({
  "line": 112,
  "name": "the player will be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 114,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 115,
  "name": "a player attempts to nuke a settlement of size one",
  "keyword": "When "
});
formatter.step({
  "line": 116,
  "name": "the player will be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 118,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 119,
  "name": "a player attempts to nuke a settlement of size greater than one",
  "keyword": "When "
});
formatter.step({
  "line": 120,
  "name": "a player attempts to nuke an area of the board that does not contain a totoro",
  "keyword": "When "
});
formatter.step({
  "line": 121,
  "name": "a player attempts to nuke an area of the board that does not completely overlap a tile",
  "keyword": "When "
});
formatter.step({
  "line": 122,
  "name": "the player will not be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 124,
  "name": "a tile is being stacked",
  "keyword": "Given "
});
formatter.step({
  "line": 125,
  "name": "a settlement exists on the tiles being covered",
  "keyword": "When "
});
formatter.step({
  "line": 126,
  "name": "the settlements are destroyed, so the meeples are no longer in play",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});