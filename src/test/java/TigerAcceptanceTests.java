import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by AizeyPineda on 4/8/17.
 */
public class TigerAcceptanceTests {

    private static Map GameBoard;
    private static Deck d;
    private static Tile tile1;
    private static Tile tile2;
    private static Tile tile3;
    private static Tile tile4;
    private static Player p1;
    private static Player p2;
    private static Coordinate CurrentPlacement;

    @Given("^the Tigers are not initialized$")
    public void the_Tigers_are_not_initialized() throws Throwable {

    }

    @When("^before the game begins _TIGER$")
    public void before_the_game_begins__TIGER() throws Throwable {

    }

    @Then("^(\\d+) Tigers are created for each player$")
    public void tigers_are_created_for_each_player(int arg1) throws Throwable {
        Player p1 = new Player("AIZEY");
        Assert.assertEquals(2, p1.getNumberOfTigersIHave());
    }


    @Given("^a Tiger is being placed$")
    public void a_Tiger_is_being_placed() throws Throwable {
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

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.placeTotoro(CurrentPlacement, p1);
    }

    @When("^a player builds _TIGER$")
    public void a_player_builds__TIGER() throws Throwable {
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

        GameBoard.placeTile(tile5, tile5Location, 3);
        GameBoard.placeTile(tile6, tile6Location, 4);
        GameBoard.placeTile(tile7, tile7Location, 4);

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(101, 99, 100);
        GameBoard.placeTiger(CurrentPlacement, p1);

    }

    @Then("^decrement the number of Tiger from the player’s total$")
    public void decrement_the_number_of_Tiger_from_the_player_s_total() throws Throwable {
        Assert.assertEquals(1, p1.getNumberOfTigersIHave());
    }

    @Given("^a Tiger$")
    public void a_Tiger() throws Throwable {
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

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.placeTotoro(CurrentPlacement, p1);

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

        GameBoard.placeTile(tile5, tile5Location, 3);
        GameBoard.placeTile(tile6, tile6Location, 4);
        GameBoard.placeTile(tile7, tile7Location, 4);

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

    }

    @Then("^it cannot be placed on a hex that is already occupied by a piece$")
    public void it_cannot_be_placed_on_a_hex_that_is_already_occupied_by_a_piece() throws Throwable {
        CurrentPlacement = new Coordinate(101, 100, 99);
        GameBoard.placeTiger(CurrentPlacement, p1);

        Assert.assertEquals(2, p1.getNumberOfTigersIHave());
    }

    @Given("^a player does not have a settlement adjacent to a tile on level (\\d+) with an empty non-volcanic adjacent hex$")
    public void a_player_does_not_have_a_settlement_adjacent_to_a_tile_on_level_with_an_empty_non_volcanic_adjacent_hex(int arg1) throws Throwable {
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

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

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

        GameBoard.placeTile(tile5, tile5Location, 3);
        GameBoard.placeTile(tile6, tile6Location, 4);
        GameBoard.placeTile(tile7, tile7Location, 4);


    }

    @When("^a player tries to place a tiger during the build phase$")
    public void a_player_tries_to_place_a_tiger_during_the_build_phase() throws Throwable {
        CurrentPlacement = new Coordinate(100, 101, 99);
        GameBoard.placeTiger(CurrentPlacement, p1);
    }

    @Then("^they will not be allowed to add a tiger$")
    public void they_will_not_be_allowed_to_add_a_tiger() throws Throwable {
        Assert.assertEquals(2, p1.getNumberOfTigersIHave());
    }

    @Given("^a player does have a settlement adjacent to a tile on level (\\d+) with an empty non-volcanic adjacent hex$")
    public void a_player_does_have_a_settlement_adjacent_to_a_tile_on_level_with_an_empty_non_volcanic_adjacent_hex(int arg1) throws Throwable {
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

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.placeTotoro(CurrentPlacement, p1);

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

        GameBoard.placeTile(tile5, tile5Location, 3);
        GameBoard.placeTile(tile6, tile6Location, 4);
        GameBoard.placeTile(tile7, tile7Location, 4);

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

    }

        @Then("^they can add a Tiger to the empty hex$")
    public void they_can_add_a_Tiger_to_the_empty_hex() throws Throwable {
            CurrentPlacement = new Coordinate(101, 99, 100);
            GameBoard.placeTiger(CurrentPlacement, p1);

            Assert.assertEquals(1, p1.getNumberOfTigersIHave());
    }

