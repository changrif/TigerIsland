import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michelle on 3/21/2017.
 */
public class DeckTest {


    Deck deck = new Deck();
    Hex hex1 = new Hex(Terrain.typesOfTerrain.JUNGLE);
    Hex hex2 = new Hex(Terrain.typesOfTerrain.GRASSLANDS);
    Hex hex3 = new Hex(Terrain.typesOfTerrain.VOLCANO);
    Tile tile = new Tile(hex1, hex2, hex3, 0);

    @Before
    public void createDeck(){
        deck.generateTiles();
    }

    @Test
    public void deckDecreasesByOneWhenTileIsDrawn(){
        deck.draw();
        Assert.assertEquals(47, deck.getCurrentSizeOfDeck());
    }
    @Test
    public void testForReturnGameTiles(){

    }
    @Test
    public void testGetTileID(){

    }
};
