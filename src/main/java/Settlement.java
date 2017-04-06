import java.util.ArrayList;

/**
 * Created by Kyle on 3/25/2017.
 */
public class Settlement {

    private int length;
    private Player player;
    private boolean HasTotoro;
    private boolean HasTiger;
    private ArrayList<Hex> SettlementLocations;

    //create new settlement
    public Settlement(Hex PlayerHex, Player player){
        this.player = player;
        SettlementLocations = new ArrayList<>();
        SettlementLocations.add(PlayerHex);
        length = 1;
        HasTotoro = false;
        HasTiger  = false;
    }

    //combine two settlements (i.e. at end of a turn)
    /*
    public Settlement(Settlement Settlement1, Settlement Settlement2){
            //TO-DO
    }
    */

    public ArrayList<Hex> getSettlementHexes(){
        return this.SettlementLocations;
    }

    public int getLength(){
        return length;
    }

    public Player getPlayer(){
        return player;
    }



    //expands the settlement by adding hex and updating length
    public void addToSettlement(Hex chosenHex){
        SettlementLocations.add(chosenHex);
        length++;
    }

    public void setLength(int length){
        this.length = length;
    }

    public void addTigerFlag(){
        this.HasTiger = true;
    }

    public void addTotoroFlag(){
        this.HasTotoro = true;
    }


    public void removeTigerFlag(){
        this.HasTiger = false;
    }

    public void removeTotoroFlag(){
        this.HasTotoro = false;
    }

    public boolean getTigerFlag(){
        return this.HasTiger;
    }

    public boolean getTotoroFlag(){
        return this.HasTotoro;
    }



}




