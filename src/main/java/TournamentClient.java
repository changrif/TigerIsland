
import java.io.*;
import java.net.*;

public class TournamentClient {

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
    }

    public void runClient() throws IOException {
        Map m = new Map();
        Player ourAI = new Player(playerId, m);
        Player opponentAI = new Player(opponentId, m);
        String fromServer;
        for(int i = 0; i < 48; i++){

            fromServer = in.readLine();//either "MAKE YOUR MOVE..." OR "GAME A MOVE 1 PLACE tile AT xyz..."

            if (weAreActivePlayer(fromServer)) {
                System.out.println("Server: " + fromServer);//make your move //getTile x+y where x,y = "JUNGLE" "LAKE" "GRASS" "ROCK"
                tileToPlaceFromServer = parseStringToGetTileIDFromServerMessageIfActivePlayer(fromServer);

                Terrain.typesOfTerrain terrainA = getTerrainAFromString(tileToPlaceFromServer);
                Terrain.typesOfTerrain terrainB = getTerrainBFromString(tileToPlaceFromServer);
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, -1000);
                Hex hex2 = new Hex(terrainA, -1000);
                Hex hex3 = new Hex(terrainB, -1000);
                Tile t = new Tile(hex1, hex2, hex3, -1000);

                ourAI.giveTileToAI(t);
                sendMessageToServerBasedOnThePlayersMove(ourAI);
            }
            else{
                fromServer = in.readLine();//message sent to both players
                System.out.println("Server: " + fromServer);
                //update the map, given meeples, totoros, tigers,
                //TODO <move>: "Place <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z> ... or expand or whatever
            }


        }


    }

    private Terrain.typesOfTerrain getTerrainAFromString(String tileToPlaceFromServer) {
        Terrain t = new Terrain();
        String [] AandB = tileToPlaceFromServer.split("\\+");
        String A = AandB[0];
        return t.getTerrainTypeFromString(A);
    }

    private Terrain.typesOfTerrain getTerrainBFromString(String tileToPlaceFromServer) {
        Terrain t = new Terrain();
        String [] AandB = tileToPlaceFromServer.split("\\+");
        String B = AandB[1];
        return t.getTerrainTypeFromString(B);
    }


    public String getPlayerId() {
        return playerId;
    }

    public void sendMessageToServerBasedOnThePlayersMove(Player ourAI) {
        Tile tilePlacedByAI = ourAI.getFirstValidTilePlacementCoordinate();
        int tilePlacedX = tilePlacedByAI.getHex1().getCoordinate().getX();
        int tilePlacedY = tilePlacedByAI.getHex1().getCoordinate().getY();
        int tilePlacedZ = tilePlacedByAI.getHex1().getCoordinate().getZ();
        int orientationOfTile = tilePlacedByAI.getTileOrientation();
        int buildOption = ourAI.getBuildAction();
        if(buildOption == 1){
//            orientationOfTile ;
            Hex HexForSettlement = ourAI.getHexToBeUsedAsSettlement();
            int settlementLocationX = HexForSettlement.getCoordinate().getX();
            int settlementLocationY = HexForSettlement.getCoordinate().getY();
            int settlementLocationZ = HexForSettlement.getCoordinate().getZ();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTile + " FOUND SETTLEMENT AT " + settlementLocationX + " " + settlementLocationY + " " + settlementLocationZ);
        }
        else if (buildOption ==2 ) {
            Hex HexForPlayerToExpand = ourAI.getHexToExpandTo();
            int settlementExpandedLocationX = HexForPlayerToExpand.getCoordinate().getX();
            int settlementExpandedLocationY = HexForPlayerToExpand.getCoordinate().getY();
            int settlementExpandedLocationZ = HexForPlayerToExpand.getCoordinate().getZ();

            //CHECK IF TERRAIN CAN BE PRINTED CORRECTLY
            Terrain.typesOfTerrain terrainToExpand = HexForPlayerToExpand.getTerrainType();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTile + " EXPAND SETTLEMENT AT " + settlementExpandedLocationX + " " + settlementExpandedLocationY + " " + settlementExpandedLocationZ + " " + terrainToExpand);
        }
        else if (buildOption == 3) {
            Hex HexForTotoroSanctuary = ourAI.getHexToPlaceTotoro();
            int totoroSanctuaryLocationX = HexForTotoroSanctuary.getCoordinate().getX();
            int totoroSanctuaryLocationY = HexForTotoroSanctuary.getCoordinate().getY();
            int totoroSanctuaryLocationZ = HexForTotoroSanctuary.getCoordinate().getZ();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTile + " BUILD TOTORO SANCTUARY AT " + totoroSanctuaryLocationX + " " + totoroSanctuaryLocationY + " " + totoroSanctuaryLocationZ);
        }
        else if (buildOption == 4) {
            Hex HexForTigerSanctuary = ourAI.getHexToPlaceTiger();
            int tigerPlaygroundLocationX = HexForTigerSanctuary.getCoordinate().getX();
            int tigerPlaygroundLocationY = HexForTigerSanctuary.getCoordinate().getY();
            int tigerPlaygroundLocationZ = HexForTigerSanctuary.getCoordinate().getZ();
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTile + " BUILD TIGER PLAYGROUND AT " + tigerPlaygroundLocationX + " " + tigerPlaygroundLocationY + " " + tigerPlaygroundLocationZ);
        }
        else if (buildOption == -1){
            out.println("Client: GAME " + gameId + " MOVE " + moveNumber + " PLACE " + tileToPlaceFromServer +
                    " AT " + tilePlacedX + " " + tilePlacedY + " " + tilePlacedZ + " " + orientationOfTile + " UNABLE TO BUILD");
        }
    }

    public String setUpMoveProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        if (weAreActivePlayer(fromServer)) {
            gameId = parseStringToGetGameIDFromServerMessageIfActivePlayer(fromServer);
//            moveNumber = parseStringToGetMoveNumberFromServerMessageIfActivePlayer(fromServer);
//            tileToPlaceFromServer = parseStringToGetTileIDFromServerMessageIfActivePlayer(fromServer);
        } else {
            gameId = parseStringToGetGameIDFromServerMessageIfNotActivePlayer(fromServer);
        }
        return fromServer;
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
        playerId = parseStringToGetPlayerIDFromServerMessage(fromServer);
        System.out.println("Server: " + fromServer);
    }

    public void setUpChallengeProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        challengeId = parseStringToGetChallengeIDFromServerMessage(fromServer);
        numberOfRounds = parseStringToGetNumberOfRoundsFromServerMessage(fromServer);
        System.out.println("Server: " + fromServer);
    }

    public void setUpRoundProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        roundId = parseStringToGetRoundIDFromServerMessage(fromServer);
        System.out.println("Server: " + fromServer);
    }

    public void setUpMatchProtocol() throws IOException {
        String fromServer;
        fromServer = in.readLine();
        opponentId = parseStringToGetOpponentPlayerIDFromServerMessage(fromServer);
        System.out.println("Server: " + fromServer);
    }

    private String parseStringToGetPlayerIDFromServerMessage(String fromServer) {
        String pid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        pid = splitStringFromServer[splitStringFromServer.length-1];
        return pid;
    }

    private String parseStringToGetChallengeIDFromServerMessage(String fromServer) {
        String cid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        cid = splitStringFromServer[2];
        return cid;
    }

    private int parseStringToGetNumberOfRoundsFromServerMessage(String fromServer) {
        String numRounds;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        numRounds = splitStringFromServer[6];
        return Integer.parseInt(numRounds);
    }

    private int parseStringToGetRoundIDFromServerMessage(String fromServer) {
        String rid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        rid = splitStringFromServer[2];
        return Integer.parseInt(rid);
    }

    private String parseStringToGetGameIDFromServerMessageIfActivePlayer(String fromServer) {
        String gid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        gid = splitStringFromServer[5];
        return gid;
    }


    private String parseStringToGetGameIDFromServerMessageIfNotActivePlayer(String fromServer) {
        String gid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        gid = splitStringFromServer[1];
        return gid;
    }

    private String parseStringToGetOpponentPlayerIDFromServerMessage(String fromServer) {
        String pid;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        pid = splitStringFromServer[splitStringFromServer.length-1];
        return pid;
    }

    private boolean weAreActivePlayer(String fromServer) {
         return fromServer.startsWith("M");
    }

    private int parseStringToGetMoveNumberFromServerMessageIfActivePlayer(String fromServer) {
        String moveNum;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        moveNum = splitStringFromServer[10];
        return Integer.parseInt(moveNum);
    }

    private String parseStringToGetTileIDFromServerMessageIfActivePlayer(String fromServer) {
        String TileId;
        String [] splitStringFromServer;
        splitStringFromServer = fromServer.split(" ");
        TileId = splitStringFromServer[splitStringFromServer.length-1];
        return TileId;
    }

}