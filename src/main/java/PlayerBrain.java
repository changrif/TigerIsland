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
    private ArrayList<Coordinate> volcanoCoordinates = new ArrayList<>();
    private ArrayList<Coordinate> availableHexesOnLevelThree = new ArrayList<>();

    public PlayerBrain(Player ourPlayer, Player opponent, Map map){
        this.ourPlayer = ourPlayer;
        this.opponent = opponent;
        this.map = map;
        volcanoCoordinates.add(ORIGIN);
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

        if(hasTigersLeft() && canFindFirstValidStackedTilePlacement())    {
            setTileToPlace(bestTilePlacement);
        }   else if(canFindFirstLevelOneTilePlacement()) {
            setTileToPlace(bestTilePlacement);
        }
        if(bestTilePlacement.getTileLevel() >= 3)   {
            addLevelThreeHexesToArrayList(tileToPlace.getHex2().getCoordinate(), tileToPlace.getHex3().getCoordinate());
        }

        map.splitSettlementsAfterNuking(tileToPlace);
        giveBrainTheUpdatedVolcanoCoordinates(bestTilePlacement.getHex1().getCoordinate(), bestTilePlacement.getTileOrientation());
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
        if(ourPlayer.getNumberOfTigersIHave() > 0) {
            return true;
        }
        return false;
    }

    public BuildOption.typesOfBuildOptions getBuildAction() {
        return this.buildOption;
    }

    public void setBuildOption(BuildOption.typesOfBuildOptions buildOption) { this.buildOption = buildOption; }

    public void getBestBuildAction()    {
        if(!wePlacedAllOfOurTigers() && canFindFirstPlaceForTigerPlayground()){
            setBuildOption(BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND);
        }
        else if(wePlacedAllOfOurTigers() && !wePlacedAllOfOurMeeples() && canFindFirstPlaceToExpandSettlement()){
            setBuildOption(BuildOption.typesOfBuildOptions.EXPANSION);
        }
        else if(!wePlacedAllOfOurMeeples() && canFindFirstPlaceToFoundSettlement()){
            //Note to Nick & David, from Nick...
            // make sure we're returning the best coordinate later for founding settlement
            //            settlementToPlaceTiger = bestSettlementPlacement;
            setBuildOption(BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT);
        }   else    {
            setBuildOption(BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD);
        }

    }

    public void executeBuildAction()    {
        if(buildOption == BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND) {
            map.placeTiger(bestSettlementPlacementForTiger, ourPlayer);
        } else if(buildOption == BuildOption.typesOfBuildOptions.EXPANSION) {
            map.expandSettlement(bestSettlementPlacementForExpansion, typeOfTerrainForBestExpansion, ourPlayer);
        }
        else if(buildOption == BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT)  {
            map.foundNewSettlement(bestSettlementPlacementForFounding, ourPlayer);
        }
    }

    public boolean wePlacedAllOfOurTigers() {
        return ourPlayer.getNumberOfTigersIHave() == 0;
    }

    public boolean wePlacedAllOfOurMeeples() { return ourPlayer.getNumberOfMeeplesIHave() == 0; }

    public boolean canFindFirstPlaceToFoundSettlement() {
        if(canPlaceNextToEmptyLevelThreeHex())    {
            System.out.println("Trying to place next to level 3");
            return true;
        }
        else if(ifPlayerHasAtleastOneSettlement())   {
            for(Settlement settlement : ourPlayer.getPlayerSettlements())   {
                if(canPlacePiece(settlement))   {
                    System.out.println("Trying to place next to settlement");
                    return true;
                }
            }

            if(canFindCoordinateForFoundingASettlement())    {
                System.out.println("Trying to found");
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
        return ourPlayer.getPlayerSettlements().size() > 0;
    }

    public boolean ifPlayerDoesNotHaveAnySettlements() {
        return ourPlayer.getPlayerSettlements().size() == 0;
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
                return true;
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
        return false;
    }

    public boolean canFindFirstPlaceToExpandSettlement()    {
        for(Settlement settlement : ourPlayer.getPlayerSettlements())   {
            for(Hex hex : settlement.getSettlementHexes()) {
                Coordinate[] adjacencyMatrix = map.createAdjacentCoordinateArray(hex.getCoordinate());
                for(Coordinate coordinateToExpand : adjacencyMatrix) {
                    if(map.isTaken(coordinateToExpand) &&
                            map.hexAt(coordinateToExpand).getTerrainType() != Terrain.typesOfTerrain.VOLCANO &&
                            !map.hexAt(coordinateToExpand).isSettled()) {
                        int requiredMeeples = map.requiredMeeplesForExpansion(hex.getCoordinate(), map.hexAt(coordinateToExpand).getTerrainType());
                        if (requiredMeeples > 0 && requiredMeeples <= ourPlayer.getNumberOfMeeplesIHave()) {
                            bestSettlementPlacementForExpansion = hex.getCoordinate();
                            typeOfTerrainForBestExpansion = map.hexAt(coordinateToExpand).getTerrainType();
                            System.out.println("true?");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean canFindFirstPlaceForTotoroSanctuary()   {
        for(Settlement settlement : ourPlayer.getPlayerSettlements())  {
            if(settlement.getLength() >= 5) {
                if(canPlacePiece(settlement))   {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canFindFirstPlaceForTigerPlayground()    {
        for(Settlement settlement : ourPlayer.getPlayerSettlements())  {
            for(Hex hex : settlement.getSettlementHexes()) {
                Coordinate[] adjacentCoordinateArray = map.createAdjacentCoordinateArray(hex.getCoordinate());
                for (Coordinate coordinate : adjacentCoordinateArray) {
                    if(map.isTaken(coordinate) &&
                            !map.hexAt(coordinate).isSettled() &&
                            map.hexAt(coordinate).getLevel() >= 3 &&
                            map.hexAt(coordinate).getTerrainType() != Terrain.typesOfTerrain.VOLCANO)    {
                        bestSettlementPlacementForTiger = coordinate;
                        return true;
                    }
                }
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
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hexIsViableForSettlement(Coordinate coordinate) {
        return map.isTaken(coordinate) &&
                !map.hexAt(coordinate).isSettled() &&
                map.hexAt(coordinate).getTerrainType() != Terrain.typesOfTerrain.VOLCANO;
    }

    public Hex getHexToBeUsedAsSettlement() {
        //TODO return the hex where you founded a settlement, if the brain chooses to do so.
        return null;
    }

    public Coordinate getCoordinateToExpandTo() {
        return bestSettlementPlacementForExpansion;
    }

    public Terrain.typesOfTerrain getTerrainForExpansion(){
        return typeOfTerrainForBestExpansion;
    }

    public Hex getHexToPlaceTotoro() {
        //TODO return the hex where you decided place Totoro Sanctuary, if the brain chooses to do so.
        return null;
    }

    public Coordinate getCoordinateForTigerPlayground() {
        return bestSettlementPlacementForTiger;
    }

    public Coordinate getCoordinateToBeUsedAsSettlement()  { return  bestSettlementPlacementForFounding; }

    public Player getOurPlayer() {
        return ourPlayer;
    }

    public Player getOpponent() {
        return opponent;
    }

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

}
