import org.junit.Assert;
import org.junit.*;

/**
 * Created by Kyle on 3/25/2017.
 */
public class SettlementTests {

    private static Map GameBoard;
    private static Deck d;
    private static Tile tile1;
    private static Tile tile2;
    private static Tile tile3;
    private static Tile tile4;
    private static Player p1;
    private static Player p2;
    private static Coordinate CurrentPlacement;


    @BeforeClass
    public static void createBoardWithFirstTile()    {
        GameBoard = new Map();
        d = new Deck();
        d.generateTiles();
        p1 = new Player("Kyle");
        p2 = new Player("Dave");
    }

    @Before
    public void P1foundsNewSettlement()   {
        Hex Hex01 = new Hex(Terrain.typesOfTerrain.VOLCANO, 1);
        Hex Hex02 = new Hex(Terrain.typesOfTerrain.JUNGLE, 2);
        Hex Hex03 = new Hex(Terrain.typesOfTerrain.JUNGLE, 3);
        Hex Hex11 = new Hex(Terrain.typesOfTerrain.VOLCANO, 1);
        Hex Hex12 = new Hex(Terrain.typesOfTerrain.JUNGLE, 2);
        Hex Hex13 = new Hex(Terrain.typesOfTerrain.JUNGLE, 3);
        Hex Hex21 = new Hex(Terrain.typesOfTerrain.VOLCANO, 1);
        Hex Hex22 = new Hex(Terrain.typesOfTerrain.JUNGLE, 2);
        Hex Hex23 = new Hex(Terrain.typesOfTerrain.ROCKY, 3);
        Hex Hex31 = new Hex(Terrain.typesOfTerrain.VOLCANO, 1);
        Hex Hex32 = new Hex(Terrain.typesOfTerrain.LAKE, 2);
        Hex Hex33 = new Hex(Terrain.typesOfTerrain.LAKE, 3);
        tile1 = new Tile(Hex01, Hex02, Hex03, 0);
        tile2 = new Tile(Hex11, Hex12, Hex13, 1);
        tile3 = new Tile(Hex21, Hex22, Hex23, 2);
        tile4 = new Tile(Hex31, Hex32, Hex33, 3);
        Coordinate tile1Location = new Coordinate(100,100);
        Coordinate tile2Location = new Coordinate(102,100);
        Coordinate tile3Location = new Coordinate(103,99);
        Coordinate tile4Location = new Coordinate(103, 101);

        GameBoard.placeTile(tile1, tile1Location, 1);
        GameBoard.placeTile(tile2, tile2Location, 1);
        GameBoard.placeTile(tile3, tile3Location, 1);
        GameBoard.placeTile(tile4, tile4Location, 1);


        Assert.assertEquals(p1.getPlayerSettlements().size(), 0);

        CurrentPlacement = new Coordinate(100,101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
        Assert.assertEquals(p1.getPlayerSettlements().size(), 1);

        CurrentPlacement = new Coordinate(100,100);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
        Assert.assertEquals(p1.getPlayerSettlements().size(), 1);

    }

    @Before public void P1ExpandSettlement(){
        CurrentPlacement = new Coordinate(100,101);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

    }

    @Before public void P1PlacesTotoro(){
        CurrentPlacement = new Coordinate(104,100);
        GameBoard.PlaceTotoro(CurrentPlacement, p1);

        //should only have 1 settlement at this point
        Assert.assertEquals(p1.getPlayerSettlements().size(), 1);

        //should be length 6 (5 Meeples and 1 Totoro)
        Assert.assertEquals(p1.getPlayerSettlements().get(0).getLength(), 6);

        //check Map location (104,100) to make sure a Totoro exists and is owned by P1
        Assert.assertTrue(GameBoard.getMap()[104][100].TotoroPresent());

        //no Meeples should be present at (104,100)
        Assert.assertFalse(GameBoard.getMap()[104][100].MeeplesPresent());

        //P1's total Meeples should be 15 now
        Assert.assertEquals(p1.getNumberOfMeeplesIHave(),15);

        //P1's total Totoro should be 2 now
        Assert.assertEquals(p1.getNumberOfTotorosIHave(), 2);
    }



    @Test public void P1FailsToAddTigerToSettlement(){
        CurrentPlacement = new Coordinate(103,102);
        GameBoard.PlaceTiger(CurrentPlacement, p1);

        //should only have 1 settlement at this point
        Assert.assertEquals(p1.getPlayerSettlements().size(), 1);

        //should be length 6 (5 Meeples and 1 Totoro)
        Assert.assertEquals(p1.getPlayerSettlements().get(0).getLength(), 6);

        //check Map location (103,102) to make sure NO Tiger exists
        Assert.assertFalse(GameBoard.getMap()[103][102].TigerPresent());

        //check Map location (104,100) to make sure a Totoro exists and is owned by P1
        Assert.assertTrue(GameBoard.getMap()[104][100].TotoroPresent());

        //no Meeples should be present at (104,100)
        Assert.assertFalse(GameBoard.getMap()[104][100].MeeplesPresent());

        //no Meeples should be present at (103,102)
        Assert.assertFalse(GameBoard.getMap()[103][102].MeeplesPresent());

        //P1's total Meeples should be 15 now
        Assert.assertEquals(p1.getNumberOfMeeplesIHave(),15);

        //P1's total Totoro should be 2 now
        Assert.assertEquals(p1.getNumberOfTotorosIHave(), 2);

        //P1's total Tiger should still be 2
        Assert.assertEquals(p1.getNumberOfTigersIHave(), 2);
    }


}


