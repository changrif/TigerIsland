import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by AizeyPineda on 4/9/17.
 */
public class StringParserAcceptanceTests {
    private StringParser parser;
    public void setUp(){
        parser = new StringParser();
    }


    @Given("^A message is sent by the server$")
    public void a_message_is_sent_by_the_server() throws Throwable {
    }

    @When("^it contain an opponent's move$")
    public void it_contain_an_opponent_s_move() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the move will be parsed$")
    public void the_move_will_be_parsed() throws Throwable {
        String messageSentToBothPlayersAfterATurn = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "PLACE <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        String messageSentToBothPlayersAfterATurn2 = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";

        String expected = "PLACE <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getOpponentMoveFromServer(messageSentToBothPlayersAfterATurn));
        expected = "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";
        Assert.assertEquals(expected, parser.getOpponentMoveFromServer(messageSentToBothPlayersAfterATurn2));
    }

    @When("^it contains the state of the game$")
    public void it_contains_the_state_of_the_game() throws Throwable {

    }

    @Then("^the state will be parsed$")
    public void the_state_will_be_parsed() throws Throwable {
        String expected = "PLACE";
        String testString = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "PLACE <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getCurrentStateFromServer(testString));

        String testString2 = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "LOST: UNABLE TO BUILD";

        Assert.assertNotEquals(expected, parser.getCurrentStateFromServer(testString2));

        PlayerState.gameState p = PlayerState.gameState.LOST_UNABLE_TO_BUILD;
        testString = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "LOST: UNABLE TO BUILD";
        Assert.assertEquals(p, parser.getGameStateFromMessageSentToBothPlayers(testString));
    }

    @When("^it contains a forfeit$")
    public void it_contains_a_forfeit() throws Throwable {

    }

    @Then("^the forfeit will be parsed$")
    public void the_forfeit_will_be_parsed() throws Throwable {
        PlayerState.gameState p = PlayerState.gameState.FORFEITED_ILLEGAL_TILE_PLACEMENT;

        String testString = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "FORFEITED: ILLEGAL TILE PLACEMENT";
        Assert.assertEquals(p, parser.getGameStateFromMessageSentToBothPlayers(testString));

        p = PlayerState.gameState.FORFEITED_ILLEGAL_BUILD;
        String testString2 = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "FORFEITED: ILLEGAL BUILD";
        Assert.assertEquals(p, parser.getGameStateFromMessageSentToBothPlayers(testString2));

        p = PlayerState.gameState.FORFEITED_TIMEOUT;
        String testString3 = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "FORFEITED: TIMEOUT";
        Assert.assertEquals(p, parser.getGameStateFromMessageSentToBothPlayers(testString3));
    }

    @When("^it contains a playerID for both players$")
    public void it_contains_a_playerID_for_both_players() throws Throwable {

    }

    @Then("^it parses the PlayerID$")
    public void it_parses_the_PlayerID() throws Throwable {
        String expected = "A";
        String testString = "GAME <gid> MOVE <#> PLAYER A " +
                " LOST: UNABLE TO BUILD";
        String pid = parser.getPlayerIdFromMessageSentToBothPlayers(testString);
        Assert.assertEquals(expected, pid);

        expected = "BCA";
        String testString2 = "GAME <gid> MOVE <#> PLAYER BCA " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";
        Assert.assertEquals(expected, parser.getPlayerIdFromMessageSentToBothPlayers(testString2));

        expected = "BLUE";
        testString = "WAIT FOR THE TOURNAMENT TO BEGIN BLUE";
        Assert.assertEquals(expected, parser.getPlayerIDFromServerMessageDuringAuthenticationProtocol(testString));
    }

    @When("^it contains a ChallengeID$")
    public void it_contains_a_ChallengeID() throws Throwable {

    }

    @Then("^it parses the ChallengeID$")
    public void it_parses_the_ChallengeID() throws Throwable {
        String expected = "OurAIisInvincible";
        String testString = "NEW CHALLENGE OurAIisInvincible YOU WILL PLAY <rounds> MATCH";
        Assert.assertEquals(expected, parser.getChallengeIDFromServerMessage(testString));

        //Adds ES after Matches as this message can be displayed either way according to documentation
        testString = "NEW CHALLENGE OurAIisInvincible YOU WILL PLAY <rounds> MATCHES";
        Assert.assertEquals(expected, parser.getChallengeIDFromServerMessage(testString));
    }

