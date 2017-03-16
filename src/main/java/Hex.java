/**
 * Created by Kyle on 3/14/2017.
 */
public class Hex {

    private int x;
    private int y;

    private String TerrainType;
    private int Level = -1;

    private Tile Tile;
    //private int TilePosition;

    private Meeple meeples[];
    private Totoro totoro;


    public Hex (String TerrainType){

        this.TerrainType = TerrainType;

    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    public String getTerrainType(){
        return TerrainType;
    }

    public void setLevel(int Level){
        this.Level = Level;
    }

    public int getLevel(){
        return Level;
    }

    public void placeMeeples(int player){
        meeples = new Meeple[Level];
        for(int i = 0; i < Level; i++){
            meeples[i] = new Meeple(player);
        }
    }

    public void placeTotoro(int player){
        totoro = new Totoro(player);
    }


}
