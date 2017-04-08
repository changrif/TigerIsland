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

        /*Map m = new Map();
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

        BuildOption.typesOfBuildOptions buildAction = pB.getBuildAction();
        System.out.println("Here");
        System.out.println("Here");
        System.out.println(buildAction);
        if( buildAction == BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND || buildAction == BuildOption.typesOfBuildOptions.EXPANSION || buildAction == BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT){
            buildOptionAvailable = true;
        }   else {
            buildOptionAvailable = false;
        }
        System.out.println("DONE");
        Assert.assertTrue(buildOptionAvailable);*/
    }






    @Given("^a new settlement is added or expanded$")
    public void a_new_settlement_is_added_or_expanded() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^a player ends their build phase$")
    public void a_player_ends_their_build_phase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the turn ends, settlements are merged \\(if necessary\\)$")
    public void the_turn_ends_settlements_are_merged_if_necessary() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^A player$")
    public void a_player() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^a player made an illegal move$")
    public void a_player_made_an_illegal_move() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the first player is about to play$")
    public void the_first_player_is_about_to_play() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the first player will have its turn$")
    public void the_first_player_will_have_its_turn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the second player will have its turn after the first player completes their turn$")
    public void the_second_player_will_have_its_turn_after_the_first_player_completes_their_turn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a player (\\d+) and a player (\\d+)$")
    public void a_player_and_a_player(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^player (\\d+) has finished his/her turn$")
    public void player_has_finished_his_her_turn(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^it becomes player (\\d+)’s turn$")
    public void it_becomes_player_s_turn(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
