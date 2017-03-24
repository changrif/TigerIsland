import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by chandlergriffin on 3/23/17.
 */
public class FirstTileMapTest {
    private static Map GameBoard;
    private static Deck d;
    private static Tile t;

    public static boolean checkPosition(int xVolcano, int yVolcano, int TilePos) {
        if(yVolcano%2 == 0)    {
            if (TilePos == 1) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano-1, yVolcano + 1) && GameBoard.isTaken(xVolcano, yVolcano + 1));
            } else if (TilePos == 2) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano + 1) && GameBoard.isTaken(xVolcano + 1, yVolcano));
            } else if (TilePos == 3) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano + 1, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano - 1));
            } else if (TilePos == 4) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano - 1) && GameBoard.isTaken(xVolcano-1, yVolcano - 1));
            } else if (TilePos == 5) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano-1, yVolcano - 1) && GameBoard.isTaken(xVolcano - 1, yVolcano));
            } else if (TilePos == 6) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano - 1, yVolcano) && GameBoard.isTaken(xVolcano-1, yVolcano + 1));
            }
        }
        else {
            if (TilePos == 1) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano + 1) && GameBoard.isTaken(xVolcano + 1, yVolcano + 1));
            } else if (TilePos == 2) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano + 1, yVolcano + 1) && GameBoard.isTaken(xVolcano + 1, yVolcano));
            } else if (TilePos == 3) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano + 1, yVolcano) && GameBoard.isTaken(xVolcano + 1, yVolcano - 1));
            } else if (TilePos == 4) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano + 1, yVolcano - 1) && GameBoard.isTaken(xVolcano, yVolcano - 1));
            } else if (TilePos == 5) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano - 1) && GameBoard.isTaken(xVolcano - 1, yVolcano));
            } else if (TilePos == 6) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano - 1, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano + 1));
            }
        }
        return false;
    }

    public static boolean checkTileIDOnHexes()  {
        if(t.getHex1().getTileIndex() == t.getHex2().getTileIndex() &&
                t.getHex1().getTileIndex() == t.getHex3().getTileIndex() &&
                t.getTileID() == t.getHex1().getTileIndex())    {
            return true;
        }
        return false;
    }

    @BeforeClass
    public static void createDeck()    {
        d = new Deck();
        d.generateTiles();
    }

    @Before
    public void initializeBoard()    {
        t = d.draw();
        GameBoard = new Map();
        GameBoard.placeTile(100, 100, t, 1);
    }

    @Test
    public void firstTilePlacementTest()    {
        Assert.assertTrue(checkPosition(100, 100, 1));
    }

    @Test
    public void firstTileLevelTest()    {
        Assert.assertEquals(1, t.getTileLevel());
    }

    @Test
    public void firstTileHex1LevelTest()    {
        Assert.assertEquals(1, GameBoard.getMap()[100][100].getLevel());
    }

    @Test
    public void firstTileHex2LevelTest()    {
        Assert.assertEquals(1, GameBoard.getMap()[99][101].getLevel());
    }

    @Test
    public void firstTileHex3LevelTest()    {
        Assert.assertEquals(1, GameBoard.getMap()[100][101].getLevel());
    }

    @Test
    public void firstTileCheckTileID()    {
        Assert.assertTrue(checkTileIDOnHexes());
    }
}
