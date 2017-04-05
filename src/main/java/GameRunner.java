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
        p1.setCurrentPlayersTurn(true);
        boolean didPlayer1Win;//1 p1 won, if its false then p1 lost
        while(gameInProgess){
            //play
            if(p1.isCurrentPlayersTurn()){
                //player1 plays
                //Draw
                Tile t = deck.draw();

//                int x = p1.getXCoordinateInputFromPlayer();
//                int y = p1.getYCoordinateInputFromPlayer();
//                int tileOrientation = p1.getTileOrientationInputFromPlayer();
                Coordinate coordinate =
                        new Coordinate(100, 100,99);
                int tileOrientation = 1;
                try {
                    map.placeTile(t, coordinate, tileOrientation);
                } catch (InvalidTilePlacement invalidTilePlacement) {
                    invalidTilePlacement.printStackTrace();
                }

                //Build action (choose 1 of these)
                //1. Found a settlement on any empty, level-1, non-volcano hex
                //2. expand an existing settlement
                //3. build a totoro sanctuary
                //4. build a tiger playground
                int option = p1.getBuildAction();
                if(option == 1){
                    int xCoordForSettlement = 100;
                    int yCoordForSettlement = 101;
                    int zCoordForSettlement = 99;
                    map.foundNewSettlement(new Coordinate(xCoordForSettlement, yCoordForSettlement, zCoordForSettlement), p1);
                }
                else if(option == 2){
                    //WHAT IS THE FIRST PARAMETER???
                    //map.ExpandSettlement(Location, Terrain.typesOfTerrain.LAKE, p1);
                }
                else if(option == 3){
                    map.PlaceTotoro(new Coordinate(100,100, 100), p1);
                }
                else if(option == 4){
                    map.PlaceTiger(new Coordinate(100, 100, 100), p1);
                }


                //Game ends and scores are compared when:
                //1. Player runs out of pieces
                if(checkIfAllPiecesArePlaced(p1)){

                    gameInProgess=false;
                }
                //Player loses if you can't build

                    // If player makes illegal move or cannot build set gameInProgress to false and p1 loses
                //Calculate the player's score
                p1.setCurrentPlayersTurn(false);
            }
            else{
                //player 2 plays
                //Draw & Place tile
                //Build
                    // If player makes illegal move or cannot build set gameInProgress to false and p2 loses
                //If can't build, then game gameInProgress=false;
                //Calculate the player's score
                p1.setCurrentPlayersTurn(true);
            }
        }
        //game is over, compare scores
        if(p1.getMatchScore() > p2.getMatchScore()){
            didPlayer1Win = true;
        }
        else if(p1.getMatchScore() == p2.getMatchScore()){
            didPlayer1Win = checkIfAllPiecesArePlaced(p1);
        }
        else{
            didPlayer1Win = false;
        }
    }

    private boolean checkIfAllPiecesArePlaced(Player p) {
        if(p.getNumberOfMeeplesIHave()==0 && p.getNumberOfTigersIHave() == 0 && p.getNumberOfTotorosIHave() == 0){
            return true;
        }
        return false;
    }


}