import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ddmac on 3/29/2017.
 */
public class PlayerTurnsAcceptanceTests {

    @Given("^the start of a game$")
    public void the_start_of_a_game() throws Throwable {
    }

    @When("^two people want to play a game$")
    public void two_people_want_to_play_a_game() throws Throwable {
    }

    @Then("^they should be able to have the role of a player to enter the game$")
    public void they_should_be_able_to_have_the_role_of_a_player_to_enter_the_game() throws Throwable {
        Player p1 = new Player("David");
        Assert.assertEquals(p1.getPlayerName(), "David");
    }



    @Given("^there are still tiles available$")
    public void there_are_still_tiles_available() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^a player draws a tile$")
    public void a_player_draws_a_tile() throws Throwable {
    }

    @Then("^the player must place the tile in a valid spot before executing a build action$")
    public void the_player_must_place_the_tile_in_a_valid_spot_before_executing_a_build_action() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();
        d.generateTiles();
        Tile t = d.draw();

        m.placeFirstTile();

        Coordinate cHex1 = new Coordinate(101, 101, 98);
        Coordinate cHex2 = new Coordinate(100, 101, 99);
        Coordinate cHex3 = new Coordinate(100, 102, 98);

        t.getHex1().setCoordinate(cHex1);
        t.getHex1().getCoordinate().coordinateToString();
        t.getHex2().setCoordinate(cHex2);
        t.getHex2().getCoordinate().coordinateToString();
        t.getHex3().setCoordinate(cHex3);
        t.getHex3().getCoordinate().coordinateToString();
        t.setTileOrientation(6);

        m.placeTile(t, cHex1, 1);
        Assert.assertTrue(m.isTaken(new Coordinate(101, 101, 98)));
    }

    @Given("^has build actions available$")
    public void has_build_actions_available() throws Throwable {
    }

    @When("^a player has just placed a tile$")
    public void a_player_has_just_placed_a_tile() throws Throwable {
    }

    @Then("^the player must complete the build action before ending their turn$")
    public void the_player_must_complete_the_build_action_before_ending_their_turn() throws Throwable {

        Map m = new Map();
        Deck d = new Deck();
        d.generateTiles();
        Tile t1 = d.draw();
        Tile t2 = d.draw();
        Tile t3 = d.draw();
        m.placeFirstTile();

        Coordinate c1 = new Coordinate(100, 99, 101);
        Coordinate c2 = new Coordinate(102, 97, 101);
        Coordinate c3 = new Coordinate(101, 101, 98);

        m.placeTile(t1, c1, 6);
        m.placeTile(t2, c2, 2);
        m.placeTile(t3, c3, 2);

        Player us = new Player("us");
        Player opponent = new Player("opponent");

        PlayerBrain pB = new PlayerBrain(us, opponent, m);

        boolean buildOptionAvailable;
        System.out.println("Here");

        pB.getBestBuildAction();

        if( pB.getBuildAction() == BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND || pB.getBuildAction() == BuildOption.typesOfBuildOptions.EXPANSION || pB.getBuildAction() == BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT){
            buildOptionAvailable = true;
        }   else {
            buildOptionAvailable = false;
        }
        System.out.println("DONE");
        Assert.assertTrue(buildOptionAvailable);
    }

    @Given("^a new settlement is added or expanded$")
    public void a_new_settlement_is_added_or_expanded() throws Throwable {
    }

    @When("^a player ends their build phase$")
    public void a_player_ends_their_build_phase() throws Throwable {
    }

    @Then("^the turn ends, settlements are merged \\(if necessary\\)$")
    public void the_turn_ends_settlements_are_merged_if_necessary() throws Throwable {
        //TEST DOES NOT PASS
        Map m = new Map();
        Deck d = new Deck();
        d.generateTiles();

        Hex Hex01 = new Hex(Terrain.typesOfTerrain.VOLCANO, 0);
        Hex Hex02 = new Hex(Terrain.typesOfTerrain.JUNGLE, 0);
        Hex Hex03 = new Hex(Terrain.typesOfTerrain.JUNGLE, 0);
        Hex Hex11 = new Hex(Terrain.typesOfTerrain.VOLCANO, 1);
        Hex Hex12 = new Hex(Terrain.typesOfTerrain.JUNGLE, 1);
        Hex Hex13 = new Hex(Terrain.typesOfTerrain.ROCKY, 1);
        Hex Hex21 = new Hex(Terrain.typesOfTerrain.VOLCANO, 2);
        Hex Hex22 = new Hex(Terrain.typesOfTerrain.LAKE, 2);
        Hex Hex23 = new Hex(Terrain.typesOfTerrain.LAKE, 2);

        Tile t1 = new Tile(Hex01, Hex02, Hex03, 0);
        Tile t2 = new Tile(Hex11, Hex12, Hex13, 1);
        Tile t3 = new Tile(Hex21, Hex22, Hex23, 2);

        Coordinate tile1Location = new Coordinate(100, 99, 101);
        Coordinate tile2Location = new Coordinate(102, 97, 101);
        Coordinate tile3Location = new Coordinate(101, 101, 98);

        m.placeFirstTile();

        Coordinate c1 = new Coordinate(100, 99, 101);
        Coordinate c2 = new Coordinate(102, 97, 101);
        Coordinate c3 = new Coordinate(101, 101, 98);

        m.placeTile(t1, c1, 6);
        m.placeTile(t2, c2, 2);
        m.placeTile(t3, c3, 2);

        Player p1 = new Player("David");

        m.foundNewSettlement(new Coordinate(100, 98, 102), p1);
        m.expandSettlement(new Coordinate(100, 98, 102), Terrain.typesOfTerrain.JUNGLE, p1);
        m.foundNewSettlement(new Coordinate(102, 98, 100), p1);
        m.expandSettlement(new Coordinate(102, 98, 100), Terrain.typesOfTerrain.ROCKY, p1);

        Assert.assertEquals(1, p1.getOwnedSettlementsSize());

    }
}