import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Nick Kroeger on 4/5/2017.
 */
public class PlayerBrain {

    private final Coordinate ORIGIN = new Coordinate(100, 100, 100);
    private Player currentPlayer;
    private Player ourPlayer;
    private String gameID;
    private boolean gameInProgress;
    private Player opponent;
    private Map map;
    private Tile bestTilePlacement;
    private Tile tileToPlace;
    private BuildOption.typesOfBuildOptions buildOption;
    public Terrain.typesOfTerrain typeOfTerrainForBestExpansion;
    public Coordinate bestSettlementPlacementForFounding;
    public Coordinate bestSettlementPlacementForExpansion;
    public Coordinate bestSettlementPlacementForTiger;
    public Coordinate bestSettlementPlacementForTotoro;
    private ArrayList<Coordinate> volcanoCoordinates = new ArrayList<>();
    private ArrayList<Coordinate> availableHexesOnLevelThree = new ArrayList<>();
    private ArrayList<Coordinate> availableHexesOnLevelOne = new ArrayList<>();
    private StringParser parser;

    public PlayerBrain(Player ourPlayer, Player opponent, Map map){
        this.currentPlayer = ourPlayer;
        this.ourPlayer = ourPlayer;
        this.opponent = opponent;
        this.map = map;
        volcanoCoordinates.add(ORIGIN);
        this.parser = new StringParser();
    }

    /*
        Basic Getter and Setters
     */
    public Map getMap() {
        return map;
    }

    public Player getCurrentPlayer() { return currentPlayer; }

    public void setCurrentPlayer(Player player) { this.currentPlayer = player; }

    public Player getOurPlayer() {
        return ourPlayer;
    }

    public Player getOpponent() {
        return opponent;
    }

    public Tile getTileToPlace() {
        return tileToPlace;
    }

    public void setTileToPlace(Tile tileToPlaceFromServer) {
        this.tileToPlace = tileToPlaceFromServer;
    }

    public BuildOption.typesOfBuildOptions getBuildAction() {
        return this.buildOption;
    }

    public void setBuildOption(BuildOption.typesOfBuildOptions buildOption) { this.buildOption = buildOption; }

    public Coordinate getCoordinateToBeUsedAsSettlement()  { return  bestSettlementPlacementForFounding; }

    public Coordinate getCoordinateToExpandTo() {
        return bestSettlementPlacementForExpansion;
    }

    public Terrain.typesOfTerrain getTerrainForExpansion(){
        return typeOfTerrainForBestExpansion;
    }

    public Coordinate getCoordinateForTigerPlayground() {
        return bestSettlementPlacementForTiger;
    }

    public Coordinate getCoordinateForTotoroSanctuary() {
        return bestSettlementPlacementForTotoro;
    }

    /*
        AI For Finding Best Tile Placement
     */
    public Tile getBestTilePlacement() {
        return bestTilePlacement;
    }

    public void setBestTilePlacement(){
        bestTilePlacement = tileToPlace;
        if((hasTigersLeft()) && canFindFirstValidStackedTilePlacement()) {
            setTileToPlace(bestTilePlacement);

            getBestBuildAction();
            if (!playerCanBuild())  {
                if(canFindFirstLevelOneTilePlacement()) {
                    setTileToPlace(bestTilePlacement);
                }
            }
        } else if(canFindFirstLevelOneTilePlacement()) {
            setTileToPlace(bestTilePlacement);
        }

        if(bestTilePlacement.getTileLevel() >= 3)   {
            addLevelThreeHexesToArrayList(tileToPlace.getHex2().getCoordinate(), tileToPlace.getHex3().getCoordinate());
        }

        map.splitSettlementsAfterNuking(tileToPlace);
        giveBrainTheUpdatedVolcanoCoordinates(bestTilePlacement.getHex1().getCoordinate(), bestTilePlacement.getTileOrientation());
    }