    @When("^it contains the RoundID$")
    public void it_contains_the_RoundID() throws Throwable {

    }

    @Then("^It parses the RoundID$")
    public void it_parses_the_RoundID() throws Throwable {
        int roundID = 2;
        String testString = "BEGIN ROUND 2 OF 8";
        Assert.assertEquals(roundID, parser.getRoundIDFromServerMessage(testString));
    }

    @When("^it contains the number of Rounds$")
    public void it_contains_the_number_of_Rounds() throws Throwable {

    }

    @Then("^it parses the number of rounds$")
    public void it_parses_the_number_of_rounds() throws Throwable {
        int roundNum = 8;
        String testString = "NEW CHALLENGE <cid> YOU WILL PLAY 8 MATCHES";
        Assert.assertEquals(roundNum, parser.getNumberOfRoundsFromServerMessage(testString));
    }

    @When("^it contains the GameID$")
    public void it_contains_the_GameID() throws Throwable {

    }

    @Then("^it parses the GameID$")
    public void it_parses_the_GameID() throws Throwable {
        String gameID = "ABC";
        String testString = "MAKE YOUR MOVE IN GAME ABC WITHIN <timemove> SECOND: MOVE <#> PLACE <tile>";
        Assert.assertEquals(gameID, parser.getGameIDFromServerMessageIfActivePlayer(testString));

        gameID = "Tiger";
        testString = "GAME Tiger MOVE <#> PLAYER <pid> " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";
        Assert.assertEquals(gameID, parser.getGameIDFromServerMessageIfNotActivePlayer(testString));
    }

    @When("^it contains an Opponent ID$")
    public void it_contains_an_Opponent_ID() throws Throwable {

    }

    @Then("^the opponentID is parsed$")
    public void the_opponentID_is_parsed() throws Throwable {
        String gameID = "RED";
        String testString = "NEW MATCH BEGINNING NOW YOUR OPPONENT IS PLAYER RED";
        Assert.assertEquals(gameID, parser.getOpponentPlayerIDFromServerMessage(testString));
    }

    @When("^a string array needs to be merged into a string$")
    public void a_string_array_needs_to_be_merged_into_a_string() throws Throwable {

    }

    @Then("^it is merged into a string$")
    public void it_is_merged_into_a_string() throws Throwable {
        String[] splitUpArray = {"PLACE", "<tile>", "AT", "<x>", "<y>", "<z>"};
        String combinedString = parser.mergeStringArrayIntoString(splitUpArray);
        Assert.assertEquals("PLACE <tile> AT <x> <y> <z>", combinedString);
    }

    @When("^it contains a build option$")
    public void it_contains_a_build_option() throws Throwable {

    }

    @Then("^it parses the build option$")
    public void it_parses_the_build_option() throws Throwable {
        BuildOption.typesOfBuildOptions b = BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT;

        String testString = "GAME <gid> MOVE <#> PLAYER BCA " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";
        Assert.assertEquals(b, parser.getBuildOptionFromMessageSentToBothPlayers(testString));

        b =  BuildOption.typesOfBuildOptions.EXPANSION;
        String testString2 = "GAME <gid> MOVE <#> PLAYER BCA " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> EXPAND SETTLEMENT AT <x> <y> <z> <terrain>";
        Assert.assertEquals(b, parser.getBuildOptionFromMessageSentToBothPlayers(testString2));

        b = BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY;
        String testString3 = "GAME <gid> MOVE <#> PLAYER BCA " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> BUILD TOTORO SANCTUARY AT <x> <y> <z>";
        Assert.assertEquals(b, parser.getBuildOptionFromMessageSentToBothPlayers(testString3));

        b = BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND;
        String testString4 = "GAME <gid> MOVE <#> PLAYER BCA " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> BUILD TIGER PLAYGROUND AT <x> <y> <z>";
        Assert.assertEquals(b, parser.getBuildOptionFromMessageSentToBothPlayers(testString4));

        b = BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD;
        String testString5 = "GAME <gid> MOVE <#> PLAYER BCA " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> UNABLE TO BUILD";
        Assert.assertEquals(b, parser.getBuildOptionFromMessageSentToBothPlayers(testString5));
    }

