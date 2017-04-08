import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

///**
// * Created by AizeyPineda on 3/24/17.
// */


public class TilesAcceptanceTests {

    @Given("^no tiles have been placed$")
    public void no_tiles_have_been_placed() throws Throwable {


    }

    @When("^before the first turn$")
    public void before_the_first_turn() throws Throwable {

    }

    @Then("^there are (48) tiles$")
    public void there_are_tiles(int arg1) throws Throwable {
        Deck d = new Deck();
        d.generateTiles();
        Assert.assertEquals(arg1, d.getCurrentSizeOfDeck());
    }

    @Then("^there are (3) tiles of each of the (16) terrain combinations$")
    public void there_are_tiles_of_each_of_the_terrain_combinations(int arg1, int arg2) throws Throwable {
        Deck d = new Deck();

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


    @Given("^all the tiles in the deck$")
    public void all_the_tiles() throws Throwable {
        Deck d = new Deck();
        d.generateTiles();
        Assert.assertEquals(48, d.getCurrentSizeOfDeck());
    }

    @When("^the game begins$")
    public void the_game_begins() throws Throwable {

    }

    @Then("^each tile should have (3) hexes with the proper configuration of one volcano and a terrain combination$")
    public void each_tile_should_have_hexes_with_the_proper_configuration_of_one_volcano_and_a_terrain_combination(int arg1) throws Throwable {
        Deck d = new Deck();
        d.generateTiles();
        Tile t;
        int volcanoCount = 0;
        for(int i = 0; i < 47; i++){
            t = d.draw();
            Assert.assertEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex1().getTerrainType());

            Assert.assertNotEquals(null, t.getHex2().getTerrainType());
            Assert.assertNotEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex2().getTerrainType());

            Assert.assertNotEquals(null, t.getHex3().getTerrainType());
            Assert.assertNotEquals(Terrain.typesOfTerrain.VOLCANO, t.getHex3().getTerrainType());

            if(Terrain.typesOfTerrain.VOLCANO == t.getHex1().getTerrainType()){
                volcanoCount++;
            }
        }
        Assert.assertEquals(47, volcanoCount);
    }

    @Given("^the board is empty$")
    public void the_board_is_empty() throws Throwable {

    }

    @When("^a tile is being placed$")
    public void a_tile_is_being_placed() throws Throwable {

    }

    @Then("^the tile is placed at the origin, in any orientation$")
    public void the_tile_is_placed_at_the_origin_in_any_orientation() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();
        Terrain.typesOfTerrain t = Terrain.typesOfTerrain.VOLCANO;
        Coordinate c = new Coordinate(100,100,100);

        for(int i = 0; i<200; i++){
            for(int j = 0; j < 200; j++) {
                for (int k = 0; k < 200; k++) {
                    Assert.assertEquals(null, m.getMap()[i][j][k]);
                }
            }
        }

        m.placeFirstTile();
        Assert.assertEquals(t, m.hexAt(c).getTerrainType());
    }

    @Given("^the board is not empty$")
    public void the_board_is_not_empty() throws Throwable {

    }

    @When("^a tile is being placed not adjacent to another tile$")
    public void a_tile_is_being_placed_not_adjacent_to_another_tile() throws Throwable {

    }

    @Then("^the player will be prohibited from doing so$")
    public void the_player_will_be_prohibited_from_so() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();
        d.generateTiles();

        Tile t = d.draw();

        Coordinate c = new Coordinate(99, 98, 103);
        m.placeFirstTile();

        try {
            m.placeTile(t, c, 6);
        }catch(InvalidTilePlacement i){
            Assert.assertEquals(null, m.getMap()[98][103][99]);
        }
    }

    @Given("^there is a fixed number of tiles available$")
    public void there_is_a_fixed_number_of_tiles_available() throws Throwable {

    }

    @When("^they successfully place a tile$")
    public void they_successfully_place_a_tile() throws Throwable {

    }

    @Then("^that tile should be removed from the list of available tiles / combination type$")
    public void that_tile_should_be_removed_from_the_list_of_available_tiles_combination_type() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();

        Coordinate c = new Coordinate(100, 101, 99);

        int LakeAndRockyTile = 0, LakeAndGrasslandTile = 0, LakeAndLakeTile = 0, LakeAndJungleTile = 0;
        int RockyAndLakeTile = 0, GrasslandAndLakeTile = 0, JungleAndLakeTile = 0, RockyAndJungleTile = 0;
        int RockyAndRockyTile = 0, RockyAndGrasslandTile = 0, JungleAndRockyTile = 0, GrasslandAndRockyTile = 0;
        int GrasslandAndJungleTile = 0, GrasslandAndGrasslandTile = 0, JungleAndJungleTile = 0, JungleAndGrasslandTile = 0;

        d.generateTiles();

        Assert.assertEquals(48, d.getCurrentSizeOfDeck());

        Tile t = d.draw();

        m.placeFirstTile();

        m.placeTile(t, c, 3);

        //Find out which type of tile was placed. In then end, all types should be accounted for 3 times each

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


        Assert.assertEquals(47, d.getCurrentSizeOfDeck());

        for(int i = 0; i < 47; i++){
            t = d.draw();
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
        Assert.assertEquals(3, LakeAndGrasslandTile);
        Assert.assertEquals(3, LakeAndJungleTile);
        Assert.assertEquals(3, LakeAndLakeTile);
        Assert.assertEquals(3, LakeAndRockyTile);
        Assert.assertEquals(3, JungleAndLakeTile);
        Assert.assertEquals(3, GrasslandAndLakeTile);
        Assert.assertEquals(3, RockyAndLakeTile);
        Assert.assertEquals(3, RockyAndGrasslandTile);
        Assert.assertEquals(3, RockyAndJungleTile);
        Assert.assertEquals(3, RockyAndRockyTile);
        Assert.assertEquals(3, GrasslandAndRockyTile);
        Assert.assertEquals(3, JungleAndRockyTile);
        Assert.assertEquals(3, GrasslandAndGrasslandTile);
        Assert.assertEquals(3, GrasslandAndJungleTile);
        Assert.assertEquals(3, JungleAndGrasslandTile);
        Assert.assertEquals(3, JungleAndJungleTile);
    }

    @When("^a tile is being placed on level (1)$")
    public void a_tile_is_being_placed_on_level(int arg1) throws Throwable {

    }

    @Then("^at least one side of the tile being placed must touch an existing tile on the board$")
    public void at_least_one_side_of_the_tile_being_placed_must_touch_an_existing_tile_on_the_board() throws Throwable {

        Map m = new Map();
        Deck d = new Deck();

        Coordinate c = new Coordinate(100, 101, 99);
        Coordinate c2 = new Coordinate(103, 103, 103);

        d.generateTiles();

        Tile t = d.draw();
        m.placeFirstTile();

        m.placeTile(t, c, 3);

        Assert.assertEquals(1, t.getTileLevel());

        t = d.draw();

        try {
            m.placeTile(t, c2, 6);
        }
        catch(InvalidTilePlacement i){
            Assert.assertEquals(null, m.getMap()[103][103][103]);
        }
    }

    @Given("^the board is not empty and has a valid level (1) configuration$")
    public void the_board_is_not_empty_and_has_a_valid_level_configuration(int arg1) throws Throwable {

    }

    @When("^a tile is in the process of being stacked$")
    public void a_tile_is_About_To_Be_Stacked() throws Throwable {

    }

    @Then("^it can be stacked so long as it follows stacking restrictions$")
    public void it_can_be_stacked_so_long_as_it_follows_stacking_restrictions() throws Throwable {
        Map m = new Map();
        Deck d = new Deck();

        Coordinate c = new Coordinate(100, 101, 99);
        Coordinate c2 = new Coordinate(100, 100, 100);

        d.generateTiles();

        Tile t = d.draw();
        m.placeFirstTile();

        m.placeTile(t, c, 3);

        Assert.assertEquals(1, t.getTileLevel());

        t = d.draw();
        m.placeTile(t, c2, 2);
        Assert.assertEquals(2, t.getTileLevel());
    }

    @When("^a tile is being stacked and$")
    public void a_tile_is_being_stacked_and() throws Throwable {

    }

    @When("^it has space beneath it$")
    public void it_has_space_beneath_it() throws Throwable {

    }

    @Then("^it is prohibited from being stacked$")
    public void it_is_prohibited_from_being_stacked() throws Throwable {

    }


    @When("^its volcano hex is not over a volcano hex$")
    public void its_volcano_hex_is_not_over_a_volcano_hex() throws Throwable {

    }

    @Then("^the tile is prohibited from being stacked$")
    public void the_tile_is_prohibited_from_being_stacked() throws Throwable {

    }

    @When("^it is placed over an area of the board$")
    public void it_is_placed_over_an_area_of_the_board() throws Throwable {

    }

    @Then("^the level of that area of the board increases by (\\d+)$")
    public void the_level_of_that_area_of_the_board_increases_by(int arg1) throws Throwable {

    }

    @Then("^it can not be placed directly over a single tile$")
    public void it_can_not_be_placed_directly_over_a_single_tile() throws Throwable {

    }

    @Then("^the tiles being covered must be at the same level$")
    public void the_tiles_being_covered_must_be_at_the_same_level() throws Throwable {

    }

    @Then("^it can not cover a size (\\d+) settlement$")
    public void it_can_not_cover_a_size_settlement(int arg1) throws Throwable {

    }

    @Then("^none of the hexes contain a totoro$")
    public void none_of_the_hexes_contain_a_totoro() throws Throwable {

    }

    @Then("^at least one of the hexes must be a volcano$")
    public void at_least_one_of_the_hexes_must_be_a_volcano() throws Throwable {

    }

    @When("^a player attempts to nuke an area of the board$")
    public void a_player_attempts_to_nuke_an_area_of_the_board() throws Throwable {

    }

    @Then("^the volcano terrain of the tile must be placed over a volcano terrain on the board$")
    public void the_volcano_terrain_of_the_tile_must_be_placed_over_a_volcano_terrain_on_the_board() throws Throwable {

    }

    @Then("^it will completely cover the hexes with no blank board space under it$")
    public void it_will_completely_cover_the_hexes_with_no_blank_board_space_under_it() throws Throwable {

    }
