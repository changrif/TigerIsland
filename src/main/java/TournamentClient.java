
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
        setUpProtocolBeforeGame();

        Map m = new Map();
        Player ourAI = new Player(playerId);//this is invalid
        Player opponentAI = new Player(opponentId);
        PlayerBrain brain = new PlayerBrain(ourAI, opponentAI, m);

        beginGame(m, brain);
    }

    public void setUpProtocolBeforeGame() throws IOException {
        setUpAuthenticationProtocol();

        setUpChallengeProtocol();

        setUpRoundProtocol();

        setUpMatchProtocol();
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
        playerId = parser.getPlayerIDFromServerMessageDuringAuthenticationProtocol(fromServer);
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

    public void beginGame(Map m, PlayerBrain brain) throws IOException {
        String fromServer;
        boolean gameInSession = true;
        fromServer = in.readLine();
        getGameIDFromServer(fromServer);
        while(gameInSession){
            if (weAreTheActivePlayer(fromServer)) {
                System.out.println("Server: " + fromServer);//make your move //getTile x+y where x,y = "JUNGLE" "LAKE" "GRASS" "ROCK"
                Tile tileToPlace = createTile(fromServer);
                brain.setTileToPlace(tileToPlace);
                sendMessageToServerBasedOnOurPlayersMove(brain);
            }
            else{
                System.out.println("Server: " + fromServer);//GAME <gid> MOVE <#> PLAYER <pid> <move> or forfeited, lost etc.
                handleMessageSentToBothPlayersFromServer(m, brain, fromServer);
            }
            fromServer = in.readLine();//either "MAKE YOUR MOVE..." OR "GAME A MOVE 1 PLACE tile AT xyz..."
            if(isGameOver(fromServer)){
                gameInSession = false;
            }
        }
    }

    private boolean isGameOver(String fromServer) {
        return parser.isGameOver(fromServer);
    }

    public void getGameIDFromServer(String fromServer) {
        if (weAreTheActivePlayer(fromServer)) {
            gameId = parser.getGameIDFromServerMessageIfActivePlayer(fromServer);
//            moveNumber = parseStringToGetMoveNumberFromServerMessageIfActivePlayer(fromServer);
//            tileToPlaceFromServer = parseStringToGetTileIDFromServerMessageIfActivePlayer(fromServer);
        } else {
            gameId = parser.getGameIDFromServerMessageIfNotActivePlayer(fromServer);
        }
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
            Coordinate coordinateForPlayerToExpand = brain.getCoordinateToExpandTo();
            int settlementExpandedLocationX = coordinateForPlayerToExpand.getX();
            int settlementExpandedLocationY = coordinateForPlayerToExpand.getY();
            int settlementExpandedLocationZ = coordinateForPlayerToExpand.getZ();
            Terrain.typesOfTerrain terrainToExpand = brain.getTerrainForExpansion();
            Terrain terra = new Terrain();
            String terrainToExpandAsString = terra.convertTerrainToString(terrainToExpand);
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " EXPAND SETTLEMENT AT " + settlementExpandedLocationX + " " + settlementExpandedLocationY + " " + settlementExpandedLocationZ + " " + terrainToExpandAsString);
        }
