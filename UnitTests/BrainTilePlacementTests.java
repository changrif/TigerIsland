import org.junit.*;

/**
 * Created by chandlergriffin on 4/5/17.
 */
public class BrainTilePlacementTests {
    private static Map GameBoard;
    private static PlayerBrain playerBrain;
    private static Player teamI = new Player("teamI");
    private static Player opponent = new Player("opponent");
    private static Deck d;
    private static Tile t;

    @BeforeClass
    public static void createBoardWithFirstTile() {
        d = new Deck();
        d.generateTiles();
        t = d.draw();
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        playerBrain = new PlayerBrain(teamI, opponent, GameBoard);
        t = d.draw();
        playerBrain.setTileToPlace(t);
        playerBrain.setBestTilePlacement();
        GameBoard.mapTileToBoard(playerBrain.getTileToPlace());

        GameBoard.foundNewSettlement(new Coordinate(99, 101, 100), teamI);
    }

    @Before
    public void draw()  {
        t = d.draw();
        playerBrain.setTileToPlace(t);
        playerBrain.setBestTilePlacement();
    }

    @Test
    public void aiPlaceTileTest1()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest2()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest3()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest4()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest5()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest6()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest7()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest8()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest9()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest10()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest11()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest12()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest13()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest14()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest15()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest16()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest17()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest18()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest19()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @Test
    public void aiPlaceTileTest20()   {
        Assert.assertTrue(GameBoard.isValidPlacement(playerBrain.getTileToPlace()));
    }

    @After
    public void placeTileAndPrintLevel()    {
        playerBrain.getTileToPlace().getHex1().getCoordinate().coordinateToString();
        System.out.println(playerBrain.getTileToPlace().getTileOrientation());
        GameBoard.mapTileToBoard(playerBrain.getTileToPlace());
        System.out.println("Tile placed on Level: " + playerBrain.getTileToPlace().getTileLevel());
    }
}
