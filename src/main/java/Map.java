/**
 * Created by Kyle on 3/14/2017.
 */
public class Map {
    private final int MAX_MAP_WIDTH = 200, MAX_MAP_HEIGHT = 200;
    private Hex Map[][];
   // private Tile GameTiles[] = new Tile[48];


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
    public Tile[] getTiles(){
        return GameTiles;
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
        Map[volcanoXCoordinate][volcanoYCoordinate] = tile.getHex1();


        if (tileOrientation == 1 && isValidPlacement(tile, tileOrientation, volcanoXCoordinate, volcanoYCoordinate)){
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
        else if (tileOrientation == 2 && isValidPlacement(tile, tileOrientation, volcanoXCoordinate, volcanoYCoordinate)){

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

        else if (tileOrientation == 3 && isValidPlacement(tile, tileOrientation, volcanoXCoordinate, volcanoYCoordinate)){
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

        else if (tileOrientation == 4 && isValidPlacement(tile, tileOrientation, volcanoXCoordinate, volcanoYCoordinate)) {

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

        else if (tileOrientation == 5 && isValidPlacement(tile, tileOrientation, volcanoXCoordinate, volcanoYCoordinate)){
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

        else if (tileOrientation == 6 && isValidPlacement(tile, tileOrientation, volcanoXCoordinate, volcanoYCoordinate)){
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


    public boolean isValidPlacement(Tile tile, int tileOrientation, int x, int y){

        boolean validPlacement = false;
        if(tileOrientation == 1 && Map[x][y + 1] != null && Map[x+1][y+1] && checkNeighborTiles()){
            validPlacement = true;
        }
        else if(tileOrientation == 2 && Map[x + 1][y + 1] != null && Map[x+1][y] && checkNeighborTiles()){

        }
        else if(tileOrientation == 3 && Map[x + 1][y] != null && Map[x+1][y - 1] && checkNeighborTiles()){

        }
        else if(tileOrientation == 4 && Map[x + 1][y - 1] != null && Map[x][y - 1] && checkNeighborTiles()){

        }
        else if(tileOrientation == 5 && Map[x][y - 1] != null && Map[x-1][y] && checkNeighborTiles()){

        }
        else if(tileOrientation == 6 && Map[x - 1][y] != null && Map[x][y + 1] && checkNeighborTiles()){

        }

        return validPlacement;

    }





    public static void main(String [] args) {


        Map GameBoard = new Map();
        int chosenTile = 1;
        int TilePos = 6;
        int xVolcano = 100;
        int yVolcano = 100;

       // GameBoard.TileGenerate();

        GameBoard.GameTiles[chosenTile].addTile(xVolcano, yVolcano, TilePos, GameBoard.getMap());

        if (TilePos == 1){
            if (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano+1) && GameBoard.isTaken(xVolcano+1, yVolcano+1))
                System.out.println("Tile placed correctly!");
            else
                System.out.println("Tile placed incorrectly");
        }

        else if (TilePos == 2){
            if (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano+1, yVolcano+1) && GameBoard.isTaken(xVolcano+1, yVolcano))
                System.out.println("Tile placed correctly!");
            else
                System.out.println("Tile placed incorrectly");
        }

        else if (TilePos == 3){
            if (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano+1, yVolcano) && GameBoard.isTaken(xVolcano+1, yVolcano-1))
                System.out.println("Tile placed correctly!");
            else
                System.out.println("Tile placed incorrectly");
        }

        else if (TilePos == 4){
            if (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano+1, yVolcano-1) && GameBoard.isTaken(xVolcano, yVolcano-1))
                System.out.println("Tile placed correctly!");
            else
                System.out.println("Tile placed incorrectly");
        }

        else if (TilePos == 5){
            if (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano-1) && GameBoard.isTaken(xVolcano-1, yVolcano))
                System.out.println("Tile placed correctly!");
            else
                System.out.println("Tile placed incorrectly");
        }

        else if (TilePos == 6){
            if (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano-1, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano+1))
                System.out.println("Tile placed correctly!");
            else
                System.out.println("Tile placed incorrectly");
        }


    }



}
