import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ddmac on 4/7/2017.
 */
public class BuildOptionTest {
    BuildOption b = new BuildOption();

    @Test
    public void doesStringCorrectlyDetermineFoundSettlementOption(){
        String test = "FOUND SETTLEMENT AT";
        BuildOption.typesOfBuildOptions type = BuildOption.typesOfBuildOptions.FOUND_SETTLEMENT;
        Assert.assertEquals(type, b.getTypeOfBuildOption(test));

    }

    @Test
    public void doesStringCorrectlyDetermineExpansionOption(){
        String test = "EXPAND SETTLEMENT AT";
        BuildOption.typesOfBuildOptions type = BuildOption.typesOfBuildOptions.EXPANSION;
        Assert.assertEquals(type, b.getTypeOfBuildOption(test));

    }

    @Test
    public void doesStringCorrectlyDetermineTotoroSanctuaryOption(){
        String test = "BUILD TOTORO SANCTUARY AT";
        BuildOption.typesOfBuildOptions type = BuildOption.typesOfBuildOptions.TOTORO_SANCTUARY;
        Assert.assertEquals(type, b.getTypeOfBuildOption(test));

    }

    @Test
    public void doesStringCorrectlyDetermineTigerSanctuaryOption(){
        String test = "BUILD TIGER PLAYGROUND AT";
        BuildOption.typesOfBuildOptions type = BuildOption.typesOfBuildOptions.TIGER_PLAYGROUND;
        Assert.assertEquals(type, b.getTypeOfBuildOption(test));

    }

    @Test
    public void doesStringCorrectlyDetermineUnableToBuildOption(){
        String test = "UNABLE TO BUILD";
        BuildOption.typesOfBuildOptions type = BuildOption.typesOfBuildOptions.UNABLE_TO_BUILD;
        Assert.assertEquals(type, b.getTypeOfBuildOption(test));

    }
}
