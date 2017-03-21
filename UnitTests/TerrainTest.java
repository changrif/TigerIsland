import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chandlergriffin on 3/21/17.
 */
public class TerrainTest {
     private Terrain.Habitat volcano;
     private Terrain.Habitat rocky;
     private Terrain.Habitat lake;
     private Terrain.Habitat jungle;
     private Terrain.Habitat grasslands;

    @Before
    public void createTerrains()  {
        volcano = new Terrain.Habitat(Terrain.typesOfTerrain.VOLCANO);
        rocky = new Terrain.Habitat(Terrain.typesOfTerrain.ROCKY);
        lake = new Terrain.Habitat(Terrain.typesOfTerrain.LAKE);
        jungle = new Terrain.Habitat(Terrain.typesOfTerrain.JUNGLE);
        grasslands = new Terrain.Habitat(Terrain.typesOfTerrain.GRASSLANDS);
    }

    @Test
    public void volcanoTest()   {
        Assert.assertEquals(Terrain.typesOfTerrain.VOLCANO, volcano.getTerrain());
    }

    @Test
    public void rockyTest()   {
        Assert.assertEquals(Terrain.typesOfTerrain.ROCKY, rocky.getTerrain());
    }

    @Test
    public void lakeTest()   {
        Assert.assertEquals(Terrain.typesOfTerrain.LAKE, lake.getTerrain());
    }

    @Test
    public void jungleTest()   {
        Assert.assertEquals(Terrain.typesOfTerrain.JUNGLE, jungle.getTerrain());
    }

    @Test
    public void grasslandsTest()   {
        Assert.assertEquals(Terrain.typesOfTerrain.GRASSLANDS, grasslands.getTerrain());
    }

    @Test
    public void isVolcanoHabitableTest()   {
        Assert.assertEquals(false, volcano.isHabitable());
    }

    @Test
    public void isRockyHabitableTest()   {
        Assert.assertEquals(true, rocky.isHabitable());
    }

    @Test
    public void isLakeHabitableTest()   {
        Assert.assertEquals(true, lake.isHabitable());
    }

    @Test
    public void isJungleHabitableTest()   {
        Assert.assertEquals(true, jungle.isHabitable());
    }

    @Test
    public void isGrasslandsHabitableTest()   {
        Assert.assertEquals(true, grasslands.isHabitable());
    }

}
