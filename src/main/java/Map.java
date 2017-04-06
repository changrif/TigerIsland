import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Kyle on 3/14/2017.
 */
public class Map {
    //Private Instance Variables
    private final int MAX_MAP_WIDTH = 200, MAX_MAP_HEIGHT = 200, MAX_MAP_LENGTH = 200;
    private final Coordinate ORIGIN = new Coordinate (100,100,100);
    private Hex Map[][][];
    private boolean isTheFirstTilePlaced;

    //Map Constructor
    public Map() {
        Map = new Hex[MAX_MAP_WIDTH][MAX_MAP_HEIGHT][MAX_MAP_LENGTH];
        isTheFirstTilePlaced = true;
    }

    public void placeFirstTile()    {
        FirstTile tile = new FirstTile();
        Map[tile.getHex1().getCoordinate().getX()][tile.getHex1().getCoordinate().getY()][tile.getHex1().getCoordinate().getZ()] = tile.getHex1();
        Map[tile.getHex2().getCoordinate().getX()][tile.getHex2().getCoordinate().getY()][tile.getHex2().getCoordinate().getZ()] = tile.getHex2();
        Map[tile.getHex3().getCoordinate().getX()][tile.getHex3().getCoordinate().getY()][tile.getHex3().getCoordinate().getZ()] = tile.getHex3();
        Map[tile.getHex4().getCoordinate().getX()][tile.getHex4().getCoordinate().getY()][tile.getHex4().getCoordinate().getZ()] = tile.getHex4();
        Map[tile.getHex5().getCoordinate().getX()][tile.getHex5().getCoordinate().getY()][tile.getHex5().getCoordinate().getZ()] = tile.getHex5();
    }

