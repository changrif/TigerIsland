import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

/**
 * Created by AizeyPineda on 3/23/17.
 */


public class MapAcceptanceTests {
    @Given("^the board is not initialized$")
    public void the_board_is_not_initialized() throws Throwable {

    }

    @When("^the players begin the game$")
    public void the_players_begin_the_game() throws Throwable {

    }

    @Then("^a board data structure should be initialized to empty$")
    public void a_board_data_structure_should_be_initialized_to_empty() throws Throwable {
        Map Gameboard = new Map();
        assertTrue(Gameboard instanceof Map);

        for(int i=0; i < 200; i++) {
            for(int j=0; j<200; j++){
                assertFalse(Gameboard.isTaken(i,j));
            }
        }

    }

    @Then("^a board data structure containing data will produce errors\\.$")
    public void a_board_data_structure_containing_data_will_produce_errors() throws Throwable {
        Map Gameboard = new Map();
        assertTrue(Gameboard instanceof Map);

        for(int i=0; i < 200; i++) {
            for(int j=0; j<200; j++){
                assertTrue(!Gameboard.isTaken(i,j));
            }
        }

    }


}
