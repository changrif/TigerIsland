/**
 * Created by ddmac on 3/29/2017.
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class FoundingANewSettlementAcceptanceTests {


    @Given("^there is an empty non-volcanic level one hex$")
    public void there_is_an_empty_non_volcanic_level_one_hex() throws Throwable {

    }
    @When("^a player has the option to build$")
    public void a_player_has_the_option_to_build() throws Throwable{

    }

    @Then("^a meeple can be placed on that hex to form a new settlement$")
    public void they_can_add_a_Meeple_to_that_hex_to_form_a_new_settlement() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();

        Coordinate c = new Coordinate(100, 100, 100);
        d.generateTiles();
        Tile t = d.draw();
        Coordinate c2 = new Coordinate(99, 101, 100);

        m.placeTile(t, c, 1);
        /* don't be mad and don't delete
        Player p = new Player("David");

        Assert.assertEquals(0, p.getOwnedSettlementsSize());
        Assert.assertEquals(20, p.getNumberOfMeeplesIHave());

        m.foundNewSettlement(c2, p);

        Assert.assertEquals(1, p.getOwnedSettlementsSize());
        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());*/
    }

}
