/**
 * Created by Kyle on 3/14/2017.
 */
public class Tile {

    private Hex Hex1;
    private Hex Hex2;
    private Hex Hex3;
    private int TileID;

    public Tile(Hex Hex1, Hex Hex2, Hex Hex3, int TileID){
        this.Hex1 = Hex1;
        this.Hex2 = Hex2;
        this.Hex3 = Hex3;
        this.TileID = TileID;

    }

    public int getTileID() {return TileID; }

    public Hex getHex1(){
        return Hex1;
    }

    public Hex getHex2(){
        return Hex2;
    }

    public Hex getHex3(){
        return Hex3;
    }

    //odd-r horizontal layout
    public void addTile(int x, int y, int TilePos, Hex Map[][]){
        Map[x][y] = Hex1;
        Hex1.setX(x);
        Hex1.setY(y);

        if (TilePos == 1){
            Map[x][y+1] = Hex2;
            Hex2.setX(x);
            Hex2.setY(y+1);

            Map[x+1][y+1] = Hex3;
            Hex3.setX(x+1);
            Hex3.setY(y+1);
        }
        else if (TilePos == 2){
            Map[x+1][y+1] = Hex2;
            Hex2.setX(x+1);
            Hex2.setY(y+1);

            Map[x+1][y] = Hex3;
            Hex3.setX(x+1);
            Hex3.setY(y);
        }

        else if (TilePos == 3){
            Map[x+1][y] = Hex2;
            Hex2.setX(x+1);
            Hex2.setY(y);

            Map[x+1][y-1] = Hex3;
            Hex3.setX(x+1);
            Hex3.setY(y-1);
        }

        else if (TilePos == 4) {
            Map[x + 1][y - 1] = Hex2;
            Hex2.setX(x + 1);
            Hex2.setY(y - 1);

            Map[x][y - 1] = Hex3;
            Hex3.setX(x);
            Hex3.setY(y - 1);
        }

        else if (TilePos == 5){
            Map[x][y-1] = Hex2;
            Hex2.setX(x);
            Hex2.setY(y-1);

            Map[x-1][y] = Hex3;
            Hex3.setX(x-1);
            Hex3.setY(y);
        }

        else if (TilePos == 6){
            Map[x-1][y] = Hex2;
            Hex2.setX(x-1);
            Hex2.setY(y);

            Map[x][y+1] = Hex3;
            Hex3.setX(x);
            Hex3.setY(y+1);
        }
    }

    public static void main(String [] args) {

        Terrain.typesOfTerrain TerrainTypes[] = {
                Terrain.typesOfTerrain.JUNGLE, Terrain.typesOfTerrain.LAKE, Terrain.typesOfTerrain.GRASSLANDS, Terrain.typesOfTerrain.ROCKY};
        Tile TileArray[] = new Tile[48];
        int TileIndex = 0;

        for (int i = 0; i < 3; i++){
            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.JUNGLE);
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.LAKE);
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.GRASSLANDS);
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.ROCKY);
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

        }

        for (int i = 0; i < 1; i++) {
            Hex hex1 = TileArray[i].getHex1();
            Hex hex2 = TileArray[i].getHex2();
            Hex hex3 = TileArray[i].getHex3();

            System.out.println(hex1.getTerrainType());
            System.out.println(hex2.getTerrainType());
            System.out.println(hex3.getTerrainType());

            System.out.println();

        }

    }

}
