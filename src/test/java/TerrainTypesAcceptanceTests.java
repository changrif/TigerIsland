import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by ddmac on 3/29/2017.
 */
public class TerrainTypesAcceptanceTests {

    private static Map GameBoard;
    private static Deck d;
    private static Tile tile1;
    private static Tile tile2;
    private static Tile tile3;
    private static Tile tile4;
    private static Player p1;
    private static Player p2;
    private static Coordinate CurrentPlacement;

    @Given("^a type of terrain,$")
    public void a_type_of_terrain() throws Throwable {
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        d = new Deck();
        d.generateTiles();
        p1 = new Player("Kyle");
        p2 = new Player("Dave");

        Hex Hex01 = new Hex(Terrain.typesOfTerrain.VOLCANO, 0);
        Hex Hex02 = new Hex(Terrain.typesOfTerrain.JUNGLE, 0);
        Hex Hex03 = new Hex(Terrain.typesOfTerrain.JUNGLE, 0);
        Hex Hex11 = new Hex(Terrain.typesOfTerrain.VOLCANO, 1);
        Hex Hex12 = new Hex(Terrain.typesOfTerrain.JUNGLE, 1);
        Hex Hex13 = new Hex(Terrain.typesOfTerrain.JUNGLE, 1);
        Hex Hex21 = new Hex(Terrain.typesOfTerrain.VOLCANO, 2);
        Hex Hex22 = new Hex(Terrain.typesOfTerrain.JUNGLE, 2);
        Hex Hex23 = new Hex(Terrain.typesOfTerrain.ROCKY, 2);
        Hex Hex31 = new Hex(Terrain.typesOfTerrain.VOLCANO, 3);
        Hex Hex32 = new Hex(Terrain.typesOfTerrain.LAKE, 3);
        Hex Hex33 = new Hex(Terrain.typesOfTerrain.LAKE, 3);
        tile1 = new Tile(Hex01, Hex02, Hex03, 0);
        tile2 = new Tile(Hex11, Hex12, Hex13, 1);
        tile3 = new Tile(Hex21, Hex22, Hex23, 2);
        tile4 = new Tile(Hex31, Hex32, Hex33, 3);
    }

    @When("^the tile has been placed,$")
    public void the_tile_has_been_placed() throws Throwable {
        Coordinate tile1Location = new Coordinate(100, 99, 101);
        GameBoard.placeTile(tile1, tile1Location, 6);
    }

    @Then("^it cannot be compared with non-adjacent terrains\\.$")
    public void it_cannot_be_compared_with_non_adjacent_terrains() throws Throwable {
        Coordinate hex = new Coordinate(99, 99, 102);
        Coordinate[] adjacencyMatrix =  GameBoard.createAdjacentCoordinateArray(hex);
        Coordinate test1 = new Coordinate(98, 99, 103);
        Coordinate test2 = new Coordinate(98, 100, 102);
        Coordinate test3 = new Coordinate(99, 100, 101);
        Coordinate test4 = new Coordinate(100, 99, 101);
        Coordinate test5 = new Coordinate(100, 98, 102);
        Coordinate test6 = new Coordinate(99, 98, 103);
        Coordinate[] testCoordinateArray = {test1, test2, test3, test4, test5, test6};

        for (int i = 0; i < adjacencyMatrix.length; i++){
            Assert.assertEquals(testCoordinateArray[i].getX(), adjacencyMatrix[i].getX());
            Assert.assertEquals(testCoordinateArray[i].getY(), adjacencyMatrix[i].getY());
            Assert.assertEquals(testCoordinateArray[i].getZ(), adjacencyMatrix[i].getZ());
        }
    }

    @Then("^it can be compared with all adjacent terrains\\.$")
    public void it_can_be_compared_with_all_adjacent_terrains() throws Throwable {
        Coordinate hex = new Coordinate(99, 99, 102);
        Coordinate[] adjacencyMatrix =  GameBoard.createAdjacentCoordinateArray(hex);
        Coordinate test1 = new Coordinate(98, 99, 103);
        Coordinate test2 = new Coordinate(98, 100, 102);
        Coordinate test3 = new Coordinate(99, 100, 101);
        Coordinate test4 = new Coordinate(100, 99, 101);
        Coordinate test5 = new Coordinate(100, 98, 102);
        Coordinate test6 = new Coordinate(99, 98, 103);
        Coordinate[] testCoordinateArray = {test1, test2, test3, test4, test5, test6};

        for (int i = 0; i < adjacencyMatrix.length; i++){
            Assert.assertEquals(testCoordinateArray[i].getX(), adjacencyMatrix[i].getX());
            Assert.assertEquals(testCoordinateArray[i].getY(), adjacencyMatrix[i].getY());
            Assert.assertEquals(testCoordinateArray[i].getZ(), adjacencyMatrix[i].getZ());
        }
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
