
import java.io.*;
import java.net.*;

public class TournamentClient {
    private StringParser parser;
    private String hostName;
    private int portNumber;
    private String tournamentPassword;
    private String teamUsername;
    private String teamPassword;
    private int numberOfChallenges;
    private int numberOfRounds;
    private String playerId;
    private String opponentId;
    private String challengeId;
    private int roundId;
    private int moveNumber;
    private String gameId;
    private String tileToPlaceFromServer;
    private int orientationOfTile;

    private final double TIME_FOR_MOVE = 1.5;

    Socket tournamentSocket;
    PrintWriter out;
    BufferedReader in;

    public TournamentClient(String[] args) throws IOException {
        hostName = args[0];
        portNumber = Integer.parseInt(args[1]);
        tournamentPassword = args[2];
        teamUsername = args[3];
        teamPassword = args[4];

        tournamentSocket = new Socket(hostName, portNumber);
        out = new PrintWriter(tournamentSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(tournamentSocket.getInputStream()));
        parser = new StringParser();
    }

    public void runClient() throws IOException {
        Map m = new Map();
        Player ourAI = new Player(playerId);
        Player opponentAI = new Player(opponentId);
        PlayerBrain brain = new PlayerBrain(ourAI, opponentAI, m);
        setUpProtocolBeforeGame();
        beginGame(m, brain);
    }

    public void beginGame(Map m, PlayerBrain brain) throws IOException {
        String fromServer;
        for(int i = 0; i < 48; i++){
            fromServer = in.readLine();//either "MAKE YOUR MOVE..." OR "GAME A MOVE 1 PLACE tile AT xyz..."
            if (weAreTheActivePlayer(fromServer)) {
                System.out.println("Server: " + fromServer);//make your move //getTile x+y where x,y = "JUNGLE" "LAKE" "GRASS" "ROCK"
                Tile tileToPlace = createTile(tileToPlaceFromServer);
                brain.setTileToPlace(tileToPlace);
                sendMessageToServerBasedOnOurPlayersMove(brain);
            }
            else{
                System.out.println("Server: " + fromServer);//GAME <gid> MOVE <#> PLAYER <pid> <move> or forfeited, lost etc.
                handleMessageSetToBothPlayersFromServer(m, brain, fromServer);
            }
        }
    }

    public void setUpProtocolBeforeGame() throws IOException {
        setUpAuthenticationProtocol();

        setUpChallengeProtocol();

        setUpRoundProtocol();

        setUpMatchProtocol();

        setUpMoveProtocol();
    }

