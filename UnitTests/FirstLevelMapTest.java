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
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano-1, yVolcano + 1) && GameBoard.testTaken(xVolcano, yVolcano + 1));
            } else if (TilePos == 2) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano + 1) && GameBoard.testTaken(xVolcano + 1, yVolcano));
            } else if (TilePos == 3) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano + 1, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano - 1));
            } else if (TilePos == 4) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano, yVolcano - 1) && GameBoard.testTaken(xVolcano-1, yVolcano - 1));
            } else if (TilePos == 5) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano-1, yVolcano - 1) && GameBoard.testTaken(xVolcano - 1, yVolcano));
            } else if (TilePos == 6) {
                return (GameBoard.testTaken(xVolcano, yVolcano) && GameBoard.testTaken(xVolcano - 1, yVolcano) && GameBoard.testTaken(xVolcano-1, yVolcano + 1));
            }
        }
        else {
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

    @BeforeClass
    public static void createBoardWithFirstTile()    {
        GameBoard = new Map();
        d = new Deck();
        d.generateTiles();
        t = d.draw();
        Coordinate coordinate = new Coordinate(100, 100);
        try {
            GameBoard.placeTile(t, coordinate,  1);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
    }

    @Before
    public void draw(){
        t=d.draw();
        /*

         */
    }

    @Test
    public void firstTilePlacementTest(){

        Assert.assertTrue(checkPosition(100, 100, 1));
    }

    @Test
    public void firstTileLevelTest(){
        Assert.assertEquals(1, GameBoard.getMap()[100][100].getLevel());
    }

    @Test
    public void secondTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(101, 100);
        try {
            GameBoard.placeTile(t, coordinate, 2);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(101, 100, 2));
    }

    @Test
    public void thirdTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(100, 99);
        try {
            GameBoard.placeTile(t, coordinate, 3);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(100, 99, 3));
    }

    @Test
    public void fourthTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(99, 99);
        try {
            GameBoard.placeTile(t, coordinate, 4);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(99, 99, 4));
    }

    @Test
    public void fifthTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(99, 100);
        try {
            GameBoard.placeTile(t, coordinate, 5);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(99, 100, 5));
    }

    @Test
    public void sixthTilePlacementTest()  {
        Coordinate coordinate = new Coordinate(100, 102);
        try {
            GameBoard.placeTile(t, coordinate, 6);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertTrue(checkPosition(100, 102, 6));
    }

    @Test
    public void correctPlacementNotAdjacentTest() {
        Coordinate coordinate = new Coordinate(70, 70);
        try {
            GameBoard.placeTile(t, coordinate,4);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertFalse(checkPosition(70, 70, 4));
    }

    @Test
    public void afterPlacingATileAtOriginInOrientation1ThenThe3CorrespondingCoordinatesAreTaken(){
        Coordinate coordinate = new Coordinate(100, 100);
        try {
            GameBoard.placeTile(t, coordinate,1);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        Assert.assertEquals(true, GameBoard.isTaken(t.getHex1().getCoordinate()));
        Assert.assertEquals(true, GameBoard.isTaken(t.getHex2().getCoordinate()));
        Assert.assertEquals(true, GameBoard.isTaken(t.getHex3().getCoordinate()));
    }

    @Test
    public void checkIfGivenTileCanBePlaceInALocation(){

        Coordinate c1 = new Coordinate(100, 100);
        GameBoard.setTileCoordinates(t, c1, 1);
        Assert.assertEquals(false, GameBoard.canPlaceTileAtGivenTileLocationOnLevel1(t));
    }
}
