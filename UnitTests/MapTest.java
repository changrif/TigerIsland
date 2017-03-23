import org.junit.*;

/**
 * Created by chandlergriffin on 3/22/17.
 */

public class MapTest {

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
        GameBoard.placeFirstTile(100, 100, t, 1);
    }

    @After
    public void drawTileTest()  {
        t = d.draw();
        Hex[][] map = GameBoard.getMap();

        for(int x = 105; x > 95; x--)   {
            for(int y = 105; y > 95; y--)   {
                System.out.print(map[x][y] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void testFirstTilePlacement()    {
        Assert.assertTrue(checkPosition(100, 100, 1));
    }

    @Test
    public void incorrectTilePlacementTest() {
        GameBoard.placeTile(100, 101, t, 3);
        Assert.assertFalse(checkPosition(100, 101, 3));
    }

    @Test
    public void correctTilePlacementTest()  {
        GameBoard.placeTile(101, 100, t, 2);
        Assert.assertTrue(checkPosition(101, 100, 2));
    }

    @Test
    public void correctPlacementNotAdjacent() {
        GameBoard.placeTile(70, 70, t,4);
        Assert.assertFalse(checkPosition(70, 70, 4));
    }

    @Test
    public void correctTilePlacementTest2()  {
        GameBoard.placeTile(103, 101, t, 5);
        Assert.assertTrue(checkPosition(103, 101, 6));
    }

}
