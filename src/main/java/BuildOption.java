/**
 * Created by Nick Kroeger on 4/5/2017.
 */
public class BuildOption {

    public BuildOption.typesOfBuildOptions getTypeOfBuildOption(String a) {
        if(a.equalsIgnoreCase("FOUND SETTLEMENT AT"))
            return typesOfBuildOptions.FOUND_SETTLEMENT;
        if(a.equalsIgnoreCase("EXPAND SETTLEMENT AT"))
            return typesOfBuildOptions.EXPANSION;
        if( a.equalsIgnoreCase("BUILD TOTORO SANCTUARY AT"))
            return typesOfBuildOptions.TOTORO_SANCTUARY;
        if(a.equalsIgnoreCase("BUILD TIGER PLAYGROUND AT"))
            return typesOfBuildOptions.TIGER_PLAYGROUND;
        if(a.equalsIgnoreCase("UNABLE TO BUILD"))
            return typesOfBuildOptions.UNABLE_TO_BUILD;
        return null;
    }
    public enum typesOfBuildOptions {
        FOUND_SETTLEMENT,
        EXPANSION,
        TOTORO_SANCTUARY,
        TIGER_PLAYGROUND,
        UNABLE_TO_BUILD
    }
}
