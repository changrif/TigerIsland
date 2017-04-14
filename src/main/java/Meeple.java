/**
 * Created by Kyle on 3/14/2017.
 * Meeples are represented as objects and they have a reference to the player they belong to and their point value.
 */
public class Meeple {

    private String player;
    private static final int pointValue = 1;

    //Constructor
    public Meeple(String playerID){
        this.player = playerID;
    }

    public int getPointValue(){
        return pointValue;
    }

    public String getPlayer(){
        return player;
    }
}