    @When("^it contains a tile orientation$")
    public void it_contains_a_tile_orientation() throws Throwable {
    }

    @Then("^it parses the tile orientation$")
    public void it_parses_the_tile_orientation() throws Throwable {
        int tileOrientation = 6;
        String testString = "PLACE <JUNGLE+LAKE> AT <102> <103> <122> 6 UNABLE TO BUILD";
        Assert.assertEquals(tileOrientation, parser.getOrientationFromOpponent(testString));

        tileOrientation = 5094;
        String testString2 = "PLACE <JUNGLE+LAKE> AT <102> <103> <122> 5094 BUILD TOTORO SANCTUARY AT <103> <222> <0>";
        Assert.assertEquals(tileOrientation, parser.getOrientationFromOpponent(testString2));
    }

    @When("^it contains a TileID$")
    public void it_contains_a_TileID() throws Throwable {
    }

    @Then("^it parses the TileID$")
    public void it_parses_the_TileID() throws Throwable {
        String expected = "JUNGLE+LAKE";
        String test = "PLACE JUNGLE+LAKE AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getTileOpponentPlacedFromServer(test));

        expected = "JUNGLE+LAKE";
        test = "MAKE YOUR MOVE IN GAME <gid> WITHIN <timemove> SECOND: MOVE <#> PLACE JUNGLE+LAKE";
        Assert.assertEquals(expected, parser.getTileIDFromServerMessageIfActivePlayer(test));
    }

    @When("^it contains a Terrain$")
    public void it_contains_a_Terrain() throws Throwable {

    }

    @Then("^it parses the Terrain$")
    public void it_parses_the_Terrain() throws Throwable {
        Terrain.typesOfTerrain t = Terrain.typesOfTerrain.JUNGLE;
        String test = "JUNGLE+LAKE";
        Assert.assertEquals(t, parser.getTerrainAFromString(test));

        t = Terrain.typesOfTerrain.LAKE;
        test = "JUNGLE+LAKE";
        Assert.assertEquals(t, parser.getTerrainBFromString(test));
    }

    @When("^it Contains coordinates$")
    public void it_Contains_coordinates() throws Throwable {
    }

    @Then("^it parses the coordinates$")
    public void it_parses_the_coordinates() throws Throwable {
        int expected = 96;
        String test = "PLACE JUNGLE+LAND AT 96 102 100 <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getXCoordFromOpponentMove(test));

        expected = 102;
        Assert.assertEquals(expected, parser.getYCoordFromOpponentMove(test));

        expected = 100;
        Assert.assertEquals(expected, parser.getZCoordFromOpponentMove(test));
    }

    @When("^it contains the score for both players and status$")
    public void it_contains_the_score_for_both_players_and_status() throws Throwable {

    }

    @Then("^it parses the score and game status$")
    public void it_parses_the_score_and_game_status() throws Throwable {
        String test = "GAME <gid> OVER PLAYER <pid> <score> PLAYER <pid> <score>";
        Assert.assertTrue(parser.isGameOver(test));

        test = "GAME <gid> OVER PLAYER BLUE 200 PLAYER RED 0";
        int expected = 200;
        Assert.assertEquals(expected, parser.getCurrentScoreForFirstPlayerWhenGameEnds(test));

        expected = 0;
        Assert.assertEquals(expected, parser.getCurrentScoreForSecondPlayerWhenGameEnds(test));
    }

    @When("^the game ends and it sends playerID$")
    public void the_game_ends_and_it_sends_playerID() throws Throwable {
    }

    @Then("^it parses the ID for the end game$")
    public void it_parses_the_ID_for_the_end_game() throws Throwable {
        String test = "GAME <gid> OVER PLAYER BLUE 200 PLAYER RED 0";
        String expected = "RED";
        Assert.assertEquals(expected, parser.getPlayerIdForSecondPlayerOnceGameEnds(test));
        test = "GAME <gid> OVER PLAYER BLUE 200 PLAYER RED 0";
        expected = "BLUE";
        Assert.assertEquals(expected, parser.getPlayerIdForFirstPlayerOnceGameEnds(test));

    }

}
