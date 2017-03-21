/**
 * Created by ddmac on 3/15/2017.
 */

public class Terrain {
    public enum typesOfTerrain {
        JUNGLE, LAKE, ROCKY, GRASSLANDS, VOLCANO
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

