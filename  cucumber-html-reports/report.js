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
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 44
    }
  ],
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_does_not_have_a_settlement_of_size_or_larger_with_an_empty_non_volcanic_adjacent_hex(int)"
});
formatter.result({
  "duration": 227709571,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_tries_to_place_a_totoro_during_the_build_phase()"
});
formatter.result({
  "duration": 49451,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.they_will_not_be_allowed_to_add_a_totoro()"
});
formatter.result({
  "duration": 35755188,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 34
    }
  ],
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_has_a_settlement_of_size_or_larger_with_an_empty_non_volcanic_adjacent_hex(int)"
});
formatter.result({
  "duration": 212728,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_enters_their_build_phase()"
});
formatter.result({
  "duration": 54115,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.they_can_add_a_Totoro_to_the_empty_hex()"
});
formatter.result({
  "duration": 32170993,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_that_has_a_certain_amount_of_totoros()"
});
formatter.result({
  "duration": 38720,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.he_she_places_a_totoro_on_the_board()"
});
formatter.result({
  "duration": 30790,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.the_amount_of_totoros_available_to_the_player_decrease_by_one()"
});
formatter.result({
  "duration": 66960506,
  "status": "passed"
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
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_has_a_settlement_with_a_Totoro()"
});
formatter.result({
  "duration": 83505,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_tries_to_add_another_Totoro_to_that_settlement()"
});
formatter.result({
  "duration": 48050,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.they_are_not_allowed_to_place_the_Totoro()"
});
formatter.result({
  "duration": 28627850,
  "status": "passed"
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
  "duration": 15246012,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_expand()"
});
formatter.result({
  "duration": 526223,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_must_be_able_to_occupy_all_contiguous_hexes_of_the_chosen_terrain()"
});
formatter.result({
  "duration": 145551,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_player_that_has_a_certain_amount_of_meeples()"
});
formatter.result({
  "duration": 43320114,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.he_she_attempts_to_expand_to_a_terrain()"
});
formatter.result({
  "duration": 377406,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_must_have_the_necessary_amount_of_meeples_to_expand()"
});
formatter.result({
  "duration": 67644,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_player_that_has_a_certain_amount_of_totoros()"
});
formatter.result({
  "duration": 11645488,
  "status": "passed"
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
  "duration": 476307,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_must_have_the_necessary_amount_of_totoros_to_expand()"
});
formatter.result({
  "duration": 117561,
  "status": "passed"
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
  "duration": 38072810,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.they_expand()"
});
formatter.result({
  "duration": 397000,
  "status": "passed"
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
  "duration": 188937,
  "status": "passed"
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
  "duration": 11712666,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_meeple_tries_to_expand_to_the_terrain()"
});
formatter.result({
  "duration": 56448,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.it_will_be_prohibited_from_doing_so()"
});
formatter.result({
  "duration": 99833,
  "status": "passed"
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
  "duration": 11253619,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.a_player_s_turn_has_ended()"
});
formatter.result({
  "duration": 42919,
  "status": "passed"
});
formatter.match({
  "location": "ExpandingASettlementAcceptanceTests.the_settlement_size_will_increase_by_the_number_of_added_territories()"
});
formatter.result({
  "duration": 35921,
  "status": "passed"
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
formatter.step({
  "line": 9,
  "name": "there is an empty volcanic level one hex",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "a player can build",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "a meeple cannot be placed on that hex to form a new settlement",
  "keyword": "Then "
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.there_is_an_empty_non_volcanic_level_one_hex()"
});
formatter.result({
  "duration": 168410,
  "status": "passed"
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.a_player_has_the_option_to_build()"
});
formatter.result({
  "duration": 53648,
  "status": "passed"
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.they_can_add_a_Meeple_to_that_hex_to_form_a_new_settlement()"
});
formatter.result({
  "duration": 43415748,
  "status": "passed"
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.there_is_an_empty_volcanic_level_one_hex()"
});
formatter.result({
  "duration": 44785,
  "status": "passed"
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.a_player_can_build()"
});
formatter.result({
  "duration": 45252,
  "status": "passed"
});
formatter.match({
  "location": "FoundingANewSettlementAcceptanceTests.they_cannot_add_a_Meeple_to_that_hex_to_form_a_new_settlement()"
});
formatter.result({
  "duration": 8105144,
  "status": "passed"
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
  "duration": 3475965,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat GameResultAcceptanceTests.a_player_has_Totoros_or_Tigers_left(GameResultAcceptanceTests.java:13)\r\n\tat ✽.Given a player has Totoros or Tigers left(GameResultsAcceptanceTests.feature:3)\r\n",
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
  "duration": 418926,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat GameResultAcceptanceTests.a_player_has_no_Meeples_or_Totoro_left(GameResultAcceptanceTests.java:31)\r\n\tat ✽.Given a player has no Meeples or Totoro left(GameResultsAcceptanceTests.feature:8)\r\n",
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
  "duration": 299966,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat GameResultAcceptanceTests.a_game_that_is_in_progress(GameResultAcceptanceTests.java:49)\r\n\tat ✽.Given a game that is in progress(GameResultsAcceptanceTests.feature:13)\r\n",
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
  "duration": 144151,
  "status": "passed"
});
formatter.match({
  "location": "HexAcceptanceTests.a_tile_is_created()"
});
formatter.result({
  "duration": 60179,
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
  "duration": 9701541,
  "status": "passed"
});
formatter.match({
  "location": "HexAcceptanceTests.a_hex_has__been_created()"
});
formatter.result({
  "duration": 41519,
  "status": "passed"
});
formatter.match({
  "location": "HexAcceptanceTests.a_tile_has_been_created()"
});
formatter.result({
  "duration": 35455,
  "status": "passed"
});
formatter.match({
  "location": "HexAcceptanceTests.it_must_have_one_and_only_one_of_the_five_terrain_types()"
});
formatter.result({
  "duration": 501498,
  "error_message": "java.lang.AssertionError: expected:\u003c1\u003e but was:\u003c0\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat HexAcceptanceTests.it_must_have_one_and_only_one_of_the_five_terrain_types(HexAcceptanceTests.java:61)\r\n\tat ✽.Then it must have one, and only one of the five terrain types(HexAcceptanceTests.feature:10)\r\n",
  "status": "failed"
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
  "duration": 116161,
  "status": "passed"
});
formatter.match({
  "location": "MapAcceptanceTests.the_players_begin_the_game()"
});
formatter.result({
  "duration": 37321,
  "status": "passed"
});
formatter.match({
  "location": "MapAcceptanceTests.a_board_data_structure_should_be_initialized_to_empty()"
});
formatter.result({
  "duration": 1710116315,
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
  "duration": 71376,
  "status": "passed"
});
formatter.match({
  "location": "MapAcceptanceTests.the_players_begin_the_game()"
});
formatter.result({
  "duration": 30323,
  "status": "passed"
});
formatter.match({
  "location": "MapAcceptanceTests.a_board_data_structure_containing_data_will_produce_errors()"
});
formatter.result({
  "duration": 964357240,
  "status": "passed"
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
formatter.match({
  "location": "MeepleAcceptanceTests.the_Meeples_are_not_initialized()"
});
formatter.result({
  "duration": 95635,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.before_the_game_begins()"
});
formatter.result({
  "duration": 28923,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 0
    }
  ],
  "location": "MeepleAcceptanceTests.meeples_are_created_for_each_player(int)"
});
formatter.result({
  "duration": 170277,
  "status": "passed"
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
formatter.match({
  "location": "MeepleAcceptanceTests.a_meeple()"
});
formatter.result({
  "duration": 44785,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_enters_their_build_phase()"
});
formatter.result({
  "duration": 37321,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.it_can_be_placed_on_a_habitable_terrain()"
});
formatter.result({
  "duration": 7140401,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.a_meeple()"
});
formatter.result({
  "duration": 32656,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_enters_their_build_phase()"
});
formatter.result({
  "duration": 28923,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.it_cannot_be_placed_on_a_volcano_terrain()"
});
formatter.result({
  "duration": 7009312,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.a_Meeple_is_being_placed()"
});
formatter.result({
  "duration": 40586,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.a_player_builds()"
});
formatter.result({
  "duration": 30789,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.decrement_the_number_of_Meeples_from_the_player_s_total()"
});
formatter.result({
  "duration": 6853031,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.a_meeple()"
});
formatter.result({
  "duration": 33122,
  "status": "passed"
});
formatter.match({
  "location": "BuildTotoroSanctuaryAcceptanceTests.a_player_enters_their_build_phase()"
});
formatter.result({
  "duration": 24259,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.it_cannot_be_placed_on_a_hex_that_is_already_occupied_by_meeples()"
});
formatter.result({
  "duration": 7189852,
  "status": "passed"
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
formatter.match({
  "location": "MeepleAcceptanceTests.a_terrain_that_is_of_type_volcano()"
});
formatter.result({
  "duration": 90503,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.a_meeple_tries_to_occupy_the_terrain()"
});
formatter.result({
  "duration": 33122,
  "status": "passed"
});
formatter.match({
  "location": "MeepleAcceptanceTests.it_will_be_prohibited_from_doing_so()"
});
formatter.result({
  "duration": 95034142,
  "status": "passed"
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
formatter.step({
  "line": 7,
  "name": "a settlement is not added next to an adjacent hex of an existing settlement of the same player",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "a players turn ends",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the settlements will not merge into one",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "a settlement is added next to an adjacent hex of an existing settlement of a different player",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "a players finishes their turn",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the settlements will not be merged",
  "keyword": "Then "
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.a_settlement_is_added_next_to_an_adjacent_hex_of_an_existing_settlement_of_the_same_color()"
});
formatter.result({
  "duration": 107764,
  "status": "passed"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.a_player_ends_their_turn()"
});
formatter.result({
  "duration": 29857,
  "status": "passed"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.the_settlements_will_merge_into_one()"
});
formatter.result({
  "duration": 7659160,
  "status": "passed"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.a_settlement_is_not_added_next_to_an_adjacent_hex_of_an_existing_settlement_of_the_same_color()"
});
formatter.result({
  "duration": 39654,
  "status": "passed"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.a_players_turn_ends()"
});
formatter.result({
  "duration": 29390,
  "status": "passed"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.the_settlements_will_not_merge_into_one()"
});
formatter.result({
  "duration": 6898750,
  "status": "passed"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.a_settlement_is_added_next_to_an_adjacent_hex_of_an_existing_settlement_of_a_different_player()"
});
formatter.result({
  "duration": 40120,
  "status": "passed"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.a_players_finishes_their_turn()"
});
formatter.result({
  "duration": 28924,
  "status": "passed"
});
formatter.match({
  "location": "MergingSettlementsAcceptanceTests.the_settlements_will_not__be_merged()"
});
formatter.result({
  "duration": 7035436,
  "status": "passed"
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
  "duration": 118960,
  "status": "passed"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.two_people_want_to_play_a_game()"
});
formatter.result({
  "duration": 28457,
  "status": "passed"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.they_should_be_able_to_have_the_role_of_a_player_to_enter_the_game()"
});
formatter.result({
  "duration": 56448,
  "status": "passed"
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
  "duration": 56448,
  "status": "passed"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_player_draws_a_tile()"
});
formatter.result({
  "duration": 37787,
  "status": "passed"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_player_must_place_the_tile_in_a_valid_spot_before_executing_a_build_action()"
});
formatter.result({
  "duration": 11354852,
  "status": "passed"
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
  "duration": 59714,
  "status": "passed"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_player_has_just_placed_a_tile()"
});
formatter.result({
  "duration": 31722,
  "status": "passed"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_player_must_complete_the_build_action_before_ending_their_turn()"
});
formatter.result({
  "duration": 7343334,
  "status": "passed"
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
  "duration": 62979,
  "status": "passed"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.a_player_ends_their_build_phase()"
});
formatter.result({
  "duration": 35455,
  "status": "passed"
});
formatter.match({
  "location": "PlayerTurnsAcceptanceTests.the_turn_ends_settlements_are_merged_if_necessary()"
});
formatter.result({
  "duration": 33588,
  "status": "passed"
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
  "duration": 367143,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat PlayerTurnsAcceptanceTests.a_player(PlayerTurnsAcceptanceTests.java:186)\r\n\tat ✽.Given A player(PlayerTurnsAcceptanceTests.feature:24)\r\n",
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
  "duration": 464177,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat PlayerTurnsAcceptanceTests.a_player_and_a_player(PlayerTurnsAcceptanceTests.java:216)\r\n\tat ✽.Given a player 1 and a player 2(PlayerTurnsAcceptanceTests.feature:34)\r\n",
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
  "duration": 21972618,
  "status": "passed"
});
formatter.match({
  "location": "GameResultAcceptanceTests.they_successfully_complete_a_build_phase()"
});
formatter.result({
  "duration": 461378,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat GameResultAcceptanceTests.they_successfully_complete_a_build_phase(GameResultAcceptanceTests.java:37)\r\n\tat ✽.When they successfully complete a build phase(ScoringAcceptanceTests.feature:5)\r\n",
  "status": "pending"
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
  "duration": 95634,
  "status": "passed"
});
formatter.match({
  "location": "GameResultAcceptanceTests.they_successfully_complete_a_build_phase()"
});
formatter.result({
  "duration": 271975,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat GameResultAcceptanceTests.they_successfully_complete_a_build_phase(GameResultAcceptanceTests.java:37)\r\n\tat ✽.When they successfully complete a build phase(ScoringAcceptanceTests.feature:10)\r\n",
  "status": "pending"
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
  "duration": 493567,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat ScoringAcceptanceTests.a_player_placed_a_Tiger(ScoringAcceptanceTests.java:110)\r\n\tat ✽.Given a player placed a Tiger(ScoringAcceptanceTests.feature:14)\r\n",
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
  "duration": 6986453,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.the_tile_has_been_placed()"
});
formatter.result({
  "duration": 83972,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.it_cannot_be_compared_with_non_adjacent_terrains()"
});
formatter.result({
  "duration": 72309,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.a_type_of_terrain()"
});
formatter.result({
  "duration": 7162328,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.the_tile_has_been_placed()"
});
formatter.result({
  "duration": 66244,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.it_can_be_compared_with_all_adjacent_terrains()"
});
formatter.result({
  "duration": 50849,
  "status": "passed"
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
  "duration": 48984,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.the_tile_is_placed_on_the_board()"
});
formatter.result({
  "duration": 27991,
  "status": "passed"
});
formatter.match({
  "location": "TerrainTypesAcceptanceTests.it_must_contain_one_and_only_one_volcano_terrain()"
});
formatter.result({
  "duration": 361545,
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
formatter.match({
  "location": "TilesAcceptanceTests.no_tiles_have_been_placed()"
});
formatter.result({
  "duration": 95634,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.before_the_first_turn()"
});
formatter.result({
  "duration": 27525,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "48",
      "offset": 10
    }
  ],
  "location": "TilesAcceptanceTests.there_are_tiles(int)"
});
formatter.result({
  "duration": 215994,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.no_tiles_have_been_placed()"
});
formatter.result({
  "duration": 27524,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.before_the_first_turn()"
});
formatter.result({
  "duration": 23792,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 10
    },
    {
      "val": "16",
      "offset": 33
    }
  ],
  "location": "TilesAcceptanceTests.there_are_tiles_of_each_of_the_terrain_combinations(int,int)"
});
formatter.result({
  "duration": 472574,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Tile Creation",
  "description": "",
  "id": "tiles;tile-creation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "all the tiles in the deck",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the game begins",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "each tile should have 3 hexes with the proper configuration of one volcano and a terrain combination",
  "keyword": "Then "
});
formatter.match({
  "location": "TilesAcceptanceTests.all_the_tiles()"
});
formatter.result({
  "duration": 153482,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.the_game_begins()"
});
formatter.result({
  "duration": 45718,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 22
    }
  ],
  "location": "TilesAcceptanceTests.each_tile_should_have_hexes_with_the_proper_configuration_of_one_volcano_and_a_terrain_combination(int)"
});
formatter.result({
  "duration": 507562,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Placing Tile for the first time",
  "description": "",
  "id": "tiles;placing-tile-for-the-first-time",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "the board is empty",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "a tile is being placed",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "the tile is placed at the origin, in any orientation",
  "keyword": "Then "
});
formatter.match({
  "location": "TilesAcceptanceTests.the_board_is_empty()"
});
formatter.result({
  "duration": 71376,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.a_tile_is_being_placed()"
});
formatter.result({
  "duration": 29390,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.the_tile_is_placed_at_the_origin_in_any_orientation()"
});
formatter.result({
  "duration": 542475965,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Placing Tile",
  "description": "",
  "id": "tiles;placing-tile",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "the board is not empty",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "a tile is being placed not adjacent to another tile",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "the player will be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "there is a fixed number of tiles available",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "they successfully place a tile",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "that tile should be removed from the list of available tiles / combination type",
  "keyword": "Then "
});
formatter.match({
  "location": "TilesAcceptanceTests.the_board_is_not_empty()"
});
formatter.result({
  "duration": 63912,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.a_tile_is_being_placed_not_adjacent_to_another_tile()"
});
formatter.result({
  "duration": 26124,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.the_player_will_be_prohibited_from_so()"
});
formatter.result({
  "duration": 6950532,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.there_is_a_fixed_number_of_tiles_available()"
});
formatter.result({
  "duration": 38254,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.they_successfully_place_a_tile()"
});
formatter.result({
  "duration": 25191,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.that_tile_should_be_removed_from_the_list_of_available_tiles_combination_type()"
});
formatter.result({
  "duration": 7139935,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Placing Tile on level 1",
  "description": "",
  "id": "tiles;placing-tile-on-level-1",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "the board is not empty",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "a tile is being placed on level 1",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "at least one side of the tile being placed must touch an existing tile on the board",
  "keyword": "Then "
});
formatter.match({
  "location": "TilesAcceptanceTests.the_board_is_not_empty()"
});
formatter.result({
  "duration": 61580,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 32
    }
  ],
  "location": "TilesAcceptanceTests.a_tile_is_being_placed_on_level(int)"
});
formatter.result({
  "duration": 132489,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.at_least_one_side_of_the_tile_being_placed_must_touch_an_existing_tile_on_the_board()"
});
formatter.result({
  "duration": 6925341,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Stacking A Tile",
  "description": "",
  "id": "tiles;stacking-a-tile",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 38,
  "name": "the board is not empty and has a valid level 1 configuration",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "a tile is in the process of being stacked",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "it can be stacked so long as it follows stacking restrictions",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "the board is not empty and has a valid level 1 configuration",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "a tile is being stacked and",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "it has space beneath it",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "it is prohibited from being stacked",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "the board is not empty and has a valid level 1 configuration",
  "keyword": "Given "
});
formatter.step({
  "line": 48,
  "name": "a tile is being stacked",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "its volcano hex is not over a volcano hex",
  "keyword": "When "
});
formatter.step({
  "line": 50,
  "name": "the tile is prohibited from being stacked",
  "keyword": "Then "
});
formatter.step({
  "line": 52,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 53,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 54,
  "name": "the level of that area of the board increases by 1",
  "keyword": "Then "
});
formatter.step({
  "line": 56,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 57,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "it can not be placed directly over a single tile",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 62,
  "name": "the tiles being covered must be at the same level",
  "keyword": "Then "
});
formatter.step({
  "line": 64,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 65,
  "name": "it is placed over an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 66,
  "name": "it can not cover a size 1 settlement",
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
  "name": "none of the hexes contain a totoro",
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
  "name": "at least one of the hexes must be a volcano",
  "keyword": "Then "
});
formatter.step({
  "line": 76,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 77,
  "name": "a player attempts to nuke an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 78,
  "name": "the volcano terrain of the tile must be placed over a volcano terrain on the board",
  "keyword": "Then "
});
formatter.step({
  "line": 80,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 81,
  "name": "a player attempts to nuke an area of the board",
  "keyword": "When "
});
formatter.step({
  "line": 82,
  "name": "it will completely cover the hexes with no blank board space under it",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 45
    }
  ],
  "location": "TilesAcceptanceTests.the_board_is_not_empty_and_has_a_valid_level_configuration(int)"
});
formatter.result({
  "duration": 195934,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.a_tile_is_About_To_Be_Stacked()"
});
formatter.result({
  "duration": 30323,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_can_be_stacked_so_long_as_it_follows_stacking_restrictions()"
});
formatter.result({
  "duration": 6912745,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 45
    }
  ],
  "location": "TilesAcceptanceTests.the_board_is_not_empty_and_has_a_valid_level_configuration(int)"
});
formatter.result({
  "duration": 129690,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.a_tile_is_being_stacked_and()"
});
formatter.result({
  "duration": 32655,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_has_space_beneath_it()"
});
formatter.result({
  "duration": 24259,
  "status": "passed"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_is_prohibited_from_being_stacked()"
});
formatter.result({
  "duration": 25192,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 45
    }
  ],
  "location": "TilesAcceptanceTests.the_board_is_not_empty_and_has_a_valid_level_configuration(int)"
});
formatter.result({
  "duration": 84439,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.its_volcano_hex_is_not_over_a_volcano_hex()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TilesAcceptanceTests.the_tile_is_prohibited_from_being_stacked()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_is_placed_over_an_area_of_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 49
    }
  ],
  "location": "TilesAcceptanceTests.the_level_of_that_area_of_the_board_increases_by(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_is_placed_over_an_area_of_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_can_not_be_placed_directly_over_a_single_tile()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_is_placed_over_an_area_of_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TilesAcceptanceTests.the_tiles_being_covered_must_be_at_the_same_level()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_is_placed_over_an_area_of_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 24
    }
  ],
  "location": "TilesAcceptanceTests.it_can_not_cover_a_size_settlement(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_is_placed_over_an_area_of_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TilesAcceptanceTests.none_of_the_hexes_contain_a_totoro()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_is_placed_over_an_area_of_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TilesAcceptanceTests.at_least_one_of_the_hexes_must_be_a_volcano()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.a_player_attempts_to_nuke_an_area_of_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TilesAcceptanceTests.the_volcano_terrain_of_the_tile_must_be_placed_over_a_volcano_terrain_on_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.a_player_attempts_to_nuke_an_area_of_the_board()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TilesAcceptanceTests.it_will_completely_cover_the_hexes_with_no_blank_board_space_under_it()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 84,
  "name": "Nuking",
  "description": "",
  "id": "tiles;nuking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 85,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 86,
  "name": "a player attempts to nuke an area of the board that completely overlaps a tile",
  "keyword": "When "
});
formatter.step({
  "line": 87,
  "name": "the player will be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 89,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 90,
  "name": "a player attempts to nuke an area of the board that will split a settlement",
  "keyword": "When "
});
formatter.step({
  "line": 91,
  "name": "the new settlement is created",
  "keyword": "Then "
});
formatter.step({
  "line": 92,
  "name": "both settlement sizes are updated",
  "keyword": "Then "
});
formatter.step({
  "line": 94,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 95,
  "name": "a player attempts to nuke an area of the board that contains a totoro",
  "keyword": "When "
});
formatter.step({
  "line": 96,
  "name": "the player will be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 98,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 99,
  "name": "a player attempts to nuke a settlement of size one",
  "keyword": "When "
});
formatter.step({
  "line": 100,
  "name": "the player will be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 102,
  "name": "a tile",
  "keyword": "Given "
});
formatter.step({
  "line": 103,
  "name": "a player attempts to nuke a settlement of size greater than one",
  "keyword": "When "
});
formatter.step({
  "line": 104,
  "name": "a player attempts to nuke an area of the board that does not contain a totoro",
  "keyword": "When "
});
formatter.step({
  "line": 105,
  "name": "a player attempts to nuke an area of the board that does not completely overlap a tile",
  "keyword": "When "
});
formatter.step({
  "line": 106,
  "name": "the player will not be prohibited from doing so",
  "keyword": "Then "
});
formatter.step({
  "line": 108,
  "name": "a tile is being stacked",
  "keyword": "Given "
});
formatter.step({
  "line": 109,
  "name": "a settlement exists on the tiles being covered",
  "keyword": "When "
});
formatter.step({
  "line": 110,
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
formatter.match({
  "location": "TilesAcceptanceTests.the_player_will_be_prohibited_from_so()"
});
formatter.result({
  "status": "skipped"
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
formatter.match({
  "location": "TilesAcceptanceTests.the_player_will_be_prohibited_from_so()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "TilesAcceptanceTests.the_player_will_be_prohibited_from_so()"
});
formatter.result({
  "status": "skipped"
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