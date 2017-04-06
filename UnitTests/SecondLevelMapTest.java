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

    public static boolean checkTileIDToBoard(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int z = coordinate.getZ();

        if (t.getTileID() == GameBoard.getMap()[x][y][z].getTileID()) {
            return true;
        }
        return false;
    }

    public static void printMap() {
        Hex[][][] map = GameBoard.getMap();
        for (int x = 105; x > 95; x--) {
            for (int y = 105; y > 95; y--) {
                for(int z = 105; z > 95; z--) {
                    if (map[x][y][z] != null) {
                        System.out.print(map[x][y][z].getTerrainType().toString().substring(0, 1) + map[x][y][z].getTileID() + "\t\t");
                    } else {
                        System.out.print(map[x][y][z] + "\t");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @BeforeClass
    public static void createBoardWithFirstTile() {
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        d = new Deck();
        d.generateTiles();
        t = d.draw();

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
            GameBoard.placeTile(t, stackedTileCoordinate, 6);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
    }

    @Before
    public void draw() {
        t = d.draw();
    }

    @Test
    public void secondTilePlacementTest() {
        Coordinate coordinate = new Coordinate(101, 101, 98);
        try {
            GameBoard.placeTile(t, coordinate, 6);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkTileIDToBoard(coordinate));
    }

    @Test
    public void thirdTilePlacementTest() {
        Coordinate coordinate = new Coordinate(97, 102, 101);
        try {
            GameBoard.placeTile(t, coordinate, 5);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkTileIDToBoard(coordinate));
    }

    @Test
    public void notOnTheSameLevelPlacementTest() {
        Coordinate coordinate = new Coordinate(99, 102, 99);
        try {
            GameBoard.placeTile(t, coordinate, 5);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertFalse(checkTileIDToBoard(coordinate));
    }

    @Test
    public void gapTilePlacementTest() {
        Coordinate coordinate = new Coordinate(102, 98, 100);
        try {
            GameBoard.placeTile(t, coordinate, 6);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertFalse(checkTileIDToBoard(coordinate));
    }

    @Test
    public void noOverlapTest() {
        Coordinate coordinate = new Coordinate(100, 100, 100);
        try {
            GameBoard.placeTile(t, coordinate, 1);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertFalse(checkTileIDToBoard(coordinate));
    }

}
