import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ddmac on 3/29/2017.
 */
public class HexAcceptanceTests {


    @Given("^a hex has been created$")
    public void a_hex_has__been_created() throws Throwable {

    }

    @When("^a tile has just been created$")
    public void a_tile_has_been_created() throws Throwable {

    }

    @Then("^it must have one, and only one of the five terrain types$")
    public void it_must_have_one_and_only_one_of_the_five_terrain_types() throws Throwable {
        Deck d = new Deck();
        d.generateTiles();
        Tile t = d.draw();

        int terrainCounterHex1 = 0;

        if (t.getHex1().getTerrainType() == Terrain.typesOfTerrain.GRASSLANDS) {
            terrainCounterHex1++;
        }
        if (t.getHex1().getTerrainType() == Terrain.typesOfTerrain.VOLCANO) {
            terrainCounterHex1++;
        }
        if (t.getHex1().getTerrainType() == Terrain.typesOfTerrain.ROCKY) {
            terrainCounterHex1++;
        }
        if (t.getHex1().getTerrainType() == Terrain.typesOfTerrain.JUNGLE) {
            terrainCounterHex1++;
        }

        Assert.assertEquals(1, terrainCounterHex1);

        int terrainCounterHex2 = 0;

        if (t.getHex2().getTerrainType() == Terrain.typesOfTerrain.GRASSLANDS) {
            terrainCounterHex2++;
        }
        if (t.getHex2().getTerrainType() == Terrain.typesOfTerrain.VOLCANO) {
            terrainCounterHex2++;
        }
        if (t.getHex2().getTerrainType() == Terrain.typesOfTerrain.ROCKY) {
            terrainCounterHex2++;
        }
        if (t.getHex2().getTerrainType() == Terrain.typesOfTerrain.JUNGLE) {
            terrainCounterHex2++;
        }

        Assert.assertEquals(1, terrainCounterHex2);


        int terrainCounterHex3 = 0;

        if (t.getHex3().getTerrainType() == Terrain.typesOfTerrain.GRASSLANDS) {
            terrainCounterHex3++;
        }
        if (t.getHex3().getTerrainType() == Terrain.typesOfTerrain.VOLCANO) {
            terrainCounterHex3++;
        }
        if (t.getHex3().getTerrainType() == Terrain.typesOfTerrain.ROCKY) {
            terrainCounterHex3++;
        }
        if (t.getHex3().getTerrainType() == Terrain.typesOfTerrain.JUNGLE) {
            terrainCounterHex3++;
        }

        Assert.assertEquals(1, terrainCounterHex3);
    }

    @Given("^a hex is created$")
    public void a_hex_is_created() throws Throwable {

    }

    @When("^a tile is initially created$")
    public void a_tile_is_created() throws Throwable {

    }

    @Then("^it should have (\\d+) sides$")
    public void it_should_have_sides(int arg1) throws Throwable {

    }


}
