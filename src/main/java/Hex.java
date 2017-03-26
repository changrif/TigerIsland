/**
 * Created by Kyle on 3/14/2017.
 */
public class Hex {

    private Coordinate coordinate;

    private Terrain.typesOfTerrain TerrainType;
    private int Level = 0;
    private int TileIndex;

    private Meeple meeples[];
    private Totoro totoro;
    private Tiger tiger;
    private Settlement settlement;


    public Hex (Terrain.typesOfTerrain TerrainType, int TileIndex){

        this.TerrainType = TerrainType;
        this.TileIndex = TileIndex;
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

    public int getTileIndex() { return TileIndex; }

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
        }
    }

    public void placeTotoro(Player player){
        totoro = new Totoro(player.getPlayerName());
        this.settlement.addTotoroFlag();
    }

    public void placeTiger(Player player){
        tiger = new Tiger(player.getPlayerName());
        this.settlement.addTigerFlag();
    }

    public void setSettlement(Settlement settlement){
        this.settlement = settlement;
    }

    public Settlement getSettlement(){
        return this.settlement;
    }


}
