import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Kyle on 3/14/2017.
 */
public class Map {
    //Private Instance Variables
    private final int MAX_MAP_WIDTH = 200, MAX_MAP_HEIGHT = 200;
    private Hex Map[][];
    private boolean isTheFirstTilePlaced;

    //Map Constructor
    public Map() {
        Map = new Hex[MAX_MAP_WIDTH][MAX_MAP_HEIGHT];
        isTheFirstTilePlaced = false;
    }

    public void placeTile(Tile tile, Coordinate coordinate, int tileOrientation) {
        setTileCoordinates(tile, coordinate, tileOrientation);
        setTileLevel(tile);
        if (isValidPlacement(tile)) {
            mapTileToBoard(tile);
        }
        else{
            throw new InvalidTilePlacement();
        }
    }

    public void setTileCoordinates(Tile tile, Coordinate coordinate, int tileOrientation) {
        Coordinate[] coordinates = getTileCoordinates(coordinate, tileOrientation);

        tile.getHex1().setCoordinate(coordinates[0]);
        tile.getHex2().setCoordinate(coordinates[1]);
        tile.getHex3().setCoordinate(coordinates[2]);
    }

    public Coordinate[] getTileCoordinates(Coordinate coordinate, int tileOrientation) {
        Coordinate[] tileCoordinates = new Coordinate[3];
        Coordinate[] adjacentCoordinates = determineTileCoordinatesBasedOnOrientation(coordinate, tileOrientation);

        tileCoordinates[0] = coordinate;
        tileCoordinates[1] = adjacentCoordinates[0];
        tileCoordinates[2] = adjacentCoordinates[1];

        return tileCoordinates;
    }

    public Coordinate[] determineTileCoordinatesBasedOnOrientation(Coordinate coordinate, int tileOrientation) {
        Coordinate[] tileCoordinates = new Coordinate[2];
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (isEven(y)) {
            if (tileOrientation == 1) {
                tileCoordinates[0] = new Coordinate(x - 1, y + 1);
                tileCoordinates[1] = new Coordinate(x, y + 1);
            } else if (tileOrientation == 2) {
                tileCoordinates[0] = new Coordinate(x, y + 1);
                tileCoordinates[1] = new Coordinate(x + 1, y);
            } else if (tileOrientation == 3) {
                tileCoordinates[0] = new Coordinate(x + 1, y);
                tileCoordinates[1] = new Coordinate(x, y - 1);
            } else if (tileOrientation == 4) {
                tileCoordinates[0] = new Coordinate(x, y - 1);
                tileCoordinates[1] = new Coordinate(x - 1, y - 1);
            } else if (tileOrientation == 5) {
                tileCoordinates[0] = new Coordinate(x - 1, y - 1);
                tileCoordinates[1] = new Coordinate(x - 1, y);
            } else if (tileOrientation == 6) {
                tileCoordinates[0] = new Coordinate(x - 1, y);
                tileCoordinates[1] = new Coordinate(x - 1, y + 1);
            }
        } else {
            if (tileOrientation == 1) {
                tileCoordinates[0] = new Coordinate(x, y + 1);
                tileCoordinates[1] = new Coordinate(x + 1, y + 1);
            } else if (tileOrientation == 2) {
                tileCoordinates[0] = new Coordinate(x + 1, y + 1);
                tileCoordinates[1] = new Coordinate(x + 1, y);
            } else if (tileOrientation == 3) {
                tileCoordinates[0] = new Coordinate(x + 1, y);
                tileCoordinates[1] = new Coordinate(x + 1, y - 1);
            } else if (tileOrientation == 4) {
                tileCoordinates[0] = new Coordinate(x + 1, y - 1);
                tileCoordinates[1] = new Coordinate(x, y - 1);
            } else if (tileOrientation == 5) {
                tileCoordinates[0] = new Coordinate(x, y - 1);
                tileCoordinates[1] = new Coordinate(x - 1, y);
            } else if (tileOrientation == 6) {
                tileCoordinates[0] = new Coordinate(x - 1, y);
                tileCoordinates[1] = new Coordinate(x, y + 1);
            }
        }

        return tileCoordinates;
    }

