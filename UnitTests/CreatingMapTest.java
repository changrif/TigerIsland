import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chandlergriffin on 3/23/17.
 */
public class CreatingMapTest {

    public boolean parseThroughMap(Hex[][][] Gameboard)   {
        for(int x = 0; x < 200; x++)  {
            for(int y = 0; y < 200; y++)  {
                for(int z = 0; z < 200; z++)
                if (Gameboard[x][y][z] != null)    {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void mapIsOfHexesTest() {
        Map GameBoard = new Map();
        Assert.assertEquals(Hex[][][].class, GameBoard.getMap().getClass());
    }

    @Test
    public void mapIsNullTest() {
        Map GameBoard = new Map();
        Assert.assertTrue(parseThroughMap(GameBoard.getMap()));
    }
}