    private boolean playerCanBuild() {
        return (!(getBuildAction() == BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD) && !conflictWithFoundingASettlement());
    }

    private boolean conflictWithFoundingASettlement()    {
        if(getBuildAction() == BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT && !availableHexesOnLevelOne.isEmpty())    {
            removeHexesFromPlacement();
            if(availableHexesOnLevelOne.isEmpty())  {
                return true;
            }
        }
        return false;
    }

    private void removeHexesFromPlacement()    {
        for(int i = 0; i < availableHexesOnLevelOne.size(); i++)   {
            Coordinate coordinate = availableHexesOnLevelOne.get(i);
            if(coordinate.getX() == bestTilePlacement.getHex2().getCoordinate().getX() &&
                    coordinate.getY() == bestTilePlacement.getHex2().getCoordinate().getY() &&
                    coordinate.getZ() == bestTilePlacement.getHex2().getCoordinate().getZ())    {
                availableHexesOnLevelOne.remove(i);
            }

            if(coordinate.getX() == bestTilePlacement.getHex3().getCoordinate().getX() &&
                    coordinate.getY() == bestTilePlacement.getHex3().getCoordinate().getY() &&
                    coordinate.getZ() == bestTilePlacement.getHex3().getCoordinate().getZ())    {
                availableHexesOnLevelOne.remove(i);
            }
        }
    }

    private boolean canFindFirstLevelOneTilePlacement()    {
        LinkedList<Coordinate> queue = new LinkedList<>();
        Coordinate[] adjacentHexes = map.createAdjacentCoordinateArray(ORIGIN);
        ArrayList<Coordinate> isVisited = new ArrayList<>();
        isVisited.add(ORIGIN);

        for(Coordinate coordinate : adjacentHexes)  {
            queue.add(coordinate);
        }

        while(!queue.isEmpty()) {
            //get current Coordinate
            Coordinate currentCoordinate = queue.poll();
            isVisited.add(currentCoordinate);

            //if a neighboring tile isn't taken, then check for valid placements
            if(!map.isTaken(currentCoordinate)) {
                if (canPlaceTile(currentCoordinate)) {
                    return true;
                }
            }

            //if a neighboring tile is taken,
            //and neighbors aren't already added to the list of coordinates
            //then add them
            else    {
                Coordinate[] adjacencyMatrix = map.createAdjacentCoordinateArray(currentCoordinate);
                Coordinate adjacentCoordinate;
                for(int i = 0; i < adjacencyMatrix.length; i++) {
                    adjacentCoordinate = adjacencyMatrix[i];
                    if(!hexHasBeenVisited(isVisited, adjacentCoordinate))   {
                        queue.add(adjacentCoordinate);
                    }
                }
            }
        }

        return false;
    }

    private boolean canFindFirstValidStackedTilePlacement()    {
        for(Coordinate volcanoCoordinate : volcanoCoordinates)  {
            if(canPlaceTile(volcanoCoordinate))   {
                return true;
            }
        }

        return false;
    }

    private boolean hexHasBeenVisited(ArrayList<Coordinate> isVisited, Coordinate adjacentCoordinate)    {

        for (int j = 0; j < isVisited.size(); j++) {
            if (isVisited.get(j).getX() == adjacentCoordinate.getX() &&
                    isVisited.get(j).getY() == adjacentCoordinate.getY() &&
                    isVisited.get(j).getZ() == adjacentCoordinate.getZ()) {
                return true;
            }
        }

        return false;
    }

    private boolean canPlaceTile(Coordinate coordinate)  {
        for(int i = 1; i < 7; i++)  {
            map.setTileCoordinates(bestTilePlacement, coordinate, i);
            map.setTileLevel(bestTilePlacement);
            bestTilePlacement.setTileOrientation(i);
            if(map.isValidPlacement(bestTilePlacement))  {
                return true;
            }
            tileReset(bestTilePlacement);
        }

        return false;
    }

