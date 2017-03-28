import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by AizeyPineda on 3/24/17.
 */
public class TilesAcceptanceTests {
    Deck d = new Deck();

    @Given("^no tiles have been placed$")
    public void no_tiles_have_been_placed() throws Throwable {


    }

    @When("^before the first turn$")
    public void before_the_first_turn() throws Throwable {

    }

    @Then("^there are (48) tiles$")
    public void there_are_tiles(int arg1) throws Throwable {
        d.generateTiles();
        Assert.assertEquals(arg1, d.getCurrentSizeOfDeck());
    }

    @Then("^there are (3) tiles of each of the (16) terrain combinations$")
    public void there_are_tiles_of_each_of_the_terrain_combinations(int arg1, int arg2) throws Throwable {

        int LakeAndRockyTile = 0, LakeAndGrasslandTile = 0, LakeAndLakeTile = 0, LakeAndJungleTile = 0;
        int RockyAndLakeTile = 0, GrasslandAndLakeTile = 0, JungleAndLakeTile = 0, RockyAndJungleTile = 0;
        int RockyAndRockyTile = 0, RockyAndGrasslandTile = 0, JungleAndRockyTile = 0, GrasslandAndRockyTile = 0;
        int GrasslandAndJungleTile = 0, GrasslandAndGrasslandTile = 0, JungleAndJungleTile = 0, JungleAndGrasslandTile = 0;

        d.generateTiles();

        for(int i = 0; i < 48; i++){
            Tile t = d.draw();
            if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex3().getTerrainType()){
                LakeAndRockyTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex3().getTerrainType()){
                LakeAndGrasslandTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex3().getTerrainType()){
                LakeAndLakeTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex3().getTerrainType()){
                LakeAndJungleTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex3().getTerrainType()){
                RockyAndLakeTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex3().getTerrainType()){
                GrasslandAndLakeTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.LAKE == t.getHex3().getTerrainType()){
                JungleAndLakeTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex3().getTerrainType()){
                RockyAndJungleTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex3().getTerrainType()){
                RockyAndRockyTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex3().getTerrainType()){
                RockyAndGrasslandTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex3().getTerrainType()){
                GrasslandAndRockyTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.ROCKY == t.getHex3().getTerrainType()){
                JungleAndRockyTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex3().getTerrainType()){
                JungleAndJungleTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex3().getTerrainType()){
                JungleAndGrasslandTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.JUNGLE == t.getHex3().getTerrainType()){
                GrasslandAndJungleTile++;
            }
            else if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex2().getTerrainType() && Terrain.typesOfTerrain.GRASSLANDS == t.getHex3().getTerrainType()){
                GrasslandAndGrasslandTile++;
            }

        }
        Assert.assertEquals(arg1, LakeAndGrasslandTile);
        Assert.assertEquals(arg1, LakeAndJungleTile);
        Assert.assertEquals(arg1, LakeAndLakeTile);
        Assert.assertEquals(arg1, LakeAndRockyTile);
        Assert.assertEquals(arg1, JungleAndLakeTile);
        Assert.assertEquals(arg1, GrasslandAndLakeTile);
        Assert.assertEquals(arg1, RockyAndLakeTile);
        Assert.assertEquals(arg1, RockyAndGrasslandTile);
        Assert.assertEquals(arg1, RockyAndJungleTile);
        Assert.assertEquals(arg1, RockyAndRockyTile);
        Assert.assertEquals(arg1, GrasslandAndRockyTile);
        Assert.assertEquals(arg1, JungleAndRockyTile);
        Assert.assertEquals(arg1, GrasslandAndGrasslandTile);
        Assert.assertEquals(arg1, GrasslandAndJungleTile);
        Assert.assertEquals(arg1, JungleAndGrasslandTile);
        Assert.assertEquals(arg1, JungleAndJungleTile);

    }

}
