import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nick Kroeger on 3/21/2017.
 */
public class RandomTileIndexGeneratorTest {
    private RandomTileIndexGenerator r;
    @Before
    public void setup(){
        r = new RandomTileIndexGenerator();
    }

    @Test
    public void totalNumberOfTilesIsFortyEight(){
        Assert.assertEquals(48, r.getAmountOfTiles());
    }

    @Test
    public void NumberOfTilesInHashSetBeforeDrawingATileShouldBeZero(){
        Assert.assertEquals(0, r.getNumberOfTilesPicked());
    }

    @Test
    public void afterPickingATileNumberOfTilesPickedShouldBeOne(){
        r.getRandomTileIndex();
        Assert.assertEquals(1, r.getNumberOfTilesPicked());
    }

    @Test
    public void afterPickingTwoTilesNumberOfTilesPickedShouldBeTwo(){
        r.getRandomTileIndex();
        r.getRandomTileIndex();
        Assert.assertEquals(2, r.getNumberOfTilesPicked());
    }

    @Test
    public void afterPickingFortyEightTilesNumberOfTilesPickedShouldBeFortyEight(){
        for(int i = 0; i< 48; i++){
            r.getRandomTileIndex();
        }
        Assert.assertEquals(48, r.getNumberOfTilesPicked());
    }

    @Test(expected = RuntimeException.class)
    public void afterPickingMoreTilesThanAvailableThenRunTimeExceptionIsThrown(){
        for(int i = 0; i< 49; i++){
            r.getRandomTileIndex();
        }
    }



}
