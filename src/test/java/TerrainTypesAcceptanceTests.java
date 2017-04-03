import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ddmac on 3/29/2017.
 */
public class TerrainTypesAcceptanceTests {

    @Given("^a type of terrain,$")
    public void a_type_of_terrain() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the tile has been placed,$")
    public void the_tile_has_been_placed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^it cannot be compared with non-adjacent terrains\\.$")
    public void it_cannot_be_compared_with_non_adjacent_terrains() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^it can be compared with all adjacent terrains\\.$")
    public void it_can_be_compared_with_all_adjacent_terrains() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a tile that has been created,$")
    public void a_tilePiece() throws Throwable {

    }

    @When("^the tile is placed on the board,$")
    public void the_tile_is_placed_on_the_board() throws Throwable {

    }

    @Then("^it must contain exactly one volcano terrain\\.$")
    public void it_must_contain_one_and_only_one_volcano_terrain() throws Throwable {
        Deck d = new Deck();
        d.generateTiles();
        Tile t;
        int volcanoCount = 0;
        for(int i = 0; i < 47; i++){
            t = d.draw();
            Assert.assertEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex1().getTerrainType());
            Assert.assertNotEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex2().getTerrainType());
            Assert.assertNotEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex3().getTerrainType());

            if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType()){
                volcanoCount++;
            }
        }
        Assert.assertEquals(47, volcanoCount);
    }
}
