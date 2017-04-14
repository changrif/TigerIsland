/**
 * Created by ddmac on 3/22/2017.
 * This class creates a tiger as an object. It has references to point value and player
 */
public class Tiger {
    private String player;
    private static final int pointValue = 75;

    //Constructor
    public Tiger(String playerID){
        this.player = playerID;
    }

    public int getPointValue(){
        return pointValue;
    }

    public String getPlayer(){
        return player;
    }
}
