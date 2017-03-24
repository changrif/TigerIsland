/**
 * Created by Kyle on 3/14/2017.
 */
public class Map {
    private final int MAX_MAP_WIDTH = 200, MAX_MAP_HEIGHT = 200;
    private Hex Map[][];
    private boolean firstTilePlaced;


    public Map(){
        Map = new Hex[MAX_MAP_WIDTH][MAX_MAP_HEIGHT];
        firstTilePlaced = false;
    }

    public boolean isTaken(int x, int y){
        if(Map[x][y] != null) {
            return true;
        }

        else
            return false;
    }

    public boolean isTilePlaceTaken(Tile t, int x1, int y1, int x2, int y2, int x3, int y3)  {
        if(!isTaken(x1, y1) && !isTaken(x2, y2) && !isTaken(x3, y3)) {
            t.setTileLevel(1);
            t.getHex1().setLevel(1);
            t.getHex2().setLevel(1);
            t.getHex3().setLevel(1);
            return true;
        }
        return false;
    }

    public Hex[][] getMap(){
        return Map;
    }

    public Terrain.typesOfTerrain getMapTerrain(int x, int y){
        return Map[x][y].getTerrainType();
    }

    public void placeTile(int x, int y, Tile tile, int tileOrientation){
        int hex2XCoordinate, hex2YCoordinate, hex3XCoordinate, hex3YCoordinate;
        int volcanoXCoordinate = x;
        int volcanoYCoordinate = y;
        tile.getHex1().setX(volcanoXCoordinate);
        tile.getHex1().setY(volcanoYCoordinate);

        if (tileOrientation == 1 && isValidPlacement(tile, tileOrientation, x, y)){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(isEven(y)){
                hex2XCoordinate = volcanoXCoordinate - 1;
                hex2YCoordinate = volcanoYCoordinate + 1;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate ;
                hex3YCoordinate = volcanoYCoordinate + 1;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }
            else{
                hex2XCoordinate = volcanoXCoordinate;
                hex2YCoordinate = volcanoYCoordinate + 1;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate + 1;
                hex3YCoordinate = volcanoYCoordinate + 1;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }
        }
        else if (tileOrientation == 2 && isValidPlacement(tile, tileOrientation, x, y)){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(isEven(y)){
                hex2XCoordinate = volcanoXCoordinate;
                hex2YCoordinate = volcanoYCoordinate + 1;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate + 1;
                hex3YCoordinate = volcanoYCoordinate;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }
            else {
                hex2XCoordinate = volcanoXCoordinate + 1;
                hex2YCoordinate = volcanoYCoordinate + 1;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate + 1;
                hex3YCoordinate = volcanoYCoordinate;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }


        }

        else if (tileOrientation == 3 && isValidPlacement(tile, tileOrientation, x, y)){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(isEven(y)){
                hex2XCoordinate = volcanoXCoordinate + 1;
                hex2YCoordinate = volcanoYCoordinate;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate;
                hex3YCoordinate = volcanoYCoordinate - 1;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }
            else {
                hex2XCoordinate = volcanoXCoordinate + 1;
                hex2YCoordinate = volcanoYCoordinate;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate + 1;
                hex3YCoordinate = volcanoYCoordinate - 1;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }

        }

        else if (tileOrientation == 4 && isValidPlacement(tile, tileOrientation, x, y)) {
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(isEven(y)){
                hex2XCoordinate = volcanoXCoordinate;
                hex2YCoordinate = volcanoYCoordinate - 1;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate - 1;
                hex3YCoordinate = volcanoYCoordinate - 1;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }
            else{
                hex2XCoordinate = volcanoXCoordinate + 1;
                hex2YCoordinate = volcanoYCoordinate - 1;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate;
                hex3YCoordinate = volcanoYCoordinate - 1;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }


        }

        else if (tileOrientation == 5 && isValidPlacement(tile, tileOrientation, x, y)){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(isEven(y)){
                hex2XCoordinate = volcanoXCoordinate - 1;
                hex2YCoordinate = volcanoYCoordinate - 1;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate - 1;
                hex3YCoordinate = volcanoYCoordinate;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }

            else {
                hex2XCoordinate = volcanoXCoordinate;
                hex2YCoordinate = volcanoYCoordinate - 1;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate - 1;
                hex3YCoordinate = volcanoYCoordinate;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }
        }

        else if (tileOrientation == 6 && isValidPlacement(tile, tileOrientation, x, y)){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(isEven(y)){
                hex2XCoordinate = volcanoXCoordinate - 1;
                hex2YCoordinate = volcanoYCoordinate ;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate - 1;
                hex3YCoordinate = volcanoYCoordinate + 1;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }

            else {
                hex2XCoordinate = volcanoXCoordinate - 1;
                hex2YCoordinate = volcanoYCoordinate;
                tile.getHex2().setX(hex2XCoordinate);
                tile.getHex2().setY(hex2YCoordinate);
                Map[hex2XCoordinate][hex2YCoordinate] = tile.getHex2();


                hex3XCoordinate = volcanoXCoordinate;
                hex3YCoordinate = volcanoYCoordinate + 1;
                tile.getHex3().setX(hex3XCoordinate);
                tile.getHex3().setY(hex3YCoordinate);
                Map[hex3XCoordinate][hex3YCoordinate] = tile.getHex3();
            }

        }
    }

