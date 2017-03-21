/**
 * Created by ddmac on 3/15/2017.
 */

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Deprecated
//Basically, don't use this. But we'll keep it for a little, because we love it.
public class RandomTileIndexGenerator {

    private final int MAX_NUMBER_OF_TILES = 48;
    private int numberOfCardsInDeck;
    Random rand;
    boolean tilesPicked [];

    public RandomTileIndexGenerator(){
        numberOfCardsInDeck=MAX_NUMBER_OF_TILES;
        rand = new Random();
        tilesPicked = new boolean[48];
    }

    public int getRandomTileIndex(int currentDeckSize){
        numberOfCardsInDeck--;
        int tileID;

        if (thereAreNoMoreCardsInTheDeck()){
            throw new RuntimeException("Every ID has been used");
        }

        do {
            tileID = getTileIndexFromZeroToSizeOfDeck(currentDeckSize);
        }while(tileHasAlreadyBeenDrawn(tileID));

        tilesPicked[tileID] = true;
        return tileID;
    }

    public boolean thereAreNoMoreCardsInTheDeck() {
        return numberOfCardsInDeck==0;
    }


    public boolean tileHasAlreadyBeenDrawn(int tileID){
        return tilesPicked[tileID]==true;
    }

    public int getTileIndexFromZeroToSizeOfDeck(int amountOfTiles) {
        return rand.nextInt(amountOfTiles);
    }

    public int getMAX_NUMBER_OF_TILES() {
        return MAX_NUMBER_OF_TILES;
    }
}