    public boolean isValidPlacement(Tile tile) {
        boolean validPlacement = false;

        if (isTheFirstTile(tile)) {
            validPlacement = true;
        } else if ((canPlaceTileAtGivenTileLocationOnLevel1(tile) && isAdjacentToAnotherTile(tile)) || canStackTile(tile)) {
            validPlacement = true;
        }

        return validPlacement;
    }

    public boolean isTheFirstTile(Tile tile) {
        if (!isTheFirstTilePlaced) {
            isTheFirstTilePlaced = true;
            return true;
        }
        return false;
    }

    public void setTileLevel(Tile tile) {

        int level = tile.getTileLevel();
        if(isTaken(tile.getHex1().getCoordinate()))   {
            level = hexAt(tile.getHex1().getCoordinate()).getLevel();
        }

        tile.setTileLevel(level+1);
        tile.getHex1().setLevel(level+1);
        tile.getHex2().setLevel(level+1);
        tile.getHex3().setLevel(level+1);
    }

    public boolean canPlaceTileAtGivenTileLocationOnLevel1(Tile tile) {
        if (!isTaken(tile.getHex1().getCoordinate()) && !isTaken(tile.getHex2().getCoordinate()) && !isTaken(tile.getHex3().getCoordinate())) {
            return true;
        }
        return false;
    }

