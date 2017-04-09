import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by AizeyPineda on 4/9/17.
 */
public class BuildOptionAcceptanceTests {
    Player player1 = new Player("Aizey");
    BuildOption buildOption = new BuildOption();
    String[]    buildOptionStrings = {"FOUND SETTLEMENT AT", "EXPAND SETTLEMENT AT", "BUILD TOTORO SANCTUARY AT", "BUILD TIGER PLAYGROUND AT", "UNABLE TO BUILD" };

    @Given("^It is a players turn$")
    public void it_is_a_players_turn() throws Throwable {

    }

    @When("^a player chooses a build option$")
    public void a_player_chooses_a_build_option() throws Throwable {
    }

    @Then("^the correct build option will be chosen$")
    public void the_correct_build_option_will_be_chosen() throws Throwable {
        for(int i = 0; i < buildOptionStrings.length; i++) {
            Assert.assertEquals(buildOption.getTypeOfBuildOption(buildOptionStrings[0]), BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT);
            Assert.assertEquals(buildOption.getTypeOfBuildOption(buildOptionStrings[1]), BuildOption.typesOfBuildOptions.EXPANSION);
            Assert.assertEquals(buildOption.getTypeOfBuildOption(buildOptionStrings[2]), BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY);
            Assert.assertEquals(buildOption.getTypeOfBuildOption(buildOptionStrings[3]), BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND);
            Assert.assertEquals(buildOption.getTypeOfBuildOption(buildOptionStrings[4]), BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD);
        }
    }
}
