import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class StringParserTest{
    private StringParser parser;
    String messageSentToBothPlayersAfterATurn = "GAME <gid> MOVE <#> PLAYER <pid> " +
            "PLACE <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
    String messageSentToBothPlayersAfterATurn2 = "GAME <gid> MOVE <#> PLAYER <pid> " +
            "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";

    @Before
    public void setUp(){
        parser = new StringParser();
    }
    @Test
    public void getOpponentMoveFromServerTest(){
        String expected = "PLACE <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getOpponentMoveFromServer(messageSentToBothPlayersAfterATurn));
    }

    @Test
    public void getOpponentMoveFromServerTest2(){
        String expected = "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";
        Assert.assertEquals(expected, parser.getOpponentMoveFromServer(messageSentToBothPlayersAfterATurn2));
    }

    @Test
    public void getStateOfTheGameFromServerWhenGameIsOngoing(){
        String expected = "PLACE";
        String testString = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "PLACE <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getCurrentStateFromServer(testString));

        String testString2 = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "LOST: UNABLE TO BUILD";

        Assert.assertNotEquals(expected, parser.getCurrentStateFromServer(testString2));
    }

    @Test
    public void getStateOfTheGameFromServerWhenSomeoneLost(){
        PlayerState.gameState p = PlayerState.gameState.LOST_UNABLE_TO_BUILD;
        String testString = "GAME <gid> MOVE <#> PLAYER <pid> " +
                "LOST: UNABLE TO BUILD";
        Assert.assertEquals(p, parser.getGameStateFromMessageSentToBothPlayers(testString));
    }

    @Test
    public void getStateOfTheGameFromServerWhenSomeoneForfeited(){
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

    @Test
    public void getPlayerIDFromServerWhenServerSendsMessageToBothPlayers(){
        String expected = "A";
        String testString = "GAME <gid> MOVE <#> PLAYER A " +
                " LOST: UNABLE TO BUILD";
        Assert.assertEquals(expected, parser.getPlayerIdFromMessageSentToBothPlayers(testString));

        expected = "BCA";
        String testString2 = "GAME <gid> MOVE <#> PLAYER BCA " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";
        Assert.assertEquals(expected, parser.getPlayerIdFromMessageSentToBothPlayers(testString2));
    }

    @Test
    public void getPlayerIDFromServerWhenServerSendsMessageDuringAuthenticationProtocol(){
        String expected = "BLUE";
        String testString = "WAIT FOR THE TOURNAMENT TO BEGIN BLUE";
        Assert.assertEquals(expected, parser.getPlayerIDFromServerMessageDuringAuthenticationProtocol(testString));
    }

    @Test
    public void getChallengeIDFromServerWhenServerSendsMessageDuringAuthenticationProtocol(){
        String expected = "OurAIisInvincible";
        String testString = "NEW CHALLENGE OurAIisInvincible YOU WILL PLAY <rounds> MATCH";
        Assert.assertEquals(expected, parser.getChallengeIDFromServerMessage(testString));

        //Adds ES after Matches as this message can be displayed either way according to documentation
        testString = "NEW CHALLENGE OurAIisInvincible YOU WILL PLAY <rounds> MATCHES";
        Assert.assertEquals(expected, parser.getChallengeIDFromServerMessage(testString));
    }

    @Test
    public void getRoundIDFromServerWhenServerSendsMessageDuringRoundProtocol(){
        int roundID = 2;
        String testString = "BEGIN ROUND 2 OF 8";
        Assert.assertEquals(roundID, parser.getRoundIDFromServerMessage(testString));
    }

    @Test
    public void getNumberOfRoundsFromServerWhenServerSendsMessageDuringRoundProtocol(){
        int roundNum = 8;
        String testString = "NEW CHALLENGE <cid> YOU WILL PLAY 8 MATCHES";
        Assert.assertEquals(roundNum, parser.getNumberOfRoundsFromServerMessage(testString));
    }

    @Test
    public void getGameIDFromServerWhenServerSendsMessageDuringMoveProtocolAndPlayerIsActive(){
        String gameID = "ABC";
        String testString = "MAKE YOUR MOVE IN GAME ABC WITHIN <timemove> SECOND: MOVE <#> PLACE <tile>";
        Assert.assertEquals(gameID, parser.getGameIDFromServerMessageIfActivePlayer(testString));
    }

    @Test
    public void getGameIDFromServerWhenServerSendsMessageDuringMoveProtocolAndPlayerIsNotActive(){
        String gameID = "Tiger";
        String testString = "GAME Tiger MOVE <#> PLAYER <pid> " +
                "PLACE <JUNGLE+LAKE> AT <102> <103> <122> <6> FOUND SETTLEMENT AT <103> <222> <0>";
        Assert.assertEquals(gameID, parser.getGameIDFromServerMessageIfNotActivePlayer(testString));
    }

    @Test
    public void getOpponentIDFromServerWhenServerSendsMessageDuringMatchProtocol(){
        String gameID = "RED";
        String testString = "NEW MATCH BEGINNING NOW YOUR OPPONENT IS PLAYER RED";
        Assert.assertEquals(gameID, parser.getOpponentPlayerIDFromServerMessage(testString));
    }

    @Test
    public void mergeStringArrayIntoStringTest(){
        String[] splitUpArray = {"PLACE", "<tile>", "AT", "<x>", "<y>", "<z>"};
        String combinedString = parser.mergeStringArrayIntoString(splitUpArray);
        Assert.assertEquals("PLACE <tile> AT <x> <y> <z>", combinedString);
    }

    @Test
    public void getTypeOfBuildOptionFromServerWhenServerSendsMessageToBothPlayers(){
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

    @Test
    public void getTileOrientationFromOpponentWhenServerSendsMessageToBothPlayers(){
        int tileOrientation = 6;
        String testString = "PLACE <JUNGLE+LAKE> AT <102> <103> <122> 6 UNABLE TO BUILD";
        Assert.assertEquals(tileOrientation, parser.getOrientationFromOpponent(testString));

        tileOrientation = 5094;
        String testString2 = "PLACE <JUNGLE+LAKE> AT <102> <103> <122> 5094 BUILD TOTORO SANCTUARY AT <103> <222> <0>";
        Assert.assertEquals(tileOrientation, parser.getOrientationFromOpponent(testString2));
    }

    @Test
    public void getOpponentTileFromServerMessageTest(){
        String expected = "JUNGLE+LAKE";
        String test = "PLACE JUNGLE+LAKE AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getTileOpponentPlacedFromServer(test));
    }

    @Test
    public void getTileIDFromServerMessageWhenPlayerIsActive(){
        String expected = "JUNGLE+LAKE";
        String test = "MAKE YOUR MOVE IN GAME <gid> WITHIN <timemove> SECOND: MOVE <#> PLACE JUNGLE+LAKE";
        Assert.assertEquals(expected, parser.getTileIDFromServerMessageIfActivePlayer(test));
    }


    @Test
    public void getTerrainAFromServerMessageTest(){
        Terrain.typesOfTerrain t = Terrain.typesOfTerrain.JUNGLE;
        String test = "JUNGLE+LAKE";
        Assert.assertEquals(t, parser.getTerrainAFromString(test));
    }

    @Test
    public void getTerrainBFromServerMessageTest(){
        Terrain.typesOfTerrain t = Terrain.typesOfTerrain.LAKE;
        String test = "JUNGLE+LAKE";
        Assert.assertEquals(t, parser.getTerrainBFromString(test));
    }


    @Test
    public void getXCoordinateFromServerMessagesSentToBothPlayers(){
        int expected = 96;
        String test = "PLACE JUNGLE+LAND AT 96 102 100 <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getXCoordFromOpponentMove(test));
    }

    @Test
    public void getYCoordinateFromServerMessagesSentToBothPlayers(){
        int expected = 102;
        String test = "PLACE JUNGLE+LAND AT 96 102 100 <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getYCoordFromOpponentMove(test));
    }

    @Test
    public void getZCoordinateFromServerMessagesSentToBothPlayers(){
        int expected = 100;
        String test = "PLACE JUNGLE+LAND AT 96 102 100 <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getZCoordFromOpponentMove(test));
    }

    @Test
    public void getGameStatusFromServerMessagesSentToBothPlayers(){
        String test = "GAME <gid> OVER PLAYER <pid> <score> PLAYER <pid> <score>";
        Assert.assertTrue(parser.isGameOver(test));
    }

    @Test
    public void getScoreForFirstPlayerWhenGameEnds(){
        String test = "GAME <gid> OVER PLAYER BLUE 200 PLAYER RED 0";
        int expected = 200;
        Assert.assertEquals(expected, parser.getCurrentScoreForFirstPlayerWhenGameEnds(test));
    }

    @Test
    public void getScoreForSecondPlayerWhenGameEnds(){
        String test = "GAME <gid> OVER PLAYER BLUE 200 PLAYER RED 0";
        int expected = 0;
        Assert.assertEquals(expected, parser.getCurrentScoreForSecondPlayerWhenGameEnds(test));
    }

    @Test
    public void getPlayerIDForSecondPlayerWhenGameEnds(){
        String test = "GAME <gid> OVER PLAYER BLUE 200 PLAYER RED 0";
        String expected = "RED";
        Assert.assertEquals(expected, parser.getPlayerIdForSecondPlayerOnceGameEnds(test));
    }

    @Test
    public void getPlayerIDForFirstPlayerWhenGameEnds(){
        String test = "GAME <gid> OVER PLAYER BLUE 200 PLAYER RED 0";
        String expected = "BLUE";
        Assert.assertEquals(expected, parser.getPlayerIdForFirstPlayerOnceGameEnds(test));
    }


}