    private boolean isEven(int y) {
        return y%2 == 0;
    }


    public boolean isValidPlacement(Tile tile, int tileOrientation, int x, int y){

        if(firstTilePlaced == false)
        {
            firstTilePlaced = true;
            tile.setTileLevel(1);
            tile.getHex1().setLevel(1);
            tile.getHex2().setLevel(1);
            tile.getHex3().setLevel(1);
            return true;
        }

        boolean validPlacement = false;

        if(isEven(y))    {
            if (tileOrientation == 1 && ((isTilePlaceTaken(tile, x, y, x-1, y+1, x, y+1) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x-1, y+1, x, y+1))) {
                    validPlacement = true;
                } else if (tileOrientation == 2 && ((isTilePlaceTaken(tile, x, y, x, y+1, x+1, y) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x, y+1, x+1, y))) {
                    validPlacement = true;
                } else if (tileOrientation == 3 && ((isTilePlaceTaken(tile, x, y, x+1, y, x, y-1) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x+1, y, x, y-1))) {
                    validPlacement = true;
                } else if (tileOrientation == 4 && ((isTilePlaceTaken(tile, x, y, x, y-1, x-1, y-1) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x, y-1, x-1, y-1))) {
                    validPlacement = true;
                } else if (tileOrientation == 5 && ((isTilePlaceTaken(tile, x, y, x-1, y-1, x-1, y) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x-1, y-1, x-1, y))) {
                    validPlacement = true;
                } else if (tileOrientation == 6 && ((isTilePlaceTaken(tile, x, y, x-1, y, x-1, y+1) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x-1, y, x-1, y+1))) {
                    validPlacement = true;
                }
            }
        else {
            if (tileOrientation == 1 && ((isTilePlaceTaken(tile, x, y, x, y+1, x+1, y+1) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x, y+1, x+1, y+1))) {
                    validPlacement = true;
                } else if (tileOrientation == 2 && ((isTilePlaceTaken(tile, x, y, x+1, y+1, x+1, y) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x+1, y+1, x+1, y))) {
                    validPlacement = true;
                } else if (tileOrientation == 3 && ((isTilePlaceTaken(tile, x, y, x+1, y, x+1, y-1) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x+1, y, x+1, y-1))) {
                    validPlacement = true;
                } else if (tileOrientation == 4 && ((isTilePlaceTaken(tile, x, y, x+1, y-1, x, y-1) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x+1, y-1, x, y-1))) {
                    validPlacement = true;
                } else if (tileOrientation == 5 && ((isTilePlaceTaken(tile, x, y, x, y-1, x-1, y) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x, y-1, x-1, y))) {
                    validPlacement = true;
                } else if (tileOrientation == 6 && ((isTilePlaceTaken(tile, x, y, x-1, y, x, y+1) && isAdjacentToAnotherTile(tile, tileOrientation, x, y)) || canStackTile(tile, x, y, x-1, y, x, y+1))) {
                    validPlacement = true;
                }
        }

        System.out.println(validPlacement + " in valid placement");
        return validPlacement;
    }

