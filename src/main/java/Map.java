/**
 * Created by Kyle on 3/14/2017.
 */
public class Map {
    private final int MAX_MAP_WIDTH = 200, MAX_MAP_HEIGHT = 200;
    private Hex Map[][];


    public Map(){
        Map = new Hex[MAX_MAP_WIDTH][MAX_MAP_HEIGHT];
    }



    public boolean isTaken(int x, int y){
        if(Map[x][y] != null) {
            return true;
        }

        else
            return false;
    }

    public Hex[][] getMap(){
        return Map;
    }

    public Terrain.typesOfTerrain getMapTerrain(int x, int y){
        return Map[x][y].getTerrainType();
    }

    public void placeFirstTile(int x, int y, Tile tile, int tileOrientation){

        int hex2XCoordinate, hex2YCoordinate, hex3XCoordinate, hex3YCoordinate;
        int volcanoXCoordinate = x;
        int volcanoYCoordinate = y;
        tile.getHex1().setX(volcanoXCoordinate);
        tile.getHex1().setY(volcanoYCoordinate);

        if (tileOrientation == 1 ){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(y%2 == 0){
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
        else if (tileOrientation == 2 ){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(y%2 == 0){
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

        else if (tileOrientation == 3 ){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(y%2 == 0){
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

        else if (tileOrientation == 4 ) {
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(y%2 == 0){
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

        else if (tileOrientation == 5 ){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(y%2 == 0){
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

        else if (tileOrientation == 6 ){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(y%2 == 0){
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

    public void placeTile(int x, int y, Tile tile, int tileOrientation){

        int hex2XCoordinate, hex2YCoordinate, hex3XCoordinate, hex3YCoordinate;
        int volcanoXCoordinate = x;
        int volcanoYCoordinate = y;
        tile.getHex1().setX(volcanoXCoordinate);
        tile.getHex1().setY(volcanoYCoordinate);

        if (tileOrientation == 1 && isValidPlacement(tile, tileOrientation, x, y)){
            Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();

            if(y%2 == 0){
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

            if(y%2 == 0){
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

            if(y%2 == 0){
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

            if(y%2 == 0){
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

            if(y%2 == 0){
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

            if(y%2 == 0){
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


    public boolean isValidPlacement(Tile tile, int tileOrientation, int x, int y){

        boolean validPlacement = false;

        if(Map[x][y] == null){
            if(y%2 == 0)    {
                if (tileOrientation == 1 && Map[x-1][y + 1] == null && Map[x][y + 1] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 2 && Map[x][y + 1] == null && Map[x + 1][y] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 3 && Map[x + 1][y] == null && Map[x][y - 1] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 4 && Map[x][y - 1] == null && Map[x-1][y - 1] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 5 && Map[x-1][y - 1] == null && Map[x - 1][y] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 6 && Map[x - 1][y] == null && Map[x-1][y + 1] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                }
            }
            else {
                if (tileOrientation == 1 && Map[x][y + 1] == null && Map[x + 1][y + 1] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 2 && Map[x + 1][y + 1] == null && Map[x + 1][y] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 3 && Map[x + 1][y] == null && Map[x + 1][y - 1] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 4 && Map[x + 1][y - 1] == null && Map[x][y - 1] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 5 && Map[x][y - 1] == null && Map[x - 1][y] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                } else if (tileOrientation == 6 && Map[x - 1][y] == null && Map[x][y + 1] == null && isAdjacentToAnotherTile(tileOrientation, x, y)) {
                    validPlacement = true;
                }
            }
        }

        System.out.println(validPlacement + " in valid placement");
        return validPlacement;
    }

    public int[][] createAdjacentCoordinateArray(int x, int y)    {
        int[][] adjacencyMatrix = new int[6][2];

        if(y%2 == 0)
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

    public boolean hasNeighbors(int x, int y)    {
        int[][] adjacencyMatrix;
        int x_adj;
        int y_adj;

        adjacencyMatrix = createAdjacentCoordinateArray(x, y);
        for(int i = 0; i < 6; i++)  {
            x_adj = adjacencyMatrix[i][0];
            y_adj = adjacencyMatrix[i][1];
            if (Map[x_adj][y_adj] != null)  {
                return true;
            }
        }

        return false;
    }

    public int[][] determineTileCoordinatesBasedOnOrientation(int tileOrientation, int x, int y){

        int[][] tileCoordinates = new int[2][2];

        if(y%2 == 0)    {
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

    public boolean isAdjacentToAnotherTile(int tileOrientation, int x, int y)    {
        int[][] tileCoordinates = determineTileCoordinatesBasedOnOrientation(tileOrientation, x, y);

        int x_2 = tileCoordinates[0][0];
        int y_2 = tileCoordinates[0][1];

        int x_3 = tileCoordinates[1][0];
        int y_3 = tileCoordinates[1][1];

        if(hasNeighbors(x, y))  {
            return true;
        }
        else if(hasNeighbors(x_2,y_2))  {
            return true;
        }
        else if(hasNeighbors(x_3, y_3)) {
            return true;
        }

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
