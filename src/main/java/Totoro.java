/**
 * Created by Kyle on 3/14/2017.
 * Creates a totoro object that has references to the player and point value of a totoro.
 */
public class Totoro {

    private String player;
    private static final int pointValue = 200;

    //Constructor
    public Totoro(String playerID){
        player = playerID;
    }

    public int getPointValue(){
        return pointValue;
    }

    public String getPlayer(){
        return player;
    }

}
