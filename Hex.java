/**
 * Created by Kyle
 */
public class Hex {

    private int x;
    private int y;
    private int z;

    private String TerrainType;
    private int Level;

    private Meeple meeples[];
    private Totoro totoro;
    //private Tile gameTile;

    public Hex(int x, int y, int z, String TerrainType, int Level){
        this.x = x;
        this.y = y;
        this.z = z;
        this.TerrainType = TerrainType;
        this.Level = Level;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ(){
        return z;
    }

//    public String getTerrainType(){
//        return TerrainType;
//    }
//
//    public int getLevel(){
//        return Level;
//    }
//
//    public void placeMeeples(int player){
//        meeples = new Meeple[Level];
//        for(int i = 0; i < Level; i++){
//            meeples[i] = new Meeple(player);
//        }
    }

    public void placeTotoro(int player){
        totoro = new Totoro(player);
    }



}
