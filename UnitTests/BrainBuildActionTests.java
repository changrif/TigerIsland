import org.junit.*;

/**
 * Created by chandlergriffin on 4/7/17.
 */
public class BrainBuildActionTests {
    private static Map GameBoard;
    private static PlayerBrain playerBrain;
    private static Player teamI = new Player("teamI");
    private static Player opponent = new Player("opponent");
    private static Deck d;
    private static Tile t;

    @BeforeClass
    public static void createBoardWithFirstTile() {
        d = new Deck();
        d.generateTiles();
        t = d.draw();
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        playerBrain = new PlayerBrain(teamI, opponent, GameBoard);
    }

    @Before
    public void PlaceTile()  {
        t = d.draw();

        //AI sets and places Tile
        playerBrain.setTileToPlace(t);
        playerBrain.setBestTilePlacement();
        GameBoard.mapTileToBoard(playerBrain.getTileToPlace());
        System.out.print("Placing Tile at...");
        playerBrain.getTileToPlace().getHex1().getCoordinate().coordinateToString();
        System.out.println("...with orientation (" + playerBrain.getTileToPlace().getTileOrientation() + ")");
        System.out.println("...with HEX2 terrain " + playerBrain.getTileToPlace().getHex2().getTerrainType());
        System.out.println("...with HEX3 terrain " + playerBrain.getTileToPlace().getHex3().getTerrainType());

        playerBrain.getBestBuildAction();
    }

    public boolean canPlaceTiger(Coordinate chosenCoordinate, Player player)  {
        //return error trying to place on Volcano or space already occupied or no tigers left to play or not level 3+ tile
        if (!GameBoard.hexIsViableForTiger(chosenCoordinate) || !GameBoard.playerHasTigersLeft(player)) {
            return false;
        }

        Coordinate[] adjacencyMatrix = GameBoard.createAdjacentCoordinateArray(chosenCoordinate);

        for(Coordinate adj : adjacencyMatrix) {
            if (GameBoard.thereIsAnAdjacentSettlement(adj, player)) {
                return true;
            }
        }

        return false;
    }

    public boolean isValidPlacement(Player player)   {
        if(playerBrain.getBuildAction() == BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND)    {
            System.out.println("Trying TP at ");
            playerBrain.getCoordinateForTigerPlayground().coordinateToString();
            System.out.println("...");
            if(canPlaceTiger(playerBrain.getCoordinateForTigerPlayground(), player))    {
                System.out.println("Placed Tiger Playground");
                return true;
            }
        } else if(playerBrain.getBuildAction() == BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT)   {
            System.out.println("Trying FS at ");
            playerBrain.getCoordinateToBeUsedAsSettlement().coordinateToString();
            System.out.println("...");
            if(GameBoard.isNewSettlementValid(GameBoard.hexAt(playerBrain.getCoordinateToBeUsedAsSettlement())))   {
                System.out.println("Founded A Settlement");
                return true;
            }
        }   else if(playerBrain.getBuildAction() == BuildOption.typesOfBuildOptions.EXPANSION)   {
            System.out.println("Trying EX at ");
            playerBrain.getCoordinateToExpandTo().coordinateToString();
            System.out.println("in terrain : " + playerBrain.getTerrainForExpansion());
            System.out.println("...");
            int requiredMeeples = GameBoard.requiredMeeplesForExpansion(playerBrain.getCoordinateToExpandTo(), playerBrain.getTerrainForExpansion());
            if(requiredMeeples > 0 && player.getNumberOfMeeplesIHave() >= requiredMeeples)   {
                System.out.println("Expanded A Settlement");
                return true;
            }
        } else if(playerBrain.getBuildAction() == BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD &&
                playerBrain.wePlacedAllOfOurMeeples() &&
                playerBrain.wePlacedAllOfOurTigers())    {
            System.out.println("--We placed all of our stuff--");
            return true;
        }
        return false;
    }

    @Test
    public void aiBuildTest1()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest2()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest3()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest4()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest5()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest6()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest7()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest8()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest9()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest10()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest11()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest12()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest13()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest14()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest15()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest16()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest17()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest18()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest19()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @Test
    public void aiBuildTest20()   {
        Assert.assertTrue(isValidPlacement(teamI));
    }

    @After
    public void executeBuild()    {
        playerBrain.executeBuildAction();
        System.out.println("Score: " + playerBrain.getOurPlayer().getMatchScore());
        System.out.println("----------------\n");
    }
}
