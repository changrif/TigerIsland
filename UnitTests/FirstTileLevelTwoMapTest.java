import org.junit.*;

/**
 * Created by chandlergriffin on 3/22/17.
 */

public class FirstTileLevelTwoMapTest {
    private static Map GameBoard;
    private static Deck d;
    private static Tile t;

    public static boolean checkPosition(Coordinate volcano, int tileOrientation)    {
        int z = volcano.getZ();
        int x = volcano.getX();
        int y = volcano.getY();

        if (tileOrientation == 1) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(z - 1, x, y + 1)) && GameBoard.isTaken(new Coordinate(z - 1, x + 1, y))) {
                return true;
            }
        } else if (tileOrientation == 2) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(z - 1, x + 1, y)) && GameBoard.isTaken(new Coordinate(z, x + 1, y - 1))) {
                return true;
            }
        } else if (tileOrientation == 3) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(z, x + 1, y - 1)) && GameBoard.isTaken(new Coordinate(z + 1, x, y - 1)))  {
                return true;
            }
        } else if (tileOrientation == 4) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(z + 1, x, y - 1)) && GameBoard.isTaken(new Coordinate(z + 1, x - 1, y))) {
                return true;
            }
        } else if (tileOrientation == 5) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(z + 1, x - 1, y)) && GameBoard.isTaken(new Coordinate(z, x - 1, y + 1)))  {
                return true;
            }
        } else if (tileOrientation == 6) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(z, x - 1, y + 1)) && GameBoard.isTaken(new Coordinate(z - 1, x, y + 1)))  {
                return true;
            }
        }
        return false;
    }

    public static boolean checkTileIDOnHexes()  {
        if(t.getHex1().getTileID() == t.getHex2().getTileID() &&
                t.getHex1().getTileID() == t.getHex3().getTileID() &&
                t.getTileID() == t.getHex1().getTileID())    {
            return true;
        }
        return false;
    }

    @Before
    public void createBoardWithFirstLevel()    {
        d = new Deck();
        d.generateTiles();
        t = d.draw();
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        Coordinate coordinate1 = new Coordinate(101, 101, 98);
        try {
            GameBoard.placeTile(t, coordinate1, 1);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }

        t = d.draw();
        Coordinate coordinate2 = new Coordinate(99, 102, 99);
        try {
            GameBoard.placeTile(t, coordinate2, 2);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }

        t = d.draw();
        Coordinate coordinate3 = new Coordinate(97, 102, 101);
        try {
            GameBoard.placeTile(t, coordinate3, 3);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }

        t = d.draw();
        Coordinate coordinate4 = new Coordinate(97, 101, 102);
        try {
            GameBoard.placeTile(t, coordinate4, 4);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }

        t = d.draw();
        Coordinate coordinate5 = new Coordinate(99, 99, 102);
        try {
            GameBoard.placeTile(t, coordinate5, 5);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }

        t = d.draw();
        Coordinate coordinate6 = new Coordinate(102, 98, 100);
        try {
            GameBoard.placeTile(t, coordinate6, 6);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }

        t = d.draw();
        Coordinate stackedTileCoordinate = new Coordinate(100, 100, 100);
        try {
            GameBoard.placeTile(t, stackedTileCoordinate, 2);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
    }

    @Test
    public void correctlyStackTileOnLevelTwo() {
        Assert.assertTrue(checkPosition(new Coordinate(100, 100, 100), 2) && GameBoard.getMap()[100][100][100].getTileID() == t.getTileID());
    }

    @Test
    public void firstStackedTilePlacementTest()    {
        Assert.assertTrue(checkPosition(new Coordinate(100, 100, 100), 2));
    }

    @Test
    public void firstStackedTileLevelTest()    {
        Assert.assertEquals(2, t.getTileLevel());
    }

    @Test
    public void firstStackedTileHex1LevelTest()    {
        Assert.assertEquals(2, GameBoard.getMap()[100][100][100].getLevel());
    }

    @Test
    public void firstStackedTileHex2LevelTest()    {
        Assert.assertEquals(2, GameBoard.getMap()[101][100][99].getLevel());
    }

    @Test
    public void firstStackedTileHex3LevelTest()    {
        Assert.assertEquals(2, GameBoard.getMap()[101][99][100].getLevel());
    }

    @Test
    public void firstStackedTileCheckTileID()    {
        Assert.assertTrue(checkTileIDOnHexes());
    }
}
