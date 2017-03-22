/**
 * Created by ddmac on 3/22/2017.
 */
public class Tiger {
    private int player;
    private static final int pointValue = 75;

    //Constructor
    public Tiger(int playerID){
        this.player = playerID;
    }

    public int getPointValue(){
        return pointValue;
    }

    public int getPlayer(){
        return player;
    }
}
