import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by chandlergriffin on 4/5/17.
 */
public class AITilePlacement {
    private static Map GameBoard;
    private static Deck d;
    private static Tile t;

    @BeforeClass
    public static void createBoardWithFirstLevel() {
        d = new Deck();
        d.generateTiles();
        t = d.draw();
        GameBoard = new Map();
        GameBoard.placeFirstTile();
    }

    @Before
    public void draw()  {
        t = d.draw();
    }

    @Test
    public void aiPlaceTileTest1()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest2()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest3()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest4()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest5()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest6()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest7()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest8()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest9()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest10()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest11()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest12()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest13()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest14()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest15()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest16()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest17()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest18()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest19()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        GameBoard.mapTileToBoard(t);
    }

    @Test
    public void aiPlaceTileTest20()   {
        t = GameBoard.searchForFirstValidTilePlacements(t);
        Assert.assertTrue(GameBoard.isValidPlacement(t));
        t.getHex1().getCoordinate().coordinateToString();
        GameBoard.mapTileToBoard(t);
    }
}