    public boolean isAdjacentToAnotherTile(Tile tile) {
        Coordinate coordinateOfHex1 = tile.getHex1().getCoordinate();
        Coordinate coordinateOfHex2 = tile.getHex2().getCoordinate();
        Coordinate coordinateOfHex3 = tile.getHex3().getCoordinate();

        if (hasNeighbors(tile, coordinateOfHex1) || hasNeighbors(tile, coordinateOfHex2) || hasNeighbors(tile, coordinateOfHex3)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNeighbors(Tile tile, Coordinate coordinate) {
        Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(coordinate);
        Coordinate adj;

        for (int i = 0; i < 6; i++) {
            adj = adjacencyMatrix[i];
            if (hexAt(adj) != null) {
                if (hexAt(adj).getLevel() == tile.getTileLevel()) {
                    return true;
                }
            }
        }

        return false;
    }

    public Coordinate[] createAdjacentCoordinateArray(Coordinate coordinate) {
        Coordinate[] adjacencyMatrix = new Coordinate[6];
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (isEven(y)) {
            adjacencyMatrix[0] = new Coordinate(x - 1, y + 1);
            adjacencyMatrix[1] = new Coordinate(x, y + 1);
            adjacencyMatrix[2] = new Coordinate(x + 1, y);
            adjacencyMatrix[3] = new Coordinate(x, y - 1);
            adjacencyMatrix[4] = new Coordinate(x - 1, y - 1);
            adjacencyMatrix[5] = new Coordinate(x - 1, y);
        } else {
            adjacencyMatrix[0] = new Coordinate(x, y + 1);
            adjacencyMatrix[1] = new Coordinate(x + 1, y + 1);
            adjacencyMatrix[2] = new Coordinate(x + 1, y);
            adjacencyMatrix[3] = new Coordinate(x + 1, y - 1);
            adjacencyMatrix[4] = new Coordinate(x, y - 1);
            adjacencyMatrix[5] = new Coordinate(x - 1, y);
        }

        return adjacencyMatrix;
    }

    public boolean canStackTile(Tile tile) {
        if (isOnTopOfMoreThanOneTile(tile) && isOnTheSameLevel(tile) && isVolcanoOverVolcano(tile) && !isOnTopOfATotoro(tile) && !isOnTopOfATiger(tile) && !isNukingAnEntireSettlement(tile)) {
            int tileLevel = hexAt(tile.getHex1().getCoordinate()).getLevel();
            return true;
        }

        return false;
    }

    public boolean isOnTopOfMoreThanOneTile(Tile tile) {
        int tileID1 = -1;
        int tileID2 = -2;
        int tileID3 = -3;

        if (isTaken(tile.getHex1().getCoordinate())) {
            tileID1 = hexAt(tile.getHex1().getCoordinate()).getTileIndex();
        }

        if (isTaken(tile.getHex2().getCoordinate())) {
            tileID2 = hexAt(tile.getHex2().getCoordinate()).getTileIndex();
        }

        if (isTaken(tile.getHex3().getCoordinate())) {
            tileID3 = hexAt(tile.getHex3().getCoordinate()).getTileIndex();
        }

        if (tileID1 == tileID2 && tileID1 == tileID3) {
            return false;
        }

        return true;
    }

    public boolean isOnTheSameLevel(Tile tile) {
        int tileLvl1 = -1;
        int tileLvl2 = -2;
        int tileLvl3 = -3;

        if (isTaken(tile.getHex1().getCoordinate())) {
            tileLvl1 = hexAt(tile.getHex1().getCoordinate()).getLevel();
        }

        if (isTaken(tile.getHex2().getCoordinate())) {
            tileLvl2 = hexAt(tile.getHex2().getCoordinate()).getLevel();
        }

        if (isTaken(tile.getHex3().getCoordinate())) {
            tileLvl3 = hexAt(tile.getHex3().getCoordinate()).getLevel();
        }

        if (tileLvl1 == tileLvl2 && tileLvl1 == tileLvl3) {
            return true;
        }

        return false;
    }

    public boolean isVolcanoOverVolcano(Tile tile) {
        Terrain.typesOfTerrain terrainOnMap = null;

        if (isTaken(tile.getHex1().getCoordinate())) {
            terrainOnMap = hexAt(tile.getHex1().getCoordinate()).getTerrainType();
        }

        if (terrainOnMap == Terrain.typesOfTerrain.VOLCANO) {
            return true;
        }

        return false;
    }

    public boolean isOnTopOfATotoro(Tile tile) {
        boolean isTotoroPresent = false;
        if (hexAt(tile.getHex2().getCoordinate()).TotoroPresent()) {
            isTotoroPresent = true;
        } else if (hexAt(tile.getHex3().getCoordinate()).TotoroPresent()) {
            isTotoroPresent = true;
        }
        return isTotoroPresent;
    }

    public boolean isOnTopOfATiger(Tile tile) {
        boolean isTigerPresent = false;
        if (hexAt(tile.getHex2().getCoordinate()).TigerPresent()) {
            isTigerPresent = true;
        } else if (hexAt(tile.getHex3().getCoordinate()).TigerPresent()) {
            isTigerPresent = true;
        }
        return isTigerPresent;
    }

    public boolean isNukingAnEntireSettlement(Tile tile) {
        boolean isNukingSettlement = false;
        Settlement settlement1 = null;
        Settlement settlement2 = null;

        if (tile.getHex2().getSettlement() != null) {
            settlement1 = tile.getHex2().getSettlement();

            if (settlement1.getLength() == 1) {
                isNukingSettlement = true;
            }
        }

        if (tile.getHex3().getSettlement() != null) {
            settlement2 = tile.getHex3().getSettlement();
            if (settlement2.getLength() == 1) {
                isNukingSettlement = true;
            }
        }

        if (settlement1 != null && settlement2 != null) {
            if (settlement1.equals(settlement2)) {
                isNukingSettlement = true;
            }
        }

        return isNukingSettlement;
    }

    //Maps a Tile's Hexes to the Board
    public void mapTileToBoard(Tile tile) {
        mapHexToBoard(tile.getHex1());
        mapHexToBoard(tile.getHex2());
        mapHexToBoard(tile.getHex3());
    }

    //Maps a Hex to the Board
    public void mapHexToBoard(Hex hex) {
        Map[hex.getCoordinate().getX()][hex.getCoordinate().getY()] = hex;
    }

    public boolean isTaken(Coordinate coordinate) {
        if (Map[coordinate.getX()][coordinate.getY()] != null) {
            return true;
        } else
            return false;
    }

    public Hex[][] getMap() {
        return Map;
    }

    public Terrain.typesOfTerrain getMapTerrain(Coordinate coordinate) {
        return hexAt(coordinate).getTerrainType();
    }

    public boolean testTaken(int x, int y) {
        if (Map[x][y] != null) {
            return true;
        } else
            return false;
    }

    private boolean isEven(int y) {
        return y % 2 == 0;
    }

    public Hex hexAt(Coordinate coordinate) {
        return Map[coordinate.getX()][coordinate.getY()];
    }

    public boolean isNewSettlementValid(Hex chosenHex) {

        if ((chosenHex.MeeplesPresent() == false) && (chosenHex.TotoroPresent() == false) && (chosenHex.TigerPresent() == false) && (chosenHex.getTerrainType() != Terrain.typesOfTerrain.VOLCANO) && (chosenHex.getLevel() == 1)) {
            return true;
        } else
            return false;
    }

    public void foundNewSettlement(Coordinate Location, Player player) {
        int x = Location.getX();
        int y = Location.getY();

        Hex chosenHex = Map[x][y];

        if (isNewSettlementValid(chosenHex)) {
            chosenHex.placeMeeples(player);

            Settlement s = new Settlement(chosenHex, player);
            chosenHex.setSettlement(s);

            player.addSettlement(s);
            player.decreaseNumberOfMeeplesByAmount(1);
            player.IncreasePoints(1);

            MergeSettlementsAfterFounding(s, player);
        }


    }

    public void ExpandSettlement(Coordinate Location, Terrain.typesOfTerrain TerrainType, Player p) {
        int x = Location.getX();
        int y = Location.getY();

        //throw error if trying to expand on volcano?
        if (TerrainType == Terrain.typesOfTerrain.VOLCANO) {
            return;
        }

        int RequiredMeeples = 0;

        ArrayList<Hex> ExpansionHexes = new ArrayList<>();
        LinkedList<Hex> queue = new LinkedList<>();

        Settlement ExpandedSettlement = Map[x][y].getSettlement();
        ArrayList<Hex> SettlementHexes = ExpandedSettlement.getSettlementHexes();

        for (int i = 0; i < SettlementHexes.size(); i++) {
            queue.add(SettlementHexes.get(i));
        }

        while (queue.size() != 0) {
            //get current Hex
            Hex CurrentHex = queue.poll();
            Coordinate CurrentHexLocation = CurrentHex.getCoordinate();

            Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(CurrentHexLocation);
            int x_adj;
            int y_adj;

            //if a neighboring tile isn't part of the settlement already
            //and isn't already added to the list of hexes marked for expansion
            //and matches the terrain type
            //then add it
            for (int i = 0; i < 6; i++) {
                x_adj = adjacencyMatrix[i].getX();
                y_adj = adjacencyMatrix[i].getY();
                boolean added = false;

                if (Map[x_adj][y_adj] != null) {

                    if (Map[x_adj][y_adj].getTerrainType() == TerrainType && Map[x_adj][y_adj].getSettlement() == null) {

                        for (int j = 0; j < ExpansionHexes.size(); j++) {
                            if (ExpansionHexes.get(j) == Map[x_adj][y_adj]) {
                                added = true;
                            }
                        }

                        if (added == false) {
                            queue.add(Map[x_adj][y_adj]);
                            ExpansionHexes.add(Map[x_adj][y_adj]);
                            RequiredMeeples += Map[x_adj][y_adj].getLevel();
                            //System.out.println("Expanded on: " + x_adj + "," + y_adj);
                        }
                    }
                }
            }

        }

        //System.out.println("Required Meeples for Expansion: " + RequiredMeeples);

        //add hexes to settlement if enough Meeples
        if (p.getNumberOfMeeplesIHave() < RequiredMeeples) {
            return;
        } else {
            for (int i = 0; i < ExpansionHexes.size(); i++) {
                ExpansionHexes.get(i).setSettlement(ExpandedSettlement);
                ExpansionHexes.get(i).placeMeeples(p);
                ExpandedSettlement.addToSettlement(ExpansionHexes.get(i));
            }
            p.decreaseNumberOfMeeplesByAmount(RequiredMeeples);
            p.IncreasePoints(RequiredMeeples);
            //System.out.println(p.getPlayerName() + " has " + p.getNumberOfMeeplesIHave() + " Meeples left!");
        }

    }

    public void PlaceTotoro(Coordinate Location, Player player) {

        int x = Location.getX();
        int y = Location.getY();

        //return error trying to place on Volcano or space already occupied or not Totoro left to play
        if (Map[x][y].getTerrainType() == Terrain.typesOfTerrain.VOLCANO || Map[x][y].getSettlement() != null || player.getNumberOfTotorosIHave() <= 0) {
            return;
        }

        Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(Location);
        int x_adj;
        int y_adj;

        for (int i = 0; i < 6; i++) {
            x_adj = adjacencyMatrix[i].getX();
            y_adj = adjacencyMatrix[i].getY();

            if ((Map[x_adj][y_adj] != null) && (Map[x_adj][y_adj].getSettlement() != null)) {
                if (Map[x_adj][y_adj].getSettlement().getLength() >= 5 && (Map[x_adj][y_adj].getSettlement().getTotoroFlag() == false)) {
                    Map[x_adj][y_adj].getSettlement().addToSettlement(Map[x][y]);
                    Map[x][y].setSettlement(Map[x_adj][y_adj].getSettlement());
                    Map[x][y].placeTotoro(player);
                    try {
                        player.decreaseNumberOfTotorosByAmount(1);
                    } catch (NotEnoughTotoro notEnough) {
                        notEnough.printStackTrace();
                    }
                    player.IncreasePoints(200);
                    //System.out.println("Totoro placed!");
                    break;
                }
            }
        }

        //System.out.println(player.getPlayerName() + " has " + player.getNumberOfTotorosIHave() + " Totoros left!");

    }

    public void PlaceTiger(Coordinate Location, Player player) {

        int x = Location.getX();
        int y = Location.getY();

        //return error trying to place on Volcano or space already occupied or no tigers left to play or not level 3+ tile
        if (Map[x][y].getTerrainType() == Terrain.typesOfTerrain.VOLCANO || Map[x][y].getSettlement() != null || player.getNumberOfTigersIHave() <= 0 || Map[x][y].getLevel() < 3) {
            return;
        }

        Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(Location);
        int x_adj;
        int y_adj;

        for (int i = 0; i < 6; i++) {
            x_adj = adjacencyMatrix[i].getX();
            y_adj = adjacencyMatrix[i].getY();

            if ((Map[x_adj][y_adj] != null) && (Map[x_adj][y_adj].getSettlement() != null) && (Map[x_adj][y_adj].getSettlement().getTigerFlag() == false)) {
                Map[x_adj][y_adj].getSettlement().addToSettlement(Map[x][y]);
                Map[x][y].setSettlement(Map[x_adj][y_adj].getSettlement());
                Map[x][y].placeTiger(player);
                try {
                    player.decreaseNumberOfTigersByAmount(1);
                } catch (NotEnoughTigers notEnoughTigers) {
                    notEnoughTigers.printStackTrace();
                }
                player.IncreasePoints(75);
                //System.out.println("Tiger placed!");
                break;
            }
        }
    }

    public void MergeSettlementsAfterFounding(Settlement MergedSettlement, Player player) {

        Coordinate Location = MergedSettlement.getSettlementHexes().get(0).getCoordinate();

        Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(Location);
        int x_adj;
        int y_adj;

        for (int i = 0; i < 6; i++) {
            x_adj = adjacencyMatrix[i].getX();
            y_adj = adjacencyMatrix[i].getY();

            if ((Map[x_adj][y_adj] != null) && (Map[x_adj][y_adj].GetPlayerBelongsTo() == player.getPlayerName()) && Map[x_adj][y_adj].getSettlement() != MergedSettlement) {
                ArrayList<Hex> HexesToMerge = Map[x_adj][y_adj].getSettlement().getSettlementHexes();
                player.getPlayerSettlements().remove(Map[x_adj][y_adj].getSettlement());

                for (int j = 0; j < HexesToMerge.size(); j++) {
                    MergedSettlement.addToSettlement(HexesToMerge.get(j));
                    HexesToMerge.get(j).setSettlement(MergedSettlement);
                }
            }
        }


    }

    public void MergeSettlementsAfterExpansion(){

    }

//    public Tile searchForFirstValidTilePlacements(Tile tile)    {
//        tile.getHex1().getCoordinate();
//
//
//        return tile;
//    }

}