    public void placeTile(Tile tile, Coordinate coordinate, int tileOrientation) {
        setTileCoordinates(tile, coordinate, tileOrientation);
        setTileLevel(tile);
        if (isValidPlacement(tile)) {
            tile.setTileOrientation(tileOrientation);
            splitSettlementsAfterNuking(tile);
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
        int z = coordinate.getZ();

        if (tileOrientation == 1) {
            tileCoordinates[0] = new Coordinate(z - 1, x, y + 1);
            tileCoordinates[1] = new Coordinate(z - 1, x + 1, y);
        } else if (tileOrientation == 2) {
            tileCoordinates[0] = new Coordinate(z - 1, x + 1, y);
            tileCoordinates[1] = new Coordinate(z, x + 1, y - 1);
        } else if (tileOrientation == 3) {
            tileCoordinates[0] = new Coordinate(z, x + 1, y - 1);
            tileCoordinates[1] = new Coordinate(z + 1, x, y - 1);
        } else if (tileOrientation == 4) {
            tileCoordinates[0] = new Coordinate(z + 1, x, y - 1);
            tileCoordinates[1] = new Coordinate(z + 1, x - 1, y);
        } else if (tileOrientation == 5) {
            tileCoordinates[0] = new Coordinate(z + 1, x - 1, y);
            tileCoordinates[1] = new Coordinate(z, x - 1, y + 1);
        } else if (tileOrientation == 6) {
            tileCoordinates[0] = new Coordinate(z, x - 1, y + 1);
            tileCoordinates[1] = new Coordinate(z - 1, x, y + 1);
        }

        /*
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
        }*/

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
        int z = coordinate.getZ();

        adjacencyMatrix[0] = new Coordinate(z - 1, x, y + 1);
        adjacencyMatrix[1] = new Coordinate(z - 1, x + 1, y);
        adjacencyMatrix[2] = new Coordinate(z, x + 1, y - 1);
        adjacencyMatrix[3] = new Coordinate(z + 1, x, y - 1);
        adjacencyMatrix[4] = new Coordinate(z + 1, x - 1, y);
        adjacencyMatrix[5] = new Coordinate(z, x - 1, y + 1);

        /*
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
        }*/

        return adjacencyMatrix;
    }

    public boolean canStackTile(Tile tile) {
        if (isOnTopOfMoreThanOneTile(tile) && isOnTheSameLevel(tile) && isVolcanoOverVolcano(tile) && !isOnTopOfATotoro(tile) && !isOnTopOfATiger(tile) && !isNukingAnEntireSettlement(tile)) {
            return true;
        }

        return false;
    }

    public boolean isOnTopOfMoreThanOneTile(Tile tile) {
        int tileID1 = -1;
        int tileID2 = -2;
        int tileID3 = -3;

        if (isTaken(tile.getHex1().getCoordinate())) {
            tileID1 = hexAt(tile.getHex1().getCoordinate()).getTileID();
        }

        if (isTaken(tile.getHex2().getCoordinate())) {
            tileID2 = hexAt(tile.getHex2().getCoordinate()).getTileID();
        }

        if (isTaken(tile.getHex3().getCoordinate())) {
            tileID3 = hexAt(tile.getHex3().getCoordinate()).getTileID();
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

        if (settlement1 != null && settlement2 != null && settlement1.getLength() == 2) {
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
        Map[hex.getCoordinate().getX()][hex.getCoordinate().getY()][hex.getCoordinate().getZ()] = hex;
    }

    public boolean isTaken(Coordinate coordinate) {
        if (Map[coordinate.getX()][coordinate.getY()][coordinate.getZ()] != null) {
            return true;
        } else
            return false;
    }

    public Hex[][][] getMap() {
        return Map;
    }

    public Terrain.typesOfTerrain getMapTerrain(Coordinate coordinate) {
        return hexAt(coordinate).getTerrainType();
    }

    private boolean isEven(int y) {
        return y % 2 == 0;
    }

    public Hex hexAt(Coordinate coordinate) {
        return Map[coordinate.getX()][coordinate.getY()][coordinate.getZ()];
    }

    /*
    public Coordinate convertCubeToOffset(Coordinate coordinate)    {
        Coordinate convertedCoordinate;
        int x = coordinate.getX() + (coordinate.getZ() - (coordinate.getZ() % 2)) / 2;
        int y = coordinate.getZ();
        convertedCoordinate = new Coordinate(x, y);
        return convertedCoordinate;
    }

    public Coordinate convertOffsetToCube(Coordinate coordinate)    {
        Coordinate convertedCoordinate;
        int x = coordinate.getX() - (coordinate.getY() - (coordinate.getY() % 2)) / 2;
        int z = coordinate.getY();
        int y = -x - z;
        convertedCoordinate = new Coordinate(x, y, z);
        return convertedCoordinate;
    }
*/
    public static void main(String [] args) {
        /*
        Map Gameboard = new Map();
        Coordinate coordinate = new Coordinate(100, 100);
        Deck deck = new Deck();
        deck.generateTiles();
        Tile tile = deck.draw();
        Gameboard.setTileCoordinates(tile, coordinate,1);

        Coordinate coordinate1 = new Coordinate(-1, 0, 1);
        Coordinate coordinate2 = new Coordinate(0, -1, 1);
        Coordinate coordinate3 = new Coordinate(1, -1, 0);
        Coordinate coordinate4 = new Coordinate(1, 0, -1);
        Coordinate coordinate5 = new Coordinate(0, 1, -1);
        Coordinate coordinate6 = new Coordinate(-1, 1, 0);

        Gameboard.printCubeCoordinate(coordinate1);
        coordinate1 = Gameboard.convertCubeToOffset(coordinate1);
        Gameboard.printOffsetCoordinate(coordinate1);

        Gameboard.printCubeCoordinate(coordinate2);
        coordinate2 = Gameboard.convertCubeToOffset(coordinate2);
        Gameboard.printOffsetCoordinate(coordinate2);

        Gameboard.printCubeCoordinate(coordinate3);
        coordinate3 = Gameboard.convertCubeToOffset(coordinate3);
        Gameboard.printOffsetCoordinate(coordinate3);

        Gameboard.printCubeCoordinate(coordinate4);
        coordinate4 = Gameboard.convertCubeToOffset(coordinate4);
        Gameboard.printOffsetCoordinate(coordinate4);

        Gameboard.printCubeCoordinate(coordinate5);
        coordinate5 = Gameboard.convertCubeToOffset(coordinate5);
        Gameboard.printOffsetCoordinate(coordinate5);

        Gameboard.printCubeCoordinate(coordinate6);
        coordinate6 = Gameboard.convertCubeToOffset(coordinate6);
        Gameboard.printOffsetCoordinate(coordinate6);*/
    }

    public void printOffsetCoordinate(Coordinate coordinate)    {
        System.out.println("x: " + coordinate.getX() + " \ny: " + coordinate.getY());
    }

    public void printCubeCoordinate(Coordinate coordinate)    {
        System.out.println("x: " + coordinate.getX() + " \ny: " + coordinate.getY() + " \nz: " + coordinate.getZ());
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
        int z = Location.getZ();

        Hex chosenHex = Map[x][y][z];

        if (isNewSettlementValid(chosenHex)) {
            chosenHex.placeMeeples(player);

            Settlement s = new Settlement(chosenHex, player);
            chosenHex.setSettlement(s);

            player.addSettlement(s);
            player.decreaseNumberOfMeeplesByAmount(1);
            player.increaseMatchScore(1);

            MergeSettlementsAfterFounding(s, player);
        }


    }

    public void ExpandSettlement(Coordinate Location, Terrain.typesOfTerrain TerrainType, Player player) {
        int x = Location.getX();
        int y = Location.getY();
        int z = Location.getZ();

        //throw error if trying to expand on volcano?
        if (TerrainType == Terrain.typesOfTerrain.VOLCANO) {
            return;
        }

        int RequiredMeeples = 0;

        ArrayList<Hex> ExpansionHexes = new ArrayList<>();
        LinkedList<Hex> queue = new LinkedList<>();

        Settlement ExpandedSettlement = Map[x][y][z].getSettlement();
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
            int z_adj;

            //if a neighboring tile isn't part of the settlement already
            //and isn't already added to the list of hexes marked for expansion
            //and matches the terrain type
            //then add it
            for (int i = 0; i < 6; i++) {
                x_adj = adjacencyMatrix[i].getX();
                y_adj = adjacencyMatrix[i].getY();
                z_adj = adjacencyMatrix[i].getZ();
                boolean added = false;

                if (Map[x_adj][y_adj][z_adj] != null) {

                    if (Map[x_adj][y_adj][z_adj].getTerrainType() == TerrainType && Map[x_adj][y_adj][z_adj].getSettlement() == null) {

                        for (int j = 0; j < ExpansionHexes.size(); j++) {
                            if (ExpansionHexes.get(j) == Map[x_adj][y_adj][z_adj]) {
                                added = true;
                            }
                        }

                        if (added == false) {
                            queue.add(Map[x_adj][y_adj][z_adj]);
                            ExpansionHexes.add(Map[x_adj][y_adj][z_adj]);
                            RequiredMeeples += Map[x_adj][y_adj][z_adj].getLevel();
                            //System.out.println("Expanded on: " + x_adj + "," + y_adj);
                        }
                    }
                }
            }
        }

        //System.out.println("Required Meeples for Expansion: " + RequiredMeeples);

        //add hexes to settlement if enough Meeples
        if (player.getNumberOfMeeplesIHave() < RequiredMeeples) {
            return;
        } else {
            for (int i = 0; i < ExpansionHexes.size(); i++) {
                ExpansionHexes.get(i).setSettlement(ExpandedSettlement);
                ExpansionHexes.get(i).placeMeeples(player);
                ExpandedSettlement.addToSettlement(ExpansionHexes.get(i));
            }
            player.decreaseNumberOfMeeplesByAmount(RequiredMeeples);
            player.increaseMatchScore(RequiredMeeples);
            //System.out.println(p.getPlayerName() + " has " + p.getNumberOfMeeplesIHave() + " Meeples left!");
        }

        MergeSettlementsAfterExpansion(ExpandedSettlement, player);

    }

    public void PlaceTotoro(Coordinate Location, Player player) {

        int x = Location.getX();
        int y = Location.getY();
        int z = Location.getZ();

        //return error trying to place on Volcano or space already occupied or not Totoro left to play
        if (Map[x][y][z].getTerrainType() == Terrain.typesOfTerrain.VOLCANO || Map[x][y][z].getSettlement() != null || player.getNumberOfTotorosIHave() <= 0) {
            return;
        }

        Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(Location);
        int x_adj;
        int y_adj;
        int z_adj;

        for (int i = 0; i < 6; i++) {
            x_adj = adjacencyMatrix[i].getX();
            y_adj = adjacencyMatrix[i].getY();
            z_adj = adjacencyMatrix[i].getZ();

            if ((Map[x_adj][y_adj][z_adj] != null) && (Map[x_adj][y_adj][z_adj].getSettlement() != null)) {
                if (Map[x_adj][y_adj][z_adj].getSettlement().getLength() >= 5 && (Map[x_adj][y_adj][z_adj].getSettlement().getTotoroFlag() == false)) {
                    Map[x_adj][y_adj][z_adj].getSettlement().addToSettlement(Map[x][y][z]);
                    Map[x][y][z].setSettlement(Map[x_adj][y_adj][z_adj].getSettlement());
                    Map[x][y][z].placeTotoro(player);
                    try {
                        player.decreaseNumberOfTotorosByAmount(1);
                    } catch (NotEnoughTotoro notEnough) {
                        notEnough.printStackTrace();
                    }
                    player.increaseMatchScore(200);
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
        int z = Location.getZ();

        //return error trying to place on Volcano or space already occupied or no tigers left to play or not level 3+ tile
        if (Map[x][y][z].getTerrainType() == Terrain.typesOfTerrain.VOLCANO || Map[x][y][z].getSettlement() != null || player.getNumberOfTigersIHave() <= 0 || Map[x][y][z].getLevel() < 3) {
            return;
        }

        Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(Location);
        int x_adj;
        int y_adj;
        int z_adj;

        for (int i = 0; i < 6; i++) {
            x_adj = adjacencyMatrix[i].getX();
            y_adj = adjacencyMatrix[i].getY();
            z_adj = adjacencyMatrix[i].getZ();

            if ((Map[x_adj][y_adj][z_adj] != null) && (Map[x_adj][y_adj][z_adj].getSettlement() != null) && (Map[x_adj][y_adj][z_adj].getSettlement().getTigerFlag() == false)) {
                Map[x_adj][y_adj][z_adj].getSettlement().addToSettlement(Map[x][y][z]);
                Map[x][y][z].setSettlement(Map[x_adj][y_adj][z_adj].getSettlement());
                Map[x][y][z].placeTiger(player);
                try {
                    player.decreaseNumberOfTigersByAmount(1);
                } catch (NotEnoughTigers notEnoughTigers) {
                    notEnoughTigers.printStackTrace();
                }
                player.increaseMatchScore(75);
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
        int z_adj;

        for (int i = 0; i < 6; i++) {
            x_adj = adjacencyMatrix[i].getX();
            y_adj = adjacencyMatrix[i].getY();
            z_adj = adjacencyMatrix[i].getZ();

            if ((Map[x_adj][y_adj][z_adj] != null) && (Map[x_adj][y_adj][z_adj].GetPlayerBelongsTo() == player.getPlayerName()) && Map[x_adj][y_adj][z_adj].getSettlement() != MergedSettlement) {
                ArrayList<Hex> HexesToMerge = Map[x_adj][y_adj][z_adj].getSettlement().getSettlementHexes();
                player.getPlayerSettlements().remove(Map[x_adj][y_adj][z_adj].getSettlement());

                for (int j = 0; j < HexesToMerge.size(); j++) {
                    MergedSettlement.addToSettlement(HexesToMerge.get(j));
                    if(HexesToMerge.get(j).TotoroPresent() == true){
                        MergedSettlement.addTotoroFlag();
                    }
                    if(HexesToMerge.get(j).TigerPresent() == true){
                        MergedSettlement.addTigerFlag();
                    }
                    HexesToMerge.get(j).setSettlement(MergedSettlement);
                }
            }
        }


    }

    public void MergeSettlementsAfterExpansion(Settlement MergedSettlement, Player player){

        ArrayList<Hex> ExpandedSettlementHexes = MergedSettlement.getSettlementHexes();

        for (int l = 0; l < ExpandedSettlementHexes.size(); l++) {

            Coordinate Location = ExpandedSettlementHexes.get(l).getCoordinate();
            Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(Location);
            int x_adj;
            int y_adj;
            int z_adj;

            for (int i = 0; i < 6; i++) {
                x_adj = adjacencyMatrix[i].getX();
                y_adj = adjacencyMatrix[i].getY();
                z_adj = adjacencyMatrix[i].getZ();

                if ((Map[x_adj][y_adj][z_adj] != null) && (Map[x_adj][y_adj][z_adj].GetPlayerBelongsTo() == player.getPlayerName()) && Map[x_adj][y_adj][z_adj].getSettlement() != MergedSettlement) {
                    ArrayList<Hex> HexesToMerge = Map[x_adj][y_adj][z_adj].getSettlement().getSettlementHexes();
                    player.getPlayerSettlements().remove(Map[x_adj][y_adj][z_adj].getSettlement());

                    for (int j = 0; j < HexesToMerge.size(); j++) {
                        MergedSettlement.addToSettlement(HexesToMerge.get(j));
                        if(HexesToMerge.get(j).TotoroPresent() == true){
                            MergedSettlement.addTotoroFlag();
                        }
                        if(HexesToMerge.get(j).TigerPresent() == true){
                            MergedSettlement.addTigerFlag();
                        }
                        HexesToMerge.get(j).setSettlement(MergedSettlement);
                    }
                }
            }
        }
    }


    public void splitSettlementsAfterNuking(Tile tile){
        Hex Hex1 = hexAt(tile.getHex2().getCoordinate());
        Hex Hex2 = hexAt(tile.getHex3().getCoordinate());


        ArrayList<Settlement> NukedSettlements = new ArrayList<>();
        if (Hex1 != null){
            if (Hex1.getSettlement() != null){
                Hex1.getSettlement().getSettlementHexes().remove(Hex1);
                NukedSettlements.add(Hex1.getSettlement());
                Hex1.setSettlement(null);
            }
        }
        if (Hex2 != null){
            if (Hex2.getSettlement() != null){
                Hex2.getSettlement().getSettlementHexes().remove(Hex2);
                NukedSettlements.add(Hex2.getSettlement());
                Hex2.setSettlement(null);
            }
        }

        //loop through the settlements added
        for (int i = 0; i < NukedSettlements.size(); i++){
            //get the hexes from the current settlement
            ArrayList<Hex> NukedSettlementsHexes = NukedSettlements.get(i).getSettlementHexes();
            Player hexOwner = NukedSettlements.get(i).getPlayer();

            //loop through the hexes in each settlement until empty
            while (!NukedSettlementsHexes.isEmpty()){
                Hex randomHex = NukedSettlementsHexes.get(0);

                //perform BFS using the randomHex as a starting point
                Settlement NewSettlement = new Settlement(randomHex, hexOwner);
                ArrayList<Hex> NewSettlementHexes = NewSettlement.getSettlementHexes();

                LinkedList<Hex> queue = new LinkedList<>();
                queue.add(randomHex);

                while (queue.size() != 0) {
                    //get current Hex and remove it from the NukedSettlements Hexes
                    Hex CurrentHex = queue.poll();

                    if (CurrentHex.TotoroPresent()){
                        NewSettlement.addTotoroFlag();
                    }
                    if (CurrentHex.TigerPresent()){
                        NewSettlement.addTigerFlag();
                    }
                    NukedSettlementsHexes.remove(CurrentHex);

                    Coordinate CurrentHexLocation = CurrentHex.getCoordinate();

                    Coordinate[] adjacencyMatrix = createAdjacentCoordinateArray(CurrentHexLocation);
                    int x_adj;
                    int y_adj;
                    int z_adj;

                    //if a neighboring tile isn't part of the settlement already
                    //and isn't already added to the list of hexes marked for expansion
                    //and matches the terrain type
                    //then add it
                    for (int j = 0; j < 6; j++) {
                        x_adj = adjacencyMatrix[j].getX();
                        y_adj = adjacencyMatrix[j].getY();
                        z_adj = adjacencyMatrix[j].getZ();
                        boolean added = false;

                        if (Map[x_adj][y_adj][z_adj] != null) {
                            if (Map[x_adj][y_adj][z_adj].getSettlement() == CurrentHex.getSettlement()) {

                                for (int k = 0; k < NewSettlementHexes.size(); k++) {
                                    if (NewSettlementHexes.get(k) == Map[x_adj][y_adj][z_adj]) {
                                        added = true;
                                    }
                                }

                                if (added == false) {
                                    queue.add(Map[x_adj][y_adj][z_adj]);
                                    NewSettlementHexes.add(Map[x_adj][y_adj][z_adj]);
                                    CurrentHex.setSettlement(NewSettlement);
                                }
                            }
                        }
                    }
                }

                NewSettlement.setLength(NewSettlement.getSettlementHexes().size());
                hexOwner.addSettlement(NewSettlement);

            }

            hexOwner.removeSettlement(NukedSettlements.get(i));

        }
    }

}




