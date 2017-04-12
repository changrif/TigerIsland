/**
 * Created by Kyle on 3/14/2017.
 */
public class Tile {

    private Hex Hex1;
    private Hex Hex2;
    private Hex Hex3;
    private int TileID;
    private int TileLevel;
    private int tileOrientation;

    public Tile(Hex Hex1, Hex Hex2, Hex Hex3, int TileID){
        this.Hex1 = Hex1;
        this.Hex2 = Hex2;
        this.Hex3 = Hex3;
        this.TileID = TileID;
        this.TileLevel = 0;
    }

    public int getTileLevel() { return TileLevel; }

    public void setTileLevel(int level) { this.TileLevel = level; }

    public int getTileID() { return TileID; }

    public Hex getHex1(){
        return Hex1;
    }

    public Hex getHex2(){
        return Hex2;
    }

    public Hex getHex3(){
        return Hex3;
    }

    public int getTileOrientation() {
        return tileOrientation;
    }

    public void setTileOrientation(int tileOrientation) {
        this.tileOrientation = tileOrientation;
    }
}