    private void tileReset(Tile tile)    {
        tile.setTileLevel(0);
        tile.getHex1().setLevel(0);
        tile.getHex2().setLevel(0);
        tile.getHex3().setLevel(0);
    }

    public void executeTilePlacement()  {
        map.mapTileToBoard(tileToPlace);
    }

    /*
        AI For Finding Best Build Action
     */
    public void getBestBuildAction()    {
        availableHexesOnLevelOne = new ArrayList<>();
        if(!wePlacedAllOfOurTigers() && canFindFirstPlaceForTigerPlayground()){
            System.out.println("TP");
            setBuildOption(BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND);
        }
        else if(wePlacedAllOfOurTigers() && !wePlacedAllOfOurMeeples() && canFindFirstPlaceToExpandSettlement()){
            System.out.println("EX");
            setBuildOption(BuildOption.typesOfBuildOptions.EXPANSION);
        }
        else if(!wePlacedAllOfOurMeeples() && canFindFirstPlaceToFoundSettlement()){
            System.out.println("FS");
            setBuildOption(BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT);
        }
        else if(wePlacedAllOfOurMeeples() && !wePlacedAllOfOurTotoro() && canFindFirstPlaceForTotoroSanctuary())   {
            System.out.println("TS");
            setBuildOption(BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY);
        }
        else    {
            System.out.println("UB");
            setBuildOption(BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD);
        }

    }

