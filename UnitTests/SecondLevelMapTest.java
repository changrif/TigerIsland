import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by chandlergriffin on 3/24/17.
 */
public class SecondLevelMapTest {
    private static Map GameBoard;
    private static Deck d;
    private static Tile t;

    public static boolean checkPosition(int xVolcano, int yVolcano, int TilePos) {
        if (yVolcano % 2 == 0) {
            if (TilePos == 1) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano - 1, yVolcano + 1) && GameBoard.isTaken(xVolcano, yVolcano + 1));
            } else if (TilePos == 2) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano + 1) && GameBoard.isTaken(xVolcano + 1, yVolcano));
            } else if (TilePos == 3) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano + 1, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano - 1));
            } else if (TilePos == 4) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano, yVolcano - 1) && GameBoard.isTaken(xVolcano - 1, yVolcano - 1));
            } else if (TilePos == 5) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano - 1, yVolcano - 1) && GameBoard.isTaken(xVolcano - 1, yVolcano));
            } else if (TilePos == 6) {
                return (GameBoard.isTaken(xVolcano, yVolcano) && GameBoard.isTaken(xVolcano - 1, yVolcano) && GameBoard.isTaken(xVolcano - 1, yVolcano + 1));
            }
        } else {
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

    public static boolean checkTileIDToBoard(int x, int y) {
        if (t.getTileID() == GameBoard.getMap()[x][y].getTileIndex()) {
            return true;
        }
        return false;
    }

    public static void printMap() {
        Hex[][] map = GameBoard.getMap();
        for (int x = 105; x > 95; x--) {
            for (int y = 105; y > 95; y--) {
                if (map[x][y] != null) {
                    System.out.print(map[x][y].getTerrainType().toString().substring(0, 1) + map[x][y].getTileIndex() + "\t\t");
                } else {
                    System.out.print(map[x][y] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @BeforeClass
    public static void createBoardWithFirstTile() {
        GameBoard = new Map();
        d = new Deck();
        d.generateTiles();
        t = d.draw();
        GameBoard.placeTile(100, 100, t, 1);
        //printMap();
        t = d.draw();
        GameBoard.placeTile(101, 100, t, 2);
        //printMap();
        t = d.draw();
        GameBoard.placeTile(100, 99, t, 3);
        //printMap();
        t = d.draw();
        GameBoard.placeTile(99, 99, t, 4);
        //printMap();
        t = d.draw();
        GameBoard.placeTile(99, 100, t, 5);
        //printMap();
        t = d.draw();
        GameBoard.placeTile(100, 102, t, 6);
        //printMap();
        t = d.draw();
        GameBoard.placeTile(100, 100, t, 2);
        //printMap();
    }

    @Before
    public void draw() {
        t = d.draw();
    }

    @Test
    public void secondTilePlacementTest() {
        GameBoard.placeTile(99, 99, t, 5);
        Assert.assertTrue(checkTileIDToBoard(99, 99));
    }

    @Test
    public void thirdTilePlacementTest() {
        GameBoard.placeTile(100, 102, t, 5);
        Assert.assertTrue(checkTileIDToBoard(100, 102));
    }

    @Test
    public void notOnTheSameLevelPlacementTest() {
        GameBoard.placeTile(101, 102, t, 6);
        Assert.assertFalse(checkPosition(101, 102, 6));
    }

    @Test
    public void gapTilePlacementTest() {
        GameBoard.placeTile(99, 100, t, 6);
        Assert.assertFalse(checkTileIDToBoard(99, 100));
    }

    @Test
    public void noOverlapTest() {
        GameBoard.placeTile(100, 99, t, 3);
        Assert.assertFalse(checkTileIDToBoard(100, 99));
    }

}
