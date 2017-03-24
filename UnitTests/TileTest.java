import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chandlergriffin on 3/21/17.
 */
public class TileTest {
    private Tile t;
    private Hex Hex1;
    private Hex Hex2;
    private Hex Hex3;
    private int TileID;

    @Before
    public void createTile()    {
        Hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, 1);
        Hex2 = new Hex(Terrain.typesOfTerrain.ROCKY, 1);
        Hex3 = new Hex(Terrain.typesOfTerrain.LAKE, 1);
        TileID = 1;

        t = new Tile(Hex1, Hex2, Hex3, TileID);
    }

    @Test
    public void getHex1Test()    {
        Assert.assertEquals(Hex1, t.getHex1());
    }

    @Test
    public void getHex2Test()    {
        Assert.assertEquals(Hex2, t.getHex2());
    }

    @Test
    public void getHex3Test()    {
        Assert.assertEquals(Hex3, t.getHex3());
    }

    @Test
    public void getTileIDTest()    {
        Assert.assertEquals(TileID, t.getTileID());
    }

}
