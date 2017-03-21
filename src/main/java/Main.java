/**
 * Created by Nick Kroeger on 3/21/2017.
 */
public class Main {
    public static void main(String [] args){

        //Create Board
        Map m = new Map();

        //Create Deck
        Deck d = new Deck();
        d.generateTiles();
        //make 2 players
        Player p1 = new Player("Nick");
        Player p2 = new Player("David");

        //the 2 players play the game
        GameRunner gr = new GameRunner(p1, p2, m, d);
        gr.runGame();


    }
}
