import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Michelle on 3/21/2017.
 */
public class Deck {

 //   private RandomTileIndexGenerator rand;
    private ArrayList<Tile> GameTiles;

    public Deck()
    {
        //rand = new RandomTileIndexGenerator();
        GameTiles = new ArrayList<Tile>();
        Collections.shuffle(GameTiles);
    }

    public Tile draw(){
        //int index = rand.getRandomTileIndex(GameTiles.size());
        int topCard = GameTiles.size();
        Tile topTile = GameTiles.get(topCard);
        GameTiles.remove(topCard);
        return topTile;
    }

    public void generateTiles(){
        Terrain.typesOfTerrain TerrainTypes[] = {
                Terrain.typesOfTerrain.JUNGLE, Terrain.typesOfTerrain.LAKE, Terrain.typesOfTerrain.GRASSLANDS, Terrain.typesOfTerrain.ROCKY};
        int TileIndex=0;
        for (int i = 0; i < 3; i++){
            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.JUNGLE);
                GameTiles.add(new Tile(hex1, hex2, hex3, TileIndex));
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.LAKE);
                GameTiles.add(new Tile(hex1, hex2, hex3, TileIndex));
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.GRASSLANDS);
                GameTiles.add(new Tile(hex1, hex2, hex3, TileIndex));
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
                Hex hex2 = new Hex(terrain);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.ROCKY);
                GameTiles.add(new Tile(hex1, hex2, hex3, TileIndex));
                TileIndex++;
            }

        }
    }

    public Tile getTile(int id)
    {
        return GameTiles.get(id);
    }

    public int getCurrentSizeOfDeck()
    {
        return GameTiles.size();
    }
}

