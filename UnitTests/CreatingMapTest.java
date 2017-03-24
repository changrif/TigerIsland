import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chandlergriffin on 3/23/17.
 */
public class CreatingMapTest {

    public boolean parseThroughMap(Hex[][] Gameboard)   {
        for(int row = 0; row < 200; row++)  {
            for(int col = 0; col < 200; col++)  {
                if (Gameboard[row][col] != null)    {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void mapIsOfHexesTest() {
        Map GameBoard = new Map();
        Assert.assertEquals(Hex[][].class, GameBoard.getMap().getClass());
    }

    @Test
    public void mapIsNullTest() {
        Map GameBoard = new Map();
        Assert.assertTrue(parseThroughMap(GameBoard.getMap()));
    }
}
