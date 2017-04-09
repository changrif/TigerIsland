import gherkin.lexer.Pl;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Nick Kroeger on 4/5/2017.
 */
public class PlayerBrain {


    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //If you're not sure what these TODOs are, please ask Nick :)
    //TODO set tile orientation when you call map.setTileCoordinates(tile, coordinate, i); please!
    //TODO make a getter for the origin in the map class

    private final Coordinate ORIGIN = new Coordinate(100, 100, 100);
    private Player currentPlayer;
    private Player ourPlayer;
    private Player opponent;
    private Map map;
    private Tile bestTilePlacement;
    private Tile tileToPlace;
    private BuildOption.typesOfBuildOptions buildOption;
    private Terrain.typesOfTerrain typeOfTerrainForBestExpansion;
    private Coordinate bestSettlementPlacementForFounding;
    private Coordinate bestSettlementPlacementForExpansion;
    private Coordinate bestSettlementPlacementForTiger;
    private Coordinate bestSettlementPlacementForTotoro;
    private ArrayList<Coordinate> volcanoCoordinates = new ArrayList<>();
    private ArrayList<Coordinate> availableHexesOnLevelThree = new ArrayList<>();
    private ArrayList<Coordinate> availableHexesOnLevelOne = new ArrayList<>();

    public PlayerBrain(Player ourPlayer, Player opponent, Map map){
        this.currentPlayer = ourPlayer;
        this.ourPlayer = ourPlayer;
        this.opponent = opponent;
        this.map = map;
        volcanoCoordinates.add(ORIGIN);
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

    public boolean canFindFirstLevelOneTilePlacement()    {
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

    public boolean canFindFirstValidStackedTilePlacement()    {
        for(Coordinate volcanoCoordinate : volcanoCoordinates)  {
            if(canPlaceTile(volcanoCoordinate))   {
                return true;
            }
        }

        return false;
    }

    public boolean hexHasBeenVisited(ArrayList<Coordinate> isVisited, Coordinate adjacentCoordinate)    {

        for (int j = 0; j < isVisited.size(); j++) {
            if (isVisited.get(j).getX() == adjacentCoordinate.getX() &&
                    isVisited.get(j).getY() == adjacentCoordinate.getY() &&
                    isVisited.get(j).getZ() == adjacentCoordinate.getZ()) {
                return true;
            }
        }

        return false;
    }

    public boolean canPlaceTile(Coordinate coordinate)  {
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

    public void tileReset(Tile tile)    {
        tile.setTileLevel(0);
        tile.getHex1().setLevel(0);
        tile.getHex2().setLevel(0);
        tile.getHex3().setLevel(0);
    }

    public boolean hasTigersLeft()   {
        if(currentPlayer.getNumberOfTigersIHave() > 0) {
            return true;
        }
        return false;
    }

    public BuildOption.typesOfBuildOptions getBuildAction() {
        return this.buildOption;
    }

    public void setBuildOption(BuildOption.typesOfBuildOptions buildOption) { this.buildOption = buildOption; }

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
        }   else    {
            System.out.println("UB");
            setBuildOption(BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD);
        }

    }

    public boolean wePlacedAllOfOurTigers() {
        return currentPlayer.getNumberOfTigersIHave() == 0;
    }

    public boolean wePlacedAllOfOurMeeples() { return currentPlayer.getNumberOfMeeplesIHave() == 0; }

    public boolean canFindFirstPlaceToFoundSettlement() {
        if(canPlaceNextToEmptyLevelThreeHex())    {
            return true;
        }
        else if(ifPlayerHasAtleastOneSettlement())   {
            for(Settlement settlement : currentPlayer.getPlayerSettlements())   {
                if(canPlacePiece(settlement))   {
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

    public boolean ifPlayerHasAtleastOneSettlement() {
        return currentPlayer.getPlayerSettlements().size() > 0;
    }

    public boolean ifPlayerDoesNotHaveAnySettlements() {
        return currentPlayer.getPlayerSettlements().size() == 0;
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
            return true;
        }

        return false;
    }

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

    public boolean canFindFirstPlaceForTotoroSanctuary()   {
        for(Settlement settlement : currentPlayer.getPlayerSettlements())  {
            if(settlement.getLength() >= 5) {
                //If we use this the function needs to change
                if(canPlacePiece(settlement))   {
                    return true;
                }
            }
        }

        return false;
    }

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

    public boolean canPlacePiece(Settlement settlement) {
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

    private boolean hexIsViableForSettlement(Coordinate coordinate) {
        return map.isTaken(coordinate) &&
                !map.hexAt(coordinate).isSettled() &&
                map.hexAt(coordinate).getTerrainType() != Terrain.typesOfTerrain.VOLCANO;
    }

    public Coordinate getCoordinateToExpandTo() {
        return bestSettlementPlacementForExpansion;
    }

    public Terrain.typesOfTerrain getTerrainForExpansion(){
        return typeOfTerrainForBestExpansion;
    }

    public Coordinate getCoordinateForTigerPlayground() {
        return bestSettlementPlacementForTiger;
    }

    public Coordinate getCoordinateToBeUsedAsSettlement()  { return  bestSettlementPlacementForFounding; }

    public void giveBrainTheTilePlacement(Coordinate volcanoCoordinate, int tileOrientation)    {
        if(map.isTaken(volcanoCoordinate))  {
            if(map.hexAt(volcanoCoordinate).getLevel() >=2) {
                Coordinate[] hexCoordinates = map.determineTileCoordinatesBasedOnOrientation(volcanoCoordinate, tileOrientation);
                addLevelThreeHexesToArrayList(hexCoordinates[0], hexCoordinates[1]);
            }
        }
    }

    public void giveBrainTheUpdatedVolcanoCoordinates(Coordinate volcanoCoordinate, int tileOrientation) {
        if(!volcanoIsInArrayList(volcanoCoordinate))  {
            volcanoCoordinates.add(volcanoCoordinate);
        }

        updateVolcanoCoordinates(volcanoCoordinate, tileOrientation);
    }

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
    }

    public int requiredMeeplesForExpansion(Coordinate coordinate, Terrain.typesOfTerrain terrainType)    {
        if (terrainType == Terrain.typesOfTerrain.VOLCANO) { return -1; }

        //Initialize number of Meeples == 0
        int numberOfMeeplesNeededToExpand = 0;
        Hex chosenHex = map.hexAt(coordinate);
        Settlement settlementToExpand = chosenHex.getSettlement();

        ArrayList<Hex> hexesInExpansion = new ArrayList<>();
        LinkedList<Hex> unvisitedHexesInTheSettlement = new LinkedList<>();
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
            for(Coordinate adj : adjacencyMatrix) {
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
        return numberOfMeeplesNeededToExpand;
    }

}
