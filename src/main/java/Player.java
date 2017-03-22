import java.util.Scanner;

/**
 * Created by Nick Kroeger on 3/21/2017.
 */

public class Player {
    private final int MAX_NUMBER_OF_MEEPLES = 20;
    private final int MAX_NUMBER_OF_TOTOROS = 3;
    private int numberOfMeeplesIHave;
    private int numberOfTotorosIHave;
    private String name;
    private boolean isCurrentPlayersTurn;
    private Tile tile;


    public Player(String PlayerName) {
        name = PlayerName;
        numberOfMeeplesIHave = MAX_NUMBER_OF_MEEPLES;
        numberOfTotorosIHave = MAX_NUMBER_OF_TOTOROS;
    }

    public void placeTile(){
        //place a tile given some coordinates... or something
    }

    public void passInTile(Tile t){
        this.tile = t;
    }

    int getXCoordinateInputFromPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Input your X coordinate for where to place the volcano tile.");
        return sc.nextInt();
    }

    int getYCoordinateInputFromPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Input your Y coordinate for where to place the volcano tile.");
        return sc.nextInt();
    }

    public boolean isCurrentPlayersTurn() {
        return isCurrentPlayersTurn;
    }

    public void setCurrentPlayersTurn(boolean currentPlayersTurn) {
        isCurrentPlayersTurn = currentPlayersTurn;
    }

    public int getNUMBER_OF_MEEPLES() {
        return MAX_NUMBER_OF_MEEPLES;
    }

    public int getNUMBER_OF_TOTOROS() {
        return MAX_NUMBER_OF_TOTOROS;
    }

    public String getPlayerName() {
        return name;
    }
}
