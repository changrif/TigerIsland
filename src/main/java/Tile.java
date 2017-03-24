/**
 * Created by Kyle on 3/14/2017.
 */
public class Tile {

    private Hex Hex1;
    private Hex Hex2;
    private Hex Hex3;
    private int TileID;
    private int TileLevel;

    public Tile(Hex Hex1, Hex Hex2, Hex Hex3, int TileID){
        this.Hex1 = Hex1;
        this.Hex2 = Hex2;
        this.Hex3 = Hex3;
        this.TileID = TileID;
        this.TileLevel = 0;
    }

    public int getTileLevel() { return TileLevel; }

    public void setTileLevel(int level) { this.TileLevel = level; }

    public int getTileID() { return TileID; }

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


    public static void main(String [] args) {

        Terrain.typesOfTerrain TerrainTypes[] = {
                Terrain.typesOfTerrain.JUNGLE, Terrain.typesOfTerrain.LAKE, Terrain.typesOfTerrain.GRASSLANDS, Terrain.typesOfTerrain.ROCKY};
        Tile TileArray[] = new Tile[48];
        int TileIndex = 0;

        for (int i = 0; i < 3; i++){
            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, TileIndex);
                Hex hex2 = new Hex(terrain, TileIndex);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.JUNGLE, TileIndex);
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, TileIndex);
                Hex hex2 = new Hex(terrain, TileIndex);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.LAKE, TileIndex);
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, TileIndex);
                Hex hex2 = new Hex(terrain, TileIndex);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.GRASSLANDS, TileIndex);
                TileArray[TileIndex] = new Tile(hex1, hex2, hex3, TileIndex);
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, TileIndex);
                Hex hex2 = new Hex(terrain, TileIndex);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.ROCKY, TileIndex);
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
