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
        Player p1 = new Player("Aizey");
        m.placeFirstTile();
        Coordinate settlement1Location = new Coordinate(101, 100, 99);

        Assert.assertEquals(0, p1.getOwnedSettlementsSize());
        Assert.assertEquals(20, p1.getNumberOfMeeplesIHave());

        m.foundNewSettlement(settlement1Location, p1);

        Assert.assertEquals(1, p1.getOwnedSettlementsSize());
        Assert.assertEquals(19, p1.getNumberOfMeeplesIHave());

//        Coordinate c = new Coordinate(100, 100, 100);
//        d.generateTiles();
//        Tile t = d.draw();
//        Coordinate c2 = new Coordinate(99, 101, 100);

        /* don't be mad and don't delete
        Player p = new Player("David");

        Assert.assertEquals(0, p.getOwnedSettlementsSize());
        Assert.assertEquals(20, p.getNumberOfMeeplesIHave());

        m.foundNewSettlement(c2, p);

        Assert.assertEquals(1, p.getOwnedSettlementsSize());
        Assert.assertEquals(19, p.getNumberOfMeeplesIHave());*/
        //m.placeTile(t, c, 1);
    }

    @Given("^there is an empty volcanic level one hex$")
    public void there_is_an_empty_volcanic_level_one_hex() throws Throwable {

    }
    @When("^a player can build$")
    public void a_player_can_build() throws Throwable{

    }

    @Then("^a meeple cannot be placed on that hex to form a new settlement$")
    public void they_cannot_add_a_Meeple_to_that_hex_to_form_a_new_settlement() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();
        Player p1 = new Player("Aizey");
        m.placeFirstTile();
        Coordinate settlement1Location = new Coordinate(100, 100, 100);

        Assert.assertEquals(0, p1.getOwnedSettlementsSize());
        Assert.assertEquals(20, p1.getNumberOfMeeplesIHave());

        try {
            m.foundNewSettlement(settlement1Location, p1);

            Assert.assertEquals(0, p1.getOwnedSettlementsSize());
            Assert.assertEquals(20, p1.getNumberOfMeeplesIHave());
        }
        catch(InvalidTilePlacement i){
            System.out.println("That is a volcano!");
        }
    }

}
