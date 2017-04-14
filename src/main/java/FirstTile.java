/**
 * Created by chandlergriffin on 4/3/17.
 * This class is specifically for the first tile. It creates the first tile and gives it a tileID and a tile level. There are also
 * getters and setters.
 */
public class FirstTile {
    private Hex Hex1;
    private Hex Hex2;
    private Hex Hex3;
    private Hex Hex4;
    private Hex Hex5;
    private int TileID;
    private int TileLevel;

    public FirstTile() {
        this.Hex1 = new Hex(Terrain.typesOfTerrain.VOLCANO, 49);
        this.Hex1.setCoordinate(new Coordinate(100, 100, 100));
        this.Hex1.setLevel(1);

        this.Hex2 = new Hex(Terrain.typesOfTerrain.JUNGLE, 49);
        this.Hex2.setCoordinate(new Coordinate(99, 100, 101));
        this.Hex2.setLevel(1);

        this.Hex3 = new Hex(Terrain.typesOfTerrain.LAKE, 49);
        this.Hex3.setCoordinate(new Coordinate(99, 101, 100));
        this.Hex3.setLevel(1);

        this.Hex4 = new Hex(Terrain.typesOfTerrain.ROCKY, 49);
        this.Hex4.setCoordinate(new Coordinate(101, 99, 100));
        this.Hex4.setLevel(1);

        this.Hex5 = new Hex(Terrain.typesOfTerrain.GRASSLANDS, 49);
        this.Hex5.setCoordinate(new Coordinate(101, 100, 99));
        this.Hex5.setLevel(1);

        this.TileID = 49;
        this.TileLevel = 1;
    }

    public int getTileLevel() {
        return TileLevel;
    }

    public int getTileID() {
        return TileID;
    }

    public Hex getHex1() {
        return Hex1;
    }

    public Hex getHex2() {
        return Hex2;
    }

    public Hex getHex3() {
        return Hex3;
    }

    public Hex getHex4() {
        return Hex4;
    }

    public Hex getHex5() {
        return Hex5;
    }
}

