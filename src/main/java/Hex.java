/**
 * Created by Kyle on 3/14/2017.
 * All of the hexes in each tile are represented by a hex object. Each hex object has a reference to its TileID and Tile level.
 * Additionally, it has it's own coordinate and terrain type. Each hex also has flags that determine whether or not there are tigers, totoros,
 * meeples, or part of a settlement. Each hex can place a tiger, totoro, meeple, and set the settlement along with getting the player it belongs
 * to.
 */
public class Hex {

    private Coordinate coordinate;

    private Terrain.typesOfTerrain TerrainType;
    private int Level = 0;
    private int TileID;

    private Meeple meeples[];
    private Totoro totoro;
    private Tiger tiger;
    private Settlement settlement;
    private String BelongsToThisPlayer;




    public Hex (Terrain.typesOfTerrain TerrainType, int TileID){
        this.TerrainType = TerrainType;
        this.TileID = TileID;
    }

    public boolean MeeplesPresent(){
        if (meeples == null){
            return false;
        }
        else
            return true;
    }

    public boolean TotoroPresent(){
        if (totoro == null){
            return false;
        }
        else
            return true;
    }

    public boolean TigerPresent(){
        if (tiger == null){
            return false;
        }
        else
            return true;
    }

    public boolean isSettled()    {
        if(tiger == null && totoro == null && meeples == null)  {
            return false;
        } else
            return true;
    }

    public int getTileID() { return TileID; }

    public void setCoordinate(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }


    public Terrain.typesOfTerrain getTerrainType(){
        return TerrainType;
    }

    public void setLevel(int Level){
        this.Level = Level;
    }

    public int getLevel(){
        return Level;
    }

    public void placeMeeples(Player player){
        meeples = new Meeple[Level];
        for(int i = 0; i < Level; i++){
            meeples[i] = new Meeple(player.getPlayerName());
            player.increaseMatchScore(Level);
        }
        BelongsToThisPlayer = player.getPlayerName();
    }

    public void placeTotoro(Player player){
        totoro = new Totoro(player.getPlayerName());
        this.settlement.addTotoroFlag();
        BelongsToThisPlayer = player.getPlayerName();
    }

    public void placeTiger(Player player){
        tiger = new Tiger(player.getPlayerName());
        this.settlement.addTigerFlag();
        BelongsToThisPlayer = player.getPlayerName();
    }

    public void setSettlement(Settlement settlement){
        this.settlement = settlement;
    }

    public Settlement getSettlement(){
        return this.settlement;
    }

    public String getPlayerBelongsTo(){
        return BelongsToThisPlayer;
    }


}
