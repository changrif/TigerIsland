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

    public PlayerBrain(Player ourPlayer, Player opponent, Map map){
        this.ourPlayer = ourPlayer;
        this.opponent = opponent;
        this.map = map;
    }

    public void setTileToPlace(Tile tileToPlaceFromServer) {
        this.tileToPlace = tileToPlaceFromServer;
    }

    public Tile getBestTilePlacement() {
        return bestTilePlacement;
    }

    private void setBestTilePlacement(){
        bestTilePlacement = searchForFirstValidTilePlacements(tileToPlace);
    }

    public Tile searchForFirstValidTilePlacements(Tile tile)    {
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
                if (canPlaceTile(tile, currentCoordinate)) {
                    return tile;
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

        return tile;
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

    public boolean canPlaceTile(Tile tile, Coordinate coordinate)  {
        for(int i = 1; i < 7; i++)  {
            map.setTileCoordinates(tile, coordinate, i);
            map.setTileLevel(tile);
            if(map.isValidPlacement(tile))  {
                return true;
            }
            map.tileReset(tile);
        }

        return false;
    }

    public BuildOption.typesOfBuildOptions getBuildAction() {
        //TODO method will decide which build option is best
        return null;
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
}