//
//    @When("^a player attempts to nuke an area of the board that completely overlaps a tile$")
//    public void a_player_attempts_to_nuke_an_area_of_the_board_that_completely_overlaps_a_tile() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^the player will be prohibited from doing so$")
//    public void the_player_will_be_prohibited_from_doing_so() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//    //Need to Add Given
//
//    @When("^a player attempts to nuke an area of the board that will split a settlement$")
//    public void a_player_attempts_to_nuke_an_area_of_the_board_that_will_split_a_settlement() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^the new settlement is created$")
//    public void the_new_settlement_is_created() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^both settlement sizes are updated$")
//    public void both_settlement_sizes_are_updated() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^a player attempts to nuke an area of the board that contains a totoro$")
//    public void a_player_attempts_to_nuke_an_area_of_the_board_that_contains_a_totoro() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^a player attempts to nuke a settlement of size one$")
//    public void a_player_attempts_to_nuke_a_settlement_of_size_one() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^a player attempts to nuke a settlement of size greater than one$")
//    public void a_player_attempts_to_nuke_a_settlement_of_size_greater_than_one() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^a player attempts to nuke an area of the board that does not contain a totoro$")
//    public void a_player_attempts_to_nuke_an_area_of_the_board_that_does_not_contain_a_totoro() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^a player attempts to nuke an area of the board that does not completely overlap a tile$")
//    public void a_player_attempts_to_nuke_an_area_of_the_board_that_does_not_completely_overlap_a_tile() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^the player will not be prohibited from doing so$")
//    public void the_player_will_not_be_prohibited_from_doing_so() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Given("^a tile is being stacked$")
//    public void a_tile_is_being_stacked() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^a settlement exists on the tiles being covered$")
//    public void a_settlement_exists_on_the_tiles_being_covered() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^the settlements are destroyed, so the meeples are no longer in play$")
//    public void the_settlements_are_destroyed_so_the_meeples_are_no_longer_in_play() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//
}
