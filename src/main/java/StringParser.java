import java.util.Arrays;

/**
 * Created by Nick Kroeger on 4/5/2017.
 * This class is used primarily to take input from the server and parse it for the information needed. Each function is
 * labeled accordingly.
 */
public class StringParser {

    public boolean weAreActivePlayer(String fromServer) {
        return fromServer.startsWith("MAKE");
    } //YOUR MOVE

    public String getPlayerIDFromServerMessageDuringAuthenticationProtocol(String fromServer) {
        String pid;
        String [] splitStringFromServer = fromServer.split(" ");
        pid = splitStringFromServer[splitStringFromServer.length-1];
        return pid;
    }

    public String getChallengeIDFromServerMessage(String fromServer) {
        String cid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        cid = splitStringFromServer[2];
        return cid;
    }

    public int getNumberOfRoundsFromServerMessage(String fromServer) {
        String numRounds;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        numRounds = splitStringFromServer[6];
        return Integer.parseInt(numRounds);
    }

    public int getRoundIDFromServerMessage(String fromServer) {
        String rid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        rid = splitStringFromServer[2];
        return Integer.parseInt(rid);
    }

    public String getGameIDFromServerMessageIfActivePlayer(String fromServer) {
        String gid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        gid = splitStringFromServer[5];
        return gid;
    }

    public String getGameIDFromServerMessageIfNotActivePlayer(String fromServer) {
        String gid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        gid = splitStringFromServer[1];
        return gid;
    }

    public String getOpponentPlayerIDFromServerMessage(String fromServer) {
        String pid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        pid = splitStringFromServer[splitStringFromServer.length-1];
        return pid;
    }

    public int getMoveNumberFromServerMessage(String fromServer) {
        String moveNum = null;
        String [] splitStringFromServer;
        if(fromServer.contains("MAKE YOUR MOVE"))   {
            splitStringFromServer = fromServer.split(" ");
            moveNum = splitStringFromServer[10];
        }
        else if(fromServer.contains("PLACED") || fromServer.contains("FORFEITED") || fromServer.contains("LOST"))    {
            splitStringFromServer = fromServer.split(" ");
            moveNum = splitStringFromServer[3];
        }
        return Integer.parseInt(moveNum);
    }

    public String getTileIDFromServerMessageIfActivePlayer(String fromServer) {
        String TileId;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        TileId = splitStringFromServer[splitStringFromServer.length-1];
        return TileId;
    }

    public String getOpponentMoveFromServer(String fromServer){
        String[] splitStringFromServer = fromServer.split(" ");
        String[] opponentsMoveArray = Arrays.copyOfRange(splitStringFromServer, 6, splitStringFromServer.length);
        String opponentMoveString = mergeStringArrayIntoString(opponentsMoveArray);
        return opponentMoveString;
    }

    public String mergeStringArrayIntoString(String[] opponentsMove) {
        String concatenatedString = "";
        int sizeOfArray = opponentsMove.length;
        for(int i = 0; i < sizeOfArray; i++) {
            concatenatedString = appendElementFromArrayToString(opponentsMove, concatenatedString, sizeOfArray, i);
        }
        return concatenatedString;
    }

    public String appendElementFromArrayToString(String[] opponentsMove, String concatenatedString, int sizeOfArray, int i) {
        if(isLastLoopIteration(sizeOfArray, i))
            concatenatedString += opponentsMove[i];
        else
            concatenatedString += opponentsMove[i] + " ";
        return concatenatedString;
    }

    public boolean isLastLoopIteration(int lastElement, int i) {
        return i == lastElement-1;
    }


    public String getTileOpponentPlacedFromServer(String opponentMove) {
        String tile;
        String[] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        tile = splitStringFromServer[1];
        return tile;
    }

    public Terrain.typesOfTerrain getTerrainAFromString(String tileToPlaceFromServer) {
        Terrain t = new Terrain();
        String [] AandB = tileToPlaceFromServer.split("\\+");
        String A = AandB[0];
        return t.getTerrainTypeFromString(A);
    }

    public Terrain.typesOfTerrain getTerrainBFromString(String tileToPlaceFromServer) {
        Terrain t = new Terrain();
        String [] AandB = tileToPlaceFromServer.split("\\+");
        String B = AandB[1];
        return t.getTerrainTypeFromString(B);
    }

    public int getXCoordFromOpponentMove(String opponentMove) {
        String X;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        X = splitStringFromServer[3];
        return Integer.parseInt(X);
    }

