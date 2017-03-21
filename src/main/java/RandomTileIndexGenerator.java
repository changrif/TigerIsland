/**
 * Created by ddmac on 3/15/2017.
 */

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class RandomTileIndexGenerator {

    private final int totalNumberOfTiles = 48;
    Random rand;
    private Collection<Integer> tilesPicked;
    public RandomTileIndexGenerator(){
        rand = new Random();
        tilesPicked = new HashSet<>();
    }

    public int getAmountOfTiles(){
        return totalNumberOfTiles;
    }

    public int getNumberOfTilesPicked(){
        return tilesPicked.size();
    }

    public int getRandomTileIndex(){
        int tileID;

        if (getNumberOfTilesPicked() == totalNumberOfTiles){
            throw new RuntimeException("Every ID has been used");
        }

        do {
            tileID = getTileIndexFromZeroToFortySeven(totalNumberOfTiles);
        }while(tileHasAlreadyBeenDrawn(tileID));

        tilesPicked.add(tileID);

        return tileID;
    }

    public boolean tileHasAlreadyBeenDrawn(int tileID){
        return tilesPicked.contains(tileID);
    }

    public int getTileIndexFromZeroToFortySeven(int amountOfTiles) {
        return rand.nextInt(amountOfTiles);
    }
}
