import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by chandlergriffin on 3/23/17.
 */
public class FirstTileMapTest {
    private static Map GameBoard;
    private static FirstTile t;

    public static boolean checkPosition()    {
        int x = 100;
        int y = 100;
        int z = 100;

        if(GameBoard.isTaken(new Coordinate(x, y, z)) &&
                GameBoard.isTaken(new Coordinate(z - 1, x, y + 1)) &&
                GameBoard.isTaken(new Coordinate(z - 1, x + 1, y)) &&
                GameBoard.isTaken(new Coordinate(z + 1, x, y - 1)) &&
                GameBoard.isTaken(new Coordinate(z + 1, x - 1, y))) {
                return true;
            }
        return false;
    }

    public static boolean checkTileIDOnHexes()  {
        if(t.getHex1().getTileID() == t.getHex2().getTileID() &&
                t.getHex1().getTileID() == t.getHex3().getTileID() &&
                t.getHex1().getTileID() == t.getHex4().getTileID() &&
                t.getHex1().getTileID() == t.getHex5().getTileID() &&
                t.getTileID() == t.getHex1().getTileID())    {
            return true;
        }
        return false;
    }

    public static void printMap() {
        Hex[][][] map = GameBoard.getMap();
        for (int x = 105; x > 95; x--) {
            for (int y = 105; y > 95; y--) {
                for(int z = 105; z > 95; z--) {
                    if (map[x][y][z] != null) {
                        System.out.print(map[x][y][z].getTerrainType().toString().substring(0, 1) + map[x][y][z].getTileID() + "\t\t");
                    } else {
                        System.out.print(map[x][y][z] + "\t");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @BeforeClass
    public static void initializeBoard()    {
        GameBoard = new Map();
        GameBoard.placeFirstTile();
        //printMap();
        t = new FirstTile();
    }

    @Test
    public void firstTilePlacementTest()    {
        Assert.assertTrue(checkPosition());
    }

    @Test
    public void firstTileLevelTest()    {
        Assert.assertEquals(1, t.getTileLevel());
    }

    @Test
    public void firstTileHex1LevelTest()    {
        Assert.assertEquals(1, t.getHex1().getLevel());
    }

    @Test
    public void firstTileHex2LevelTest()    {
        Assert.assertEquals(1, t.getHex2().getLevel());
    }

    @Test
    public void firstTileHex3LevelTest()    {
        Assert.assertEquals(1, t.getHex3().getLevel());
    }

    @Test
    public void firstTileHex4LevelTest()    {
        Assert.assertEquals(1, t.getHex4().getLevel());
    }

    @Test
    public void firstTileHex5LevelTest()    {
        Assert.assertEquals(1, t.getHex5().getLevel());
    }

    @Test
    public void firstTileCheckTileID()    {
        Assert.assertTrue(checkTileIDOnHexes());
    }
}
