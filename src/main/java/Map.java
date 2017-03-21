/**
 * Created by Kyle on 3/14/2017.
 */
public class Map {

    private Hex Map[][] = new Hex[200][200];
    private Tile GameTiles[] = new Tile[48];


    public Map(){
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


    public void TileGenerate(){
        Terrain.typesOfTerrain TerrainTypes[] = {
                Terrain.typesOfTerrain.JUNGLE, Terrain.typesOfTerrain.LAKE, Terrain.typesOfTerrain.GRASSLANDS, Terrain.typesOfTerrain.ROCKY};
        int TileIndex = 0;
        for (int i = 0; i < 3; i++){
            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.JUNGLE);
                GameTiles[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.LAKE);
                GameTiles[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.GRASSLANDS);
                GameTiles[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.ROCKY);
                GameTiles[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

        }
    }


    public boolean isValidPlacement(){
        return true;
    }





    public static void main(String [] args) {


        Map GameBoard = new Map();
        int chosenTile = 1;
        int TilePos = 6;
        int xVolcano = 100;
        int yVolcano = 100;

        GameBoard.TileGenerate();

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
