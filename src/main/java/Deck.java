import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Michelle on 3/21/2017.
 * This class was created and used for unit and acceptance testing. It generates a deck of 48 tiles with all of the possible terrain
 * combinations and then shuffles them. Additionally, the draw function will draw a tile randomly from the deck and returns it as a Tile object.
 */
public class Deck {

    private ArrayList<Tile> GameTiles;

    public Deck()
    {
        GameTiles = new ArrayList<>();

    }

    public Tile draw(){
        int topCard = GameTiles.size() - 1;
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
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, TileIndex);
                Hex hex2 = new Hex(terrain, TileIndex);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.JUNGLE, TileIndex);
                GameTiles.add(new Tile(hex1, hex2, hex3, TileIndex));
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, TileIndex);
                Hex hex2 = new Hex(terrain, TileIndex);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.LAKE, TileIndex);
                GameTiles.add(new Tile(hex1, hex2, hex3, TileIndex));
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, TileIndex);
                Hex hex2 = new Hex(terrain, TileIndex);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.GRASSLANDS, TileIndex);
                GameTiles.add(new Tile(hex1, hex2, hex3, TileIndex));
                TileIndex++;
            }

            for (Terrain.typesOfTerrain terrain: TerrainTypes){
                Hex hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, TileIndex);
                Hex hex2 = new Hex(terrain, TileIndex);
                Hex hex3 = new Hex(Terrain.typesOfTerrain.ROCKY, TileIndex);
                GameTiles.add(new Tile(hex1, hex2, hex3, TileIndex));
                TileIndex++;
            }

        }
        Collections.shuffle(GameTiles);
    }


    public int getCurrentSizeOfDeck()
    {
        return GameTiles.size();
    }
}

