import org.junit.*;

/**
 * Created by chandlergriffin on 3/23/17.
 */
public class FirstLevelMapTest {
    private static Map GameBoard;
    private static Deck d;
    private static Tile t;

    public static boolean checkPosition(Coordinate volcano, int tileOrientation)    {
        int x = volcano.getX();
        int y = volcano.getY();
        int z = volcano.getZ();

        if (tileOrientation == 1) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(x - 1, y, z + 1)) && GameBoard.isTaken(new Coordinate(x - 1, y + 1, z))) {
                return true;
            }
        } else if (tileOrientation == 2) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(x - 1, y + 1, z)) && GameBoard.isTaken(new Coordinate(x, y + 1, z - 1))) {
                return true;
            }
        } else if (tileOrientation == 3) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(x, y + 1, z - 1)) && GameBoard.isTaken(new Coordinate(x + 1, y, z - 1)))  {
                return true;
            }
        } else if (tileOrientation == 4) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(x + 1, y, z - 1)) && GameBoard.isTaken(new Coordinate(x + 1, y - 1, z))) {
                return true;
            }
        } else if (tileOrientation == 5) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(x + 1, y - 1, z)) && GameBoard.isTaken(new Coordinate(x, y - 1, z + 1)))  {
                return true;
            }
        } else if (tileOrientation == 6) {
            if(GameBoard.isTaken(volcano) && GameBoard.isTaken(new Coordinate(x, y - 1, z + 1)) && GameBoard.isTaken(new Coordinate(x - 1, y, z + 1)))  {
                return true;
            }
        }
        return false;
    }

    @BeforeClass
    public static void createBoardWithFirstTile()    {
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        d = new Deck();
        d.generateTiles();
    }

    @Before
    public void draw()  {
        t = d.draw();
    }

    @Test
    public void firstTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(101, 101, 98);
        try {
            GameBoard.placeTile(t, coordinate, 1);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(coordinate, 1));
    }

    @Test
    public void secondTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(99, 102, 99);
        try {
            GameBoard.placeTile(t, coordinate, 2);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(coordinate, 2));
    }

    @Test
    public void thirdTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(97, 102, 101);
        try {
            GameBoard.placeTile(t, coordinate, 3);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(coordinate, 3));
    }

    @Test
    public void fourthTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(97, 101, 102);
        try {
            GameBoard.placeTile(t, coordinate, 4);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(coordinate, 4));
    }

    @Test
    public void fifthTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(99, 99, 102);
        try {
            GameBoard.placeTile(t, coordinate, 5);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(coordinate, 5));
    }

    @Test
    public void sixthTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(102, 98, 100);
        try {
            GameBoard.placeTile(t, coordinate, 6);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(coordinate, 6));
    }

    @Test
    public void correctPlacementNotAdjacentTest() {
        Coordinate coordinate = new Coordinate(70, 70, 70);
        try {
            GameBoard.placeTile(t, coordinate,4);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertFalse(checkPosition(coordinate, 4));
    }

    @Test
    public void checkIfGivenTileCanBePlaceInALocation(){
        Coordinate coordinate = new Coordinate(100, 100, 100);
        GameBoard.setTileCoordinates(t, coordinate, 1);
        Assert.assertFalse(GameBoard.canPlaceTileAtGivenTileLocationOnLevel1(t));
    }
}
