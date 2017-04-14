/**
 * Created by Nick Kroeger on 4/5/2017.
 */
public class BuildOption {

    public BuildOption.typesOfBuildOptions getTypeOfBuildOption(String a) {
        a.toUpperCase();
        if(a.contains("FOUND SETTLEMENT AT") || a.contains("FOUNDED SETTLEMENT AT"))
            return typesOfBuildOptions.FOUND_SETTLEMENT;
        if(a.contains("EXPAND SETTLEMENT AT") || a.contains("EXPANDED SETTLEMENT AT"))
            return typesOfBuildOptions.EXPANSION;
        if( a.contains("BUILD TOTORO SANCTUARY AT") || a.contains("BUILT TOTORO SANCTUARY AT"))
            return typesOfBuildOptions.TOTORO_SANCTUARY;
        if(a.contains("BUILD TIGER PLAYGROUND AT") || a.contains("BUILT TIGER PLAYGROUND AT"))
            return typesOfBuildOptions.TIGER_PLAYGROUND;
        if(a.contains("UNABLE TO BUILD"))
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
