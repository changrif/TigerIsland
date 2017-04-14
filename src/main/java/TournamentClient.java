import java.io.*;
import java.net.*;

public class TournamentClient {
    private StringParser parser;
    private String hostName;
    private int portNumber;
    private String tournamentPassword;
    private String teamUsername;
    private String teamPassword;
    private int numberOfRounds;
    private String playerId;
    private String opponentId;
    private Map mapForGameOne;
    private Map mapForGameTwo;
    private MockServer fileInput;
    private boolean thereAreChallengesLeft;
    private String gameID;
    private PlayerBrain brain1;
    private PlayerBrain brain2;
    private boolean matchHasBegun;

    private final double TIME_FOR_MOVE = 1.5;

    Socket tournamentSocket;
    PrintWriter out;
    BufferedReader in;
    private boolean bothPlayersAreStillActive;

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
        //fileInput = new MockServer();

        bothPlayersAreStillActive = true;
        thereAreChallengesLeft = true;
    }

    public void runClient() throws IOException {
        setUpAuthenticationProtocol();
        setUpChallengeProtocol();
        System.out.println("WHY ISN'T THIS CHANGING");
        System.out.println("WHY ISN'T THIS CHANGING");
        System.out.println("WHY ISN'T THIS CHANGING");
        System.out.println("WHY ISN'T THIS CHANGING");

        while(thereAreChallengesLeft) {
            setUpRoundProtocol();
            setUpMatchProtocol();
            for (int i = 0; i < numberOfRounds; i++) {
                mapForGameOne = new Map();
                mapForGameOne.placeFirstTile();
                mapForGameTwo = new Map();
                mapForGameTwo.placeFirstTile();

                System.out.println("reset player data");
                Player ourAI = new Player(playerId);
                Player opponentAI = new Player(opponentId);
                brain1 = new PlayerBrain(ourAI, opponentAI, mapForGameOne);
                brain2 = new PlayerBrain(ourAI, opponentAI, mapForGameTwo);
                brain1.setGameInProgress(true);
                brain2.setGameInProgress(true);

                runMoveProtocol();

                gameID = "";
                setUpRoundProtocol();
                setUpMatchProtocol();
            }
            setUpChallengeProtocol();
        }

        while(true) {
            if(getAndDisplayMessageFromServer() != null)    {
            }
            else    {
                try{
                    out.close();
                    in.close();
                } catch (IOException e){}
                break;
            }
        }
    }

    public void setUpAuthenticationProtocol() throws IOException {
        String fromServer;

        fromServer = getAndDisplayMessageFromServer();
        if(fromServer.contains("WELCOME TO ANOTHER EDITION OF THUNDERDOME"))    {
            out.println("ENTER THUNDERDOME " + tournamentPassword);
            System.out.println("Client: ENTER THUNDERDOME " + tournamentPassword);
        }

        fromServer = getAndDisplayMessageFromServer();
        if(fromServer.contains("TWO SHALL ENTER"))  {
            out.println("I AM " + teamUsername + " " + teamPassword);
            System.out.println("Client: I AM " + teamUsername + " " + teamPassword);
        }

        fromServer = getAndDisplayMessageFromServer();
        if(fromServer.contains("WAIT FOR THE TOURNAMENT TO BEGIN")) {
            playerId = parser.getPlayerIDFromServerMessageDuringAuthenticationProtocol(fromServer);
        }
    }

    public void setUpChallengeProtocol() throws IOException {
        String fromServer;
        //   challengeId = parser.getChallengeIDFromServerMessage(fromServer); THANKS DAVE
        fromServer = getAndDisplayMessageFromServer();
        if(fromServer.contains("NEW CHALLENGE")) {
            numberOfRounds = parser.getNumberOfRoundsFromServerMessage(fromServer);
        }
        else if(fromServer.contains("WAIT FOR THE NEXT CHALLENGE")) {
            setUpChallengeProtocol();
        }
        else if(fromServer.contains("END OF CHALLENGE"))    {
            thereAreChallengesLeft = false;
        }
    }

    public void setUpRoundProtocol() throws IOException {
        String fromServer = getAndDisplayMessageFromServer();
        if(fromServer.contains("WAIT FOR THE NEXT MATCH")) {
            setUpRoundProtocol();
        }
    }

    public void setUpMatchProtocol() throws IOException {
        String fromServer = getAndDisplayMessageFromServer();
        if(fromServer.contains("NEW MATCH")) {
            opponentId = parser.getOpponentPlayerIDFromServerMessage(fromServer);
            System.out.println("OPPONENT ID" + opponentId);
            matchHasBegun = true;
        }
        else if(fromServer.contains("OVER PLAYER"))   { //GAME <GID> OVER PLAYER ...
            getAndDisplayMessageFromServer();
        }
    }

    public void runMoveProtocol() throws IOException {
        String fromServer;
        Tile tileToPlace;
        int moveNumber = -1; //maybe add a check

        while(brain1.isGameInProgress() || brain2.isGameInProgress()) {
            fromServer = getAndDisplayMessageFromServer();
            if (fromServer.contains("MAKE YOUR MOVE")) {
                gameID = parser.getGameIDFromServerMessageIfActivePlayer(fromServer);
                moveNumber = parser.getMoveNumberFromServerMessage(fromServer);

                if (matchHasBegun) {
                    setGameIDForBrain(brain1);
                    matchHasBegun = false;
                }
                if(gameID.equals(brain1.getGameID())) {
                    System.out.println("BRAIN 1");
                    // Get details of the move from server
                    String terrains = parser.getTileIDFromServerMessageIfActivePlayer(fromServer);
                    tileToPlace = brain1.createTile(fromServer, moveNumber);
                    brain1.setTileToPlace(tileToPlace);
                    //Client sends message to server
                    sendMessageToServerBasedOnOurPlayersMove(brain1, moveNumber, gameID, terrains);
                }
                else{
                    System.out.println("BRAIN 2");
                    // Get details of the move from server
                    String terrains = parser.getTileIDFromServerMessageIfActivePlayer(fromServer);
                    tileToPlace = brain2.createTile(fromServer, moveNumber);
                    brain2.setTileToPlace(tileToPlace);
                    //Client sends message to server
                    sendMessageToServerBasedOnOurPlayersMove(brain2, moveNumber, gameID, terrains);
                }

            } else if (fromServer.contains("PLAYER " + opponentId + " PLACED")) {
                gameID = parser.getGameIDFromServerMessageIfNotActivePlayer(fromServer);
                moveNumber = parser.getMoveNumberFromServerMessage(fromServer);
                System.out.println("PLAYER OPPONENT PLACED");

                System.out.println(moveNumber);
                if (matchHasBegun) {
                    setGameIDForBrain(brain1);
                    matchHasBegun = false;
                }
                if (gameID.equals(brain1.getGameID())) {
                    System.out.println("BRAIN 1");
                    // Get details of the move from server
                    String opponentMove = parser.getOpponentMoveFromServer(fromServer);
                    tileToPlace = brain1.createTileFromOpponentToPlaceOnBoard(opponentMove, moveNumber);
                    brain1.setTileToPlace(tileToPlace);
                    //Client sends message to server
                    brain1.placeTileFromOpponent(opponentMove, moveNumber);
                    brain1.addOpponentsMoveToBoardBasedOnBuildOption(parser.getOpponentMoveFromServer(fromServer));
                } else {
                    System.out.println("BRAIN 2");
                    // Get details of the move from server
                    String opponentMove = parser.getOpponentMoveFromServer(fromServer);
                    tileToPlace = brain2.createTileFromOpponentToPlaceOnBoard(opponentMove, moveNumber);
                    brain2.setTileToPlace(tileToPlace);

                    //Client sends message to server
                    brain2.placeTileFromOpponent(opponentMove, moveNumber);
                    brain2.addOpponentsMoveToBoardBasedOnBuildOption(parser.getOpponentMoveFromServer(fromServer));
                }
            }
            else if (fromServer.contains("FORFEITED") || fromServer.contains("LOST")) {
                gameID = parser.getGameIDFromServerMessageIfNotActivePlayer(fromServer);

                if(matchHasBegun)   {
                    setGameIDForBrain(brain1);
                    matchHasBegun = false;
                }
                if(gameID.equals(brain1.getGameID())){
                    brain1.setGameInProgress(false);
                }
                else{
                    brain2.setGameInProgress(false);
                }
            }
        }
    }

    public void sendMessageToServerBasedOnOurPlayersMove(PlayerBrain brain, int moveNumber, String gameID, String tileToPlace) {
        brain.setBestTilePlacement();
        brain.executeTilePlacement();
        //brain needs to place tile now  (this is just a note telling us where we place the tile!)
        Tile tilePlacedByAI = brain.getTileToPlace();

        int tilePlacedX = tilePlacedByAI.getHex1().getCoordinate().getX()-100;
        int tilePlacedY = tilePlacedByAI.getHex1().getCoordinate().getY()-100;
        int tilePlacedZ = tilePlacedByAI.getHex1().getCoordinate().getZ()-100;
        int orientationOfTilePlaced = tilePlacedByAI.getTileOrientation();

        brain.getBestBuildAction();
        BuildOption.typesOfBuildOptions buildOptions = brain.getBuildAction();
        brain.executeBuildAction();

        if(BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT == buildOptions){
            Coordinate coordinateForSettlement = brain.getCoordinateToBeUsedAsSettlement();
            int settlementLocationX = coordinateForSettlement.getX()-100;
            int settlementLocationY = coordinateForSettlement.getY()-100;
            int settlementLocationZ = coordinateForSettlement.getZ()-100;
            out.println("GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " FOUND SETTLEMENT AT " + settlementLocationX + " " + settlementLocationY + " " + settlementLocationZ);
            System.out.println("Client: GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " FOUND SETTLEMENT AT " + settlementLocationX + " " + settlementLocationY + " " + settlementLocationZ);

        }
        else if (BuildOption.typesOfBuildOptions.EXPANSION == buildOptions) {
            Coordinate coordinateForPlayerToExpand = brain.getCoordinateToExpandTo();
            int settlementExpandedLocationX = coordinateForPlayerToExpand.getX()-100;
            int settlementExpandedLocationY = coordinateForPlayerToExpand.getY()-100;
            int settlementExpandedLocationZ = coordinateForPlayerToExpand.getZ()-100;
            Terrain.typesOfTerrain terrainToExpand = brain.getTerrainForExpansion();
            Terrain terra = new Terrain();
            String terrainToExpandAsString = terra.convertTerrainToString(terrainToExpand);
            out.println("GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " EXPAND SETTLEMENT AT " + settlementExpandedLocationX + " " + settlementExpandedLocationY + " " + settlementExpandedLocationZ + " " + terrainToExpandAsString);
            System.out.println("Client: GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " EXPAND SETTLEMENT AT " + settlementExpandedLocationX + " " + settlementExpandedLocationY + " " + settlementExpandedLocationZ + " " + terrainToExpandAsString);
        }
        else if (BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY == buildOptions) {
            Coordinate coordinateForTotoroSanctuary = brain.getCoordinateForTotoroSanctuary();
            int totoroSanctuaryLocationX = coordinateForTotoroSanctuary.getX()-100;
            int totoroSanctuaryLocationY = coordinateForTotoroSanctuary.getY()-100;
            int totoroSanctuaryLocationZ = coordinateForTotoroSanctuary.getZ()-100;
            out.println("GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " BUILD TOTORO SANCTUARY AT " + totoroSanctuaryLocationX + " " + totoroSanctuaryLocationY + " " + totoroSanctuaryLocationZ);
            System.out.println("Client: GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " BUILD TOTORO SANCTUARY AT " + totoroSanctuaryLocationX + " " + totoroSanctuaryLocationY + " " + totoroSanctuaryLocationZ);

        }
        else if (BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND == buildOptions) {
            Coordinate coordinateForTigerPlayground = brain.getCoordinateForTigerPlayground();
            int tigerPlaygroundLocationX = coordinateForTigerPlayground.getX()-100;
            int tigerPlaygroundLocationY = coordinateForTigerPlayground.getY()-100;
            int tigerPlaygroundLocationZ = coordinateForTigerPlayground.getZ()-100;
            out.println("GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " BUILD TIGER PLAYGROUND AT " + tigerPlaygroundLocationX + " " + tigerPlaygroundLocationY + " " + tigerPlaygroundLocationZ);
            System.out.println("Client: GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " BUILD TIGER PLAYGROUND AT " + tigerPlaygroundLocationX + " " + tigerPlaygroundLocationY + " " + tigerPlaygroundLocationZ);
        }
        else if (BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD == buildOptions){
            out.println("GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " UNABLE TO BUILD");
            System.out.println("Client: GAME " + gameID + " MOVE " + moveNumber + " PLACE " + tileToPlace +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTilePlaced + " UNABLE TO BUILD");
        }
    }

    public String getAndDisplayMessageFromServer() throws IOException {
        String fromServer = in.readLine();
        //String fromServer = fileInput.readFromFile();//make your move, sent to active player, we don't know gid yet
        System.out.println("Server: " + fromServer);
        return fromServer;
    }

    public void setGameIDForBrain(PlayerBrain brain) {
        brain.setGameID(gameID);
    }
}