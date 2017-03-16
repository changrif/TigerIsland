/**
 * Created by Kyle on 3/14/2017.
 */
public class Map {

    private Hex Map[][] = new Hex[200][200];


    public Map(){
    }

    public String getMapTerrain(int x, int y){
        return Map[x][y].getTerrainType();
    }

    public boolean isTaken(int x, int y){
        if(Map[x][y] != null) {
            return true;
        }

        else
            return false;
    }

    //odd-r horizontal layout
    public void addTile(int x, int y, int TilePos, Tile Tile){
        Map[x][y] = Tile.getHex1();
        Tile.getHex1().setX(x);
        Tile.getHex1().setY(y);

        if (TilePos == 1){
            Map[x][y+1] = Tile.getHex2();
            Tile.getHex2().setX(x);
            Tile.getHex2().setY(y+1);

            Map[x+1][y+1] = Tile.getHex3();
            Tile.getHex3().setX(x+1);
            Tile.getHex3().setY(y+1);
        }
        else if (TilePos == 2){
            Map[x+1][y+1] = Tile.getHex2();
            Tile.getHex2().setX(x+1);
            Tile.getHex2().setY(y+1);

            Map[x+1][y] = Tile.getHex3();
            Tile.getHex3().setX(x+1);
            Tile.getHex3().setY(y);
        }

        else if (TilePos == 3){
            Map[x+1][y] = Tile.getHex2();
            Tile.getHex2().setX(x+1);
            Tile.getHex2().setY(y);

            Map[x+1][y-1] = Tile.getHex3();
            Tile.getHex3().setX(x+1);
            Tile.getHex3().setY(y-1);
        }

        else if (TilePos == 4) {
            Map[x + 1][y - 1] = Tile.getHex2();
            Tile.getHex2().setX(x + 1);
            Tile.getHex2().setY(y - 1);

            Map[x][y - 1] = Tile.getHex3();
            Tile.getHex3().setX(x);
            Tile.getHex3().setY(y - 1);
        }

        else if (TilePos == 5){
            Map[x][y-1] = Tile.getHex2();
            Tile.getHex2().setX(x);
            Tile.getHex2().setY(y-1);

            Map[x-1][y] = Tile.getHex3();
            Tile.getHex3().setX(x-1);
            Tile.getHex3().setY(y);
        }

        else if (TilePos == 6){
            Map[x-1][y] = Tile.getHex2();
            Tile.getHex2().setX(x-1);
            Tile.getHex2().setY(y);

            Map[x][y+1] = Tile.getHex3();
            Tile.getHex3().setX(x);
            Tile.getHex3().setY(y+1);
        }
    }

    public boolean isValidPlacement(){
        return true;
    }





    public static void main(String [] args) {

        String TerrainTypes[] = {"Jungle", "Lake", "Grassland", "Rocky"};
        Tile TileArray[] = new Tile[48];
        int TileIndex = 0;

        for (int i = 0; i < 3; i++) {
            for (String terrain : TerrainTypes) {
                Hex hex1 = new Hex("Volcano");
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex("Jungle");
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (String terrain : TerrainTypes) {
                Hex hex1 = new Hex("Volcano");
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex("Lake");
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (String terrain : TerrainTypes) {
                Hex hex1 = new Hex("Volcano");
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex("Grassland");
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (String terrain : TerrainTypes) {
                Hex hex1 = new Hex("Volcano");
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex("Rocky");
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

        }

        Map GameBoard = new Map();
        int chosenTile = 1;
        int TilePos = 6;
        int xVolcano = 100;
        int yVolcano = 100;

        GameBoard.addTile(xVolcano, yVolcano, TilePos , TileArray[chosenTile]);

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

        System.out.println(TileArray[chosenTile].getHex1().getTerrainType());
        System.out.println(TileArray[chosenTile].getHex1().getX());
        System.out.println(TileArray[chosenTile].getHex1().getY());

        System.out.println(TileArray[chosenTile].getHex2().getTerrainType());
        System.out.println(TileArray[chosenTile].getHex2().getX());
        System.out.println(TileArray[chosenTile].getHex2().getY());

        System.out.println(TileArray[chosenTile].getHex3().getTerrainType());
        System.out.println(TileArray[chosenTile].getHex3().getX());
        System.out.println(TileArray[chosenTile].getHex3().getY());

    }



}
