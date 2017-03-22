import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michelle on 3/21/2017.
 */
public class DeckTest {
    Deck deck;
    Tile t;

    @Before
    public void createDeck(){
        deck = new Deck();
        deck.generateTiles();
    }

    @Test
    public void deckDecreasesByOneWhenTileIsDrawn(){
        deck.draw();
        Assert.assertEquals(47, deck.getCurrentSizeOfDeck());
    }

    @Test
    public void checkThatAll48TilesWereCreatedWithCorrectCombinationOfTerrainTypes(){
        Hex h1 = new Hex(Terrain.typesOfTerrain.VOLCANO);
        Hex h2 = new Hex(Terrain.typesOfTerrain.JUNGLE);
        Hex h3 = new Hex(Terrain.typesOfTerrain.JUNGLE);
        Tile JJ_1 = new Tile(h1,h2,h3);


        for(int i = 0; i < 47; i++){
            t = deck.draw();
            Assert.assertEquals();
        }
        Tile tile = new Tile(hex1, hex2, hex3, 0);
        Assert.assertEquals(true,deck.contains(tile));

    }
    @Test
    public void testForReturnGameTiles(){

    }
    @Test
    public void testGetTileID(){

    }
};
