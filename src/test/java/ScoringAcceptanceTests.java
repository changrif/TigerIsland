import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ddmac on 3/29/2017.
 */
public class ScoringAcceptanceTests {
    private static Map GameBoard;
    private static Deck d;
    private static Tile tile1;
    private static Tile tile2;
    private static Tile tile3;
    private static Tile tile4;
    private static Player p1;
    private static Player p2;
    private static Coordinate CurrentPlacement;

    @Given("^a player has placed Meeple\\(s\\)$")
    public void a_player_has_placed_Meeple_s() throws Throwable {
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

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

    }


    @Then("^increment their score by (\\d+) pt per level per Meeple$")
    public void increment_their_score_by_pt_per_level_per_Meeple(int arg1) throws Throwable {
        Assert.assertEquals(p1.getMatchScore(), 1);

        Hex Hex41 = new Hex(Terrain.typesOfTerrain.VOLCANO, 4);
        Hex Hex42 = new Hex(Terrain.typesOfTerrain.JUNGLE, 4);
        Hex Hex43 = new Hex(Terrain.typesOfTerrain.JUNGLE, 4);
        Tile tile5 = new Tile(Hex41, Hex42, Hex43, 4);
        Coordinate tile5Location = new Coordinate(100, 100, 100);

        GameBoard.placeTile(tile5, tile5Location, 3);

        CurrentPlacement = new Coordinate(100,101, 99);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
        Assert.assertEquals(p1.getMatchScore(), 3);
    }

    @Given("^a player placed a Totoro$")
    public void a_player_placed_a_Totoro() throws Throwable {
        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.PlaceTotoro(CurrentPlacement, p1);

    }

    @Then("^increment their score by (\\d+) points$")
    public void increment_their_score_by_points(int arg1) throws Throwable {
        Assert.assertEquals(p1.getMatchScore(),200);
    }

    @Given("^a player placed a Tiger$")
    public void a_player_placed_a_Tiger() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    //Add the Then Statements
}
