import org.junit.*;

/**
 * Created by chandlergriffin on 3/23/17.
 */
public class FirstLevelMapTest {
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

    @BeforeClass
    public static void createBoardWithFirstTile()    {
        GameBoard = new Map();
        d = new Deck();
        d.generateTiles();
        t = d.draw();
        GameBoard.placeTile(100, 100, t, 1);
    }

    @Before
    public void draw() {
        t = d.draw();
        /*
        Hex[][] map = GameBoard.getMap();
        for(int x = 105; x > 95; x--)   {
            for(int y = 105; y > 95; y--)   {
                System.out.print(map[x][y] + "\t");
            }
            System.out.println();
        }
        System.out.println();*/
    }

    @Test
    public void firstTilePlacementTest()    {
        Assert.assertTrue(checkPosition(100, 100, 1));
    }

    @Test
    public void firstTileLevelTest()    {
        Assert.assertEquals(1, GameBoard.getMap()[100][100].getLevel());
    }

    @Test
    public void secondTilePlacementTest()  {
        GameBoard.placeTile(101, 100, t, 2);
        Assert.assertTrue(checkPosition(101, 100, 2));
    }

    @Test
    public void thirdTilePlacementTest()  {
        GameBoard.placeTile(100, 99, t, 3);
        Assert.assertTrue(checkPosition(100, 99, 3));
    }

    @Test
    public void fourthTilePlacementTest()  {
        GameBoard.placeTile(99, 99, t, 4);
        Assert.assertTrue(checkPosition(99, 99, 4));
    }

    @Test
    public void fifthTilePlacementTest()  {
        GameBoard.placeTile(99, 100, t, 5);
        Assert.assertTrue(checkPosition(99, 100, 5));
    }

    @Test
    public void sixthTilePlacementTest()  {
        GameBoard.placeTile(100, 102, t, 6);
        Assert.assertTrue(checkPosition(100, 102, 6));
    }

    @Test
    public void correctPlacementNotAdjacentTest() {
        GameBoard.placeTile(70, 70, t,4);
        Assert.assertFalse(checkPosition(70, 70, 4));
    }
}
