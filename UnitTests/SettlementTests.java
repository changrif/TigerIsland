import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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
    private static Tile tile5;
    private static Player p1;
    private static Player p2;
    private static Coordinate CurrentPlacement;


    @BeforeClass
    public static void createBoardWithFirstTile()    {
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        d = new Deck();
        d.generateTiles();
        p1 = new Player("Kyle");
        p2 = new Player("Dave");
    }

    @Test
    public void P1foundsNewSettlement() {
        Hex Hex01 = new Hex(Terrain.typesOfTerrain.VOLCANO, 0);
        Hex Hex02 = new Hex(Terrain.typesOfTerrain.JUNGLE, 0);
        Hex Hex03 = new Hex(Terrain.typesOfTerrain.JUNGLE, 0);
        Hex Hex11 = new Hex(Terrain.typesOfTerrain.VOLCANO, 1);
        Hex Hex12 = new Hex(Terrain.typesOfTerrain.JUNGLE, 1);
        Hex Hex13 = new Hex(Terrain.typesOfTerrain.JUNGLE, 1);
        Hex Hex21 = new Hex(Terrain.typesOfTerrain.VOLCANO, 2);
        Hex Hex22 = new Hex(Terrain.typesOfTerrain.JUNGLE, 2);
        Hex Hex23 = new Hex(Terrain.typesOfTerrain.ROCKY, 2);
        Hex Hex31 = new Hex(Terrain.typesOfTerrain.VOLCANO, 3);
        Hex Hex32 = new Hex(Terrain.typesOfTerrain.LAKE, 3);
        Hex Hex33 = new Hex(Terrain.typesOfTerrain.LAKE, 3);
        Hex Hex41 = new Hex(Terrain.typesOfTerrain.VOLCANO, 4);
        Hex Hex42 = new Hex(Terrain.typesOfTerrain.ROCKY, 4);
        Hex Hex43 = new Hex(Terrain.typesOfTerrain.ROCKY, 4);

        tile1 = new Tile(Hex01, Hex02, Hex03, 0);
        tile2 = new Tile(Hex11, Hex12, Hex13, 1);
        tile3 = new Tile(Hex21, Hex22, Hex23, 2);
        tile4 = new Tile(Hex31, Hex32, Hex33, 3);
        tile5 = new Tile(Hex41, Hex42, Hex43, 4);
        Coordinate tile1Location = new Coordinate(100, 99, 101);
        Coordinate tile2Location = new Coordinate(97, 101, 102);
        Coordinate tile3Location = new Coordinate(102, 97, 101);
        Coordinate tile4Location = new Coordinate(101, 101, 98);
        Coordinate tile5Location = new Coordinate(100, 99, 101);

        try {
            GameBoard.placeTile(tile1, tile1Location, 6);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        try {
            GameBoard.placeTile(tile2, tile2Location, 4);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        try {
            GameBoard.placeTile(tile3, tile3Location, 2);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        try {
            GameBoard.placeTile(tile4, tile4Location, 1);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }

        Assert.assertEquals(p1.getPlayerSettlements().size(), 0);

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
        Assert.assertEquals(p1.getPlayerSettlements().size(), 1);

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);
        Assert.assertEquals(p1.getPlayerSettlements().size(), 1);

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.PlaceTotoro(CurrentPlacement, p1);
        Assert.assertEquals(p1.getPlayerSettlements().size(), 1);
        Assert.assertEquals(p1.getPlayerSettlements().get(0).getLength(), 7);


        CurrentPlacement = new Coordinate(100, 102, 98);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
        Assert.assertEquals(p1.getPlayerSettlements().size(), 2);
        Assert.assertEquals(p1.getPlayerSettlements().get(0).getLength(), 7);
        Assert.assertEquals(p1.getPlayerSettlements().get(1).getLength(), 1);


//        CurrentPlacement = new Coordinate(100,101,99);
//        GameBoard.foundNewSettlement(CurrentPlacement, p1);
        CurrentPlacement = new Coordinate(100, 102, 98);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.LAKE, p1);
        Assert.assertEquals(p1.getPlayerSettlements().size(), 1);
        Assert.assertEquals(p1.getPlayerSettlements().get(0).getLength(), 9);
        Assert.assertTrue(p1.getPlayerSettlements().get(0).getTotoroFlag());

        Coordinate NukingLocation = new Coordinate(100, 99, 101);
        GameBoard.placeTile(tile5, NukingLocation, 1);
        Assert.assertEquals(p1.getOwnedSettlementsSize(), 2);

        Assert.assertTrue(p1.getPlayerSettlements().get(0).getTotoroFlag());
        Assert.assertFalse(p1.getPlayerSettlements().get(1).getTotoroFlag());
    }
}




