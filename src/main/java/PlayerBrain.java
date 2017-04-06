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
    private Coordinate bestSettlementPlacement;
    private Coordinate settlementToPlace;
    private ArrayList<Coordinate> volcanoCoordinates = new ArrayList<>();

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
        if(canFindFirstValidStackedTilePlacement())    {
            bestTilePlacement = tileToPlace;
        }   else if(canFindFirstLevelOneTilePlacement(tileToPlace)) {
            bestTilePlacement = tileToPlace;
        }

        setTileToPlace(bestTilePlacement);
        map.splitSettlementsAfterNuking(tileToPlace);
        giveBrainTheUpdatedVolcanoCoordinates(bestTilePlacement.getHex1().getCoordinate(), bestTilePlacement.getTileOrientation());
    }

    public boolean canFindFirstLevelOneTilePlacement(Tile tile)    {
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
                    if(!hasBeenVisited(isVisited, adjacentCoordinate))   {
                        queue.add(adjacentCoordinate);
                    }
                }
            }
        }

        return false;
    }

    public boolean hasBeenVisited(ArrayList<Coordinate> isVisited, Coordinate adjacentCoordinate)    {

        for (int j = 0; j < isVisited.size(); j++) {
            if (isVisited.get(j).getX() == adjacentCoordinate.getX() &&
                    isVisited.get(j).getY() == adjacentCoordinate.getY() &&
                    isVisited.get(j).getZ() == adjacentCoordinate.getZ()) {
                return true;
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

    public boolean canPlaceTile(Coordinate coordinate)  {
        for(int i = 1; i < 7; i++)  {
            map.setTileCoordinates(tileToPlace, coordinate, i);
            map.setTileLevel(tileToPlace);
            tileToPlace.setTileOrientation(i);
            if(map.isValidPlacement(tileToPlace))  {
                return true;
            }
            tileReset(tileToPlace);
        }

        return false;
    }

    public void tileReset(Tile tile)    {
        tile.setTileLevel(0);
        tile.getHex1().setLevel(0);
        tile.getHex2().setLevel(0);
        tile.getHex3().setLevel(0);
    }

    private boolean hexIsViableForSettlement(Coordinate coordinate) {
        return map.isTaken(coordinate) && !map.hexAt(coordinate).isSettled() && map.hexAt(coordinate).getTerrainType() != Terrain.typesOfTerrain.VOLCANO;
    }

    public BuildOption.typesOfBuildOptions getBuildAction() {
        //TODO method will decide which build option is best
        if(canFindFirstPlaceForTotoroSanctuary()){

        }/*
        else if(canPlaceTigerPlayground() != null){

        }
        else if(canExpandSettlement() != null){

        }
        else if(canFoundSettlement() != null){

        }*/
        return null;
    }

    public boolean canFindFirstPlaceForTotoroSanctuary()   {
        Coordinate coordinateToPlaceTotoro;

        for(Settlement settlement : ourPlayer.getPlayerSettlements())  {
            if(settlement.getLength() >= 5) {
                if(canPlacePiece(settlement))   {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canPlacePiece(Settlement settlement) {

        for(Hex hex : settlement.getSettlementHexes())  {
            Coordinate[] adjacentCoordinateArray = map.createAdjacentCoordinateArray(hex.getCoordinate());
            for(Coordinate coordinate : adjacentCoordinateArray)    {
                if(hexIsViableForSettlement(coordinate))   {
                    return true;
                }
            }
        }

        return false;
    }

    public Hex getHexToBeUsedAsSettlement() {
        //TODO return the hex where you founded a settlement, if the brain chooses to do so.
        return null;
    }

    public Hex getHexToExpandTo() {
        //TODO return the hex where you decided to initially expand, if the brain chooses to do so.
        return null;
    }

    public Hex getHexToPlaceTotoro() {
        //TODO return the hex where you decided place Totoro Sanctuary, if the brain chooses to do so.
        return null;
    }

    public Hex getHexToPlaceTiger() {
        //TODO return the hex where you decided to place Tiger playground, if the brain chooses to do so.
        return null;
    }

    public Player getOurPlayer() {
        return ourPlayer;
    }

    public Player getOpponent() {
        return opponent;
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

}