    //Founding a Tiger Playground
    public boolean canFindFirstPlaceForTigerPlayground()    {
        for(Settlement settlement : currentPlayer.getPlayerSettlements())  {
            for(Hex hex : settlement.getSettlementHexes()) {
                Coordinate[] adjacentCoordinateArray = map.createAdjacentCoordinateArray(hex.getCoordinate());
                for (Coordinate coordinate : adjacentCoordinateArray) {
                    if(canPlaceTiger(coordinate, currentPlayer))    {
                        bestSettlementPlacementForTiger = coordinate;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean canPlaceTiger(Coordinate chosenCoordinate, Player player)  {
        //return error trying to place on Volcano or space already occupied or no tigers left to play or not level 3+ tile
        if (!map.hexIsViableForTiger(chosenCoordinate) || !map.playerHasTigersLeft(player)) {
            return false;
        }

        Coordinate[] adjacencyMatrix = map.createAdjacentCoordinateArray(chosenCoordinate);

        for(Coordinate adj : adjacencyMatrix) {
            if (map.thereIsAnAdjacentSettlement(adj, player)) {
                deleteHexFromLevelThreeHexArrayList(adj);
                return true;
            }
        }

        return false;
    }

    public boolean hasTigersLeft()   {
        if(currentPlayer.getNumberOfTigersIHave() > 0) {
            return true;
        }
        return false;
    }

    public boolean wePlacedAllOfOurTigers() {
        return currentPlayer.getNumberOfTigersIHave() == 0;
    }

    //Expanding a Settlement
    public boolean canFindFirstPlaceToExpandSettlement()    {
        for(Settlement settlement : currentPlayer.getPlayerSettlements())   {
            for(Hex hex : settlement.getSettlementHexes()) {
                Coordinate[] adjacencyMatrix = map.createAdjacentCoordinateArray(hex.getCoordinate());
                for(Coordinate coordinateToExpand : adjacencyMatrix) {
                    if(map.isTaken(coordinateToExpand) &&
                            map.hexAt(coordinateToExpand).getTerrainType() != Terrain.typesOfTerrain.VOLCANO &&
                            !map.hexAt(coordinateToExpand).isSettled()) {
                        int requiredMeeples = requiredMeeplesForExpansion(hex.getCoordinate(), map.hexAt(coordinateToExpand).getTerrainType());
                        if (requiredMeeples > 0 && requiredMeeples <= currentPlayer.getNumberOfMeeplesIHave()) {
                            bestSettlementPlacementForExpansion = hex.getCoordinate();
                            typeOfTerrainForBestExpansion = map.hexAt(coordinateToExpand).getTerrainType();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int requiredMeeplesForExpansion(Coordinate coordinate, Terrain.typesOfTerrain terrainType)    {
        if (terrainType == Terrain.typesOfTerrain.VOLCANO) { return -1; }

        //Initialize number of Meeples == 0
        int numberOfMeeplesNeededToExpand = 0;
        Hex chosenHex = map.hexAt(coordinate);
        Settlement settlementToExpand = chosenHex.getSettlement();

        ArrayList<Hex> hexesInExpansion = new ArrayList<>();
        LinkedList<Hex> unvisitedHexesInTheSettlement = new LinkedList<>();
        if(settlementToExpand != null) {
            map.addSettlementHexesToUnvisitedQueue(unvisitedHexesInTheSettlement, settlementToExpand);

            while (map.thereAreStillHexesToVisit(unvisitedHexesInTheSettlement)) {
                //Visit Hex
                Hex currentHex = unvisitedHexesInTheSettlement.poll();
                Coordinate currentHexCoordinate = currentHex.getCoordinate();

                Coordinate[] adjacencyMatrix = map.createAdjacentCoordinateArray(currentHexCoordinate);

                //if a neighboring tile isn't part of the settlement already
                //and isn't already added to the list of hexes marked for expansion
                //and matches the terrain type
                //then add it
                for (Coordinate adj : adjacencyMatrix) {
                    boolean added = false;

                    if (map.isTaken(adj)) {
                        if (map.hexAt(adj).getTerrainType() == terrainType && !map.hexAt(adj).isSettled()) {

                            for (int j = 0; j < hexesInExpansion.size(); j++) {
                                if (hexesInExpansion.get(j) == map.hexAt(adj)) {
                                    added = true;
                                }
                            }

                            if (added == false) {
                                unvisitedHexesInTheSettlement.add(map.hexAt(adj));
                                hexesInExpansion.add(map.hexAt(adj));
                                numberOfMeeplesNeededToExpand += map.hexAt(adj).getLevel();
                            }
                        }
                    }
                }
            }
        }
        return numberOfMeeplesNeededToExpand;
    }

    //Founding a Settlement -
    // 1) Next to Lvl 3 Hex
    // 2) Next to another Settlement
    // 3) Anywhere
    public boolean canFindFirstPlaceToFoundSettlement() {
        if(canPlaceNextToEmptyLevelThreeHex())    {
            return true;
        }
        else if(ifPlayerHasAtleastOneSettlement())   {
            for(Settlement settlement : currentPlayer.getPlayerSettlements())   {
                if(canPlaceNextToASettlement(settlement))   {
                    return true;
                }
            }

            if(canFindCoordinateForFoundingASettlement())    {
                return true;
            }
        }
        else if(canFindCoordinateForFoundingASettlement())    {
            return true;
        }

        return false;
    }

    public boolean canPlaceNextToEmptyLevelThreeHex()   {
        for(Coordinate coordinate : availableHexesOnLevelThree)  {
            for (Coordinate adjacentCoordinate : map.createAdjacentCoordinateArray(coordinate)) {
                if (hexIsViableForSettlement(adjacentCoordinate) && map.hexAt(adjacentCoordinate).getLevel() == 1) {
                    bestSettlementPlacementForFounding = adjacentCoordinate;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canPlaceNextToASettlement(Settlement settlement) {
        for(Hex hex : settlement.getSettlementHexes())  {
            Coordinate[] adjacentCoordinateArray = map.createAdjacentCoordinateArray(hex.getCoordinate());
            for(Coordinate coordinate : adjacentCoordinateArray)    {
                if(hexIsViableForSettlement(coordinate) && map.hexAt(coordinate).getLevel() == 1)   {
                    bestSettlementPlacementForFounding = coordinate;
                    availableHexesOnLevelOne.add(coordinate);
                }
            }
        }

        if(!availableHexesOnLevelOne.isEmpty()) {
            return true;
        }

        return false;
    }

    public boolean canFindCoordinateForFoundingASettlement()    {
        LinkedList<Coordinate> queue = new LinkedList<>();
        Coordinate[] adjacentHexes = map.createAdjacentCoordinateArray(ORIGIN);
        ArrayList<Coordinate> isVisited = new ArrayList<>();
        isVisited.add(ORIGIN);

        for(Coordinate coordinate : adjacentHexes)  {
            queue.add(coordinate);
        }

        while(!queue.isEmpty()) {
            //System.out.println("LOOP QUEUE");
            //get current Coordinate
            Coordinate currentCoordinate = queue.poll();
            //currentCoordinate.coordinateToString();
            isVisited.add(currentCoordinate);

            //if a neighboring hex is taken, then check for valid placement
            if(map.isTaken(currentCoordinate) && hexIsViableForSettlement(currentCoordinate) && map.hexAt(currentCoordinate).getLevel() == 1) {
                bestSettlementPlacementForFounding = currentCoordinate;
                availableHexesOnLevelOne.add(currentCoordinate);
            }

            //if a neighboring hex isn't taken,
            //and neighbors aren't already added to the list of coordinates
            //then add them
            else    {
                Coordinate[] adjacencyMatrix = map.createAdjacentCoordinateArray(currentCoordinate);
                Coordinate adjacentCoordinate;
                for(int i = 0; i < adjacencyMatrix.length; i++) {
                    adjacentCoordinate = adjacencyMatrix[i];
                    if(!hexHasBeenVisited(isVisited, adjacentCoordinate) && map.isTaken(adjacentCoordinate))   {
                        queue.add(adjacentCoordinate);
                    }
                }
            }
        }

        if(availableHexesOnLevelOne.size() > 0) {
            bestSettlementPlacementForFounding = availableHexesOnLevelOne.get(0);
            return true;
        }

        return false;
    }

    public boolean wePlacedAllOfOurMeeples() { return currentPlayer.getNumberOfMeeplesIHave() == 0; }

    public boolean ifPlayerHasAtleastOneSettlement() {
        return currentPlayer.getPlayerSettlements().size() > 0;
    }

    private boolean hexIsViableForSettlement(Coordinate coordinate) {
        return map.isTaken(coordinate) &&
                !map.hexAt(coordinate).isSettled() &&
                map.hexAt(coordinate).getTerrainType() != Terrain.typesOfTerrain.VOLCANO;
    }

    //Founding a Totoro Sanctuary - (not necessary for AI Strategy)
    public boolean canFindFirstPlaceForTotoroSanctuary()   {
        for(Settlement settlement : currentPlayer.getPlayerSettlements())  {
            if(settlement.getLength() >= 5) {
                if(!settlement.getTotoroFlag() && canPlaceNextToSettlementOfSizeFiveOrGreater(settlement))   {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canPlaceNextToSettlementOfSizeFiveOrGreater(Settlement settlement)    {
        for(Hex hex : settlement.getSettlementHexes())  {
            Coordinate[] adjacentCoordinateArray = map.createAdjacentCoordinateArray(hex.getCoordinate());
            for(Coordinate coordinate : adjacentCoordinateArray)    {
                if(hexIsViableForSettlement(coordinate))   {
                    bestSettlementPlacementForTotoro = coordinate;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canPlaceTotoro(Coordinate coordinate) {
        //return error trying to place on Volcano or space already occupied or not Totoro left to play
        if (map.hexAt(coordinate).getTerrainType() == Terrain.typesOfTerrain.VOLCANO ||
                map.hexAt(coordinate).isSettled() ||
                currentPlayer.getNumberOfTotorosIHave() <= 0) {
            return false;
        }

        Coordinate[] adjacencyMatrix = map.createAdjacentCoordinateArray(coordinate);
        Coordinate adjacentCoordinate;

        for (int i = 0; i < 6; i++) {
            adjacentCoordinate = adjacencyMatrix[i];

            if (map.settlementIsValidForTotoro(adjacentCoordinate, currentPlayer)) {
                //If it's a valid placement, then the adjacent coordinate is a part of the player's setlement
                //and it is of size 5 or greater without a Totoro already
                map.hexAt(adjacentCoordinate).getSettlement().addToSettlement(map.hexAt(coordinate));
                map.hexAt(coordinate).setSettlement(map.hexAt(adjacentCoordinate).getSettlement());
                return true;
            }
        }
        return false;
    }

    public boolean wePlacedAllOfOurTotoro() { return currentPlayer.getNumberOfTotorosIHave() <= 0; }


    /*
        Execute methods
     */
    public void executeBuildAction()    {
        if(buildOption == BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND) {
            map.placeTiger(bestSettlementPlacementForTiger, currentPlayer);
        } else if(buildOption == BuildOption.typesOfBuildOptions.EXPANSION) {
            map.expandSettlement(bestSettlementPlacementForExpansion, typeOfTerrainForBestExpansion, currentPlayer);
        }
        else if(buildOption == BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT)  {
            map.foundNewSettlement(bestSettlementPlacementForFounding, currentPlayer);
        }
        else if(buildOption == BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY) {
            map.placeTotoro(bestSettlementPlacementForTotoro, currentPlayer);
        }
        System.out.println("We have this many tigers : " + ourPlayer.getNumberOfTigersIHave());
        System.out.println("We have this many meeples : " + ourPlayer.getNumberOfMeeplesIHave());
    }

    /*
        Managing AI Variables
     */

    //Give Brain Tile Placement For updating Level Three Hexes
    public void giveBrainTheTilePlacement(Coordinate volcanoCoordinate, int tileOrientation)    {
        if(map.isTaken(volcanoCoordinate))  {
            if(map.hexAt(volcanoCoordinate).getLevel() >=2) {
                Coordinate[] hexCoordinates = map.determineTileCoordinatesBasedOnOrientation(volcanoCoordinate, tileOrientation);
                addLevelThreeHexesToArrayList(hexCoordinates[0], hexCoordinates[1]);
            }
        }
    }

    //Give the Brain Tile Placement for updating Volcano Coordinates
    public void giveBrainTheUpdatedVolcanoCoordinates(Coordinate volcanoCoordinate, int tileOrientation) {
        if(!volcanoIsInArrayList(volcanoCoordinate))  {
            volcanoCoordinates.add(volcanoCoordinate);
        }

        updateVolcanoCoordinates(volcanoCoordinate, tileOrientation);
    }

    //Volcano ArrayList Functions
    public void updateVolcanoCoordinates(Coordinate volcanoCoordinate, int tileOrientation) {
        Coordinate[] coordinatesOfHex2And3OfTilePlaced = map.determineTileCoordinatesBasedOnOrientation(volcanoCoordinate, tileOrientation);
        for(Coordinate coordinate : coordinatesOfHex2And3OfTilePlaced)   {
            if(map.isTaken(coordinate) && map.hexAt(coordinate).getTerrainType() == Terrain.typesOfTerrain.VOLCANO) {
                deleteVolcanoFromArrayList(coordinate);
            }
        }
    }

    private boolean volcanoIsInArrayList(Coordinate coordinateToBeAdded) {
        Coordinate volcanoCoordinate;
        for(int i = 0; i < volcanoCoordinates.size(); i++) {
            volcanoCoordinate = volcanoCoordinates.get(i);
            if (volcanoCoordinate.getX() == coordinateToBeAdded.getX() &&
                    volcanoCoordinate.getY() == coordinateToBeAdded.getY() &&
                    volcanoCoordinate.getZ() == coordinateToBeAdded.getZ()) {
                return true;
            }
        }
        return false;
    }

    public void deleteVolcanoFromArrayList(Coordinate coordinateToBeDeleted)   {
        Coordinate coordinate;
        for(int i = 0; i < volcanoCoordinates.size(); i++) {
            coordinate = volcanoCoordinates.get(i);
            if(coordinate.getX() == coordinateToBeDeleted.getX() &&
                    coordinate.getY() == coordinateToBeDeleted.getY() &&
                    coordinate.getZ() == coordinateToBeDeleted.getZ())  {
                volcanoCoordinates.remove(i);
            }
        }
    }

    //Level Three Hexes ArrayList
    public void addLevelThreeHexesToArrayList(Coordinate hex2, Coordinate hex3)   {
        availableHexesOnLevelThree.add(hex2);
        availableHexesOnLevelThree.add(hex3);
    }

    public void deleteHexFromLevelThreeHexArrayList(Coordinate coordinateToBeDeleted)   {
        Coordinate coordinate;
        for(int i = 0; i < availableHexesOnLevelThree.size(); i++) {
            coordinate = availableHexesOnLevelThree.get(i);
            if(coordinate.getX() == coordinateToBeDeleted.getX() &&
                    coordinate.getY() == coordinateToBeDeleted.getY() &&
                    coordinate.getZ() == coordinateToBeDeleted.getZ())  {
                availableHexesOnLevelThree.remove(i);
            }
        }
    }

    /*
        Tournament Client Functions
     */

    //GAME ID get/set
    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getGameID() {
        return gameID;
    }

    //Game in Progress
    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    //Place the opponent Tile
    public Tile createTileFromOpponentToPlaceOnBoard(String opponentMove,int moveNumberAndTileID) {
        String tileOpponentPlaced = parser.getTileOpponentPlacedFromServer(opponentMove);
        Tile t = createTile(tileOpponentPlaced, moveNumberAndTileID);
        return t;
    }

    public Tile createTile(String fromServer, int moveNumberAndTileID){
        String tileToPlaceFromServer = parser.getTileIDFromServerMessageIfActivePlayer(fromServer);
        Terrain.typesOfTerrain terrainA = parser.getTerrainAFromString(tileToPlaceFromServer);
        Terrain.typesOfTerrain terrainB = parser.getTerrainBFromString(tileToPlaceFromServer);
        Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, moveNumberAndTileID);
        Hex hex2 = new Hex(terrainA, moveNumberAndTileID);
        Hex hex3 = new Hex(terrainB, moveNumberAndTileID);
        Tile t = new Tile(hex1, hex2, hex3, moveNumberAndTileID);
        return t;
    }

    public Coordinate getVolcanoCoordinateFromOpponent(String opponentMove) {
        int opponentX = parser.getXCoordFromOpponentMove(opponentMove);
        int opponentY = parser.getYCoordFromOpponentMove(opponentMove);
        int opponentZ = parser.getZCoordFromOpponentMove(opponentMove);
        return new Coordinate(opponentZ + 100, opponentX + 100, opponentY + 100);
    }

    public void placeTileFromOpponent(String opponentMove, int moveNumberAndTileID) {
        int opponentOrientation = parser.getOrientationFromOpponent(opponentMove);
        Coordinate opponentVolcanoCoordinate = getVolcanoCoordinateFromOpponent(opponentMove);
        Tile opponentTile = createTileFromOpponentToPlaceOnBoard(opponentMove, moveNumberAndTileID);

        this.giveBrainTheUpdatedVolcanoCoordinates(opponentVolcanoCoordinate, opponentOrientation);
        this.giveBrainTheTilePlacement(opponentVolcanoCoordinate, opponentOrientation);
        this.opponentPlaceTile(opponentTile, opponentVolcanoCoordinate, opponentOrientation);
    }

    public void opponentPlaceTile(Tile tile, Coordinate coordinate, int tileOrientation) {
        map.placeTile(tile, coordinate, tileOrientation);
    }

    //Opponent Build
    public void addOpponentsMoveToBoardBasedOnBuildOption(String opponentMove) {
        if(BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT == parseBuildSelectionFromOpponent(opponentMove)) {
            addOpponentSettlementToBoard(opponentMove);
        }
        else if(BuildOption.typesOfBuildOptions.EXPANSION == parseBuildSelectionFromOpponent(opponentMove)){
            addOpponentExpansionOnBoardBasedOnTheServerMessage(opponentMove);
        }
        else if(BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY == parseBuildSelectionFromOpponent(opponentMove)){
            addOpponentTotoroSanctuaryToBoard(opponentMove);
        }
        else if(BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND == parseBuildSelectionFromOpponent(opponentMove)){
            addOpponentTigerPlaygroundToBoard(opponentMove);
        }
        else if(BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD == parseBuildSelectionFromOpponent(opponentMove)) {
            //Do nothing
        }
    }

    public BuildOption.typesOfBuildOptions parseBuildSelectionFromOpponent(String opponentMove) {
        BuildOption.typesOfBuildOptions buildOptions = parser.getBuildOptionFromMessageSentToBothPlayers(opponentMove);
        return buildOptions;
    }

    public void addOpponentSettlementToBoard(String s){
        int xCoordForOpponentSettlement = parser.getXCoordFromOpponentFoundOrExpand(s);
        int yCoordForOpponentSettlement = parser.getYCoordFromOpponentFoundOrExpand(s);
        int zCoordForOpponentSettlement = parser.getZCoordFromOpponentFoundOrExpand(s);
        Coordinate c = new Coordinate(zCoordForOpponentSettlement + 100, xCoordForOpponentSettlement + 100, yCoordForOpponentSettlement + 100);
        map.foundNewSettlement(c, this.getOpponent());
    }

    public void addOpponentExpansionOnBoardBasedOnTheServerMessage(String s) {
        int xCoordForOpponentExpansion = parser.getXCoordFromOpponentFoundOrExpand(s);
        int yCoordForOpponentExpansion = parser.getYCoordFromOpponentFoundOrExpand(s);
        int zCoordForOpponentExpansion = parser.getZCoordFromOpponentFoundOrExpand(s);
        Coordinate c = new Coordinate(zCoordForOpponentExpansion, xCoordForOpponentExpansion, yCoordForOpponentExpansion);
        Terrain.typesOfTerrain t = parser.getTerrainTypeFromServerMessageIfOpponentExpands(s);
        map.expandSettlement(c, t, this.getOpponent());
    }

    public void addOpponentTotoroSanctuaryToBoard(String opponentMove) {
        int xCoordForOpponentTotoroSanctuary = parser.getXCoordFromOpponentBuild(opponentMove);
        int yCoordForOpponentTotoroSanctuary = parser.getYCoordFromOpponentBuild(opponentMove);
        int zCoordForOpponentTotoroSanctuary = parser.getZCoordFromOpponentBuild(opponentMove);
        Coordinate c = new Coordinate(zCoordForOpponentTotoroSanctuary, xCoordForOpponentTotoroSanctuary, yCoordForOpponentTotoroSanctuary);
        map.placeTotoro(c, this.getOpponent());
    }

    public void addOpponentTigerPlaygroundToBoard(String opponentMove) {
        int xCoordForOpponentTigerPlayground = parser.getXCoordFromOpponentBuild(opponentMove);
        int yCoordForOpponentTigerPlayground = parser.getYCoordFromOpponentBuild(opponentMove);
        int zCoordForOpponentTigerPlayground = parser.getZCoordFromOpponentBuild(opponentMove);
        Coordinate c = new Coordinate(zCoordForOpponentTigerPlayground, xCoordForOpponentTigerPlayground, yCoordForOpponentTigerPlayground);
        map.placeTiger(c, this.getOpponent());
    }
}