import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ddmac on 3/29/2017.
 */
public class MergingSettlementsAcceptanceTests {
    @Given("^a settlement is added next to an adjacent hex of an existing settlement of the same color$")
    public void a_settlement_is_added_next_to_an_adjacent_hex_of_an_existing_settlement_of_the_same_color() throws Throwable {

    }

    @When("^a player ends their turn$")
    public void a_player_ends_their_turn() throws Throwable {

    }

    @Then("^the settlements will merge into one$")
    public void the_settlements_will_merge_into_one() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();
        Player p1 = new Player("David");
        m.placeFirstTile();
        Coordinate settlement1Location = new Coordinate(101, 100, 99);
        Coordinate settlement2Location = new Coordinate(101, 99, 100);

        Assert.assertEquals(0, p1.getOwnedSettlementsSize());
        Assert.assertEquals(20, p1.getNumberOfMeeplesIHave());

        m.foundNewSettlement(settlement1Location, p1);

        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(19, p1.getNumberOfMeeplesIHave());

        m.foundNewSettlement(settlement2Location, p1);

        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(18, p1.getNumberOfMeeplesIHave());
        Assert.assertEquals(2, m.getMap()[99][100][101].getSettlement().getLength());
    }


    @Given("^a settlement is not added next to an adjacent hex of an existing settlement of the same player$")
    public void a_settlement_is_not_added_next_to_an_adjacent_hex_of_an_existing_settlement_of_the_same_color() throws Throwable {

    }

    @When("^a players turn ends$")
    public void a_players_turn_ends() throws Throwable {

    }

    @Then("^the settlements will not merge into one$")
    public void the_settlements_will_not_merge_into_one() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();
        Player p1 = new Player("David");
        m.placeFirstTile();
        Coordinate settlement1Location = new Coordinate(101, 100, 99);
        Coordinate settlement2Location = new Coordinate(101, 99, 100);
        Coordinate settlement3Location = new Coordinate(99, 100, 101);

        Assert.assertEquals(0, p1.getOwnedSettlementsSize());
        Assert.assertEquals(20, p1.getNumberOfMeeplesIHave());

        m.foundNewSettlement(settlement1Location, p1);

        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(19, p1.getNumberOfMeeplesIHave());

        m.foundNewSettlement(settlement2Location, p1);

        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(18, p1.getNumberOfMeeplesIHave());
        Assert.assertEquals(2, m.getMap()[99][100][101].getSettlement().getLength());

        m.foundNewSettlement(settlement3Location, p1);

        Assert.assertEquals(2, p1.getOwnedSettlementsSize());
        Assert.assertEquals(1, m.getMap()[100][101][99].getSettlement().getLength());
        Assert.assertEquals(17, p1.getNumberOfMeeplesIHave());
    }

    @Given("^a settlement is added next to an adjacent hex of an existing settlement of a different player$")
    public void a_settlement_is_added_next_to_an_adjacent_hex_of_an_existing_settlement_of_a_different_player() throws Throwable {

    }

    @When("^a players finishes their turn$")
    public void a_players_finishes_their_turn() throws Throwable {

    }

    @Then("^the settlements will not be merged$")
    public void the_settlements_will_not__be_merged() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();
        d.generateTiles();
        Tile t = d.draw();
        Player p1 = new Player("David");
        Player p2 = new Player("Daniel");

        Coordinate c = new Coordinate(100, 101, 99);

        m.placeFirstTile();
        m.placeTile(t, c, 3);

        Coordinate settlement1Location = new Coordinate(101, 100, 99);
        Coordinate settlement2Location = new Coordinate(101, 99, 100);
        Coordinate settlement3Location = new Coordinate(101, 101, 98);

        Assert.assertEquals(0, p1.getOwnedSettlementsSize());
        Assert.assertEquals(20, p1.getNumberOfMeeplesIHave());

        m.foundNewSettlement(settlement1Location, p1);

        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(19, p1.getNumberOfMeeplesIHave());

        m.foundNewSettlement(settlement2Location, p1);

        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(18, p1.getNumberOfMeeplesIHave());
        Assert.assertEquals(2, m.getMap()[99][100][101].getSettlement().getLength());

        m.foundNewSettlement(settlement3Location, p2);

        Assert.assertEquals(1, p2.getOwnedSettlementsSize());
        Assert.assertEquals(1, m.getMap()[101][98][101].getSettlement().getLength());
        Assert.assertEquals(19, p2.getNumberOfMeeplesIHave());

        //Settlement length of first player should be the same as before...and it is so it works
        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(18, p1.getNumberOfMeeplesIHave());
        Assert.assertEquals(2, m.getMap()[99][100][101].getSettlement().getLength());
    }

}