    public int getYCoordFromOpponentMove(String opponentMove) {
        String Y;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        Y = splitStringFromServer[4];
        return Integer.parseInt(Y);
    }

    public int getZCoordFromOpponentMove(String opponentMove) {
        String Z;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        Z = splitStringFromServer[5];
        return Integer.parseInt(Z);
    }

    public int getXCoordFromOpponentBuild(String opponentMove) {
        String X;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        X = splitStringFromServer[11];
        return Integer.parseInt(X);
    }

    public int getYCoordFromOpponentBuild(String opponentMove) {
        String Y;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        Y = splitStringFromServer[12];
        return Integer.parseInt(Y);
    }

    public int getZCoordFromOpponentBuild(String opponentMove) {
        String Z;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        Z = splitStringFromServer[13];
        return Integer.parseInt(Z);
    }

    public int getXCoordFromOpponentFoundOrExpand(String opponentMove) {
        String X;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        X = splitStringFromServer[10];
        return Integer.parseInt(X);
    }

    public int getYCoordFromOpponentFoundOrExpand(String opponentMove) {
        String Y;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        Y = splitStringFromServer[11];
        return Integer.parseInt(Y);
    }

    public int getZCoordFromOpponentFoundOrExpand(String opponentMove) {
        String Z;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        Z = splitStringFromServer[12];
        return Integer.parseInt(Z);
    }

    public int getOrientationFromOpponent(String opponentMove) {
        String orientation;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        orientation = splitStringFromServer[6];
        return Integer.parseInt(orientation);
    }

    /*
    public PlayerState.gameState getGameStateFromMessageSentToBothPlayers(String fromServer){
        PlayerState p = new PlayerState();
        String [] gameStateMessageFromMessageSentToBothPlayers;
        String[] splitStringFromServer = fromServer.split(" ");
        gameStateMessageFromMessageSentToBothPlayers = Arrays.copyOfRange(splitStringFromServer, 6, splitStringFromServer.length);
        String gameStateMessage = mergeStringArrayIntoString(gameStateMessageFromMessageSentToBothPlayers);
        return p.getStateOfTheGameAfterMove(gameStateMessage);
    }*/

    public String getPlayerIdFromMessageSentToBothPlayers(String fromServer){
        String pidFromMessageSentToBothPlayers;
        String[] splitStringFromServer = fromServer.split(" ");
        pidFromMessageSentToBothPlayers = splitStringFromServer[5];
        return pidFromMessageSentToBothPlayers;
    }

    public BuildOption.typesOfBuildOptions getBuildOptionFromMessageSentToBothPlayers(String fromServer){
        BuildOption b = new BuildOption();
        return b.getTypeOfBuildOption(fromServer);
    }

    public String getCurrentStateFromServer(String fromServer) {
        String [] serverMessage = fromServer.split(" ");
        String currentState = serverMessage[6];
        return currentState;
    }

    public boolean isGameOver(String fromServer) {
        if(fromServer.contains("OVER PLAYER"))  { //GAME <GID> OVER PLAYER ...
            return true;
        }
        return false;
    }

    public Terrain.typesOfTerrain getTerrainTypeFromServerMessageIfOpponentExpands(String opponentMove) {
        Terrain t = new Terrain();
        String terrainType;
        String [] splitStringFromServer;
        splitStringFromServer = opponentMove.split(" ");
        terrainType = splitStringFromServer[splitStringFromServer.length-1];
        return t.getTerrainTypeFromString(terrainType);
    }

    public int getCurrentScoreForFirstPlayerWhenGameEnds(String fromServer) {
        String score;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        score = splitStringFromServer[5];
        return Integer.parseInt(score);
    }

    public int getCurrentScoreForSecondPlayerWhenGameEnds(String fromServer) {
        String score;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        score = splitStringFromServer[splitStringFromServer.length-1];
        return Integer.parseInt(score);
    }

    public String getPlayerIdForFirstPlayerOnceGameEnds(String fromServer){
        String pidFromMessageSentToBothPlayers;
        String[] splitStringFromServer = fromServer.split(" ");
        pidFromMessageSentToBothPlayers = splitStringFromServer[4];
        return pidFromMessageSentToBothPlayers;
    }

    public String getPlayerIdForSecondPlayerOnceGameEnds(String fromServer){
        String pidFromMessageSentToBothPlayers;
        String[] splitStringFromServer = fromServer.split(" ");
        pidFromMessageSentToBothPlayers = splitStringFromServer[7];
        return pidFromMessageSentToBothPlayers;
    }
}