    public void setUpAuthenticationProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);

        out.println("Client: ENTER THUNDERDOME "+tournamentPassword);

        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);

        out.println("Client: I AM " + teamUsername + " " + teamPassword);

        fromServer = in.readLine();
        playerId = parser.getPlayerIDFromServerMessage(fromServer);
        System.out.println("Server: " + fromServer);
    }

    public void setUpChallengeProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        challengeId = parser.getChallengeIDFromServerMessage(fromServer);
        numberOfRounds = parser.getNumberOfRoundsFromServerMessage(fromServer);
        System.out.println("Server: " + fromServer);
    }

    public void setUpRoundProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        roundId = parser.getRoundIDFromServerMessage(fromServer);
        System.out.println("Server: " + fromServer);
    }

    public void setUpMatchProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        opponentId = parser.getOpponentPlayerIDFromServerMessage(fromServer);
        System.out.println("Server: " + fromServer);
    }

    public String setUpMoveProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        if (weAreTheActivePlayer(fromServer)) {
            gameId = parser.getGameIDFromServerMessageIfActivePlayer(fromServer);
//            moveNumber = parseStringToGetMoveNumberFromServerMessageIfActivePlayer(fromServer);
//            tileToPlaceFromServer = parseStringToGetTileIDFromServerMessageIfActivePlayer(fromServer);
        } else {
            gameId = parser.getGameIDFromServerMessageIfNotActivePlayer(fromServer);
        }
        return fromServer;
    }

    public boolean weAreTheActivePlayer(String fromServer) {
        return parser.weAreActivePlayer(fromServer);
    }

    public void sendMessageToServerBasedOnOurPlayersMove(PlayerBrain brain) {
        Tile tilePlacedByAI = brain.getBestTilePlacement();

        int tilePlacedX = tilePlacedByAI.getHex1().getCoordinate().getX();
        int tilePlacedY = tilePlacedByAI.getHex1().getCoordinate().getY();
        int tilePlacedZ = tilePlacedByAI.getHex1().getCoordinate().getZ();
        int orientationOfTilePlaced = tilePlacedByAI.getTileOrientation();

        BuildOption.typesOfBuildOptions buildOptions = brain.getBuildAction();

        if(BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT == buildOptions){
//            orientationOfTile ;
            Hex HexForSettlement = brain.getHexToBeUsedAsSettlement();
            int settlementLocationX = HexForSettlement.getCoordinate().getX();
            int settlementLocationY = HexForSettlement.getCoordinate().getY();
            int settlementLocationZ = HexForSettlement.getCoordinate().getZ();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " FOUND SETTLEMENT AT " + settlementLocationX + " " + settlementLocationY + " " + settlementLocationZ);
        }
        else if (BuildOption.typesOfBuildOptions.EXPANSION == buildOptions) {
            Hex HexForPlayerToExpand = brain.getHexToExpandTo();
            int settlementExpandedLocationX = HexForPlayerToExpand.getCoordinate().getX();
            int settlementExpandedLocationY = HexForPlayerToExpand.getCoordinate().getY();
            int settlementExpandedLocationZ = HexForPlayerToExpand.getCoordinate().getZ();

            //CHECK IF TERRAIN CAN BE PRINTED CORRECTLY
            Terrain.typesOfTerrain terrainToExpand = HexForPlayerToExpand.getTerrainType();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " EXPAND SETTLEMENT AT " + settlementExpandedLocationX + " " + settlementExpandedLocationY + " " + settlementExpandedLocationZ + " " + terrainToExpand);
        }
        else if (BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY == buildOptions) {
            Hex HexForTotoroSanctuary = brain.getHexToPlaceTotoro();
            int totoroSanctuaryLocationX = HexForTotoroSanctuary.getCoordinate().getX();
            int totoroSanctuaryLocationY = HexForTotoroSanctuary.getCoordinate().getY();
            int totoroSanctuaryLocationZ = HexForTotoroSanctuary.getCoordinate().getZ();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " BUILD TOTORO SANCTUARY AT " + totoroSanctuaryLocationX + " " + totoroSanctuaryLocationY + " " + totoroSanctuaryLocationZ);
        }
        else if (BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND == buildOptions) {
            Hex HexForTigerSanctuary = brain.getHexToPlaceTiger();
            int tigerPlaygroundLocationX = HexForTigerSanctuary.getCoordinate().getX();
            int tigerPlaygroundLocationY = HexForTigerSanctuary.getCoordinate().getY();
            int tigerPlaygroundLocationZ = HexForTigerSanctuary.getCoordinate().getZ();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " BUILD TIGER PLAYGROUND AT " + tigerPlaygroundLocationX + " " + tigerPlaygroundLocationY + " " + tigerPlaygroundLocationZ);
        }
        else if (BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD == buildOptions){
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " UNABLE TO BUILD");
        }
    }

    public void handleMessageSetToBothPlayersFromServer(Map m, PlayerBrain brain, String fromServer) throws IOException {
        String opponentMove;
        int opponentOrientation;
        Coordinate opponentVolcanoCoordinate;
        Tile opponentTile;
        String currentState = parser.getCurrentStateFromServer(fromServer);
        PlayerState.gameState stateOfGame = null;
        if(didSomeoneLose(currentState)){
            stateOfGame = parser.getGameStateFromMessageSentToBothPlayers(fromServer);
            if(weLostTheGame(brain, fromServer)){
                setStateIfWeLostTheGame(brain, stateOfGame);
                //End Game.....
            }
            else{
                setStateIfWeWonTheGame(brain, stateOfGame);
                //End Game.....
            }

            //then check if we lost or if opponent lost
            //if we lost, then set our player state to Lost
            //if we forfeited, then set out player state to forfeited
        }
        //if(parser.getPIDFromServerSentToBothPlayers(fromServer).equals())
        //update the map, given meeples, totoros, tigers,
        //TODO ..."Place <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>
        //TODO ... or expand or whatever
        opponentMove = getOpponentMove(fromServer);
        opponentOrientation = getOpponentTileOrientation(opponentMove);
        opponentVolcanoCoordinate = getVolcanoCoordinateFromOpponent(opponentMove);
        opponentTile = createTileFromOpponentToPlaceOnBoard(opponentMove);
        brain.giveBrainTheUpdatedVolcanoCoordinates(opponentVolcanoCoordinate, opponentOrientation);
        m.placeTile(opponentTile, opponentVolcanoCoordinate, opponentOrientation);

    }

    public boolean didSomeoneLose(String currentState) {
        return !currentState.equals("PLACE");
    }

    public void setStateIfWeWonTheGame(PlayerBrain brain, PlayerState.gameState stateOfGame) {
        brain.getOpponent().setCurrentStateOfTheGameAfterAIMove(stateOfGame);
        brain.getOurPlayer().setCurrentStateOfTheGameAfterAIMove(stateOfGame.WINNER);
    }

    public void setStateIfWeLostTheGame(PlayerBrain brain, PlayerState.gameState stateOfGame) {
        brain.getOurPlayer().setCurrentStateOfTheGameAfterAIMove(stateOfGame);
        brain.getOpponent().setCurrentStateOfTheGameAfterAIMove(stateOfGame.WINNER);
    }

    public boolean weLostTheGame(PlayerBrain brain, String fromServer) {
        String playerName = brain.getOurPlayer().getPlayerName();
        String playerNameFromServer = parser.getPlayerIdFromMessageSentToBothPlayers(fromServer);
        return playerName.equalsIgnoreCase(playerNameFromServer);
    }


    private Tile createTileFromOpponentToPlaceOnBoard(String opponentMove) {
        String tileOpponentPlaced = parser.getTileOpponentPlacedFromServer(opponentMove);
        Tile t = createTile(tileOpponentPlaced);
        return t;
    }

    private Tile createTile(String s){
        tileToPlaceFromServer = parser.getTileIDFromServerMessageIfActivePlayer(s);
        Terrain.typesOfTerrain terrainA = parser.getTerrainAFromString(tileToPlaceFromServer);
        Terrain.typesOfTerrain terrainB = parser.getTerrainBFromString(tileToPlaceFromServer);
        Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, -1000);
        Hex hex2 = new Hex(terrainA, -1000);
        Hex hex3 = new Hex(terrainB, -1000);
        Tile t = new Tile(hex1, hex2, hex3, -1000);
        return t;
    }

    private Coordinate getVolcanoCoordinateFromOpponent(String opponentMove) {
        int opponentX = parser.getXCoordFromOpponentMove(opponentMove);
        int opponentY = parser.getYCoordFromOpponentMove(opponentMove);
        int opponentZ = parser.getZCoordFromOpponentMove(opponentMove);
        return new Coordinate(opponentZ, opponentX, opponentY);
    }

    private String getOpponentMove(String fromServer) {
        return parser.getOpponentMoveFromServer(fromServer);
    }

    private int getOpponentTileOrientation(String opponentMove) {
        return parser.getOrientationFromOpponent(opponentMove);
    }

    public String getPlayerId() {
        return playerId;
    }

}