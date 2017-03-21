/**
 * Created by Michelle on 3/21/2017.
 */
public class Deck {

    public Tile GameTiles[] = new Tile[48];

    public Deck()
    {
    }

    public int getSizeOfDeck()
    {
        return GameTiles.length;
    }

    public Tile[] getDeck()
    {
        return GameTiles;
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

    public Tile getTile(int id)
    {
        return GameTiles[id];
    }

    public int getTileID(int id)
    {
        return GameTiles[id].getTileID();
    }
}