    public boolean canStackTile(Tile t, int x1,int y1, int x2, int y2, int x3, int y3)   {
        if(isOnTopOfMoreThanOneTile(x1, y1,  x2, y2, x3, y3) && isOnTheSameLevel(x1, y1,  x2, y2, x3, y3) && isVolcanoOverVolcano(x1, y1)) {
            int tileLevel = (Map[x1][y1]).getLevel();
            t.setTileLevel(tileLevel+1);
            t.getHex1().setLevel(tileLevel+1);
            t.getHex2().setLevel(tileLevel+1);
            t.getHex3().setLevel(tileLevel+1);
            return true;
        }

        //System.out.println("MORE THAN ONE TILE: " + isOnTopOfMoreThanOneTile(x1, y1,  x2, y2, x3, y3));
        //System.out.println("IS ON THE SAME LEVEL: " + isOnTheSameLevel(x1, y1,  x2, y2, x3, y3));
        //System.out.println("IS VOLCANO OVER VOLCANO: " + isVolcanoOverVolcano( x1, y1));
        return false;
    }

    public int[][] createAdjacentCoordinateArray(int x, int y)    {
        int[][] adjacencyMatrix = new int[6][2];

        if(isEven(y))
        {
            adjacencyMatrix[0][0] = x-1;
            adjacencyMatrix[0][1] = y+1;

            adjacencyMatrix[1][0] = x;
            adjacencyMatrix[1][1] = y+1;

            adjacencyMatrix[2][0] = x+1;
            adjacencyMatrix[2][1] = y;

            adjacencyMatrix[3][0] = x;
            adjacencyMatrix[3][1] = y-1;

            adjacencyMatrix[4][0] = x-1;
            adjacencyMatrix[4][1] = y-1;

            adjacencyMatrix[5][0] = x-1;
            adjacencyMatrix[5][1] = y;
        }
        else    {
            adjacencyMatrix[0][0] = x;
            adjacencyMatrix[0][1] = y+1;

            adjacencyMatrix[1][0] = x+1;
            adjacencyMatrix[1][1] = y+1;

            adjacencyMatrix[2][0] = x+1;
            adjacencyMatrix[2][1] = y;

            adjacencyMatrix[3][0] = x+1;
            adjacencyMatrix[3][1] = y-1;

            adjacencyMatrix[4][0] = x;
            adjacencyMatrix[4][1] = y-1;

            adjacencyMatrix[5][0] = x-1;
            adjacencyMatrix[5][1] = y;
        }

        return adjacencyMatrix;
    }

    public boolean hasNeighbors(Tile t, int x, int y)    {
        int[][] adjacencyMatrix;
        int x_adj;
        int y_adj;

        int currentLevel = t.getTileLevel();
        //System.out.println("CURRENT LEVEL IS " + currentLevel);

        adjacencyMatrix = createAdjacentCoordinateArray(x, y);
        for(int i = 0; i < 6; i++)  {
            x_adj = adjacencyMatrix[i][0];
            y_adj = adjacencyMatrix[i][1];
            //System.out.println(x_adj + ", " + y_adj);
            //System.out.println(Map[x_adj][y_adj]);
            if (Map[x_adj][y_adj] != null) {
                //System.out.println("ADJ LEVEL IS " + Map[x_adj][y_adj].getLevel());
                if (Map[x_adj][y_adj].getLevel() == currentLevel)  {
                    return true;
                }
            }
        }

        return false;
    }

    public int[][] determineTileCoordinatesBasedOnOrientation(int tileOrientation, int x, int y){

        int[][] tileCoordinates = new int[2][2];

        if(isEven(y))    {
            if(tileOrientation == 1)
            {
                tileCoordinates[0][0] = x-1;
                tileCoordinates [0][1] = y+1;

                tileCoordinates[1][0] = x;
                tileCoordinates [1][1] = y+1;
            }
            if(tileOrientation == 2)
            {
                tileCoordinates[0][0] = x;
                tileCoordinates [0][1] = y+1;

                tileCoordinates[1][0] = x+1;
                tileCoordinates [1][1] = y;
            }
            if(tileOrientation == 3)
            {
                tileCoordinates[0][0] = x+1;
                tileCoordinates [0][1] = y;

                tileCoordinates[1][0] = x;
                tileCoordinates [1][1] = y-1;
            }
            if(tileOrientation == 4)
            {
                tileCoordinates[0][0] = x;
                tileCoordinates [0][1] = y-1;

                tileCoordinates[1][0] = x-1;
                tileCoordinates [1][1] = y-1;
            }
            if(tileOrientation == 5)
            {
                tileCoordinates[0][0] = x-1;
                tileCoordinates [0][1] = y-1;

                tileCoordinates[1][0] = x-1;
                tileCoordinates [1][1] = y;
            }
            if(tileOrientation == 6)
            {
                tileCoordinates[0][0] = x-1;
                tileCoordinates [0][1] = y;

                tileCoordinates[1][0] = x-1;
                tileCoordinates [1][1] = y+1;
            }
        }
        else {
            if (tileOrientation == 1) {
                tileCoordinates[0][0] = x;
                tileCoordinates[0][1] = y + 1;

                tileCoordinates[1][0] = x + 1;
                tileCoordinates[1][1] = y + 1;
            }
            if (tileOrientation == 2) {
                tileCoordinates[0][0] = x + 1;
                tileCoordinates[0][1] = y + 1;

                tileCoordinates[1][0] = x + 1;
                tileCoordinates[1][1] = y;
            }
            if (tileOrientation == 3) {
                tileCoordinates[0][0] = x + 1;
                tileCoordinates[0][1] = y;

                tileCoordinates[1][0] = x + 1;
                tileCoordinates[1][1] = y - 1;
            }
            if (tileOrientation == 4) {
                tileCoordinates[0][0] = x + 1;
                tileCoordinates[0][1] = y - 1;

                tileCoordinates[1][0] = x;
                tileCoordinates[1][1] = y - 1;
            }
            if (tileOrientation == 5) {
                tileCoordinates[0][0] = x;
                tileCoordinates[0][1] = y - 1;

                tileCoordinates[1][0] = x - 1;
                tileCoordinates[1][1] = y;
            }
            if (tileOrientation == 6) {
                tileCoordinates[0][0] = x - 1;
                tileCoordinates[0][1] = y;

                tileCoordinates[1][0] = x;
                tileCoordinates[1][1] = y + 1;
            }
        }

        return tileCoordinates;
    }

