/**
 * Created by ddmac on 3/15/2017.
 */

public class Terrain {
    public typesOfTerrain getTerrainTypeFromString(String a) {
        if(a.equalsIgnoreCase("JUNGLE"))
            return typesOfTerrain.JUNGLE;
        if(a.equalsIgnoreCase("LAKE"))
            return typesOfTerrain.LAKE;
        if(a.equalsIgnoreCase("GRASS"))
            return typesOfTerrain.GRASSLANDS;
        if(a.equalsIgnoreCase("ROCK"))
            return typesOfTerrain.ROCKY;
        return null;
    }

    public enum typesOfTerrain {
        JUNGLE, LAKE, ROCKY, GRASSLANDS, VOLCANO
    }

    public String convertTerrainToString(Terrain.typesOfTerrain t){
        if(t == typesOfTerrain.GRASSLANDS)
            return "GRASS";
        if(t == typesOfTerrain.JUNGLE)
            return "JUNGLE";
        if(t == typesOfTerrain.LAKE)
            return "LAKE";
        if(t == typesOfTerrain.ROCKY)
            return "ROCK";
        return null;
    }

    //We can move this somewhere else later if it is more convenient as well as change names
    public static class Habitat {
        typesOfTerrain t;

        public Habitat(typesOfTerrain t){
            this.t = t;
        }

        public typesOfTerrain getTerrain()  { return t; }

        public boolean isHabitable() {
            switch (t) {
                case JUNGLE:
                    return true;
                case LAKE:
                    return true;
                case ROCKY:
                    return true;
                case GRASSLANDS:
                    return true;
                case VOLCANO:
                    return false;
                default:
                    break;
            }
            return false;
        }
    }
}

