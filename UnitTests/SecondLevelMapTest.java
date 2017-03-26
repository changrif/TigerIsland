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
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano - 1, yVolcano + 1) && GameBoard.testTaken(xVolcano, yVolcano + 1));
            } else if (TilePos == 2) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano + 1) && GameBoard.testTaken(xVolcano + 1, yVolcano));
            } else if (TilePos == 3) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano + 1, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano - 1));
            } else if (TilePos == 4) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano - 1) && GameBoard.testTaken(xVolcano - 1, yVolcano - 1));
            } else if (TilePos == 5) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano - 1, yVolcano - 1) && GameBoard.testTaken(xVolcano - 1, yVolcano));
            } else if (TilePos == 6) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano - 1, yVolcano) && GameBoard.testTaken(xVolcano - 1, yVolcano + 1));
            }
        } else {
            if (TilePos == 1) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano + 1) && GameBoard.testTaken(xVolcano + 1, yVolcano + 1));
            } else if (TilePos == 2) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano + 1, yVolcano + 1) && GameBoard.testTaken(xVolcano + 1, yVolcano));
            } else if (TilePos == 3) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano + 1, yVolcano) && GameBoard.testTaken(xVolcano + 1, yVolcano - 1));
            } else if (TilePos == 4) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano + 1, yVolcano - 1) && GameBoard.testTaken(xVolcano, yVolcano - 1));
            } else if (TilePos == 5) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano - 1) && GameBoard.testTaken(xVolcano - 1, yVolcano));
            } else if (TilePos == 6) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano - 1, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano + 1));
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
        Coordinate coordinate = new Coordinate(100, 100);
        GameBoard.placeTile(t, coordinate, 1);
        //printMap();
        t = d.draw();
        coordinate = new Coordinate(101, 100);
        GameBoard.placeTile(t, coordinate, 2);
        //printMap();
        t = d.draw();
        coordinate = new Coordinate(100, 99);
        GameBoard.placeTile(t, coordinate, 3);
        //printMap();
        t = d.draw();
        coordinate = new Coordinate(99, 99);
        GameBoard.placeTile(t, coordinate, 4);
        //printMap();
        t = d.draw();
        coordinate = new Coordinate(99, 100);
        GameBoard.placeTile(t, coordinate, 5);
        //printMap();
        t = d.draw();
        coordinate = new Coordinate(100, 102);
        GameBoard.placeTile(t, coordinate, 6);
        //printMap();
        t = d.draw();
        coordinate = new Coordinate(100, 100);
        GameBoard.placeTile(t, coordinate, 2);
        //printMap();
    }

    @Before
    public void draw() {
        t = d.draw();
    }

    @Test
    public void secondTilePlacementTest() {
        Coordinate coordinate = new Coordinate(99, 99);
        GameBoard.placeTile(t, coordinate, 5);
        Assert.assertTrue(checkTileIDToBoard(99, 99));
    }

    @Test
    public void thirdTilePlacementTest() {
        Coordinate coordinate = new Coordinate(100, 102);
        GameBoard.placeTile(t, coordinate, 5);
        Assert.assertTrue(checkTileIDToBoard(100, 102));
    }

    @Test
    public void notOnTheSameLevelPlacementTest() {
        Coordinate coordinate = new Coordinate(101, 102);
        GameBoard.placeTile(t, coordinate, 6);
        Assert.assertFalse(checkPosition(101, 102, 6));
    }

    @Test
    public void gapTilePlacementTest() {
        Coordinate coordinate = new Coordinate(99, 100);
        GameBoard.placeTile(t, coordinate, 6);
        Assert.assertFalse(checkTileIDToBoard(99, 100));
    }

    @Test
    public void noOverlapTest() {
        Coordinate coordinate = new Coordinate(100, 99);
        GameBoard.placeTile(t, coordinate, 3);
        Assert.assertFalse(checkTileIDToBoard(100, 99));
    }

}
