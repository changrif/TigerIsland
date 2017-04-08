import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ddmac on 3/29/2017.
 */
public class ExpandingASettlementAcceptanceTests {

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

    @Given("^there is an adjacent non-volcanic hex to a player’s existing settlement$")
    public void there_is_an_adjacent_non_volcanic_hex_to_a_player_s_existing_settlement() throws Throwable {
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
        Coordinate tile3Location = new Coordinate(102, 97, 101);
        Coordinate tile4Location = new Coordinate(101, 101, 98);

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
    }

    @When("^they expand$")
    public void they_expand() throws Throwable {
        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

    }

    @Then("^they must be able to occupy all contiguous hexes of the chosen terrain$")
    public void they_must_be_able_to_occupy_all_contiguous_hexes_of_the_chosen_terrain() throws Throwable {
        for (int i = 0; i < p1.getPlayerSettlements().get(0).getLength(); i++) {
            String terrain = p1.getPlayerSettlements().get(0).getSettlementHexes().get(i).getTerrainType().toString();
            Assert.assertEquals(terrain, "JUNGLE");
        }
    }

    @Given("^a player that has a certain amount of meeples$")
    public void a_player_that_has_a_certain_amount_of_meeples() throws Throwable {
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
        Coordinate tile3Location = new Coordinate(102, 97, 101);
        Coordinate tile4Location = new Coordinate(101, 101, 98);

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);
    }

    @When("^he/she attempts to expand to a terrain$")
    public void he_she_attempts_to_expand_to_a_terrain() throws Throwable {
        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);
    }

    @Then("^they must have the necessary amount of meeples to expand$")
    public void they_must_have_the_necessary_amount_of_meeples_to_expand() throws Throwable {
        Assert.assertTrue(p1.getNumberOfMeeplesIHave() >= 0);
    }

    @Given("^a player that has a certain amount of totoros$")
    public void a_player_that_has_a_certain_amount_of_totoros() throws Throwable {
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
        Coordinate tile3Location = new Coordinate(102, 97, 101);
        Coordinate tile4Location = new Coordinate(101, 101, 98);

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);


    }

    @When("^he/she attempts to expand to a terrain adjacent to a settlement of length (\\d+)\\+$")
    public void he_she_attempts_to_expand_to_a_terrain_adjacent_to_a_settlement_of_length(int arg1) throws Throwable {
        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);
    }

    @Then("^they must have the necessary amount of totoros to expand$")
    public void they_must_have_the_necessary_amount_of_totoros_to_expand() throws Throwable {
        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.placeTotoro(CurrentPlacement, p1);
        Assert.assertEquals(p1.getNumberOfTotorosIHave(), 2);
    }

    @Given("^a player has enough Meeples left$")
    public void a_player_has_enough_Meeples_left() throws Throwable {
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
        Coordinate tile3Location = new Coordinate(102, 97, 101);
        Coordinate tile4Location = new Coordinate(101, 101, 98);

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

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

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.placeTotoro(CurrentPlacement, p1);

        GameBoard.placeTile(tile5, tile5Location, 3);
        GameBoard.placeTile(tile6, tile6Location, 4);
        GameBoard.placeTile(tile7, tile7Location, 4);

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);
    }

    @Then("^the must place (\\d+) Meeple per level on each hex$")
    public void the_must_place_Meeple_per_level_on_each_hex(int arg1) throws Throwable {
        Assert.assertEquals(7, p1.getNumberOfMeeplesIHave());
    }

    @Given("^a non-adjacent terrain$")
    public void a_non_adjacent_terrain() throws Throwable {
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
        Coordinate tile3Location = new Coordinate(102, 97, 101);
        Coordinate tile4Location = new Coordinate(101, 101, 98);

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

    }

    @When("^a meeple tries to expand to the terrain$")
    public void a_meeple_tries_to_expand_to_the_terrain() throws Throwable {

    }

    @Then("^it will be prohibited from doing so$")
    public void it_will_be_prohibited_from_doing_so() throws Throwable {
        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.ROCKY, p1);
        Assert.assertEquals(19, p1.getNumberOfMeeplesIHave());
    }

    @Given("^a successful expansion of a settlement$")
    public void a_successful_expansion_of_a_settlement() throws Throwable {
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
        Coordinate tile3Location = new Coordinate(102, 97, 101);
        Coordinate tile4Location = new Coordinate(101, 101, 98);

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99, 100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

    }

    @When("^a player’s turn has ended$")
    public void a_player_s_turn_has_ended() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the settlement size will increase by the number of added territories$")
    public void the_settlement_size_will_increase_by_the_number_of_added_territories() throws Throwable {
        Assert.assertEquals(6, p1.getPlayerSettlements().get(0).getLength());
    }
}
