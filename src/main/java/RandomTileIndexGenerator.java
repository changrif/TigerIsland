/**
 * Created by ddmac on 3/15/2017.
 */

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class RandomTileIndexGenerator {

    public RandomTileIndexGenerator(){

    }

    public int getRandomTileIndex(Collection<Integer> tilesPicked){
        Random rand = new Random();
        final int amountOfTiles = 48;

        if (tilesPicked.size()== amountOfTiles){
            throw new RuntimeException("Every ID has been used");
        }

        boolean newIndex = false;
        int index=0;

        while(newIndex == false){
            index = rand.nextInt(amountOfTiles);
            if(tilesPicked.contains(index) == false){
                newIndex = true;
            }
        }

        tilesPicked.add(index);
        System.out.println(index);
        return index;
    }

    public static void main(String args[]){
        RandomTileIndexGenerator r = new RandomTileIndexGenerator();

        Collection<Integer> tilesPicked = new HashSet<>();

        //Just testing....
        //test
        for(int i = 0; i < 48; i++) {
            System.out.print(i + ". ");
            r.getRandomTileIndex(tilesPicked);
        }
    }
}
