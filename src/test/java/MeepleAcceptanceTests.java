import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.input.TeeInputStream;
import org.junit.Assert;

/**
 * Created by ddmac on 3/29/2017.
 */
public class MeepleAcceptanceTests {

    @Given("^the Meeples are not initialized$")
    public void the_Meeples_are_not_initialized() throws Throwable {

    }

    @When("^before the game begins$")
    public void before_the_game_begins() throws Throwable {

    }

    @Then("^(\\d+) Meeples are created for each player$")
    public void meeples_are_created_for_each_player(int playersCurrentNumberOfMeeples) throws Throwable {
        Player p1 = new Player("David");
        Assert.assertEquals(playersCurrentNumberOfMeeples, p1.getNumberOfMeeplesIHave());
    }



    @Given("^a meeple$")
    public void a_meeple() throws Throwable {

    }

    @Then("^it can be placed on a habitable terrain$")
    public void it_can_be_placed_on_a_habitable_terrain() throws Throwable {
        Deck d = new Deck();
        Map m = new Map();
        d.generateTiles();
        Tile t = d.draw();

        Coordinate c = new Coordinate(100,99,101);

        Coordinate settlement1Coords = new Coordinate(99, 99,102);

        m.placeTile(t, c, 6);

        Player p = new Player("David");

        Assert.assertEquals(0, p.getOwnedSettlementsSize());

        m.foundNewSettlement(settlement1Coords, p);

        Assert.assertEquals(1, p.getOwnedSettlementsSize());
        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());

    }

    @Then("^it cannot be placed on a volcano terrain$")
    public void it_cannot_be_placed_on_a_volcano_terrain() throws Throwable {

        Deck d = new Deck();
        Map m = new Map();
        d.generateTiles();
        Tile t = d.draw();

        Coordinate c = new Coordinate(100,99,101);
        m.placeTile(t, c, 6);

        Player p = new Player("David");

        Assert.assertEquals(0, p.getOwnedSettlementsSize());

        Assert.assertEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex1().getTerrainType());

        m.foundNewSettlement(c, p);

        Assert.assertEquals(0, p.getOwnedSettlementsSize());
        Assert.assertEquals(20, p.getNumberOfMeeplesIHave());

    }

    @Given("^a Meeple is being placed$")
    public void a_Meeple_is_being_placed() throws Throwable {

    }

    @When("^a player builds$")
    public void a_player_builds() throws Throwable {

    }

    @Then("^decrement the number of Meeples from the player’s total$")
    public void decrement_the_number_of_Meeples_from_the_player_s_total() throws Throwable {

        Deck d = new Deck();
        Map m = new Map();
        d.generateTiles();
        Tile t = d.draw();

        Coordinate c = new Coordinate(100,99,101);

        Coordinate settlement1Coords = new Coordinate(99,99,102);

        m.placeTile(t, c, 6);

        Player p = new Player("David");

        m.foundNewSettlement(settlement1Coords, p);

        Assert.assertEquals(1, p.getOwnedSettlementsSize());
        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());
    }

    @Then("^it cannot be placed on a hex that is already occupied by meeples$")
    public void it_cannot_be_placed_on_a_hex_that_is_already_occupied_by_meeples() throws Throwable {
        Deck d = new Deck();
        Map m = new Map();
        d.generateTiles();
        Tile t = d.draw();

        Coordinate c = new Coordinate(100,99,101);

        Coordinate settlement1Coords = new Coordinate(99,99,102);

        m.placeTile(t, c, 6);

        Player p = new Player("David");

        m.foundNewSettlement(settlement1Coords, p);

        Assert.assertEquals(1, p.getOwnedSettlementsSize());
        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());

        m.foundNewSettlement(settlement1Coords, p);

        Assert.assertEquals(1, p.getOwnedSettlementsSize());
        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());
    }






    @Given("^a terrain that is of type volcano,$")
    public void a_terrain_that_is_of_type_volcano() throws Throwable {

    }

    @When("^a meeple tries to occupy the terrain,$")
    public void a_meeple_tries_to_occupy_the_terrain() throws Throwable {

    }

    @Then("^it will be prohibited from doing so\\.$")
    public void it_will_be_prohibited_from_doing_so() throws Throwable {
        Deck d = new Deck();
        Map m = new Map();
        d.generateTiles();
        Tile t = d.draw();

        Coordinate c = new Coordinate(100,99,101);
        m.placeFirstTile();
        m.placeTile(t, c, 6);

        Player p = new Player("David");

        Assert.assertEquals(0, p.getOwnedSettlementsSize());

        Assert.assertEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex1().getTerrainType());

        m.foundNewSettlement(c, p);

        Assert.assertEquals(0, p.getOwnedSettlementsSize());
        Assert.assertEquals(20, p.getNumberOfMeeplesIHave());
    }
}
