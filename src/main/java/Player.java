import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nick Kroeger on 3/21/2017.
 */

public class Player {
    private final int MAX_NUMBER_OF_MEEPLES = 20;
    private final int MAX_NUMBER_OF_TOTOROS = 3;
    private final int MAX_NUMBER_OF_TIGERS = 2;
    private int numberOfMeeplesIHave;
    private int numberOfTotorosIHave;
    private int numberOfTigersIHave;
    private String name;
    private int matchScore;
    private int tournamentScore;
    private int roundScore;
    private boolean isCurrentPlayersTurn;
    private ArrayList<Settlement> OwnedSettlements;
    private PlayerState.gameState currentStateOfTheGameAfterAIMove;

    public Player(String PlayerName) {
        OwnedSettlements = new ArrayList<>();
        matchScore = 0;
        tournamentScore = 0;
        roundScore = 0;
        name = PlayerName;
        numberOfMeeplesIHave = MAX_NUMBER_OF_MEEPLES;
        numberOfTotorosIHave = MAX_NUMBER_OF_TOTOROS;
        numberOfTigersIHave = MAX_NUMBER_OF_TIGERS;
    }

    public PlayerState.gameState getCurrentStateOfTheGameAfterAIMove() {
        return currentStateOfTheGameAfterAIMove;
    }

    public void setCurrentStateOfTheGameAfterAIMove(PlayerState.gameState currentStateOfTheGameAfterAIMove) {
        this.currentStateOfTheGameAfterAIMove = currentStateOfTheGameAfterAIMove;
    }

    public int getTileOrientationInputFromPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! Input the orientation number (1-6) for which you want to rotate the " +
                "other two hexes around the volcano pivot.");
        return sc.nextInt();
    }

    public int getYCoordinateInputFromPlayer(){
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

    public int getNumberOfMeeplesIHave() {
        return numberOfMeeplesIHave;
    }

    public void decreaseNumberOfMeeplesByAmount(int numberOfMeeplesPlacedForCurrentTurn){
        int updatedAmountOfMeeples = numberOfMeeplesIHave - numberOfMeeplesPlacedForCurrentTurn;
        if(updatedAmountOfMeeples < 0){
            throw new NotEnoughMeeples();
        }
        this.numberOfMeeplesIHave = updatedAmountOfMeeples;
    }

    public int getNumberOfTotorosIHave() {
        return numberOfTotorosIHave;
    }

    public void decreaseNumberOfTotorosByAmount(int numberOfTotorosPlacedOnCurrentTurn) throws NotEnoughTotoro {
        int updatedAmountOfTotoros = numberOfTotorosIHave - numberOfTotorosPlacedOnCurrentTurn;
        if(updatedAmountOfTotoros < 0){
            throw new NotEnoughTotoro();
        }
        this.numberOfTotorosIHave = updatedAmountOfTotoros;

    }

    public int getNumberOfTigersIHave() {
        return numberOfTigersIHave;
    }

    public int getOwnedSettlementsSize() {
        return OwnedSettlements.size();
    }

    public void decreaseNumberOfTigersByAmount(int numberOfTigersPlacedOnCurrentTurn) throws NotEnoughTigers{
        int updatedAmountOfTigers = numberOfTigersIHave - numberOfTigersPlacedOnCurrentTurn;
        if(updatedAmountOfTigers < 0){
            throw new NotEnoughTigers();
        }
        this.numberOfTigersIHave = updatedAmountOfTigers;
    }

    public String getPlayerName() {
        return name;
    }

    public void addSettlement(Settlement NewSettlement){
        OwnedSettlements.add(NewSettlement);
    }

    public ArrayList<Settlement> getPlayerSettlements(){
        return OwnedSettlements;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void increaseMatchScore(int PointsToAdd){
        matchScore += PointsToAdd;
    }

    public int getTournamentScore() {
        return tournamentScore;
    }

    public void increaseTournamentScore(int PointsToAdd){
        tournamentScore += PointsToAdd;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public void increaseRoundScore(int PointsToAdd){
        roundScore += PointsToAdd;
    }

}
