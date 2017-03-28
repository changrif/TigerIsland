/**
 * Created by Kyle on 3/14/2017.
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