//        else if (BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY == buildOptions) {
//            Hex HexForTotoroSanctuary = brain.getHexToPlaceTotoro();
//            int totoroSanctuaryLocationX = HexForTotoroSanctuary.getCoordinate().getX();
//            int totoroSanctuaryLocationY = HexForTotoroSanctuary.getCoordinate().getY();
//            int totoroSanctuaryLocationZ = HexForTotoroSanctuary.getCoordinate().getZ();
//            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
//                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " BUILD TOTORO SANCTUARY AT " + totoroSanctuaryLocationX + " " + totoroSanctuaryLocationY + " " + totoroSanctuaryLocationZ);
//        }
        else if (BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND == buildOptions) {
            Coordinate coordinateForTigerPlayground = brain.getCoordinateForTigerPlayground();
            int tigerPlaygroundLocationX = coordinateForTigerPlayground.getX();
            int tigerPlaygroundLocationY = coordinateForTigerPlayground.getY();
            int tigerPlaygroundLocationZ = coordinateForTigerPlayground.getZ();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " BUILD TIGER PLAYGROUND AT " + tigerPlaygroundLocationX + " " + tigerPlaygroundLocationY + " " + tigerPlaygroundLocationZ);
        }
        else if (BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD == buildOptions){
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " UNABLE TO BUILD");
        }
    }

    public void handleMessageSentToBothPlayersFromServer(Map m, PlayerBrain brain, String fromServer) throws IOException {
        String opponentMove;
        int opponentOrientation;
        Coordinate opponentVolcanoCoordinate;
        Tile opponentTile;
        String currentState = parser.getCurrentStateFromServer(fromServer);
        PlayerState.gameState stateOfGame = null;
        if(didSomeoneLose(currentState)){
            //then check if we lost or if opponent lost
            //if we lost, then set our player state to Lost
            //if we forfeited, then set out player state to forfeited
//            stateOfGame = parser.getGameStateFromMessageSentToBothPlayers(fromServer);
//            if(weLostTheGame(brain, fromServer)){
//                setStateIfWeLostTheGame(brain, stateOfGame);
//                //End Game.....
//            }
//            else{
//                setStateIfWeWonTheGame(brain, stateOfGame);
//                //End Game.....
//            }


        }
        else{
            placeTileFromOpponent(m, brain, fromServer);
            opponentMove = getOpponentMove(fromServer);

            if(BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT == parseBuildSelectionFromOpponent(opponentMove)) {
                addOpponentSettlementToBoard(m, brain, opponentMove);
            }
            else if(BuildOption.typesOfBuildOptions.EXPANSION == parseBuildSelectionFromOpponent(opponentMove)){
                addOpponentExpansionOnBoardBasedOnTheServerMessage(m, brain, opponentMove);
            }
            else if(BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY == parseBuildSelectionFromOpponent(opponentMove)){
                addOpponentTotoroSanctuaryToBoard(m, brain, opponentMove);
            }
            else if(BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND == parseBuildSelectionFromOpponent(opponentMove)){
                addOpponentTigerPlaygroundToBoard(m, brain, opponentMove);
            }
            else if(BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD == parseBuildSelectionFromOpponent(opponentMove)){

            }
        }
        //if(parser.getPIDFromServerSentToBothPlayers(fromServer).equals())
        //update the map, given meeples, totoros, tigers,
        //TODO ..."Place <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>
        //TODO ... or expand or whatever


    }

    private void addOpponentSettlementToBoard(Map m, PlayerBrain brain, String s){
        int xCoordForOpponenentSettlement = parser.getXCoordFromOpponentMove(s);
        int yCoordForOpponenentSettlement = parser.getYCoordFromOpponentMove(s);
        int zCoordForOpponenentSettlement = parser.getZCoordFromOpponentMove(s);
        Coordinate c = new Coordinate(zCoordForOpponenentSettlement, xCoordForOpponenentSettlement, yCoordForOpponenentSettlement);
        m.foundNewSettlement(c, brain.getOpponent());
    }

    private void addOpponentExpansionOnBoardBasedOnTheServerMessage(Map m, PlayerBrain brain, String s) {
        int xCoordForOpponenentExpansion = parser.getXCoordFromOpponentMove(s);
        int yCoordForOpponenentExpansion = parser.getYCoordFromOpponentMove(s);
        int zCoordForOpponenentExpansion = parser.getZCoordFromOpponentMove(s);
        Coordinate c = new Coordinate(zCoordForOpponenentExpansion, xCoordForOpponenentExpansion, yCoordForOpponenentExpansion);
        Terrain.typesOfTerrain t = parser.getTerrainTypeFromServerMessageIfOpponentExpands(s);
        m.ExpandSettlement(c, t, brain.getOpponent());
    }

    private void addOpponentTotoroSanctuaryToBoard(Map m, PlayerBrain brain, String opponentMove) {
        int xCoordForOpponenentTotoroSanctuary = parser.getXCoordFromOpponentMove(opponentMove);
        int yCoordForOpponenentTotoroSanctuary = parser.getYCoordFromOpponentMove(opponentMove);
        int zCoordForOpponenentTotoroSanctuary = parser.getZCoordFromOpponentMove(opponentMove);
        Coordinate c = new Coordinate(zCoordForOpponenentTotoroSanctuary, xCoordForOpponenentTotoroSanctuary, yCoordForOpponenentTotoroSanctuary);
        m.PlaceTotoro(c, brain.getOpponent());
    }

    private void addOpponentTigerPlaygroundToBoard(Map m, PlayerBrain brain, String opponentMove) {
        int xCoordForOpponenentTigerPlayground = parser.getXCoordFromOpponentMove(opponentMove);
        int yCoordForOpponenentTigerPlayground = parser.getYCoordFromOpponentMove(opponentMove);
        int zCoordForOpponenentTigerPlayground = parser.getZCoordFromOpponentMove(opponentMove);
        Coordinate c = new Coordinate(zCoordForOpponenentTigerPlayground, xCoordForOpponenentTigerPlayground, yCoordForOpponenentTigerPlayground);
        m.PlaceTiger(c, brain.getOpponent());
    }

    private BuildOption.typesOfBuildOptions parseBuildSelectionFromOpponent(String opponentMove) {
        BuildOption.typesOfBuildOptions buildOptions = parser.getBuildOptionFromMessageSentToBothPlayers(opponentMove);
        return buildOptions;
    }


    public void placeTileFromOpponent(Map m, PlayerBrain brain, String fromServer) {
        String opponentMove;
        int opponentOrientation;
        Coordinate opponentVolcanoCoordinate;
        Tile opponentTile;
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

    private Tile createTile(String fromServer){
        tileToPlaceFromServer = parser.getTileIDFromServerMessageIfActivePlayer(fromServer);
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