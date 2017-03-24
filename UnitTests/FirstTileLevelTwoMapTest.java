import org.junit.*;

/**
 * Created by chandlergriffin on 3/22/17.
 */

public class FirstTileLevelTwoMapTest {

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
    public void createBoardWithFirstLevel()    {
        t = d.draw();
        GameBoard = new Map();
        GameBoard.placeTile(100, 100, t, 1);

        t = d.draw();
        GameBoard.placeTile(101, 100, t, 2);

        t = d.draw();
        GameBoard.placeTile(100, 100, t, 2);
    }

    @Test
    public void correctlyStackTileOnLevelTwo() {
        Assert.assertTrue(checkPosition(100, 100, 2) && GameBoard.getMap()[100][100].getTileIndex() == t.getTileID());
    }

    @Test
    public void firstStackedTilePlacementTest()    {
        Assert.assertTrue(checkPosition(100, 100, 2));
    }

    @Test
    public void firstStackedTileLevelTest()    {
        Assert.assertEquals(2, t.getTileLevel());
    }

    @Test
    public void firstStackedTileHex1LevelTest()    {
        Assert.assertEquals(2, GameBoard.getMap()[100][100].getLevel());
    }

    @Test
    public void firstStackedTileHex2LevelTest()    {
        Assert.assertEquals(2, GameBoard.getMap()[100][101].getLevel());
    }

    @Test
    public void firstStackedTileHex3LevelTest()    {
        Assert.assertEquals(2, GameBoard.getMap()[101][100].getLevel());
    }

    @Test
    public void firstStackedTileCheckTileID()    {
        Assert.assertTrue(checkTileIDOnHexes());
    }
}
