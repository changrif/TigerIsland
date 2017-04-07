import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by AizeyPineda on 4/6/17.
 */
public class ScoringTests {

    private static Map GameBoard;
    private static Deck d;
    private static Tile tile1;
    private static Tile tile2;
    private static Tile tile3;
    private static Tile tile4;
    private static Player p1;
    private static Player p2;
    private static Coordinate CurrentPlacement;

    @Before
    public void createBoardWithFirstLevel()    {
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        d = new Deck();
        d.generateTiles();
        p1 = new Player("Kyle");
        p2 = new Player("Dave");

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
        tile1 = new Tile(Hex01, Hex02, Hex03, 0);
        tile2 = new Tile(Hex11, Hex12, Hex13, 1);
        tile3 = new Tile(Hex21, Hex22, Hex23, 2);
        tile4 = new Tile(Hex31, Hex32, Hex33, 3);
        Coordinate tile1Location = new Coordinate(100, 99, 101);
        Coordinate tile2Location = new Coordinate(97, 101, 102);
        Coordinate tile3Location = new Coordinate(102,97, 101);
        Coordinate tile4Location = new Coordinate(101, 101, 98);

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

    }

    @Test
    public void playerScoreAfterFoundingSettlement() {
        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
        Assert.assertEquals(p1.getMatchScore(), 1);
    }


    @Test
    public void playerScoreAfterExpandingSettlement() {
        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);


        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);
        Assert.assertEquals(p1.getMatchScore(), 6);
    }

    @Test
    public void playerScoreAfterPlacingTotoro() {
        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);


        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.PlaceTotoro(CurrentPlacement, p1);
        Assert.assertEquals(p1.getMatchScore(), 206);

    }

    @Test
    public void playerScoreAfterPlacingTiger() {
        Hex Hex41 = new Hex(Terrain.typesOfTerrain.VOLCANO, 4);
        Hex Hex42 = new Hex(Terrain.typesOfTerrain.JUNGLE, 4);
        Hex Hex43 = new Hex(Terrain.typesOfTerrain.JUNGLE, 4);
        Hex Hex51 = new Hex(Terrain.typesOfTerrain.VOLCANO, 5);
        Hex Hex52 = new Hex(Terrain.typesOfTerrain.JUNGLE, 5);
        Hex Hex53 = new Hex(Terrain.typesOfTerrain.JUNGLE, 5);
        Hex Hex61 = new Hex(Terrain.typesOfTerrain.VOLCANO, 6);
        Hex Hex62 = new Hex(Terrain.typesOfTerrain.JUNGLE, 6);
        Hex Hex63 = new Hex(Terrain.typesOfTerrain.ROCKY, 6);
        Tile tile5 = new Tile(Hex41, Hex42, Hex43, 4);
        Tile tile6 = new Tile(Hex51, Hex52, Hex53, 5);
        Tile tile7 = new Tile(Hex61, Hex62, Hex63, 6);
        Coordinate tile5Location = new Coordinate(100, 100, 100);
        Coordinate tile6Location = new Coordinate(100, 99, 101);
        Coordinate tile7Location = new Coordinate(100,100, 100);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
        Assert.assertEquals(1, p1.getPlayerSettlements().get(0).getLength());
        Assert.assertEquals(1, p1.getOwnedSettlementsSize());

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);
        Assert.assertEquals(6, p1.getPlayerSettlements().get(0).getLength());
        Assert.assertEquals(1, p1.getOwnedSettlementsSize());

//        CurrentPlacement = new Coordinate(102,98,100);
//        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.PlaceTotoro(CurrentPlacement, p1);
        Assert.assertFalse(p1.getPlayerSettlements().get(0).getTigerFlag());
        Assert.assertTrue(p1.getPlayerSettlements().get(0).getTotoroFlag());
        Assert.assertEquals(7, p1.getPlayerSettlements().get(0).getLength());
        Assert.assertEquals(1, p1.getOwnedSettlementsSize());

        GameBoard.placeTile(tile5, tile5Location, 3);
        Assert.assertEquals(7, p1.getPlayerSettlements().get(0).getLength());
        Assert.assertEquals(1, p1.getOwnedSettlementsSize());

        GameBoard.placeTile(tile6, tile6Location, 4);
        Assert.assertEquals(6, p1.getPlayerSettlements().get(0).getLength());
        Assert.assertEquals(1, p1.getOwnedSettlementsSize());

        GameBoard.placeTile(tile7, tile7Location, 4);
        Assert.assertEquals(6, p1.getPlayerSettlements().get(0).getLength());
        Assert.assertEquals(1, p1.getPlayerSettlements().size());

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.ExpandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);
        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(9, p1.getPlayerSettlements().get(0).getLength());

        CurrentPlacement = new Coordinate(101, 99, 100);
        GameBoard.PlaceTiger(CurrentPlacement, p1);
        Assert.assertEquals(p1.getMatchScore(), 288);
        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(10, p1.getPlayerSettlements().get(0).getLength());
        Assert.assertTrue(p1.getPlayerSettlements().get(0).getTigerFlag());
        Assert.assertTrue(p1.getPlayerSettlements().get(0).getTotoroFlag());
//
//        ArrayList<Hex> FinalSettlement = p1.getPlayerSettlements().get(1).getSettlementHexes();
//        for (int i = 0; i < FinalSettlement.size(); i++){
//            System.out.println(FinalSettlement.get(i).getCoordinate().getX() + "," + FinalSettlement.get(i).getCoordinate().getY() + "," + FinalSettlement.get(i).getCoordinate().getZ());
//        }
    }
}