import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Kyle on 4/6/2017.
 */
public class SettlementTestsWithTwoPlayers {
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
        Hex Hex12 = new Hex(Terrain.typesOfTerrain.GRASSLANDS, 1);
        Hex Hex13 = new Hex(Terrain.typesOfTerrain.LAKE, 1);
        Hex Hex21 = new Hex(Terrain.typesOfTerrain.VOLCANO, 2);
        Hex Hex22 = new Hex(Terrain.typesOfTerrain.ROCKY, 2);
        Hex Hex23 = new Hex(Terrain.typesOfTerrain.ROCKY, 2);
        Hex Hex31 = new Hex(Terrain.typesOfTerrain.VOLCANO, 3);
        Hex Hex32 = new Hex(Terrain.typesOfTerrain.LAKE, 3);
        Hex Hex33 = new Hex(Terrain.typesOfTerrain.LAKE, 3);


        tile1 = new Tile(Hex01, Hex02, Hex03, 0);
        tile2 = new Tile(Hex11, Hex12, Hex13, 1);
        tile3 = new Tile(Hex21, Hex22, Hex23, 2);
        tile4 = new Tile(Hex31, Hex32, Hex33, 3);

        Coordinate tile1Location = new Coordinate(100, 98, 102);
        Coordinate tile2Location = new Coordinate(100, 102, 98);
        Coordinate tile3Location = new Coordinate(103, 97, 100);


        try {
            GameBoard.placeTile(tile1, tile1Location, 3);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        try {
            GameBoard.placeTile(tile2, tile2Location, 5);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
        try {
            GameBoard.placeTile(tile3, tile3Location, 2);
        } catch (InvalidTilePlacement invalidTilePlacement) {
            invalidTilePlacement.printStackTrace();
        }
//        try {
//            GameBoard.placeTile(tile4, tile4Location, 1);
//        } catch (InvalidTilePlacement invalidTilePlacement) {
//            invalidTilePlacement.printStackTrace();
//        }


        CurrentPlacement = new Coordinate(100, 99, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(101, 99, 100);
        GameBoard.foundNewSettlement(CurrentPlacement, p2);

        CurrentPlacement = new Coordinate(100, 99, 101);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(101, 99, 100);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.ROCKY, p2);

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(101, 100, 99);
        GameBoard.foundNewSettlement(CurrentPlacement, p2);

        CurrentPlacement = new Coordinate(101, 101, 98);
        GameBoard.foundNewSettlement(CurrentPlacement, p2);

        CurrentPlacement = new Coordinate(100, 101, 99);
        GameBoard.PlaceTotoro(CurrentPlacement, p2);

        //check player settlements before the nuking test
        Assert.assertEquals( 1,p1.getPlayerSettlements().size());
        Assert.assertEquals( 4,p1.getPlayerSettlements().get(0).getLength());

        Assert.assertEquals( 1,p2.getPlayerSettlements().size());
        Assert.assertEquals( 6,p2.getPlayerSettlements().get(0).getLength());
        Assert.assertTrue(p2.getPlayerSettlements().get(0).getTotoroFlag());


        //test nuking settlements from both players
        CurrentPlacement = new Coordinate(100,100,100);
        GameBoard.placeTile(tile4, CurrentPlacement, 5);


        Assert.assertEquals( 2,p1.getPlayerSettlements().size());
        Assert.assertEquals( 2,p1.getPlayerSettlements().get(0).getLength());
        Assert.assertEquals( 1,p1.getPlayerSettlements().get(1).getLength());

        Assert.assertEquals( 2,p2.getPlayerSettlements().size());
        Assert.assertEquals( 3,p2.getPlayerSettlements().get(0).getLength());
        Assert.assertEquals( 2,p2.getPlayerSettlements().get(1).getLength());
        Assert.assertTrue(p2.getPlayerSettlements().get(0).getTotoroFlag());

    }
}


