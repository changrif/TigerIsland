/**
 * Created by Nick Kroeger on 3/21/2017.
 */
class GameRunner{

    private boolean gameInProgess = true;
    private Player p1;
    private Player p2;
    private Map map;
    private Deck deck;
    private String winner;

    public GameRunner(Player player1, Player player2, Map m, Deck d){
        p1 = player1;
        p2 = player2;
        map = m;
        deck = d;
        winner = null;
    }

    public boolean getGameInProgress(){
        return gameInProgess;
    }

    public void setGameInProgress(boolean gameStillRunning){
        gameInProgess = gameStillRunning;
    }

    public void runGame(){

        while(gameInProgess){
            //play


            if(p1.isCurrentPlayersTurn()){
                //player1 plays
                //Draw
                Tile t = deck.draw();
                //Build
                //If can't build, then game gameIsNotFinished=false;
                    // If player makes illegal move or cannot build set gameInProgress to false and p1 loses
                //Calculate the player's score
                p1.setCurrentPlayersTurn(false);
            }
            else{
                //player 2 plays
                //Draw
                //Build
                    // If player makes illegal move or cannot build set gameInProgress to false and p2 loses
                //If can't build, then game gameInProgress=false;
                //Calculate the player's score
                p1.setCurrentPlayersTurn(true);
            }
        }
    }

}