    @Given("^a player has a settlement with a Tiger$")
    public void a_player_has_a_settlement_with_a_Tiger() throws Throwable {
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

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.placeTotoro(CurrentPlacement, p1);

        Hex Hex41 = new Hex(Terrain.typesOfTerrain.VOLCANO, 4);
        Hex Hex42 = new Hex(Terrain.typesOfTerrain.JUNGLE, 4);
        Hex Hex43 = new Hex(Terrain.typesOfTerrain.JUNGLE, 4);
        Hex Hex51 = new Hex(Terrain.typesOfTerrain.VOLCANO, 5);
        Hex Hex52 = new Hex(Terrain.typesOfTerrain.JUNGLE, 5);
        Hex Hex53 = new Hex(Terrain.typesOfTerrain.JUNGLE, 5);
        Hex Hex61 = new Hex(Terrain.typesOfTerrain.VOLCANO, 6);
        Hex Hex62 = new Hex(Terrain.typesOfTerrain.LAKE, 6);
        Hex Hex63 = new Hex(Terrain.typesOfTerrain.ROCKY, 6);
        Tile tile5 = new Tile(Hex41, Hex42, Hex43, 4);
        Tile tile6 = new Tile(Hex51, Hex52, Hex53, 5);
        Tile tile7 = new Tile(Hex61, Hex62, Hex63, 6);
        Coordinate tile5Location = new Coordinate(100, 100, 100);
        Coordinate tile6Location = new Coordinate(100, 99, 101);
        Coordinate tile7Location = new Coordinate(100,100, 100);

        GameBoard.placeTile(tile5, tile5Location, 3);
        GameBoard.placeTile(tile6, tile6Location, 4);
        GameBoard.placeTile(tile7, tile7Location, 4);

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(101, 100, 99);
        GameBoard.placeTiger(CurrentPlacement, p1);
    }

    @When("^a player tries to add another Tiger to that settlement$")
    public void a_player_tries_to_add_another_Tiger_to_that_settlement() throws Throwable {
        CurrentPlacement = new Coordinate(101, 99, 100);
        GameBoard.placeTiger(CurrentPlacement, p1);
    }

    @Then("^they are not allowed to place the Tiger$")
    public void they_are_not_allowed_to_place_the_Tiger() throws Throwable {
        Assert.assertEquals(1, p1.getNumberOfTigersIHave());
    }

    @Given("^a terrain that is of type volcano$")
    public void a_terrain_that_is_of_type_volcano() throws Throwable {
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

        GameBoard.placeTile(tile1, tile1Location, 6);
        GameBoard.placeTile(tile2, tile2Location, 4);
        GameBoard.placeTile(tile3, tile3Location, 2);
        GameBoard.placeTile(tile4, tile4Location, 1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.foundNewSettlement(CurrentPlacement, p1);

        CurrentPlacement = new Coordinate(99,100, 101);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

        CurrentPlacement = new Coordinate(99,101, 100);
        GameBoard.placeTotoro(CurrentPlacement, p1);

        Hex Hex41 = new Hex(Terrain.typesOfTerrain.VOLCANO, 4);
        Hex Hex42 = new Hex(Terrain.typesOfTerrain.JUNGLE, 4);
        Hex Hex43 = new Hex(Terrain.typesOfTerrain.JUNGLE, 4);
        Hex Hex51 = new Hex(Terrain.typesOfTerrain.VOLCANO, 5);
        Hex Hex52 = new Hex(Terrain.typesOfTerrain.JUNGLE, 5);
        Hex Hex53 = new Hex(Terrain.typesOfTerrain.JUNGLE, 5);
        Hex Hex61 = new Hex(Terrain.typesOfTerrain.VOLCANO, 6);
        Hex Hex62 = new Hex(Terrain.typesOfTerrain.LAKE, 6);
        Hex Hex63 = new Hex(Terrain.typesOfTerrain.ROCKY, 6);
        Tile tile5 = new Tile(Hex41, Hex42, Hex43, 4);
        Tile tile6 = new Tile(Hex51, Hex52, Hex53, 5);
        Tile tile7 = new Tile(Hex61, Hex62, Hex63, 6);
        Coordinate tile5Location = new Coordinate(100, 100, 100);
        Coordinate tile6Location = new Coordinate(100, 99, 101);
        Coordinate tile7Location = new Coordinate(100,100, 100);

        GameBoard.placeTile(tile5, tile5Location, 3);
        GameBoard.placeTile(tile6, tile6Location, 4);
        GameBoard.placeTile(tile7, tile7Location, 4);

        CurrentPlacement = new Coordinate(99, 101, 100);
        GameBoard.expandSettlement(CurrentPlacement, Terrain.typesOfTerrain.JUNGLE, p1);

    }

    @When("^a Tiger tries to occupy the terrain,$")
    public void a_Tiger_tries_to_occupy_the_terrain() throws Throwable {
        CurrentPlacement = new Coordinate(100, 100, 100);
        GameBoard.placeTiger(CurrentPlacement, p1);
    }

    @Then("^tiger will be prohibited from doing so\\.$")
    public void tiger_will_be_prohibited_from_doing_so() throws Throwable {
        Assert.assertEquals(2, p1.getNumberOfTigersIHave());
    }

}