    public boolean isAdjacentToAnotherTile(Tile t, int tileOrientation, int x, int y)    {
        int[][] tileCoordinates = determineTileCoordinatesBasedOnOrientation(tileOrientation, x, y);

        int x_2 = tileCoordinates[0][0];
        int y_2 = tileCoordinates[0][1];

        int x_3 = tileCoordinates[1][0];
        int y_3 = tileCoordinates[1][1];

        if(hasNeighbors(t, x, y) || hasNeighbors(t, x_2,y_2) || hasNeighbors(t, x_3, y_3))  {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isOnTopOfMoreThanOneTile(int x1,int y1, int x2, int y2, int x3, int y3) {
        int tileID1 = -1;
        int tileID2 = -2;
        int tileID3 = -3;

        //System.out.println("COORDINATE X: " + x1 + " Y: " + y1 + " is " + Map[x1][y1]);

        if(isTaken(x1, y1)){
            tileID1 = (Map[x1][y1]).getTileIndex();
        }

        if(isTaken(x2, y2)) {
            tileID2 = (Map[x2][y2]).getTileIndex();
        }

        if(isTaken(x3, y3)) {
            tileID3 = (Map[x3][y3]).getTileIndex();
        }

        if(tileID1 == tileID2 && tileID1 == tileID3)    {
            return false;
        }

        return true;
    }

    public boolean isVolcanoOverVolcano(int x1, int y1) {
        Terrain.typesOfTerrain terrainOnMap = null;

        if(isTaken(x1, y1)) {
            terrainOnMap = (Map[x1][y1]).getTerrainType();
        }

        if(terrainOnMap == Terrain.typesOfTerrain.VOLCANO)    {
            return true;
        }

        //System.out.println("Terrain: " + terrainOnMap);

        return false;
    }

    public boolean isOnTheSameLevel(int x1,int y1, int x2, int y2, int x3, int y3) {
        int tileLvl1 = -1;
        int tileLvl2 = -2;
        int tileLvl3 = -3;

        if(isTaken(x1, y1)){
            tileLvl1 = (Map[x1][y1]).getLevel();
        }

        if(isTaken(x2, y2)) {
            tileLvl2 = (Map[x2][y2]).getLevel();
        }

        if(isTaken(x3, y3)) {
            tileLvl3 = (Map[x3][y3]).getLevel();
        }

        if(tileLvl1 == tileLvl2 && tileLvl1 == tileLvl3)    {
            return true;
        }

        //System.out.println("TILE1: " + tileLvl1);
        //System.out.println("TILE2: " + tileLvl2);
        //System.out.println("TILE3: " + tileLvl3);

        return false;
    }

    public static void main(String [] args) {

        Map GameBoard = new Map();
        int TilePos = 4;
        int xVolcano = 100;
        int yVolcano = 100;

        Deck d = new Deck();
        d.generateTiles();
        Tile t = d.draw();
        GameBoard.placeTile(xVolcano, yVolcano, t, TilePos);


    }



}
