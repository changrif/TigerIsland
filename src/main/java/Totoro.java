package generic;

/**
 * Created by Kyle on 3/14/2017.
 */
public class Totoro {
    private int player;
    private static final int pointValue = 200;

    //Constructor
    public Totoro(int playerID){
        player = playerID;
    }

    public int getPointValue(){
        return pointValue;
    }

    public int getPlayer(){
        return player;
    }

}
