package generic;

/**
 * Created by Kyle on 3/14/2017.
 */
public class Meeple {

    private int player;
    private static final int pointValue = 1;

    //Constructor
    public Meeple(int playerID){
        this.player = playerID;
    }

    public int getPointValue(){
        return pointValue;
    }

    public int getPlayer(){
        return player;
    }
}


